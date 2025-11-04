package study04;

public class UserInfo {
	
    //	default 자신패키지
    //	public 전체접근
	//  private class안에서만 사용
	
	private String userId;
	String userPassword; //public 생략 가능
	String userName;
	String userEmail;
	String userPhone;
	
//	public UserInfo(String string, String string2) {
//		userId = string;
//		userName = string2;
//	}
	public UserInfo(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

//	public UserInfo() {
//	}

	public UserInfo(String userId, String userName, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + "]";
	}

	public String showInfo() {
		return "고객님의 아이디는 " + userId + "이고, 등록된 이름은 " + userName + "입니다.";
	}
}
