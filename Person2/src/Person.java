
public class Person {
	public String name = null;
	public int age = 0;

	public Person(){}
	/* ���R���X�g���N�^1 */

	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	/* ���R���X�g���N�^2 */

	public Person(String name){
		this.name = name;
		this.age = 0;
	}
	/* ���R���X�g���N�^3 */

	public Person(int age){
		this.name = "���O�Ȃ�";
		this.age = age;
	}
	/* ���R���X�g���N�^4 */

	public Person(int age, String name){
		this.name = name;
		this.age = age;
	}
	/* ���R���X�g���N�^5 */

}
