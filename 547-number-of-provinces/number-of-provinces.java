class Solution {


    public static void helper(int src,HashMap<Integer,ArrayList<Integer>>graph,boolean[]vis){
        if(vis[src]){
            return;
        }


        vis[src] = true;
        ArrayList<Integer> destNodes = graph.get(src);
        if(destNodes == null || destNodes.size() == 0){
            return;
        }


        for(int dest : destNodes){
            helper(dest,graph,vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {



        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

        int n = isConnected.length;
        int m = isConnected[0].length;


        for(int i = 0;i<n;i++){

            graph.put(i,new ArrayList<>());
            for(int j = 0;j<m;j++){
                System.out.print(isConnected[i][j]+" ");

                if(i == j){
                    continue;
                }
                
                if(isConnected[i][j] == 1){
                    graph.get(i).add(j);
                }

            }
            System.out.println();
        }

        System.out.println(graph);


        int counter = 0;

        boolean[]vis = new boolean[n];

        for(int i = 0;i<n;i++){
            if(!vis[i]){
                counter++;
                helper(i,graph,vis);
            }
        }
        return counter;
        
    }
}