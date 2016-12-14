import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Test implements Runnable {
	
	private Thread currentThread = null;
	
	private static ReentrantLock lock = new ReentrantLock();
	
	public Test(Thread currentThread) {
		this.currentThread = currentThread;
	}

	public static void main(String[] args) {
		//AbstractQueuedSynchronizer
		//AbstractQueuedLongSynchronizer
		//Sync
		/**
		 * NonfairSync 
		 * 中lock的实现方法
		 * FairSync
		 *  final void lock() {
		 *  //使用了cas原子操作，更新状态为1
            if (compareAndSetState(0, 1))
            	//锁定，使用独占模式同步的当前所有者（Thread.currentThread()）
                setExclusiveOwnerThread(Thread.currentThread());
            else
                acquire(1);
        }
        
         public final void acquire(int arg) {
			        if (!tryAcquire(rag) &&
			            acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
			            selfInterrupt();
    				}
    				
    				
    		tryAcquire	()调用了这个方法	
    		
    		参数acquires值得是state要增加的次数
    		final boolean nonfairTryAcquire(int acquires) {
    		//获得当前线程
            final Thread current = Thread.currentThread();
            //获得当前的状态
            int c = getState();
            //若果状态是否为零，如果为零使用cas原子操作判断是否可以获得锁
            if (c == 0) {
                if (compareAndSetState(0, acquires)) {
                	//记录获得锁的线程
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            //由于lock是可重入锁，所以当持有这个锁的线程递归访问这个方法时，将状态值向上递增
            else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0) // overflow
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }
        
        
        protected final boolean tryRelease(int releases) {
		    int c = getState() - releases;
		    //当前线程没有获得这把锁，而你却去释放它就会发生IllegalMonitorStateException
		    if (Thread.currentThread() != getExclusiveOwnerThread())
		        throw new IllegalMonitorStateException();
		    boolean free = false;
		    if (c == 0) {
		        free = true;
		        setExclusiveOwnerThread(null);
		    }
		    setState(c);
		    return free;
		}
        
        
        private void unparkSuccessor(Node node) {
        //此时node是需要是需要释放锁的头结点

        //清空头结点的waitStatus，也就是不再需要锁了
        compareAndSetWaitStatus(node, Node.SIGNAL, 0);

        //从头结点的下一个节点开始寻找继任节点，当且仅当继任节点的waitStatus<=0才是有效继任节点，否则将这些waitStatus>0（也就是CANCELLED的节点）从AQS队列中剔除  
       //这里并没有从head->tail开始寻找，而是从tail->head寻找最后一个有效节点。
       //解释在这里 http://www.blogjava.net/xylz/archive/2010/07/08/325540.html#377512

        Node s = node.next;
        if (s == null || s.waitStatus > 0) {
            s = null;
            //从后往前找，如果找到就赋值给s
            for (Node t = tail; t != null && t != node; t = t.prev)
                if (t.waitStatus <= 0)
                    s = t;
        }

        //如果找到一个有效的继任节点，就唤醒此节点线程
        if (s != null)
            LockSupport.unpark(s.thread);
    }
        
		 */
		
		lock.lock();//new ReentrantLock(),不指定参数默认使用不公平锁NonfairSync
		lock.unlock();
		Test test = new Test(Thread.currentThread());
		new Thread(test).start();
		System.out.println("十秒后结束！！！");
		//LockSupport.park();//阻塞，于此类似的方法有Thread.suspend，不过已经过时了，不推荐使用。
		//这种中断类似，这个TRUE可以换成一个条件判断
		while(true) {
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				break;
			}
		}
	
	}

	@Override
	public void run() {
		try {
			
			for(int i = 0; i < 10; i++) {
				
				Thread.sleep(1000);
				
				System.out.println(10 - i - 1);
				
			}
			currentThread.interrupt();//中断main线程，main线程直接结束
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//LockSupport.unpark(currentThread);//解除main线程的阻塞，类似的方法Thread.resume，不过已经过时了，不推荐使用
		
	}

}
