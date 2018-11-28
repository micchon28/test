package jp.co.internous.action;

public class Test {

	public static void main(String[] args){

		Person taro = new Person();
		taro.name = "山田太郎";
		taro.age=20;
		taro.phoneNumber = "080-1234-5678";
		taro.address = "東京";

		System.out.println(taro.name);
		System.out.println(taro.age);
		System.out.println(taro.phoneNumber);
		System.out.println(taro.address);

		Person jiro = new Person();
		jiro.name = "木村次郎";
		jiro.age = 18;
		jiro.phoneNumber = "080-1122-3344";
		jiro.address = "埼玉";

		System.out.println(jiro.name);
		System.out.println(jiro.age);
		System.out.println(jiro.phoneNumber);
		System.out.println(jiro.address);

		Person hanako = new Person();
		hanako.name = "鈴木花子";
		hanako.age = 16;
		hanako.phoneNumber = "080-5566-7788";
		hanako.address = "千葉";

		System.out.println(hanako.name);
		System.out.println(hanako.age);
		System.out.println(hanako.phoneNumber);
		System.out.println(hanako.address);

		Person mitsuki = new Person();
		mitsuki.name = "野井光樹";
		mitsuki.age = 29;
		mitsuki.phoneNumber = "080-1112-2233";
		mitsuki.address = "秋田";

		System.out.println(mitsuki.name);
		System.out.println(mitsuki.age);
		System.out.println(mitsuki.phoneNumber);
		System.out.println(mitsuki.address);

		taro.talk();
		jiro.walk();
		hanako.run();

		Robot aibo = new Robot();
		Robot asimo = new Robot();
		Robot pepper = new Robot();

		aibo.name = "aibo";
		asimo.name = "asimo";
		pepper.name = "pepper";

		aibo.talk();
		asimo.walk();
		pepper.run();


	}



}
