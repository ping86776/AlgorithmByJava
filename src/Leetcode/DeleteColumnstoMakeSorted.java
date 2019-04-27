package Leetcode;

/**
 * 944. Delete Columns to Make Sorted
 */
public class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] A) {
        int count = 0;
        for(int i = 0;i < A[0].length();i++){
            for(int j = 0;j < A.length-1;j++){
                if(A[j].charAt(i) > A[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"cba", "daf", "ghi"};
//        for (int i = 0; i < A[0].length(); i++) {
//            System.out.println(A[0].substring(0,i)+A[0].substring(i+1));
//        }
        DeleteColumnstoMakeSorted d = new DeleteColumnstoMakeSorted();
        d.minDeletionSize(A);

    }
}
