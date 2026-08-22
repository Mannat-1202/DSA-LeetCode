class Solution {
    public boolean checkDivisibility(int n) {
        
        if(n == 0) return true;
        int num = n;
        int dsum = 0;
        int dproduct = 1;
        while(num>0){

            int n1 = num%10;
            dsum += n1;
            dproduct *= n1;
            num= num/10;
            
        }
        int sum = dsum + dproduct;
       return n % sum  == 0;
    }
}