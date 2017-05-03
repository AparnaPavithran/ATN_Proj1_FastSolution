import java.util.Scanner;
 
public class ShortVertices
{
    private int distances[];
    private String[] dist;
    private int numberofvertices;
    public static final int MAX_VALUE = 9999999;
 
    public ShortVertices(int numberofvertices)
    {
        this.numberofvertices = numberofvertices;
        distances = new int[numberofvertices + 1];
        dist = new String[numberofvertices + 1];
    }
 
    public int[][] shorts(int adjacencymatrix[][],Integer[] utdid)
    {
        
        int den[][] = new int[numberofvertices + 1][numberofvertices + 1];
        
        for (int node = 1; node <= numberofvertices; node++)
        {
        	for (int sn = 1; sn <= numberofvertices; sn++){
        		den[node][sn] = 0;
        	}
        
        }
 
        
        for(int j=1;j<=numberofvertices;j++){
        	dist[j]="";
        }
        for(int srcs=1;srcs<=numberofvertices;srcs++)
        {
        	 int src=srcs;
        	 
        	 for (int node = 1; node <= numberofvertices; node++)
             {
                 distances[node] = MAX_VALUE;
             }
        	 distances[srcs] = 0;
         	//System.out.println("Start "+srcs);
         	
        	for (int node = 1; node <= numberofvertices - 1; node++)
            {
            	
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
                                if(srcs!=sourcenode)
                                	den[sourcenode][destinationnode]=1;
                               
                                
                            }
                    }
                }
            }
        }
        
       
        return den;
        
        
    }
 
    
}