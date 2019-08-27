package Others;

import java.util.Arrays;


public class Heap {
    /**
     * 完成一次建堆，最大值在堆的顶部(根节点)
     */
    public static void maxHeapify(int[] arrays, int size) {

        // 从数组的尾部开始，直到第一个元素(往往是从数组最后一个元素来进行建堆)
        for (int i = size-1; i >= 0; i--) {
            heapify(arrays, i, size);
        }

    }
    /**
     * 建堆
     *
     * @param arrays 看作是完全二叉树
     * @param cur 当前父节点位置
     * @param size 节点总数
     */
    public static void heapify(int[] arrays, int cur, int size) {

        if (cur < size) {
            //左子树和右字数的位置
            int left = 2 * cur + 1;
            int right = 2 * cur + 2;

            //把当前父节点位置看成是最大的
            int max = cur;

            if (left < size) {
                //如果比当前根元素要大，记录它的位置
                if (arrays[max] < arrays[left]) {
                    max = left;
                }
            }
            if (right < size) {
                //如果比当前根元素要大，记录它的位置
                if (arrays[max] < arrays[right]) {
                    max = right;
                }
            }
            //如果最大的不是根元素位置，那么就交换
            if (max != cur) {
                int temp = arrays[max];
                arrays[max] = arrays[cur];
                arrays[cur] = temp;

                //继续比较，直到完成一次建堆
                heapify(arrays, max, size);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,6,7,2,3,4,5};
        for (int i = 0; i < arr.length; i += 5) {
            System.out.println(arr[i]);
        }
        //完成第一次建堆
        maxHeapify(arr, arr.length-1);

        //记录数组最大下标的位置
        int size = arr.length-1;

        //接下来不断对堆顶执行调整方法heapify()，然后让数组最后一位与当前堆顶（数组第一位）进行交换,反复，即可排序
        for(int i = 0; i < arr.length; i++){
            int temp = arr[0];
            arr[0] = arr[(arr.length -1) -i];
            arr[(arr.length -1) -i] = temp;

            heapify(arr, 0, size);
            size--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
