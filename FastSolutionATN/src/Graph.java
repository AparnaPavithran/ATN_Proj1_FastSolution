/**
 * Class to represent a graph
 * 
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Graph implements Iterable<Vertex> {
	

	
	List<Vertex> v; // vertices of graph
	int size; // number of verices in the graph
	boolean directed;  // true if graph is directed, false otherwise
	int min=Integer.MAX_VALUE;


	/**
	 * Constructor for Graph
	 * 
	 * @param size
	 *            : int - number of vertices
	 */
	Graph(int size) {
		this.size = size;
		this.v = new ArrayList<>(size + 1);
		this.v.add(0, null);  // Vertex at index 0 is not used
		this.directed = false;  // default is undirected graph
		// create an array of Vertex objects
		for (int i = 1; i <= size; i++)
			this.v.add(i, new Vertex(i));
	}

	/**
	 * Find vertex no. n
	 * @param n
	 *           : int
	 */
	Vertex getVertex(int n) {
		return this.v.get(n);
	}

	/**
	 * Method to add an edge to the graph
	 * 
	 * @param a
	 *            : int - one end of edge
	 * @param b
	 *            : int - other end of edge
	 * @param weight
	 *            : int - the weight of the edge
	 */
	void addEdge(Vertex from, Vertex to, int weight) {
		Edge e = new Edge(from, to, weight);
		if(this.directed) {
			from.adj.add(e);
			to.revAdj.add(e);
		} else {
			from.adj.add(e);
			to.adj.add(e);
		}
	}

	/**
	 * Method to create iterator for vertices of graph
	 */
	public Iterator<Vertex> iterator() {
		Iterator<Vertex> it = this.v.iterator();
		it.next();  // Index 0 is not used.  Skip it.
		return it;
	}



	// read a directed graph using the Scanner interface
	public static Graph readDirectedGraph(Scanner in) {
		return readGraph(in, true);
	}

	// read an undirected graph using the Scanner interface
	public static Graph readGraph(Scanner in) {
		return readGraph(in, false);
	}

	public static Graph readGraph(Scanner in, boolean directed) {
		// read the graph related parameters 
		System.out.println("Number of Nodes in the graph");
		int n = in.nextInt(); // number of vertices in the graph - nodes
		//System.out.println("Number of Edges in the graph");
		//int m = in.nextInt(); // number of edges in the graph - edges
		int m=n*(n-1);
		System.out.println("Value of k");
		int k = in.nextInt(); 

		// create a graph instance
		Graph g = new Graph(n);
		g.directed = directed;
		//System.out.println("From To");
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i!=j){
					int u=i;
					int v=j;
					int w;
					if(v<=k){
						w=1;
					}
					else
					{
						w=200;
					}
					g.addEdge(g.getVertex(u), g.getVertex(v), w);
				}
				
			}
		}


//////////////////****************************************************** utd id  ************************
		Integer[] utdid=new Integer[n];
		System.out.println("UTD ID");
		for(int i=0;i<n/2;i++){
			int x=in.nextInt();
			utdid[i]=x;
			utdid[i+n/2]=x;
		}
		
		System.out.println("Input Graph:");
		for(Vertex u: g) {
		    System.out.print(u + ": ");
		    for(Edge e: u.adj) {
			e.otherEnd(u);
			System.out.print(e + " ");
		    }
		    System.out.println();
		}
		FastSolution.fastsoln(n, k, utdid,g);

		
		return g;
	}



	
	

	
	
	/*
	 * 6 6 
	 
	1 2 
	1 3 
	2 5
	3 4
	4 5
	5 6
	
2 0 2 1 3 1 0 9 9 5

6 7  
2 1 5
1 3 7
1 4 15
2 4 10
3 4 1
5 6 2
4 5 1
	
	2 0 2 1 3 1 0 9 9 5
	utd id - 
	 */
	
	/*public Queue<Edge> bfs(Vertex src, Vertex dest) {
	src.seen = true;
	dest.seen= false;
	src.d = 0;
	Queue<Edge> bf = new LinkedList<>();
	Queue<Vertex> q = new LinkedList<>();
	q.add(src);
	while(!q.isEmpty()) {
	    Vertex u = q.remove();
	    for(Edge e: u.adj) {
		Vertex v = e.otherEnd(u);
		if(!v.seen) {
		    v.seen = true;
		    v.d = u.d + 1;
		    q.add(v);
		}
	    }
	}
	return bf;
    }
	public void bfs(){
		for(Vertex u:this){
			u.seen=false;
			u.p=null;
		}
	}
	public void bfs(Vertex src, Vertex dst){
		bfs();
		src.seen=true;
		Queue<Vertex> lst=new LinkedList<>();
		lst.add(src);
		while(!lst.isEmpty()){
			Vertex v=lst.poll();
			for(Edge e:v.adj){
				Vertex u=e.otherEnd(v);
				if(!u.seen) {
					u.seen=true;
					u.d=u.d+1;
					u.p=v;
					lst.add(u);
				}
			}
		}	
	}
	public List<Vertex> path(Vertex dst,Vertex src){
		List<Vertex> path=new LinkedList<>();
		Vertex u=dst; //current vertex
		path.add(dst);
		while(u!=src){
			path.add(0,u.p);
			u=u.p;
		}
		return path;
	}

	public Queue<Vertex> mincostpath(Vertex src, Vertex dest){
		Queue<Vertex> path=new LinkedList<>();
		path.add(src);
		Vertex v=src;
		Vertex minc = null;
		int mincost=Integer.MAX_VALUE;

		Queue<Vertex> c; //check
		if(src==dest){
			return path; 
		}
		else
		{
			for(Edge e:v.adj){
				Vertex u=e.otherEnd(v);
				c=mincostpath(u,dest);
				if(mincost>e.weight){
					mincost=e.weight;
					minc=u;
				}
			}
			path.add(minc);

		}
		return path;
	}
*/
	/*
	 * Number of Nodes in the graph
20
Number of Edges in the graph
32
Value of k
3
From To
20
32
13
1 2
1 3
2 5
2 6
3 4
3 5
5 7
6 7
7 8
7 12
8 11
8 12
9 8
9 4
10 9
10 11
10 15
11 13
11 15
12 14
13 17
13 18
14 13
14 16
15 18
16 19
16 20
17 16
17 18
17 19
18 20
19 20

2 0 2 1 3 1 0 9 9 5

UTD ID :  2 0 2 1 3 1 0 9 9 5
	 */

}


