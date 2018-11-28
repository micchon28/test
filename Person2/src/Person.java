
public class Person {
	public String name = null;
	public int age = 0;

	public Person(){}
	/* ↑コンストラクタ1 */

	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	/* ↑コンストラクタ2 */

	public Person(String name){
		this.name = name;
		this.age = 0;
	}
	/* ↑コンストラクタ3 */

	public Person(int age){
		this.name = "名前なし";
		this.age = age;
	}
	/* ↑コンストラクタ4 */

	public Person(int age, String name){
		this.name = name;
		this.age = age;
	}
	/* ↑コンストラクタ5 */

}
