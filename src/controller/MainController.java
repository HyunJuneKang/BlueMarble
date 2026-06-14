package controller;
import java.util.Scanner;

import dto.UsersDTO;
import model.Difficulty;
import model.GameState;
import service.GameService;
import service.LoginService;
import view.GameView;
import view.InventoryView;
import view.LobbyView;
import view.LoginView;
import view.RecordView;
import view.ShopView;


public class MainController {
    static Scanner sc = new Scanner(System.in);
    static UsersDTO loginUser;
 
    
    public static void main(String[] args) {
        while (true) {
            loginLoop();

            if (loginUser == null) {
                break; // 로그인 메뉴에서 종료 선택
            }

            gameLoop();
        }

        System.out.println("프로그램 종료");
    }

    private static void loginLoop() {
        boolean isStop = false;

        while (!isStop) {
            LoginView.loginMenuDisplay();
            String job = sc.nextLine();

            switch (job) {
	            case "1" -> {
	                loginUser = login();
	
	                if (loginUser != null) {
	                    isStop = true;
	                }
	            }
                case "2" -> { // 회원가입
                    signUser();
                }
                case "3" -> { // 비밀번호 초기화
                	resetPassword();
                }
                case "9" -> { // 프로그램 종료
                	loginUser = null;
                    isStop = true;
                }
                default -> {
                    System.out.println("작업선택 오류. 다시선택");
                }
            }
        }
    }

	private static UsersDTO login() {
       	String inputID = "";
    	String inputPassword = "";
    	// ID 입력
    	LoginView.loginDisplay(inputID,inputPassword,"아이디를 입력 해 주세요.","");
    	inputID = sc.nextLine();
    	// Password 입력
    	LoginView.loginDisplay(inputID,inputPassword,"패스워드를 입력 해 주세요.","");
    	inputPassword = sc.nextLine();
    	
    	// 로그인 성공했다고 가정
    	StringBuilder sb = new StringBuilder();
    	sb.append("로그인 중");
    	for (int i = 0 ; i < 3;i++) {
    		sb.append(".");
    		LoginView.loginDisplay(inputID,inputPassword,sb.toString(),"");
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	
    	
    	UsersDTO user = LoginService.login(inputID, inputPassword);
    	//로그인 성공
    	if (user  != null) { 
    		sb.delete(0, sb.length());
        	sb.append("잠시후 게임 메뉴로 입장합니다");
        	for (int i = 0 ; i < 3;i++) {
        		sb.append(".");
        		LoginView.loginDisplay(inputID,inputPassword,"로그인에 성공 하셨습니다!",sb.toString());
        		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	}
        	return user ;
    	}
    	//로그인 실패
    	else {
    		sb.delete(0, sb.length());
        	sb.append("잠시후 로그인 페이지로 돌아갑니다");
        	for (int i = 0 ; i < 3;i++) {
        		sb.append(".");
        		LoginView.loginDisplay(inputID,inputPassword,"로그인에 실패 하셨습니다!",sb.toString());
        		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	}
        	return null;
    	}
		
	}

	private static void signUser() {
    	String inputID = "";
    	String inputPass = "";
    	String inputUsername = "";
    	String inputQue = "";
    	String inputAns = "";
    	LoginView.signDisplay("아이디를 입력 해 주세요.","",inputID,inputPass,inputUsername,inputQue,inputAns);
    	inputID = sc.nextLine();
    	UsersDTO user = LoginService.checkID(inputID);
    	
    	if (user != null) {
    		LoginView.signDisplay("해당 아이디는 존재하는 아이디 입니다.","잠시후 로그인 페이지로 돌아갑니다.",
    										inputID,inputPass,inputUsername,inputQue,inputAns);
    		return;
    	}
    	
    	LoginView.signDisplay("패스워드를 입력 해 주세요.","",inputID,inputPass,inputUsername,inputQue,inputAns);
    	inputPass = sc.nextLine();
    	LoginView.signDisplay("닉네임을 입력 해 주세요.","",inputID,inputPass,inputUsername,inputQue,inputAns);
    	inputUsername = sc.nextLine();
    	LoginView.signDisplay("비밀번호 초기화 질문을 입력 해 주세요.","",inputID,inputPass,inputUsername,inputQue,inputAns);
    	inputQue = sc.nextLine();
    	LoginView.signDisplay("질문에 대한 답을 입력 해 주세요.","",inputID,inputPass,inputUsername,inputQue,inputAns);
    	inputAns = sc.nextLine();
    	//Service로 해당정보 INSERT
    	
    	UsersDTO newUser = UsersDTO.builder()
    	        .userId(inputID)
    	        .password(inputPass)
    	        .userName(inputUsername)
    	        .question(inputQue)
    	        .answer(inputAns)
    	        .gold(0)
    	        .experience(0)
    	        .build();
    	
    	
    	if (LoginService.sign(newUser)){
        	StringBuilder sb = new StringBuilder();
        	sb.append("잠시후 로그인 페이지로 돌아갑니다");
        	for (int i = 0 ; i < 3; i++) {
        		sb.append(".");
        		LoginView.signDisplay("회원가입에 성공하셨습니다.",sb.toString(),inputID,inputPass,inputUsername,inputQue,inputAns);
        		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	}
    	} else {
        	StringBuilder sb = new StringBuilder();
        	sb.append("잠시후 로그인 페이지로 돌아갑니다");
        	for (int i = 0 ; i < 3; i++) {
        		sb.append(".");
        	    LoginView.signDisplay(
        	            "회원가입에 실패했습니다.",
        	            "잠시후 로그인 페이지로 돌아갑니다.",
        	            inputID, inputPass, inputUsername, inputQue, inputAns
        	        );
        		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	}
    	}
		
	}

	private static void resetPassword() {
		String inputID = "";
		String inputPass = "";
		String inputAns = "";
		String loadQue = "";
		String loadAns = "";
		String loadUsername = "";
		LoginView.resetPassIdInput("아이디를 입력 해 주세요.","",inputID ,loadUsername,inputPass);
		inputID = sc.nextLine();
		//Service로 해당 아이디가 DB에 있는지 확인
		
		UsersDTO user = LoginService.checkID(inputID);
		
		if (user == null) {
			System.out.println("해당 아이디가 없습니다.");
			return;
		}
	
		// 질문에 대한 답 확인
		LoginView.resetPassIdInput("질문에 대한 답을 입력해 주세요.",loadQue,inputID ,loadUsername,inputPass);
		inputAns = sc.nextLine();
		
		// 답 정합성 체크
		StringBuilder sb = new StringBuilder();
		sb.append("질문에 대한 정답을 확인중 입니다");
		for (int i = 0 ; i < 3;i++) {
			sb.append(".");
			LoginView.resetPassIdInput(inputAns,sb.toString(),inputID ,loadUsername,inputPass);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (!LoginService.checkAns(user,inputAns)) {
			System.out.println("질문에 대한 답이 틀렸습니다.");
			return;
		}
		// 비밀번호 입력하기
		LoginView.resetPassIdInput("새로운 비밀번호를 입력 해 주세요","",inputID ,loadUsername,inputPass);
		inputPass = sc.nextLine();
		//Service로 비밀번호 UPDATE
		LoginService.updatePass(user,inputPass);
		
		sb.delete(0, sb.length());
		sb.append("잠시후 로그인 페이지로 돌아갑니다");
		for (int i = 0 ; i < 3;i++) {
			sb.append(".");
			LoginView.resetPassIdInput("비밀번호 초기화에 성공하셨습니다.",sb.toString(),inputID ,loadUsername,inputPass);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static void gameLoop() {
        boolean isStop = false;

        while (!isStop) {
            LobbyView.clearScreen();
            LobbyView.lobbyDisplay(loginUser);
            String job = sc.nextLine();

            switch (job) {
                case "1" -> { // 게임 시작
                	gameMenuLoop();
                }
                case "2" -> { // 상 점
                	shopLoop();
                }
                case "3" -> { // 인벤토리
                    inventoryLoop();
                }	
                case "4" -> { // 게임 기록
                    recordLoop();
                }
                case "9" -> {
                    loginUser = null;
                    isStop = true;
                }
                default -> {
                    System.out.println("작업선택 오류. 다시선택");
                }
            }
        }
    }

	private static void gameMenuLoop() {
		boolean isStop = false;
		while(!isStop) {
			GameView.gameMenuDisplay(loginUser);
			String job = sc.nextLine();
			switch (job) {
			    case "1" -> {
			    	playGameLoop(Difficulty.EASY);
			    }
			    case "2" -> {
			    	playGameLoop(Difficulty.NORMAL);
			    }
			    case "3" -> {
			    	playGameLoop(Difficulty.HARD);
			    }
			    case "9" -> {
			    	isStop = true;
			    }
			}
		}
	}

	private static void playGameLoop(Difficulty diff) {
		boolean isStop = false;
		// gamestate 생성
	    GameState game = GameService.startGame(loginUser, diff);
		// Service로 player ai 맵 로드  
		while(!isStop) {
			GameView.gameBoardDisplay(game);
			String job = sc.nextLine();
	        switch (job) {
	        
	            case "1" -> { //주사위 던지기
	            	GameService.rollDice(game);
	            }
	            case "2" -> { //아이템 사용
	            	useItemLoop(game);
	            }
	            case "3" -> { //인벤토리 보기
	            	gameInventoryLoop(game);
	            }
	            case "9" -> { //게임중단
	            	GameService.quitGame(game);
	            	isStop = true;
	            }
	            default -> System.out.println("작업선택 오류. 다시선택");
        }
			
			
		}
		
	}

	private static void gameInventoryLoop(GameState game) {
		// TODO Auto-generated method stub
		
	}

	private static void useItemLoop(GameState game) {
		// TODO Auto-generated method stub
		
	}

	private static void recordLoop() {
		boolean isStop = false;
		while(!isStop) {
			RecordView.recordDisplay(loginUser);
			String job = sc.nextLine();
			switch (job) {
				case "9" -> {
					isStop = true;
				}
			}
		}
	}

	private static void inventoryLoop() {
		boolean isStop = false;
		while(!isStop) {
			InventoryView.inventoryDisplay(loginUser);
			String job = sc.nextLine();
			switch (job) {
				case "9" -> {
					isStop = true;
				}
			}
		}
	}

	private static void shopLoop() {
		boolean isStop = false;
		while(!isStop) {
			ShopView.shopLobbyDisplay(loginUser);
			String job = sc.nextLine();
			switch (job) {
				case "1" -> { // 아이템 구매
					// Service -> 아이템 DB select
					shopPurchaseLoop();
				}
				case "2" -> { // 아이템 판매
					// Service -> 유저 인벤토리 select
					shopSellLoop();
				}
				case "9" -> { // 게임 로비
					isStop = true;
				}
				default -> {
					System.out.println("작업선택 오류. 다시선택");
				}
			}
		}
	}
	private static void shopPurchaseLoop() {
		boolean isStop = false;
		while(!isStop) {
			ShopView.itemPurchaseDisplay(loginUser);
			String job = sc.nextLine();
	        switch (job) {
				case "1" -> {
					// Service -> itemDAO.selectByID -> 
				}
				case "2" -> { 
				}
				case "3" -> { 
				}
				case "9" -> { //돌아가기
					isStop = true;
				}
				default -> {
					System.out.println("작업선택 오류. 다시선택");
				}
	    	}
		}
	}

	private static void shopSellLoop() {
		boolean isStop = false;
		while(!isStop) {
			ShopView.itemSellDisplay(loginUser);
			String job = sc.nextLine();
	        switch (job) {
				case "1" -> {
					// Service -> inventoryDBO.selectBy(Userid,itemNo) -> 
				}
				case "2" -> { 
				}
				case "3" -> { 
				}
				case "9" -> { //돌아가기
					isStop = true;
				}
				default -> {
					System.out.println("작업선택 오류. 다시선택");
				}	        
	    	}
		}
	}

}