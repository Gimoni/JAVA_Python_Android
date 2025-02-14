

public class EpochTimeExample4 {

	/*
	 * AC
	 * 0001-01-01 Monday
	 * 
	 * 1970-01-01 00:00:00 부터 경과시간 (Thursday)
	 * 
	 *  0  1  2  3  4  5  6 
	 *  일 월  화  수  목 금  토
	 * 
	 */
	
	public static void main(String[] args) {
		long epoch = System.currentTimeMillis()/1000 + 9*60*60;
		
		int year = 1970;
		long week=4;
		
//		for(;;) {
		while(true) {
			int dayOfYear = 365;
			if (year%4==0&&year%100!=0 || year%400==0)
				dayOfYear++;
			
			int secondOfYear = dayOfYear*24*60*60;
			
			if (epoch - secondOfYear >= 0) { 
				epoch -= secondOfYear;
				week += dayOfYear;
			} else			
				break;
			
			year++;
		}
		/*
		 * 1   2   3   4   5   6   7  8   9 10 11 12
		 * 31  28  31 30  31  30  31 31  30 31 30 31
		 *     29
		 */	
		int month = 0;
		for (int i=1; i<=12; i++) {
			int dayOfMonth=0;
			if (i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12)
				dayOfMonth = 31;
			else if (i==4 || i==6 || i==9 || i==11)
				dayOfMonth = 30;
			else if (i==2) {
				if (year%4==0&&year%100!=0 || year%400==0)
					dayOfMonth = 29;
				else
					dayOfMonth = 28;
			}
			
			int secondOfMonth = dayOfMonth*24*60*60;
			if (epoch-secondOfMonth >= 0) {
				epoch -= secondOfMonth;
				week += dayOfMonth;
			} else {
				month = i;
				break;
			}
			
		}

			
		long day = epoch/60/60/24+1;	
		week += epoch/60/60/24;
		
		week =  week %7;
		long hour = epoch/60/60%24;
		long minute = epoch/60%60;
		long second = epoch%60;
		
		char weekName = switch((int)week) {
		case 0 -> '일';
		case 1 -> '월';
		case 2 -> '화';
		case 3 -> '수';
		case 4 -> '목';
		case 5 -> '금';
		case 6 -> '토';
		default -> 'X';
		};

		
		System.out.printf("%04d-%d-%d %c %02d:%02d:%02d\n", year, month, day, weekName, hour, minute, second);
		
	}

}

