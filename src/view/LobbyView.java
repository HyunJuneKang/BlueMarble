package view;

import dto.UsersDTO;

public class LobbyView {

	public static void clearScreen() {
		for(int i = 0; i < 20;i++) {
			System.out.println();
		}
	}

	public static void lobbyDisplay(UsersDTO user) {
		String screen = String.format("""
				+=======================================================================================+
				|                                  >>> 부 루 마 블 <<<                                    |
				+=======================================================================================+
				|                                                                                       |
				|                         ┌──────────────────────────────┐                              |
				|                         │         Game Lobby           │                              |
				|                         └──────────────────────────────┘                              |
				|                                                                                       |
				|                              1. 게임 시작                                               |
				|                              2. 상점                                                   |
				|                              3. 인벤토리                                                |
				|                              4. 전적                                                   |
				|                              9. 로그아웃                                                |
				|                                                                                       |
				|                                                        PLAYER : %-20s |
				|                                                        GOLD  : %,15d G|
				|                                                        EXP   : %,15d  |
				|                                                                                       |
				+=======================================================================================+
				""",
				user.getUserName()
				, user.getGold()
				, user.getExperience()
				);

		System.out.println(screen);
		System.out.print("입력 >>");
	}
}

