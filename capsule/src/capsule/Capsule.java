package capsule;

public class Capsule {
	public static void main(String args[]){
		Person taro = new Person("�R�c���Y", 20);
		System.out.println(taro.getName());
		taro.setName("�c�����Y");
		System.out.println(taro.getName());
		System.out.println(taro.getAge());
		taro.setAge(30);
		System.out.println(taro.getAge());

	}
}
