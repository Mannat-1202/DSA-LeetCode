class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtrack(s,0,path,result);
        return result;
    }
    private void backtrack(String s,int start ,List<String> path,List<List<String>> result){

        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int end = start; end<s.length();end++){
            if(palindrome(s,start,end)){

                 path.add(s.substring(start,end+1));

                 backtrack(s,end+1,path,result);

                 path.remove(path.size()-1);
            }
        }
    }
    private boolean palindrome(String s , int start, int end){
        
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}