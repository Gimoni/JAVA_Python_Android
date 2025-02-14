package com.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		// LIFO (Last in First Out) : 마지막에 들어간 것이 처음으로 나온다.
		//ArrayList<Integer> source = new ArrayList();
		
		var source = new ArrayList<Integer>();
		var target = new ArrayList<Integer>();
		
		//stack create
		var stack = new Stack<Integer>();
		
		Random r = new Random();
		for (int i=0; i<10; i++) 
			source.add(r.nextInt(100));
		
		//정렬
		source.sort((a,b)-> a-b);	// asc 
		
		// stack에 정렬구조를 push
		source.forEach(h -> stack.push(h));
		
		System.out.println(source);
		
		// stack에서 pop
		while (!stack.empty())
			target.add(stack.pop());
		
		System.out.println(target);
		
		
	}
	public static void main2(String[] args) {
		
		// LIFO (Last in First Out) : 마지막에 들어간 것이 처음으로 나온다.
		Stack<Integer> s = new Stack(); 
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		
		while(!s.empty())
			System.out.println(s.pop());
			
	}

}
