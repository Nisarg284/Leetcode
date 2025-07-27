class Solution {
public String minWindow(String s, String t) {

    if(t.length() > s.length())
    {
        return "";
    }
        HashMap<Character, Integer> idealMap = new HashMap<>();
        HashMap<Character, Integer> actualMap = new HashMap<>();

        int m = t.length();
        int n = s.length();

        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            idealMap.put(ch, idealMap.getOrDefault(ch, 0) + 1);
        }

        // System.out.println("IdealMap: "+idealMap);

        int len = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int counter = 0;
        String ans = "";

        while (j < n) {
            char right = s.charAt(j);
            if (idealMap.containsKey(right)) {
                actualMap.put(right, actualMap.getOrDefault(right, 0) + 1);

                if (actualMap.get(right).equals( idealMap.get(right))) {
                    counter++;
                }
            }

            while (counter == idealMap.size()) {
                // System.out.println("run inner");
                char left = s.charAt(i);
                int currLen = j - i + 1;
                if (currLen < len) {
                    len = currLen;
                    ans = s.substring(i, j + 1);
                }

                if (idealMap.containsKey(left)) {

                    if (actualMap.get(left) == 1) {
                        actualMap.remove(left);
                        counter--;
                    } else {
                        actualMap.put(left, actualMap.get(left) - 1);
                        if (actualMap.get(left) < idealMap.get(left)) {
                            counter--;
                        }
                    }
                }
                i++;
            }
            j++;

        }
        return ans;
    }

}


