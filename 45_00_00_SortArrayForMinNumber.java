 解题思路：
 * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
 * 排序规则如下：
 * 若ab > ba 则 a > b，
 * 若ab < ba 则 a < b，
 * 若ab = ba 则 a = b；
 * 解释说明：
 * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        int n;
        String s="";
        ArrayList<Integer> list=new ArrayList<Integer>();
        n=numbers.length;
         
        for(int i=0;i<n;i++){
            list.add(numbers[i]);//将数组放入arrayList中
        }
        //实现了Comparator接口的compare方法，将集合元素按照compare方法的规则进行排序
        Collections.sort(list,new Comparator<Integer>(){
         
            @Override
            public int compare(Integer str1, Integer str2) {
                // TODO Auto-generated method stub         
                    String s1=str1+""+str2;
                    String s2=str2+""+str1;
                     
                    return s1.compareTo(s2);
                }
            });
         
        for(int j:list){
            s+=j;
        }
        return s;
    }
}
