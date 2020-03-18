// 堆排序:
//   堆排序是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序，它的最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序。
// 堆:
// 　堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。
//   同时，我们对堆中的结点按层进行编号，将这种逻辑结构映射到数组中。
// 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]  
// 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]  
// // 时间复杂度O(N), 初始化建堆时间复杂度O(N), 最底层元素调整一次, 倒数第二层调整两次, 倒数第三层三次
//              树高为H = log(N), 即2^H = N, 最底层2^{H-1}个节点
//              所以总次数: S =            1*2^{H-1} + 2*2^{H-2} + 3*2^{H-3} +... 共logN项
//                        2S = 1*2^{H} + 2*2^{H-1} + 3*2^{H-2} + ...
//                        S = 1*2^{H} + 2^{H-1} + 2^{H-2} +... 共logN项
//                          = 2^{H+1}(1-(1/2)^{logN})
//                          约等于2n
//              将堆顶元素放至末尾, 然后重新调整堆结构的时间复杂度O(NlogN), 每次O(logN)
             
//   堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。
// 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了。
// 步骤一 构造初始堆。将给定无序序列构造成一个大顶堆（一般升序采用大顶堆，降序采用小顶堆)。
//   1.假设给定无序序列结构arr。
//   2.此时我们从最后一个非叶子结点开始（叶结点自然不用调整，第一个非叶子结点 arr.length/2-1），从左至右，从下至上进行调整。判断子节点和父节点的值大小，
//   把大的放到父节点位置上，进行交换。
//   3.查找所有非叶子结点。进行调整，直到得到大顶堆。
// 步骤二 将堆顶元素与末尾元素进行交换，使末尾元素最大。然后继续调整堆，再将堆顶元素与末尾元素交换，得到第二大元素。如此反复进行交换、重建、交换。
//   1.for(int i = 0; i < arr.length - 1; i++)，length依次减1反复调整堆结构，获得有序序列。
  
import java.util.Arrays;

/**
 * Created by chengxiao on 2016/12/17.
 * 堆排序demo
 */
public class HeapSort {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}


//快速排序，适用于链表的写法，partition的时间复杂度o(n),QuickSort的时间复杂度是o(logn),快速排序的时间复杂度即o(nlogn)。
private void swap(int a, int b) {
        int temp = a;
        a = b;
        b = a;
    }
int partition(int[] nums, int begin, int end){
    if(begin == end){
        return begin;
    }
    int base = begin;//从左到右扫描，使用与链表
    int slow = begin;//标致着替换的位置,slow最终会停留在比base元素小的最后一个元素下标上，[3,6,2,1,4,2,7],这时slow等于下标5。
    int fast = slow + 1; //fast依次往右扫描，对比是否比base小
    while(fast <= end){
        if(nums[fast] < nums[base]){
            slow++;
            swap(nums[slow], nums[fast]);
        }
        fast++;
    }
    swap(nums[base], nums[slow]);
    return slow;
}
int[] QuickSort(int[] nums, int begin, int end){
    if(nums.length != 0 && begin <= end){
        int index = partition(nums, begin, end);
        QuickSort(nums, begin, index - 1);
        QuickSort(nums, index + 1, end);
    }
    return nums;
}


//归并排序,一般应用是，海量数据的时候，先用一次归并排序拆分成若干个小数组，然后小数组内不用归并排序进行排序，而是使用快速排序，然后存到文件中，
//顺序读取，合并到一个文件中
// 注意, 首先要把数组分成两部分, 然后再把两部分当做有序数组来进行合并,时间复杂度o(NlogN)
import java.util.Arrays;

/**
 * Created by chengxiao on 2016/12/8.
 */
public class MergeSort {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}


//插入排序（Insertion Sort）算法是一个对少量元素进行排序的有效算法。
// 插入排序是稳定的（即：两个相等的数不会交换位置）。
//   插入排序是在一个已经有序的小序列的基础上，一次插入一个元素。当然，刚开始这个有序的小序列只有1个元素，就是第一个元素。比较是从有序序列的末尾开始，
// 也就是想要插入的元素和已经有序的最大者开始比起，如果比它大则直接插入在其后面，否则一直往前找直到找到它该插入的位置。如果碰见一个和插入元素相等的，
// 那么插入元素把想插入的元素放在相等元素的后面。所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的。
// 时间复杂度：
//   将有n个元素的数组排序。
//   最佳情况就是，数组已经是正序排列了，在这种情况下，需要进行的比较操作是 （n-1）次即可。
//   最坏情况就是，数组是反序排列，那么此时需要进行的比较共有n(n-1)/2次。
//   插入排序的赋值操作是比较操作的次数加上 (n-1）次。
//   平均插入排序算法的时间复杂度为 O(n²)。因而，插入排序不适合对于数据量比较大的排序应用。

public int[] insertSort(int[] nums){
    for(int i = 1; i < nums.length; i++){
        int temp = nums[i];//临时存储第i个元素
        int j = i;
        //从前面有序序列里面找到比temp大的元素
        while(j > 0 && nums[j - i] > temp){
            nums[j] = nums[j - 1];//只要找到大的元素，依次往右挪
            j--;
        }
        // 存在比其小的数，插入
        if (j != i) {
             nums[j] = temp;
        }    
    }
    return nums;
}


//冒泡排序的基本思想就是：从无序序列头部开始，进行两两比较，根据大小交换位置，直到最后将最大（小）的数据元素交换到了无序队列的队尾，从而成为有序
// 序列的一部分；下一次继续这个过程，直到所有数据元素都排好序。
// 算法的核心在于每次通过两两比较交换位置，选出剩余无序序列里最大（小）的数据元素放到队尾。

public void bubble_sort(int[] arr) {
		int i, j, temp, len = arr.length;
		for (i = 0; i < len - 1; i++){
			for (j = 0; j < len - 1 - i; j++){
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
      }
    }
}
