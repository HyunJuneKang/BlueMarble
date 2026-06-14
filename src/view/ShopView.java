package view;
import dao.ItemDAO;
import dto.UsersDTO;



public class ShopView {
	public static void shopLobbyDisplay(UsersDTO user) {
		String screen = String.format("""
				+=======================================================================================+
				|                                  >>> 부 루 마 블 <<<                                    |
				+=======================================================================================+
				|                                                                                       |
				|                         ┌──────────────────────────────┐                              |
				|                         │         Shop Lobby           │                              |
				|                         └──────────────────────────────┘                              |
				|                                                                                       |
				|                              1. 아이템 구매                                              |
				|                              2. 아이템 판매                                              |
				|                              9. 게임 메뉴                                               |
				|                                                                                       |
				|                                                                                       |
				|                                                        PLAYER : %-20s |
				|                                                        GOLD  : %,15d G|
				|                                                                                       |
				+=======================================================================================+
				""",
				user.getUserName(),
				user.getGold()
				);

		System.out.println(screen);
		System.out.print("입력 >>");
	}
	public static void itemPurchaseDisplay(UsersDTO user) {
		ItemDAO dao = new ItemDAO();
//		List<ItemDTO> items = dao.selectAll();
		String screen = """
				+=======================================================================================+
				|                                  >>> 부 루 마 블 <<<                                    |
				+=======================================================================================+
				|                                                                                       |
				|                         ┌──────────────────────────────┐                              |
				|                         │        Item Purchase         │                              |
				|                         └──────────────────────────────┘                              |
				|                                                                                       |
				""";
		String screen3 = String.format("""
                |                                                                                       |
				|                                                                                       |
				|                              9. 상점 메뉴                                               |
				|                                                        PLAYER : %-20s |
				|                                                        GOLD  : %,15d G|
				|                                                                                       |
				+=======================================================================================+
				""",
				user.getUserName(),
				user.getGold()
				);
		System.out.println(screen);
		
		int itemidx = 1;
//	    for(ItemDTO item : items) {
//	        System.out.printf(
//	                "| %2d | %-12s | %6d Gold |\n",
//	                itemidx++,
//	                item.getName(),
//	                item.getPrice()
//	        );
//	    }
	    
		System.out.println(screen3);
		System.out.print("입력 >>");
	}
	public static void itemSellDisplay(UsersDTO user) {
		ItemDAO dao = new ItemDAO();
//		List<ItemDTO> items = dao.selectAll();
		String screen = """
				+=======================================================================================+
				|                                  >>> 부 루 마 블 <<<                                    |
				+=======================================================================================+
				|                                                                                       |
				|                         ┌──────────────────────────────┐                              |
				|                         │        Item Purchase         │                              |
				|                         └──────────────────────────────┘                              |
				|                                                                                       |
				""";
		String screen3 = String.format("""
                |                                                                                       |
				|                                                                                       |
				|                              9. 상점 메뉴                                               |
				|                                                        PLAYER : %-20s |
				|                                                        GOLD  : %,15d G|
				|                                                                                       |
				+=======================================================================================+
				""",
				user.getUserName(),
				user.getGold()
				);
		System.out.println(screen);
		// for문으로 플레이어 아이템 db로 보여주기
		System.out.println(screen3);
		System.out.print("입력 >>");
	}

}
