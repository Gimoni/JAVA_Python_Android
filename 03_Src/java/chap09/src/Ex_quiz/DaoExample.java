package Ex_quiz;

public class DaoExample {

	
	public static void dbWork(DataAccessObject dao) {
		System.out.println(dao.select());
	}
	
	public static void main(String[] args) {
//		dbWork(new ());
	}

	public interface DataAccessObject {
		String select();
		String insert();
		String update();
		String delect();
	}
	
	class OracleDao implements DataAccessObject {

		@Override
		public String select() {
			return"Oracle DB에서 검색";
			
		}

		@Override
		public String insert() {
			return"Oracle DB에 삽입";
		}

		@Override
		public String update() {
			return "Oracle DB를 수정";
		}

		@Override
		public String delect() {
			return "Oracle DB에서 삭제";
		}
		
	}
	
	class MySqlDao implements DataAccessObject {

		@Override
		public String select() {
			return "MySql DB에서 검색";
			
		}

		@Override
		public String insert() {
			return "MySql DB에 삽입";
			
		}

		@Override
		public String update() {
			return "MySql DB를 수정";
			
		}

		@Override
		public String delect() {
			return "MySql DB에서 삭제";
			
		}
		
	}
	
}
