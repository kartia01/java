package study04;

public class UserInfoTest {

	public static void main(String[] args) {
		UserInfo userLee = new UserInfo();
//		user.Lee.userId = "000011";
		userLee.userName = "홍길동";
		System.out.println(userLee.userEmail);
		System.out.println(userLee);
		
		UserInfo userhan = new UserInfo("00011","한석봉");
		UserInfo userhan1 = new UserInfo("00012","한철수","test@.test.com");
		
		System.out.println(userhan.showInfo());
		System.out.println(userhan1.showInfo());
		
		System.out.println(userhan.getUserId());

		System.out.println(userhan1);
	}

}
