import java.util.*;

/**
 * Created by 310288079 on 7/28/2017.
 */
public class TopologicalSort {

    HashMap<Integer, GraphNode> map = new HashMap<Integer, GraphNode>();

    public List<Integer> TopologicalSort(int totalNodes, int[][] edges){

        for(int i = 0; i < totalNodes; i ++){
            map.put(i, new GraphNode());
        }

        for(int[] edge : edges){
            int dest = edge[1];
            int src = edge[0];

            map.get(src).addEdge(dest);
            map.get(dest).in_degree ++;
        }


        List<Integer> ans = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(Map.Entry<Integer, GraphNode> entry : map.entrySet()){
            if(entry.getValue().in_degree == 0){
                queue.offer(entry.getKey());
            }
        }


        while(!queue.isEmpty()){
            int nodeNumber = queue.poll();
            ans.add(nodeNumber);
            for(int nextnodeNumber : map.get(nodeNumber).adjacencyList){
                map.get(nextnodeNumber).in_degree --;
                if(map.get(nextnodeNumber).in_degree == 0)
                    queue.add(nextnodeNumber);
            }
        }



        for(int i = 0; i < ans.size(); i ++){
            System.out.print(ans.get(i) + ", ");
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] edges = new int[][] {{5,2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        TopologicalSort ts = new TopologicalSort();
        ts.TopologicalSort(5, edges);
    }
}


class GraphNode {
    int in_degree = 0;
    List<Integer> adjacencyList = null;

    public GraphNode(){
        this.adjacencyList = new ArrayList<Integer>();
    }

    public void addEdge(int nodeNumber){
        adjacencyList.add(nodeNumber);
    }
}