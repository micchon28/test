public class SmartPhone extends Mp3Player{

	/* Mp3Player�N���X�̃��\�b�h���I�[�o�[���C�h���镶 */
	public void play(){
		System.out.println("�Đ��i�n�C���]�@�\�j");
	}
	public void stop(){
		System.out.println("��~(�n�C���]�@�\�j");
	}
	public void next(){
		System.out.println("����(�n�C���]�@�\�j");
	}
	public void back(){
		System.out.println("�߂�(�n�C���]�@�\�j");
	}

	/* �I�[�o�[���C�h�����܂� */

	public void call(){
		System.out.println("�d�b");
	}
	public void mail(){
		System.out.println("���[��");
	}
	public void photo(){
		System.out.println("�ʐ^");
	}
	public void internet(){
		System.out.println("�C���^�[�l�b�g");
	}
}
