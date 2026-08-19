class Solution {
    public List<Integer> partitionLabels(String s) {
        
        HashMap<Character,Integer> last = new HashMap<>();

        for(int i=0;i<s.length();i++){
            last.put(s.charAt(i),i);
        }
        int start=0;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        for(int i =0;i<s.length();i++){

            char c = s.charAt(i);
            end = Math.max(end,last.get(c));
            if(i == end){
                result.add(end - start +1);
                start = end +1;
            }
        }
        return result;
    }
}