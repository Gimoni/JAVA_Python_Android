

public class EpochTimeExample {

	public static void main(String[] args) {

//		int epoch = System.currentTimeMillis(); // Error . 함수가 수행 후 만들어진 타입을 확인하고 일치시켜야 한다.
		long epoch = System.currentTimeMillis();
		
		long hour = epoch/1000/60/60%24 + 9;
		long minute = epoch/1000/60%60;
		long second = epoch%60;
		
		System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
		
		
	}

}
