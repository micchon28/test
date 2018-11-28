public class Test {
	public static void main(String[] args){
		TestUserDAO dao = new TestUserDAO();
		dao.select("taro", "123");
		dao.selectALL();
		dao.selectByName("taro");
		dao.selectByPassword("123");
		dao.updateUserNameByUserName("taro", "saburo");
		dao.selectByPassword("123");
		dao.insert(4, "shiro", "012");
		dao.selectByPassword("012");
		dao.delete("shiro");
		dao.selectALL();
	}
}
