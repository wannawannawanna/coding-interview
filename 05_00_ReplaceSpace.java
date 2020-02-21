package Offer;

public class example5_1 {
//	public String replaceSpace(StringBuffer str) {
//    	return str.toString().replaceAll(" " , "%20");
//    }
//	或者
	public String replaceSpace(StringBuffer str) {
    	if(str == null) {
    		return null;
    	}
    	for(int i = 0; i < str.toString().length(); i++) {
    		char c = str.charAt(i);
    		if(c == ' ') {
    			str.replace(i, i+1, "%20");
    		}
    	}
    	return str.toString();
    }
	public static void main(String[] args) {
		example5_1 ex = new example5_1();
		StringBuffer str = new StringBuffer("We are happy");
		System.out.println(ex.replaceSpace(str));
	}
}
