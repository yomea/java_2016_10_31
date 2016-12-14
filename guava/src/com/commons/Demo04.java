package com.commons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;

/**
 * 函数编程closure
 * @author may
 *
 */
public class Demo04 {
	
	//判断选择closure
	public static void ifClosure() {
		Closure<Employee> closure = new Closure<Employee>() {

			@Override
			public void execute(Employee arg0) {
				arg0.setSalary(arg0.getSalary() * 1.5);
				
			}
		};
		
		Closure<Employee> closure2 = new Closure<Employee>() {

			@Override
			public void execute(Employee arg0) {
				
				arg0.setSalary(arg0.getSalary() * 1.2);
				
			}
		};
		
		Predicate<Employee> predicate = new Predicate<Employee>() {

			@Override
			public boolean evaluate(Employee arg0) {
				
				if(arg0.getSalary() < 10000) {
					
					return true;
				}
				
				return false;
			}
			
			
		};
		
		List<Employee> exployees = new ArrayList<>();
		
		exployees.add(new Employee("a hong", 10000));
		exployees.add(new Employee("b hong", 90000));
		exployees.add(new Employee("c hong", 80000));
		exployees.add(new Employee("d hong", 9000));
		
		
		Closure<Employee> ifClosure = IfClosure.ifClosure(predicate, closure, closure2);
		
		IteratorUtils.forEach(exployees.iterator(), ifClosure);
		
		for (Employee employee : exployees) {
			System.out.println(employee.getSalary());
		}
		
		
	}
	//如果不满足条件就循环closure
	public static void whileClosure() {
		
		Closure<Employee> closure = new Closure<Employee>() {

			@Override
			public void execute(Employee arg0) {
				arg0.setSalary(arg0.getSalary() * 1.5);
				
			}
		};
		
		
		Predicate<Employee> predicate = new Predicate<Employee>() {

			@Override
			public boolean evaluate(Employee arg0) {
				
				if(arg0.getSalary() < 10000) {
					
					return true;
				}
				
				return false;
			}
			
			
		};
		
		List<Employee> exployees = new ArrayList<>();
		
		exployees.add(new Employee("a hong", 10000));
		exployees.add(new Employee("b hong", 90000));
		exployees.add(new Employee("c hong", 80000));
		exployees.add(new Employee("d hong", 3000));
		
		
		Closure<Employee> whileClosure = WhileClosure.whileClosure(predicate, closure, false);
		
		IteratorUtils.forEach(exployees.iterator(), whileClosure);
		
		for (Employee employee : exployees) {
			System.out.println(employee.getSalary());
		}
		
	}
	//链式
	public static void chainClosure() {
		Closure<Employee> closure = new Closure<Employee>() {

			@Override
			public void execute(Employee arg0) {
				arg0.setSalary(arg0.getSalary() * 1.5);
				
			}
		};
		
		Closure<Employee> closure2 = new Closure<Employee>() {

			@Override
			public void execute(Employee arg0) {
				
				if(arg0.getSalary() > 10000) {
					
					arg0.setSalary(arg0.getSalary() - 10000);
				}
				
				
			}
		};
		
		List<Employee> exployees = new ArrayList<>();
		
		exployees.add(new Employee("a hong", 10000));
		exployees.add(new Employee("b hong", 90000));
		exployees.add(new Employee("c hong", 80000));
		exployees.add(new Employee("d hong", 9000));
		
		
		@SuppressWarnings("unchecked")
		Closure<Employee> chainClosure = ChainedClosure.chainedClosure(closure, closure2);
		
		IteratorUtils.forEach(exployees.iterator(), chainClosure);
		
		for (Employee employee : exployees) {
			System.out.println(employee.getSalary());
		}
		
		
	}

	public static void main(String[] args) {
		
		//ifClosure();
		//whileClosure();
		chainClosure();
		
		
	}

}
