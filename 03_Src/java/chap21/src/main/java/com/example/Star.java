package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Star extends HttpServlet {

	interface Checkable {
		boolean check(int i, int j);
	}
	void triangle(PrintWriter out, Checkable c) {
		for (int i=0; i<5; i++) {
			for (int j=0; j<5;j++) {
				if(c.check(i, j))
					out.print("*");
				else
					out.print(" ");
			}
			out.println();
		}
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		System.out.println("...");
//		
//	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		
		var out = response.getWriter();

		out.println("Hello WebBrowser!");
		
		for (int i=0; i<10; i++) {
			out.println("i = " + i);
		}
		
		out.println();
		
		out.println("1.");
		
		triangle(out, new Checkable() {
			
			@Override
			public boolean check(int i, int j) {
				return i>=j;
			}
		});
		
//		for (int i=0; i<5; i++) {
//			for (int j=0; j<i+1; j++) 
//				out.print("*");
//			for (int j=0; j<4-i; j++)
//				out.print(" ");
//			out.println();
//		}
//		
//		for (int i=0; i<5; i++) {
//			for (int j=0; j<i+1; j++) 
//				if (j<1-(1+i))
//					out.print(" ");
//				else 
//					out.print("*");
//			out.println();
//		}
//		
//		for (int i=0; i<5; i++) {
//			for (int j=0; j<5;j++) {
//				if(i>=j)
//					out.print("*");
//				else
//					out.print(" ");
//			}
//			out.println();
//		}
		
		out.println("2.");
		
		triangle(out,new Checkable() {
			
			@Override
			public boolean check(int i, int j) {
				return i<=j;
			}
		});
		
		triangle(out, (i, j) -> i<=j);
		
//		for (int i=0; i<5; i++) {
//			for (int j=0; j<i+1; j++) 
//				out.print(" ");
//			for (int j=0; j<5-i; j++)
//				out.print("*");
//			out.println();
//		}
//		for (int i=0; i<5; i++) {
//			for (int j=0; j<i+1; j++) 
//				if (j<5-(1-i))
//					out.print(" ");
//				else
//					out.print("*");
//			out.println();
//		}
		
		
		out.println("3.");
		
		triangle(out,new Checkable() {
			
			@Override
			public boolean check(int i, int j) {
				return i<4-(j-1);
			}
		});
		
		triangle (out, (i, j) -> i<4-(j-1));
		
//		for (int i=0; i<5; i++) {
//			for (int j=0; j<5-i; j++) 
//				out.print(" ");
//			for (int j=0; j<i+1; j++)
//				out.print("*");
//			out.println();
//		}
		
		out.println("4.");
		
		triangle(out,new Checkable() {
			
			@Override
			public boolean check(int i, int j) {
				return i>=5-(j+1);
			}
		});
		
		
//		for (int i=0; i<5; i++) {
//			for (int j=0; j<4+i; j++)
//				out.print(" ");
//			for (int j=0; j<5-i; j++) 
//				out.print("*");
//			out.println();
//		}
		
		
		/*5.		6.
		 * ***** 	*   *
		 * *   *     * *
		 * *   *      *
		 * *   *     * *
		 * *****	*   *
		 */
		out.println("5.");
		
		triangle(out, new Checkable() {
			
			@Override
			public boolean check(int i, int j) {
				return i==0 || i==4 || j==0 || j==4;
			}
		});
		out.println("6.");
		
		triangle(out, new Checkable() {
			
			@Override
			public boolean check(int i, int j) {
				return i==j || 1-i==j-3;
			}
		});
		
		out.println("7.");
		triangle(out,new Checkable() {
			
			@Override
			public boolean check(int i, int j) {
				return i<4+(j+1);
			}
		});
		System.out.println("Star Servelt...");
		
	}

}
