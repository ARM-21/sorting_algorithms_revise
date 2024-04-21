import java.util.Arrays;
public class Main {

//    public static void main(String[] args) {
//        int[] arr1 = {-4,3,-2,1,-6,-11};
//        int[] arr2 = {};
////        System.out.println(findMedianSortedArrays(arr1,arr2));
//        System.out.println(removeDuplicates(arr1));
////        sortColors(arr1);
////        System.out.println(Arrays.toString(arr1));
////        negativeAndPostitive(arr1);
//
//    }
    public static void negativeAndPostitive(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<0 && arr[j]>0){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                }
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static int partition(int[] arr, int st, int end){
        int piEle = arr[st];
        int count=0;
        for(int i=st+1;i<arr.length;i++){
            if(arr[i] <=piEle){
                count++;
            }
        }
        int piInd = count + st;
        swap(arr,st,piInd);
        int i=st;
        int j=end;
        while(i<piInd && j>piInd){
            while(arr[i] < piEle){
                i++;

            }
            while(arr[j] > piEle){
                j--;
            }
            if(i<piInd && j>piInd){
                swap(arr,i,j);
                i++;
                j--;

            }
        }
        return piInd;
    }

    public static void sorting(int[] arr, int st , int end){
        if(st >= end){
            return;
        }
        int piInd = partition(arr,st,end);
        sorting(arr,st,piInd-1);
        sorting(arr,piInd+1,end);
    }
    public static void sortColors(int[] nums)
    {
        sorting(nums,0,nums.length-1);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<n1 && j<n2){
            if(nums1[i] < nums2[j]){
                arr[k++] = nums1[i++];

            }
            else{
                arr[k++] = nums2[j++];
            }


        }
        while(i<n1){
            arr[k++] = nums1[i++];
        }
        while(j<n2){
            arr[k++] = nums2[j++];

        }
        int median = arr.length/2;
        System.out.println(median);
        System.out.println(Arrays.toString(arr));
        if(arr[0] < 0){
            if(arr.length % 2 == 0){
                return (arr[median - 1] + arr[median])/2.0;
            }
            return arr[median];
        }
        if(arr.length % 2 == 0){

            System.out.println(median);
            return (arr[median - 1] + arr[median])/2.0;
        }
        else{
            return arr[median];
        }



    }
    public static int removeDuplicates(int[] nums) {
        int count= 0;
        int cout = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length-1;j++){
                if(nums[i] == nums[j+1]){
                    nums[j+1] = -888;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != -888){
                count++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] == -888){
                cout++;
            }

        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j] == -888 && nums[j+1] >= -1){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;

                }
 if(!(cout > 0)) {


                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j + 1];
                        nums[j + 1] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(nums));


        return count;


    }

    public static void binarySearch(int[] arr,int st ,int end) {
        int median = st + (end-st)/2;
        while(st <= end){


        }
    }

    public static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(6);
        a.next = b;
        System.out.println(a.next);
        System.out.println(b);
    }
}


