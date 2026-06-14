package view;

public class LoginView {

	public static void loginMenuDisplay() {
		String screen = """
				+=======================================================================================+
				|                                  >>> 부 루 마 블 <<<                                    |
				+=======================================================================================+
				|                                                                                       |
				|                         ┌──────────────────────────────┐                              |
				|                         │         Login Menu           │                             |
				|                         └──────────────────────────────┘                              |
				|                                                                                       |
				|                              1. 로그인                                                  |
				|                              2. 회원가입                                                 |
				|                              3. 비밀번호 초기화                                            |
				|                              9. 종료                                                   |
				|                                                                                       |
				|                                                                                       |
				|                                                                                       |
				|                                                                                       |
				+=======================================================================================+

				""";
		System.out.println(screen);
		System.out.print("입력<< ");
	}
//=======================Login   ============================
	public static void loginDisplay(String userID,String userPass,String message,String message2) {
		String screen = String.format("""
				+=======================================================================================+
				|                                  >>> 부 루 마 블 <<<                                  |
				+=======================================================================================+
				|                                                                                       |
				|                         ┌──────────────────────────────┐                              |
				|                         │           Login              │                              |
				|                         └──────────────────────────────┘                              |
				|                                                                                       |
				|                            ID       : %-20s                           |
				|                                                                                       |
				|                            PASSWORD : %-20s                           |
				|                                                                                       |
				|                         ┌──────────────────────────────┐                              |
				|                         │ %-25s │                              |
				|                         │ %-25s │                              |
				|                         └──────────────────────────────┘                              |
				+=======================================================================================+
				""",
				userID,
				mask(userPass),
				message,
				message2
				);
		System.out.println(screen);
		System.out.print("입력<< ");
	}
//=======================Sign User============================
	public static void signDisplay(
	        String message,
	        String message2,
	        String userID,
	        String userPass,
	        String userName,
	        String userQuestion,
	        String userAns) {

		String screen = String.format("""
				+=======================================================================================+
				|                                  >>> 부 루 마 블 <<<                                  |
				+=======================================================================================+
				|                                                                                       |
				|                         ┌──────────────────────────────┐                              |
				|                         │         Sign Menu            │                              |
				|                         └──────────────────────────────┘                              |
				|                                                                                       |
				|                            ID       : %-20s                           |
				|                            PASSWORD : %-20s                           |
				|                            USERNAME : %-20s                           |
				|                            QUESTION : %-20s                           |
				|                            ANSWER   : %-20s                           |
				|                                                                                       |
				|                         ┌──────────────────────────────┐                              |
				|                         │ %-28s │                              |
				|                         │ %-28s │                              |
				|                         └──────────────────────────────┘                              |
				|                                                                                       |
				+=======================================================================================+
				""",
				userID,
				mask(userPass),
				userName,
				userQuestion,
				userAns,
				message,
				message2
				);

	    System.out.println(screen);
	    System.out.print("입력<< ");
	}
	private static String mask(String value) {
	    return value == null ? "" : "*".repeat(value.length());
	}


//=======================Reset PassWord============================
	public static void resetPassIdInput(
	        String message,
	        String message2,
	        String userID,
	        String userName,
	        String userPass
	        ) {

		String screen = String.format("""
		        +=======================================================================================+
		        |                                  >>> 부 루 마 블 <<<                                  |
		        +=======================================================================================+
		        |                                                                                       |
		        |                         ┌──────────────────────────────┐                              |
		        |                         │      ResetPassword Menu      │                              |
		        |                         └──────────────────────────────┘                              |
		        |                                                                                       |
		        |                            ID       : %-20s                           |
		        |                            USERNAME : %-20s                           |
		        |                            PASSWORD : %-20s                           |
		        |                                                                                       |
		        |                         ┌──────────────────────────────┐                              |
		        |                         │ %-25s │                              |
		        |                         │ %-25s │                              |
		        |                         └──────────────────────────────┘                              |
		        |                                                                                       |
		        +=======================================================================================+
		        """,
		        userID,
		        userName,
		        mask(userPass),
		        message,
		        message2
		);

	    System.out.println(screen);
	    System.out.print("입력<< ");
	}

}
