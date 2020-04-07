//以键值对的方式存储每个字符出现的频次，键是字符，值是出现的频次
import java.util.HashMap;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null){
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                int num = map.get(str.charAt(i));  //put()  和  get()
                map.put(str.charAt(i), num + 1);  //这里不要写自增的写法，省的出错，如num++就不对， 得是++num
            }
            else{
                map.put(str.charAt(i), 1);
            }
        }
        for(int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;      
    }
}
