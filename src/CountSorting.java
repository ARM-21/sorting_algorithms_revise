import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Collections.swap;

public class CountSorting {

    static Scanner scanner = new Scanner(System.in);


    public static void removeDuplicates2(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int max = findMaxSize(arr);
        int[] freq = new int[max + 1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        System.out.println(Arrays.toString(freq));
        int[] prefSum = new int[freq.length];
        prefSum[0] = freq[0];
        for(int i=1;i<freq.length;i++){
            prefSum[i] = prefSum[i-1] + freq[i];
        }
        System.out.println(Arrays.toString(prefSum));
        int[] newArray = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){

//                arr[prefSum[i]-1] = -1;
                int ind = prefSum[arr[i]]-1;
                newArray[ind] = arr[i];
                prefSum[arr[i]]--;





        }
        System.out.println(Arrays.toString(newArray));


    }
    public void removeDuplicates(int[] nums) {
        int max = nums[0];

        for(int i: nums){
            if(max < i){
                max = i;
            }
        }

        int[] freqArray = new int[max+1];
        int[] pref = new int[freqArray.length];
        for(int i=0;i<nums.length;i++){
            freqArray[nums[i]]++;
          }
        pref[0] = freqArray[0];
        for(int i=1;i<freqArray.length;i++){
    pref[i] = pref[i-1] + freqArray[i];
        }

        for(int i=0;i<freqArray.length;i++){
            if(freqArray[i] >= 3){
                nums[pref[i]-1] = -888;
            }


        }
        System.out.println(Arrays.toString(freqArray));
        System.out.println(Arrays.toString(pref));
        System.out.println(Arrays.toString(nums));

    }

    public static void basicCountSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){

            }
        }
    }

    public static void basicCountSorting2(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){

                if(max < arr[i]){
                max = arr[i];

            }
        }

        int[] freq = new int[max+1];


        for(int i=0;i<freq.length;i++){
            freq[arr[i]]++;
        }
        int k=0;
        System.out.println(Arrays.toString(freq));
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<freq[i];j++){
                arr[k++] = i;
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    public static int findMaxSize(int[] arr) {
        int max = Integer.MIN_VALUE;
for(int i=0;i<arr.length;i++){
        if(arr[i] >max){
            max = arr[i];
}}
return max;
    }
    public static int[] frequencyArray(int[] arr) {
        int[] freq = new int[findMaxSize(arr)+1];

        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        return freq;
    }

    public static void swap(int[] arr, int l , int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void twoPointers(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        while( l < r) {
            if (arr[l] == 1 && arr[r] == 0) {
                swap(arr, l, r);
                l++;
                r--;
            }
            if(arr[l] == 0){
                l++;

            }
            if(arr[r] == 1){
                r--;
            }
        }


    }

    public static void oddAndEven(int[] arr) {
        int l=0;
        int r = arr.length-1;
while(l < r){
    if(arr[r]%2 ==0 && arr[l]%2 != 0){
        swap(arr,l,r);
        l++;
        r--;
    }
    if(arr[l]%2 == 0){
        l++;
    }
    if(arr[r] != 0){
        r--;
    }
}
    }


    public static void prefixSumUsingNewArray(){
        int[] arr = {1,2,5,7,8};
        int[] pref = new int[arr.length];
        pref[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            pref[i] = pref[i-1] + arr[i];
        }
        System.out.println(Arrays.toString(pref));

        for(int i=1;i<arr.length;i++){
            arr[i] = arr[i-1] + arr[i];
        }
        System.out.println(Arrays.toString(arr));

    }



//    only works on no-decreasing or sorted array.
    public static void nonDecreasingSquaredArray(int[] arr){

        int l=0;
        int k=0;
        int[] newArr = new int[arr.length];
        int r = arr.length -1 ;
        while(l <= r){
            if(Math.abs(arr[l]) > Math.abs(arr[r])){
                newArr[k++] = arr[l] * arr[l];
                l++;
            }
            else{
                newArr[k++] = arr[r]*arr[r];
                r--;
            }

        }

        System.out.println(Arrays.toString(newArr));
    }

    public static void countSortingAgain(int[] arr) {
        int max = findMaxSize(arr);
        System.out.println(max);
        int[] frequencyArray = new int[max+1];
        for(int i=0;i<arr.length;i++){
            frequencyArray[arr[i]]++;
        }
        int[] prefCount = new int[frequencyArray.length];
        prefCount[0] = frequencyArray[0];
        for(int i =1;i<frequencyArray.length;i++){
            prefCount[i] = prefCount[i-1] + frequencyArray[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(frequencyArray));
        System.out.println(Arrays.toString(prefCount));
        int[] newArray = new int[arr.length];
for(int i=arr.length-1;i>=0;i--){

    int count = prefCount[arr[i]]-1;
    newArray[count] = arr[i];
    prefCount[arr[i]]--;
}
        System.out.println("output "+Arrays.toString(newArray));
        System.out.println("prefCount "+Arrays.toString(prefCount));

    }

    public static void countSortingAgain2(int[] arr) {
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]){
                max = arr[i];
            }

        }

        int[] freqArray = new int[max+1];
        int[] prefArray = new int[freqArray.length];
        prefArray[0] = freqArray[0];

        for(int i=0;i<arr.length;i++){
            freqArray[arr[i]]++;
        }
        for(int i=1;i<prefArray.length;i++){
            prefArray[i] = prefArray[i-1] + freqArray[i];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(freqArray));
        System.out.println(Arrays.toString(prefArray));
        int[] newAray = new int[arr.length];
        for(int i=0;i<freqArray.length;i++){
//int count = prefArray[arr[i]];
//newAray[count-1] = arr[i];
//prefArray[arr[i]]--;
//            System.out.println(i);
//            System.out.println(Arrays.toString(freqArray));
            if(freqArray[i] >=3){
                System.out.println(i);
                arr[prefArray[i]-1] = -1;
//                prefArray[arr[i]]--;

            }
        }
//        System.out.println(Arrays.toString(newAray));
        System.out.println(Arrays.toString(arr));
    }

    public static void bs(int[] arr,int target) {

    }


    public static void main(String[] args) {
        int[] arr = {2,2,2,1,1,1,5,8,6,7,7};
//        nonDecreasingSquaredArray(arr);
//CountSorting ct = new CountSorting();
//ct.removeDuplicates(arr);
//        prefixSumUsingNewArray();
//        twoPointers(arr);
//        System.out.println(Arrays.toString(arr));
//        basicCountSorting2(arr);
//        removeDuplicates2(arr);
//    countSortingAgain(arr);
        countSortingAgain2(arr);
    }


}
