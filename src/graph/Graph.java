package graph;


import edu.princeton.cs.algs4.In;

import java.util.LinkedList;


/**
 * 无向图
 */
public class Graph {
    /*顶点数目*/
    private int vertexCount;

    /*边数目*/
    private int edgeCount;

    /*邻接矩阵*/
    private LinkedList<Integer>[] adj;


    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.edgeCount = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[vertexCount];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int count = in.readInt();
        for (int i = 0; i < count; i++) {
            int v1 = in.readInt();
            int v2 = in.readInt();
            addEdge(v1, v2);
        }
    }

    /**
     * 获取图的顶点数
     *
     * @return
     */
    public int getVertexCount() {
        return vertexCount;
    }

    /**
     * 获取图的边数
     *
     * @return
     */
    public int getEdgeCount() {
        return edgeCount;
    }

    /**
     * 获取顶点的邻接矩阵
     *
     * @param v
     * @return
     */
    public LinkedList<Integer> getAdj(int v) {
        return adj[v];
    }

    /**
     * 连接两顶点
     *
     * @param v1
     * @param v2
     */
    public void addEdge(int v1, int v2) {
        adj[v1].addFirst(v2);
        adj[v2].addFirst(v1);
        edgeCount++;
    }

    /**
     * 打印图的邻接矩阵
     */
    public void print() {
        for (int i = 0; i < vertexCount; i++) {
            System.out.print("vertex: " + i + "\t" + "    adj[]:");
            for (Integer vertex : adj[i]) {
                System.out.print(vertex + "  ");
            }
            System.out.println();
        }
    }


    /**
     * 图顶点的度
     *
     * @param v
     * @return
     */
    public int degree(int v) {
        return adj[v].size();
    }

    /**
     * 图最大的度
     *
     * @return
     */
    public int maxDegree() {
        int max = 0;
        for (LinkedList<Integer> vertex : adj) {
            max = vertex.size() > max ? vertex.size() : max;
        }
        return max;
    }


    /**
     * 图中自环数
     *
     * @return
     */
    public int numberOfSelfLoops() {
        int number = 0;
        for (int i = 0; i < adj.length; i++) {
            for (Integer vertex : adj[i]) {
                if (vertex == i) {
                    number++;
                }
            }
        }
        return number;
    }



    public static void main(String[] args) {
    /*    Graph graph = new Graph(13);
        graph.addEdge(0,5);
        graph.addEdge(4,3);
        graph.addEdge(0,1);
        graph.addEdge(9,12);
        graph.addEdge(6,4);
        graph.addEdge(5,4);
        graph.addEdge(0,2);
        graph.addEdge(11,12);
        graph.addEdge(9,10);
        graph.addEdge(0,6);
        graph.addEdge(7,8);
        graph.addEdge(9,11);
        graph.addEdge(5,3);
        graph.print();
        System.out.println(graph.getEdgeCount());*/
        Graph graph = new Graph(new In("tinyG.txt"));
        graph.print();

    }

}
