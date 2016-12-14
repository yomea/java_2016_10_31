package httpServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器类
 * @author may
 *
 */
public class Server {

	private ServerSocket serverSocket = null;
	private Socket socket = null;
	

	public static void main(String[] args) {

		Server server = new Server();

		try {
			//启动服务
			server.start();
			while(true) {
				//接受请求
				server.receive();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 服务器启动方法
	 * @throws IOException
	 */
	public void start() throws IOException {

		serverSocket = new ServerSocket(8888);

		System.out.println("服务器已经启动");

	}
	/**
	 * 接收请求
	 */
	public void receive() {

		try {
			socket = serverSocket.accept();
			//创建请求实例
			Response response = new Response(socket);
			//创建响应实例
			Request request = new Request(socket);
			//创建分发器，为每个请求创建一个线程
			Dispatcher dispatcher = new Dispatcher(socket, request, response);
			
			Thread thread = new Thread(dispatcher);
			
			thread.start();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}
	
	//关闭服务
	public void stop() throws IOException {

		serverSocket.close();
	}

}
