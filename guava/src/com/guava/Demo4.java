package com.guava;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 加入约束
 * 
 * @author may
 *
 */
public class Demo4 {

	public static void main(String[] args) {

		Set<String> sets = Sets.newHashSet();
		// 创建约束
		Constraint<String> constraint = new Constraint<String>() {
			@Override
			public String checkElement(String element) {
				// 非空验证
				Preconditions.checkNotNull(element);
				// 长度验证5-20
				Preconditions.checkArgument(element.length() >= 5 && element.length() <= 20);
				return element;
			}
		};
		Set<String> cs = Constraints.constrainedSet(sets, constraint);
		// cs.add(null);// java.lang.NullPointerException
		// cs.add("doog");//java.lang.IllegalArgumentException
		cs.add("abcde");
		for (String temp : cs) {
			System.out.println(temp);
		}
	}

}

/**
 * 解决com.google.common.collect.Constraints com.google.common.collect.Constraint引入不了
 * 的问题。由于自带的Constraint，Constraints是默认的访问权限，在其他的包是看不见得
 * 除了这么解决，当然还可以将本类的包设置成和Google的一样
 * @author may
 * @param <E>
 */
interface Constraint<E> {
	// public String checkElement(String element);
	E checkElement(E element);
}

class Constraints<E> {
	public static <E> Set<E> constrainedSet(Set<E> set, Constraint<? super E> constraint) {
		return new ConstrainedSet<E>(set, constraint);
	}

	private static <E> Collection<E> checkElements(Collection<E> elements, Constraint<? super E> constraint) {
		Collection<E> copy = Lists.newArrayList(elements);
		for (E element : copy) {
			constraint.checkElement(element);
		}
		return copy;
	}

	/** @see Constraints#constrainedSet */
	static class ConstrainedSet<E> extends ForwardingSet<E> {
		private final Set<E> delegate;
		private final Constraint<? super E> constraint;

		public ConstrainedSet(Set<E> delegate, Constraint<? super E> constraint) {
			this.delegate = checkNotNull(delegate);
			this.constraint = checkNotNull(constraint);
		}

		@Override
		protected Set<E> delegate() {
			return delegate;
		}

		@Override
		public boolean add(E element) {
			constraint.checkElement(element);
			return delegate.add(element);
		}

		@Override
		public boolean addAll(Collection<? extends E> elements) {
			return delegate.addAll(checkElements(elements, constraint));
		}
	}
}
