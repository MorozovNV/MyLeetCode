package num4_ValidParentheses;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        char[] round = {'(', ')'};
        char[] square = {'[', ']'};
        char[] curly = {'{', '}'};
        char[] chars = new char[s.length()];
        boolean open = false;

        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (chars[i] == round[0] || chars[i] == square[0] || chars[i] == curly[0]) {
                open = true;
            }else if (open && (chars[i] == round[1] || chars[i] == square[1] || chars[i] == curly[1])) {
                open = false;
            } else return false;
            if (chars[i] == round[0] && chars[i + 1] != round[1]) {
                return false;
            }
            if (chars[i] == square[0] && chars[i + 1] != square[1]) {
                return false;
            }
            if (chars[i] == curly[0] && chars[i + 1] != curly[1]) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("()[]{}("));
        System.out.println(solution.isValid(")()[]{}("));
        System.out.println(solution.isValid("())[]{}("));
    }
}