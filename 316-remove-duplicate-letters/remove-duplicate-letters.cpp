class Solution {
public:
    string removeDuplicateLetters(string s) {
        //here we use the stack 
        vector<int> chars(26,0);
        stack<char> st;
        for(int i = 0; i < s.size(); i++)
        {
            chars[s[i] - 'a']++;
        }
        //now we have to store the current stack 
        unordered_set<char> current;
        for(int i = 0; i < s.size(); i++)
        {
            if(current.count(s[i]))
            {
                chars[s[i] - 'a']--;
                continue;
            }
            while(!st.empty() && s[i] < st.top() && chars[st.top() - 'a'] > 1)
            {
                chars[st.top() - 'a']--;
                current.erase(st.top());
                st.pop();
            }
            st.push(s[i]);
            current.insert(s[i]);
        }
        string ans = "";
        while(!st.empty())
        {
            ans += st.top();
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};