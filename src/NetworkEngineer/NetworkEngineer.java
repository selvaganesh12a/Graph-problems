package NetworkEngineer;

import java.util.*;
class Pair1{
    int u;
    int v;
    int w;
    Pair1(int u, int v, int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
public class NetworkEngineer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("No.Of.Vertices");
        int v = in.nextInt();
        HashSet<Integer> vis = new HashSet<>();
        HashMap<Character,Integer> idx = new HashMap<>();
        HashMap<Integer,Character> ch = new HashMap<>();
        for(int i = 0; i < v; i++) {
            char c = in.next().charAt(0);
            idx.putIfAbsent(c,i);
            ch.putIfAbsent(i,c);
        }
        System.out.println("No. of . connections ");
        int edges = in.nextInt();
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for (int i = 0; i < edges; i++) {
            char src = in.next().charAt(0);
            char dest = in.next().charAt(0);
            int weight = in.nextInt();
            adj.putIfAbsent(idx.get(src),new ArrayList<>());
            adj.get(idx.get(src)).add(new int[]{idx.get(dest),weight});
            adj.putIfAbsent(idx.get(dest),new ArrayList<>());
            adj.get(idx.get(dest)).add(new int[]{idx.get(src),weight});
        }
        int sum = 0;
        PriorityQueue<Pair1> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        pq.add(new Pair1(0,-1,0));
        while(!pq.isEmpty()){
            Pair1 temp = pq.poll();
            if(!vis.contains(temp.u)){
                vis.add(temp.u);
                if(temp.v != -1) System.out.println(temp.u + " -> " + temp.v + " Weight " + temp.w);
                sum += temp.w;
                for(int[] i: adj.get(temp.u)){
                    if(!vis.contains(i[0]))
                        pq.add(new Pair1(i[0],temp.u,i[1]));
                }
            }
        }
        System.out.println(sum);
    }
}
