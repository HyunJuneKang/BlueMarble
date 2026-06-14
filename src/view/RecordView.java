package view;

import dto.UsersDTO;

public class RecordView {
	public static void recordDisplay(UsersDTO user) {
		String screen = """
				+=======================================================================================+
				|                                  >>> 부 루 마 블 <<<                                    |
				+=======================================================================================+
				|                                                                                       |
				|                         ┌──────────────────────────────┐                              |
				|                         │        Match history         │                              |
				|                         └──────────────────────────────┘                              |
				|                                                                                       |
				""";
		String screen3 = String.format("""
                |                                                                                       |
				|                                                                                       |
				|                              9. 게임 메뉴                                               |
				|                                                        PLAYER : %-20s |
				|                                                        GOLD  : %,15d G|
				|                                                                                       |
				+=======================================================================================+
				""",
				user.getUserName(),
				user.getGold()
				);
		System.out.println(screen);

	    
		System.out.println(screen3);
		System.out.print("입력 >>");
	}
}
