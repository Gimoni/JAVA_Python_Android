
public class OperatorQuizExample {
	
	// Entry Point (진입점)
	public static void main11(String[] args) {
		System.out.println("Start Program");
		
		/*
		 *  여기에 코드 작성
		 */
		
		System.out.println("End Program...");
	}
	

	public static void main10(String[] args) {
		char ch = 'A';
		
//		char lowerCase =  'A'<=ch && ch<='Z' ? (char)(ch+32) : ch;
		char lowerCase =  'A'<=ch && ch<='Z' ? (char)(ch+'a'-'A') : ch;
		
		System.out.println("ch:" + ch);
		System.out.println("ch to lowerCase:" + lowerCase);
	}
	
	public static void main9(String[] args) {
		// 연습문제 [3-9]
		char ch = 'z';
		boolean b =  'A'<=ch && ch <= 'Z' || 'a'<=ch && ch<='z';
		
		System.out.println(b);
				
				
	}
	
	
	public static void main8(String[] args) {
		// 연습문제 [3-8]
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b);
		
		char ch = 'A';
		ch = (char) (ch + 2);
		
		double f = 3f / 2f;
		long l =  3000L * 3000L * 3000L;
		
		float f2 = 0.1f;
		double d = 0.1;
		
		boolean result = f2 ==(float)d;		// 동등비교에서는 변수타입을 같게 캐스팅해야한다. 
		
		System.out.println("c=" +c);				// c=30
		System.out.println("ch=" +ch);				// ch =C
		System.out.println("f=" +f);				// f=1.5
		System.out.println("l=" + l);				// 27000000000
		System.out.println("result="+result);		// true
		
		
		
	}
	public static void main7(String[] args) {
		// 연습문제 [3-7]
		int fahrenheit = 100; 
		float celcius = (float)((5/9) * (fahrenheit -32));
		
		System.out.println("fahrenhit: " + fahrenheit);
		System.out.println("Celcius:" +((int)(5/9.*(fahrenheit-32)*100+0.5))/100.);
		
	}
	
	public static void main6(String[] args) {
		// 연습문제 [3-6]
		int num = 24;
		System.out.println((num + 10)/10*10-num);
		System.out.println(10-num%10);
	}
	
	public static void main5(String[] args) {
		// 연습문제 [3-5]
		int num = 333;
//		System.out.println(num - num%10 +1 );
		System.out.println(num/ 10*10 +1);
	}
	public static void main4(String[] args) {
		// 연습문제 [3-4]
		int num = 456;
		System.out.println(num /100 *100);
		System.out.println(num - num%100); 	// 100으로 나눈 나머지를 뺀다
	}
	public static void main3(String[] args) {
		// 연습문제 [3-3]
		int num = -10;
		System.out.println(num > 0 ? "양수" : num <0 ? "음수": "영");
	}
	
	public static void main2(String[] args) {
		// 연습문제 [3-2]
		int numOfApples = 123;			// 사과의 개수
		int sizeOfBucket = 10; 			// 바구니의 크기 (바구니에 담을 수 있는 사과의 개수)
		int numOfBucket = numOfApples/sizeOfBucket + (numOfApples%sizeOfBucket==0 ? 0: 1); // 모든 사과를 담는데 필요한 바구니의 수 
		
		
		System.out.println("필요한 바구니의 수 : " +numOfBucket );
	}
	
	public static void main1(String[] args) {
		// 연습문제 [3-1]
		int x = 2;
		int y = 5;
		char c = 'A'; 	// 'A'의 문자코드는 65
		
		System.out.println(1 + x << 33);					// 6
		System.out.println(y >= 5 || x < 0 && x > 2);		// true
		System.out.println(y += 10 - x++);					// 13
		System.out.println(x+=2);							// 5
		System.out.println( !('A' <= c && c <='z'));		// false
		System.out.println('C'-c);							// 2
		System.out.println('5'-'0');						// 5	
		System.out.println(c + 1);							// 66
		System.out.println(++c);							// B  
		System.out.println(c++);							// B
		System.out.println(c);								// C
		
	}

}
