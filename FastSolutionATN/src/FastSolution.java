import java.awt.Label;
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;



public class FastSolution {

	public static void fastsoln(int n,int k,Integer[] utdid,Graph g){
		int numberofvertices = n;
		int distances[] = new int[numberofvertices + 1];
 
		Random r = new Random();
		int Low = 1;
		int High = n;
		
		
		
        int adjacencymatrix[][] = new int[numberofvertices + 1][numberofvertices + 1];
        //System.out.println("Enter the adjacency matrix");
        for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
        {
        	int krand[]=new int[k+1];
    		
            for(int rand=1;rand<=k;rand++){
            	krand[rand]=r.nextInt(High-Low) + Low;
            	//System.out.print("Random "+krand[rand]);
            }
        	
            for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
            {
            	int flag=0;
            	for(int rand=1;rand<=k;rand++){
            		
                	if(krand[rand]==destinationnode)
                		flag=1;
                }
            	if(flag==1){
            		adjacencymatrix[sourcenode][destinationnode] = 1;
            	}
            	else{
            		adjacencymatrix[sourcenode][destinationnode] = 200;
            	}
                
 	        if (sourcenode == destinationnode)
                {
                    adjacencymatrix[sourcenode][destinationnode] = 0;
                    continue;
                }

            }
        }
        
        //************************Adjacency Matrix************************//
        /*for (int node = 1; node <= numberofvertices; node++)
        {
        	for (int sn = 1; sn <= numberofvertices; sn++){
        		 System.out.print(adjacencymatrix[node][sn]+" ");
        }
        	System.out.println();
        }*/
 
		ShortVertices shortvertices = new ShortVertices(numberofvertices); 
        int den[][]=shortvertices.shorts(adjacencymatrix, utdid);
        
        int countden=0;
        for (int node = 1; node <= numberofvertices; node++)
         {
         	for (int sn = 1; sn <= numberofvertices; sn++){
         		 //System.out.print(den[node][sn]+" ");   ///// **** to print length of each path **** ////
         		 if(den[node][sn]==1){
         			 countden++;
         		 }
         }
         	//System.out.println();
         }
        
        int capacity=0;
        int cost=0; int dens=0;
        for(int i=1;i<=n;i++){        	 
            BellmanFord bellmanford = new BellmanFord(numberofvertices);   
            distances=bellmanford.BellmanFordEvaluation(i, adjacencymatrix,utdid);
            
            
            for(int j=1;j<=n;j++){
            	if(i!=j){
            		Integer x=utdid[i-1]-utdid[j-1];	//bij value calculated
					x=Math.abs(x);
					int c=x*distances[j];
					capacity=capacity+c;
					cost=cost+distances[j];
            	}
            	//System.out.print(distances[j]+" ");
            	if(distances[j]==1 || distances[j]==200){
            		dens++;
            		den[i][j]=1;
            	}
            }
           // System.out.println();
        }
		
		
		System.out.println("*********************************");
		System.out.println("Total Cost "+cost);
		System.out.println("*********************************");
		System.out.println("*********************************");
		System.out.println("Capacity "+capacity);
		System.out.println("*********************************");
		
        float edge=n*(n-1);
        if(countden+dens<(n*(n-1)))
        	countden=countden+dens;
        else if(countden<dens)
        	countden=dens;
        float density;
        density=countden/edge;
        System.out.println("*********************************");
		System.out.println("Density "+density);
		System.out.println("*********************************");
		
       // return distances;
		System.out.println("Final Graph:");
		
		if(countden<edge){
			for(int i=1;i<=n;i++){
				System.out.print(i+ " : ");
				for(int j=1;j<=n;j++){
					if(den[i][j]==1)
					System.out.print("("+i+","+j+") ");
				}
				System.out.println();
			}
		}
        
        
	}


}
