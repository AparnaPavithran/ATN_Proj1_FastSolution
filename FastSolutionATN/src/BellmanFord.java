import java.util.Scanner;
 
public class BellmanFord
{
    private int distances[];
    private int numberofvertices;
    public static final int MAX_VALUE = 9999999;
 
    public BellmanFord(int numberofvertices)
    {
        this.numberofvertices = numberofvertices;
        distances = new int[numberofvertices + 1];
    }
 
    public int[] BellmanFordEvaluation(int source, int adjacencymatrix[][],Integer[] utdid)
    {
        for (int node = 1; node <= numberofvertices; node++)
        {
            distances[node] = MAX_VALUE;
        }
        int den[][] = new int[numberofvertices + 1][numberofvertices + 1];
        
        for (int node = 1; node <= numberofvertices; node++)
        {
        	for (int sn = 1; sn <= numberofvertices; sn++){
        		den[node][sn] = 0;
        	}
        
        }
 
        distances[source] = 0;
        //System.out.println("Source : "+source);
        for (int node = 1; node <= numberofvertices - 1; node++)
        {
        	int src=source;
        	//System.out.println("node : "+node);
            for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
            {
            	//System.out.println("sourcenode : "+sourcenode);
                for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
                {
                	//System.out.println("destinationnode : "+destinationnode);
                        if (distances[destinationnode] > (distances[sourcenode] + adjacencymatrix[sourcenode][destinationnode]))
                        {
                            distances[destinationnode] = distances[sourcenode] + adjacencymatrix[sourcenode][destinationnode];
 
                        }
                }
            }
        }
 
        return distances;
        
    }
 
}