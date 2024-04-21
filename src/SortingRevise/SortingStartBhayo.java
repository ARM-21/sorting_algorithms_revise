package SortingRevise;

import java.util.Arrays;

public class SortingStartBhayo {
    public static void merging(int[] arr, int st, int mid, int en) {
        int n1 = mid - st + 1;
        int n2 = en - mid;
        int[] lft = new int[n1];
        int[] rgt = new int[n2];
        for (int i = 0; i < lft.length; i++) {
            lft[i] = arr[i + st];
        }
        for (int j = 0; j < rgt.length; j++) {
            rgt[j] = arr[j + mid + 1];
        }
        int i = 0;
        int j = 0;
        int k = st;
        while (i < n1 && j < n2) {
            if (lft[i] < rgt[j]) {
                arr[k++] = lft[i++];
            } else {
                arr[k++] = rgt[j++];
            }
        }
        while (i < n1) {
            arr[k++] = lft[i++];
        }
        while (j < n2) {
            arr[k++] = rgt[j++];
        }
        System.out.println(Arrays.toString(arr));


    }

    public static void mergeSorting(int[] arr, int st, int en) {
        if (st >= en) {
            return;
        }
        int mid = st + (en - st) / 2;
        mergeSorting(arr, st, mid);
        mergeSorting(arr, mid + 1, en);
        merging(arr, st, mid, en);

    }

    public static int partition(int[] arr, int st, int en) {
        int PIEle = arr[st];
        int count = 0;
        for(int i=st+1;i<arr.length;i++){
            if(arr[i] < PIEle) count++;
        }
        int PIInd = st + count;
        swap(arr,st,PIInd);

        int i=st;
        int j=en;
        while(i<PIInd && j>PIInd){
            while(arr[i]<PIEle) i++;
            while(arr[j]>PIEle) j--;
            if(i<PIInd && j<PIInd){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        return PIInd;
}

    public static void swap(int[] arr,int i ,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void quickSorting(int[] arr,int st,int en) {
        if(st >= en){
            return;
        }
        int PIInd = partition(arr,st,en);
        quickSorting(arr,st,PIInd-1);
        quickSorting(arr,PIInd +1,en);

    }

    public static void insertionSorting(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int currEle = arr[i];
            int j=i-1;
            while(j>=0 && currEle<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = currEle;

        }
        System.out.println(Arrays.toString(arr));
    }

    public static int binarySearch(int[] arr,int st,int en,int target) {

        while(st <= en){
            int mid = st + (en-st)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid]>target) en = mid -1;
            else  st = mid +1;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,6,8};
//        mergeSorting(arr,0,arr.length-1);
//quickSorting(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        insertionSorting(arr);
        System.out.println(binarySearch(arr,0,arr.length-1,8));
    }





}
