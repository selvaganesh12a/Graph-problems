import java.util.*;
public class NetworkCable {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);  // onlinegdb.com/gcS84UTyC
        int n=sc.nextInt();
        HashMap<Character,Boolean> visited=new HashMap<>();
        HashMap<Character,List<Character>> adjmap=new HashMap<>();
        int edges=sc.nextInt();
        char start=sc.next().charAt(0);
        for(int i=0;i<edges;i++){
            char u=sc.next().charAt(0),v=sc.next().charAt(0);
            adjmap.putIfAbsent(u,new ArrayList<>());
            adjmap.putIfAbsent(v,new ArrayList<>());
            adjmap.get(u).add(v);
            adjmap.get(v).add(u);
            visited.putIfAbsent(u,false);
            visited.putIfAbsent(v,false);
        }
        Queue<Character> q=new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            char c=q.poll();
            visited.put(c,true);
            System.out.print(c+" ");
            for(char m : adjmap.get(c)){
                if(visited.containsKey(m) && !visited.get(m)) {
                    q.offer(m);
                }
            }
        }
    }
}