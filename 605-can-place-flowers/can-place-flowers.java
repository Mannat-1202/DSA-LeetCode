class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int l = flowerbed.length;

        for(int i=0;i<l;i++){

            if(flowerbed[i] == 0){

                int left = (i == 0) ? 0 : flowerbed[i-1];
                int right = (i == l-1) ? 0 : flowerbed[i+1];

                if(left == 0 && right == 0){
                    flowerbed[i] = 1;
                    n--;
                    if(n==0) return true;
                }
            }
        }
        return n<=0;
    }
}