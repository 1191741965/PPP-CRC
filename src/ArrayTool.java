

class ArrayTool {
	int [] pppArray = new int [32];
	int [] crcArray = new int [32];
	int pppLength = 0;
	int crcLength = 0;
	public int[] setPppToArray(String pppString, String crcString) {
		//���pppУ�����г���
		pppLength = pppString.length();
		//���crcУ���볤��
		crcLength = crcString.length();
		//pppУ������ת��Ϊ����
		int pppInt = Integer.parseInt(pppString);
		int newPppLength = pppLength + crcLength -1;
		int sum = pppLength + crcLength -1;
		for (int i =  (pppLength-1); i > -1; i--) {
			pppArray[i] = pppInt % 10;
			pppInt /=10;
		}
		int index = pppLength;
		while (index < newPppLength) {
			pppArray[index] = 0;
			index++;
			
		}
		return pppArray;
	}
	public int[] setCrcToArray(String crcString) {
		//���crcУ���볤��
		crcLength = crcString.length();
		//crcУ����ת��Ϊ��������
		int crcInt = Integer.parseInt(crcString);
		for (int i =  (crcLength-1); i > -1; i--) {
			crcArray[i] = crcInt % 10;
			crcInt /=10;
		}
		//��������
		return crcArray;
	}
	public int setPppLength(String pppString) {
		return pppString.length();
	}
	public int setCrcLength(String crcString) {
		return crcString.length();
	}
}
