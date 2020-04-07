import java.util.HashMap;
import java.util.ArrayList;
public class Solution {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    ArrayList<Character> list = new ArrayList<Character>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            int num = map.get(ch);
            map.put(ch, num + 1);
        }
        else{
            map.put(ch, 1);
        }
        list.add(ch);  //替代哈希表中的键
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if(map == null){
            return '#';
        }
        for(Character ch : list){  //因为是动态的，所以没有范围，只能借助别的容器来存储字符流中字符，然后获取这些字符出现的频次
            if(map.get(ch) == 1){
                return ch;
            }
        }
        return '#';
    }
}
