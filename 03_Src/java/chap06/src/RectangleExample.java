import util.VT100;

public class RectangleExample {

	public static void main(String[] args) {

		VT100.clearScreen();
		
		VT100.cursorMove(10, 20);
		VT100.setForeground(31);
		VT100.setBackground(44);
		System.out.println("Hello function!");

		VT100.reset();
		
		System.out.println("Program End....");
		
	}

}
