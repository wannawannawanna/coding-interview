//  解题思路：潜在的大数问题，拼接之后可能溢出整形的范围
//  * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
//  * 排序规则如下：
//  * 若ab > ba 则 a > b，
//  * 若ab < ba 则 a < b，
//  * 若ab = ba 则 a = b；
//  * 解释说明：
//  * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
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
     //比较器就是一个接口，通过实现这个接口重写compare方法，返回正值代表大于返回0代表等于，返回负值代表小于。这样就可以自定义排序方法。
     //jdk8的List本身也支持比较器排序。jdk7中集合可以使用Collections的sort方法，实现自定义比较器排序，
     //数组可以通过Arrays.sort()方法实现自定义比较器排序。
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
//         StringBuilder builder = new StringBuilder();
//         for (Integer num : list) {
//             builder.append(num);
//         }
//         return builder.toString();
    }
}


//解法二，
import java.util.Arrays;
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
