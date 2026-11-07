
class Solution {
    public boolean repeatedSubstringPattern(String s) {

        String doubled = s + s;

        String result = doubled.substring(1, doubled.length() - 1);

        return result.contains(s);
    }
}
