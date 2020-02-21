package Offer;

public class example5_1 {
//	public String replaceSpace(StringBuffer str) {
//    	return str.toString().replaceAll(" " , "%20");
//    }
//	或者
// 	public String replaceSpace(StringBuffer str) {
// 		if(str == null) {
// 			return null;
// 		}
// 		for(int i = 0; i < str.toString().length(); i++) {
// 			char c = str.charAt(i);
// 			if(c == ' ') {
// 				str.replace(i, i+1, "%20");
// 			}
// 		}
// 		return str.toString();
// 	}
// 	
	public String replaceSpace(StringBuffer str) {
		int spacenum = 0;
		if(str == null) {
			return null;
		}
		int originallength = str.length();
		for(int i = 0; i < str.toString().length(); i++) {
			if(str.charAt(i) == ' ') {
				spacenum ++;
			}
		}
			
		int newlength = originallength + 2 * spacenum;
		originallength--;		
		str.setLength(newlength);
		newlength--;
		for(;newlength > originallength  && originallength >= 0;originallength--) {
			if(str.charAt(originallength) != ' ') {
				str.setCharAt(newlength--, str.charAt(originallength));
			}			
			else {
				str.setCharAt(newlength--, '0');
				str.setCharAt(newlength--, '2');
				str.setCharAt(newlength--, '%');
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
