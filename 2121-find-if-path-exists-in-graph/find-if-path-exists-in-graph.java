class Solution {


    public static boolean helper(int src,int destination,boolean[] vis,HashMap<Integer,ArrayList<Integer>>graph){

        vis[src] = true;
        if(src == destination){
            return true;
        }

        ArrayList<Integer> destNodes = graph.get(src);
        for(int dest : destNodes){

            if(!vis[dest]){
                boolean flag = helper(dest,destination,vis,graph);

                if(flag){
                    return true;
                }
            }
        }

        return false;

    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

        for(int[]arr : edges){
            int src = arr[0];
            int dest = arr[1];

            graph.computeIfAbsent(src,k -> new ArrayList<>()).add(dest);
            graph.computeIfAbsent(dest,k -> new ArrayList<>()).add(src);
        }

        System.out.println(graph);

        boolean[] vis = new boolean[n];

        return helper(source,destination,vis,graph);
        
    }
}