import java.util.*;

public class MergeAccounts {


    public List<List<String>>  merge(List<List<String>> accounts){
        HashMap<String, Node> map = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();
        for(List<String> account: accounts){
            for(int i = 1; i < account.size(); i ++){
                emailToName.put(account.get(i), account.get(0));
                if(!map.containsKey(account.get(i))) {
                    map.put(account.get(i), new Node(account.get(i)));
                }
            }

            for(int i = 1; i < account.size(); i ++){
                for(int j = i + 1; j < account.size() ; j ++){
                    map.get(i).neighbor.add(map.get(j));
                    map.get(j).neighbor.add(map.get(i));
                }
            }
        }

        HashSet<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, Node> entry : map.entrySet()){
            if(!visited.contains(entry.getKey())){
                queue.add(entry.getValue());
                String owner = emailToName.get(entry.getKey());
                List<String> mergedaccount = new ArrayList<>();
                mergedaccount.add(owner);
                while(!queue.isEmpty()){
                    Node tmp = queue.poll();
                    mergedaccount.add(tmp.email);
                    for(Node next: tmp.neighbor){
                        if(!visited.contains(next.email)){
                            queue.add(next);
                        }
                    }
                }
                result.add(mergedaccount);
            }
        }

        return result;
    }


    class Node{
        String email;
        HashSet<Node> neighbor;
        Node(String email){
            this.email = email;
            this.neighbor = new HashSet<>();
        }
    }
}
