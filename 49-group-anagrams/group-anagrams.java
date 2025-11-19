class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> hm = Arrays.stream(strs)
                                .collect(Collectors.groupingBy(
                                    word -> {
                                        char[] arr = word.toCharArray();
                                        Arrays.sort(arr);
                                        return new String(arr);
                                    }
                                ));

        List<List<String>> ans = new ArrayList<>();

        hm.values().stream()
        .forEach(curr -> ans.add(curr));

        return ans;
        
    }


}