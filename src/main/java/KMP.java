public class KMP {
    public int[] computePrefixArray(String pattern) {
        int[] prefixArray = new int[pattern.length()];
        int j = 0;
        for(int i = 1; i < pattern.length(); i++) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                prefixArray[i] = j + 1;
                j++;
            } else if(j > 0) {
                j = prefixArray[j - 1];
                i--;
            }
        }
        return prefixArray;
    }

    public boolean KMPAlgorithm(String text, String pattern) {
        int[] prefixArray = computePrefixArray(pattern);
        int j = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length() - 1)
                    return true;
                j++;
            } else if(j > 0) {
                j = prefixArray[j - 1];
                i--;
            }
        }
        return false;
    }

}
