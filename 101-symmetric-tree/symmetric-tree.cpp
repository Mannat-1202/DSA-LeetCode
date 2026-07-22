/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool solve(TreeNode* root1, TreeNode* root2)
    {
        if(root1 == NULL && root2 == NULL)
        {
            return true;
        }
        if(root1 == NULL && root2 != NULL)
        {
            return false;
        }
        if(root1 != NULL && root2 == NULL)
        {
            return false;
        }

        if(root1->val != root2->val)
        {
            return false;
        }

        bool first = solve(root1->left, root2->right);
        bool second = solve(root1->right, root2->left);

        return first && second;
    }
    bool isSymmetric(TreeNode* root) {
        if(root == NULL)
        {
            return true;
        }

        return solve(root->left,root->right);
    }
};