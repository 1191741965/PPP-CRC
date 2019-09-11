
class CRCTool {
	String crcCode = "";
	int index = 0;
	int i,j;
	int flag=0;
	public CRCTool() {}
	public String setCrcCode(int [] pppArray,int [] crcArray, int pppArrayLength, int crcArrayLength) {
		int [] Arr = new int [10];
		for ( ; i <= pppArrayLength;) {
			i = flag;
			int k = 0;
			Arr[0] = -1;
			for (j = 0; j < crcArrayLength;) {
				if (pppArray[i] != crcArray[j] ) {
					pppArray[i] = 1;
					Arr[k] = i;
					k++;i++;j++;}else {
					pppArray[i] = 0;
					i++;j++;}}
			if (Arr[0] == -1) {
				flag = flag + j;
			}else {
				flag = Arr[0];}
			if ((pppArrayLength - flag) < crcArrayLength) {
				break;}}
		for (int i = (pppArrayLength - crcArrayLength +1); i < pppArrayLength; i++) {
			crcCode += pppArray[i];}
		return crcCode;
	}
}
