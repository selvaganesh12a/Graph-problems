import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
class Pair{
    int u;
    int v;
    int w;
    Pair(int u,int v,int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the vertex count ");
        int v = in.nextInt();
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++) adj.add(new ArrayList<>());
        System.out.println("Enter the edges count ");
        int edges = in.nextInt();
        for(int i = 0; i < edges; i++){
            char s = in.next().charAt(0);
            char d = in.next().charAt(0);
            int w = in.nextInt();
            adj.get(s-'A').add(new int[]{d-'A',w});
        }
        boolean[] vis = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        pq.add(new Pair(0,-1,0));
        System.out.println("Selected Edges in MST : ");
        int sum = 0;
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            if(!vis[temp.u]){
                vis[temp.u] = true;
                if(temp.v != -1) System.out.println(temp.v + " -> " + temp.u + " with cost " + temp.w);
                sum += temp.w;
                for(int[] i: adj.get(temp.u)){
                    if(!vis[i[0]]) {
                        pq.add(new Pair(i[0],temp.u,i[1]));
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
