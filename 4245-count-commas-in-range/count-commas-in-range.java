class Solution {
    public int countCommas(int n) {
        int comma = 0;
        if(n<1000) return 0;
        else{
            comma = n - 999;
        }
        return comma;
        
    }
}