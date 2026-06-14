package service;

import dao.UsersDAO;
import dto.UsersDTO;

public class LoginService {


	public static boolean sign(UsersDTO user) {
		return UsersDAO.insertUser(user);
	}

	public static UsersDTO checkID(String inputID) {
		UsersDTO user = UsersDAO.selectById(inputID);
		return user;
	}

	public static boolean checkAns(UsersDTO user, String inputAns) {
		// TODO Auto-generated method stub
		return true;
	}


	public static UsersDTO login(String inputID, String inputPassword) {
		// 로그인
		UsersDTO user = UsersDAO.selectById(inputID);
	    if (user == null) {
	        return null; // 아이디 없음
	    }

	    if (!user.getPassword().equals(inputPassword)) {
	        return null; // 비밀번호 틀림
	    }

	    return user; // 로그인 성공
	}

	public static void updatePass(UsersDTO user, String inputPass) {
		// TODO Auto-generated method stub
		
	}	

}
