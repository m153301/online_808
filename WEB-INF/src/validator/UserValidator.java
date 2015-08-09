package validator;

public class UserValidator{
	
	private final int MAX_LENGTH_USER_ID = 12;
	private final int MAX_LENGTH_USER_PASSWORD = 12;
	private final int MAX_LENGTH_USER_NAME = 50;
	private String ERROR_USER_ID_TOO_LONG = "ユーザIDは"+Integer.toString(MAX_LENGTH_USER_ID)+"文字以内でご入力ください．";
	private String ERROR_USER_PASSWORD_TOO_LONG = "パスワードは"+Integer.toString(MAX_LENGTH_USER_PASSWORD)+"文字以内でご入力ください．";
	private String ERROR_USER_NAME_TOO_LONG = "氏名は"+Integer.toString(MAX_LENGTH_USER_NAME)+"文字以内でご入力ください．";
	private String ERROR_USER_ID_NOT_BYTE = "ユーザIDは半角英数字でご入力下さい。";
	//formのtypeをpasswordにすると半角しか入力できないから不要だった．
//	private String ERROR_USER_PASSWORD_NOT_BYTE = "パスワードは半角英数字でご入力下さい。";
	
	public UserValidator(){
		
	}
	
	public String validateUserId(String userId){
		if(userId.length() > MAX_LENGTH_USER_ID || userId.length() < 0){
			return ERROR_USER_ID_TOO_LONG;
		}
		else if(!isByte(userId)){
			return ERROR_USER_ID_NOT_BYTE;
		}
		return null;
	}
	
	public String validateUserPassword(String userPassword){
		if(userPassword.length()> MAX_LENGTH_USER_PASSWORD || userPassword.length() < 0){
			return ERROR_USER_PASSWORD_TOO_LONG;
		}
//		else if(!isByte(userPassword)){
//			return ERROR_USER_PASSWORD_NOT_BYTE;
//		}
		return null;
	}
	
	public String validateUserName(String userName){
		return(userName.length() > MAX_LENGTH_USER_NAME || userName.length() < 0)?ERROR_USER_NAME_TOO_LONG:null;
	}
	
	private boolean isByte(String chara){
		byte[] bytes = chara.getBytes();
		if(chara.length() == bytes.length){
			return true;
		}
		else{
			//全角混入
			return false;
		}
	}
	
}