class Solution {
     public String reverseParentheses(String s) {
        char[]a=s.toCharArray();
        Stack<String>stack=new Stack<>();
        StringBuilder temp= new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a[i]=='('){
                stack.push(temp.toString());
                temp=new StringBuilder();
            }
            else if (a[i]==')'){
                temp=new StringBuilder(stack.pop()+temp.reverse().toString());
            }else {
                temp.append(a[i]);
            }
        }
        return temp.toString();
    }
}