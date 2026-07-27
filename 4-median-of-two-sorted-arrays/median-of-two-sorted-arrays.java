class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n+m];

        for(int i=0;i<nums1.length;i++){
            arr[i] = nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            arr[nums1.length+i] = nums2[i];
        }
        Arrays.sort(arr);
        if(arr.length % 2 == 1){
           return arr[arr.length/2];
        }
        else{
            return (arr[arr.length/2] + arr[arr.length/2 -1])/2.0;
        }

        
    }
}