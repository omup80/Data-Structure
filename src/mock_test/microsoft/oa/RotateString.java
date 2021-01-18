package mock_test.microsoft.oa;
//https://leetcode.com/problems/rotate-string/
class RotateString {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length())
            return false;
        A = A+A;
        if(A.contains(B))
            return true;
        return false;
    }
}