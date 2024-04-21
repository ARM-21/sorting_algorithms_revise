import java.util.Arrays;

public class SortingRevise {


    public static void main(String[] args) {
        int[] arr ={2,4,3,1,6,5};
//        quick(arr,0,arr.length-1);
//        mergeSorting(arr,0,arr.length-1);
//        count(arr);
        insertionSorting(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertionSorting(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int currEle = arr[i];
            int j = i-1;
            while(j>=0 && currEle < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = currEle;
        }
    }

    public static void count(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max) max = arr[i];
        }
        int[] freq = new int[max+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        System.out.println(Arrays.toString(freq));
        int[] pref = new int[freq.length];
        pref[0] =freq[0];
        for(int i=1;i<freq.length;i++){
            pref[i] = pref[i-1] + freq[i];
        }
        System.out.println(Arrays.toString(pref));
        int[] outArray = new int[arr.length];
        int k=arr.length-1;
        for(int i=0;i<arr.length;i++){
            int ind = pref[arr[k]]-1;
            outArray[ind] = arr[k];
            pref[arr[k]]--;
            k--;
        }
        System.out.println(Arrays.toString(outArray));


    }

    public static void mergeSorting(int[] arr,int st,int en) {
        if(st >= en) return;
        int mid = st + (en-st)/2;
        mergeSorting(arr,st,mid);
        mergeSorting(arr,mid+1,en);
        merger(arr,st,mid,en);
    }

    public static void merger(int[] arr,int st,int mid,int en) {
        int n1 = mid -st +1;
        int n2 = en -mid;
        int[] lft = new int[n1];
        int[] rgt = new int[n2];
//        int j=0;
        for(int i=0;i<n1;i++){
            lft[i] = arr[i+st];
        }
        for(int k=0;k<n2;k++){
            rgt[k]=arr[k+mid+1];
        }
        int i=0,j=0,k=st;
        while(i<n1 && j<n2){
        if(lft[i] < rgt[j]) arr[k++]=lft[i++];
        else arr[k++] =rgt[j++];
        }

        while(i<n1) arr[k++] = lft[i++];
        while(j<n2) arr[k++] =rgt[j++];

    }

    public static void quick(int[] arr,int st,int en) {
        if(st >= en) return;
        int piInd = partition(arr,st,en);
        quick(arr,st,piInd-1);
        quick(arr,piInd+1,en);
    }

    public static int partition(int[] arr,int st,int en) {
        int piEle = arr[st];
        int count = 0;
        for(int i=st+1;i<arr.length;i++){
            if(piEle > arr[i]) count++;
        }

        int piInd = st + count;
        swap(arr,st,piInd);

        int i=st,j=en;
        while(i<piInd && j>piInd){
            while(arr[i] <piEle) i++;
            while (arr[j] > piEle) j--;
            if(i<piInd && j>piInd){
                swap(arr,i,j);
                i++;
                j--;
            }


        }
        return piInd;
    }

    public static void swap(int[] arr , int st,int en) {
        int temp = arr[st];
        arr[st] = arr[en];
        arr[en] = temp;
    }
}
