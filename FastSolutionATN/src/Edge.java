
/**
 * Class that represents an edge of a Graph
 * @author 
 *
 */

import java.lang.Exception;

public class Edge {
	Vertex from; // head vertex
	Vertex to; // tail vertex
	int weight;// weight of edge
	int capcity;


	Edge(Vertex u, Vertex v, int w) {
		from = u;
		to = v;
		weight = w;
		capcity = 0;
	}

	public Vertex otherEnd(Vertex u) {
		assert from == u || to == u;
		// if the vertex u is the head of the arc, then return the tail else
		// return the head
		if (from == u) {
			return to;
		} else {
			return from;
		}
	}

	@Override
	public int hashCode() {
		int h1 = this.from.hashCode() + this.to.hashCode();
		return h1;
	}

	@Override
	public boolean equals(Object o) {
		Edge e = (Edge) o;
		if(o==null || o.getClass()!=this.getClass()){
			return false;
		}
		if ((this.to == e.to) && (this.from == e.from)) {
			return true;
		}
		return false;
	}

	/**
	 * Return the string "(x,y)", where edge goes from x to y
	 */
	public String toString() {
		return "(" + from + "," + to + ")";
	}

	public String stringWithSpaces() {
		return from + " " + to + " " + weight;
	}
}
