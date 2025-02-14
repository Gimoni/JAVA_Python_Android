package Ex_quiz;

public class SoundableExample {

	public static void main(String[] args) {
		printSound(new cat());
		printSound(new dog());
	}
	public interface Soundable {
		String sound();
	}

	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	
	static class cat implements Soundable {

		@Override
		public String sound() {
			return "야옹";
		}
	}
	
	static class dog implements Soundable {

		@Override
		public String sound() {
			return "멍멍";
		}
		
	}
}
