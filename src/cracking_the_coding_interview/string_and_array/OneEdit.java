package cracking_the_coding_interview.string_and_array;

class OneEdit {
    public boolean isOneEditDistance(String s, String t) {


        //check for equal string
        if (s.length() == t.length())
            return checkForEqualString(s, t);

        return checkForUnequalString(s, t);


    }


    private boolean checkForUnequalString(String s, String t) {

        // for one insertion only 1 length insertion is allowed
        int sLen = s.length();
        int tLen = t.length();
        if (Math.abs(sLen - tLen) > 1)
            return false;

        int i = 0;
        int j = 0;
        int diff = 0;

        while (i < sLen && j < tLen) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {

                // difference already one, more can not be allowed
                // so test case should fAIL
                if (diff == 1) {
                    return false;
                }

                diff++;

                if (sLen > tLen) {
                    i++;
                } else {
                    j++;
                }

            }


        }


        return true;

    }


    private boolean checkForEqualString(String s, String t) {
        //for equal string only one difference is allowed
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                count += 1;
                if (count > 1)
                    return false;
            }
        }

        if (count == 0)
            return false;
        return true;

    }
}