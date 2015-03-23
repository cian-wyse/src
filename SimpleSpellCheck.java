
public class SimpleSpellCheck {
	public static void main (String[] args){
		String s1 = "rosettacode";
		String s2 = "raisethysword";
		
		System.out.println(minDist(s1,s2));
	}



	private static int minimum(int a, int b, int c) {                            
	    return Math.min(Math.min(a, b), c);                                      
	}
	
	private static int minDist(String target, String source){	
		//int m = target.length();
		//int n = source.length();
		System.out.println("target length: "+target.length()+" source length: "+source.length());
		
		int[][] dist = new int[target.length()+1][source.length()+1];  
		dist[0][0] = 0;

		for (int i=0; i<target.length();i++){
			dist[i][0] = i;
		}
		/*******/
//		for (int j=0; j<target.length();j++){
//			dist[j][0]=j;
//			System.out.println(dist[j][0]);
//		}
			
		
//		for (int i=0; i<source.length();i++){
//			dist[i][0]=i;
//			System.out.println(dist[i][0]);
//		}
		/*******/
		for (int j=0;j<source.length();j++){
			dist[0][j]= j;
		}
		
		for (int i=1; i<=target.length();i++){
			for (int j=1; j<=source.length(); j++){
				dist[i][j]= minimum(
						dist[i-1][j]+1,
						dist[i][j-1]+1,
						dist[i-1][j-1]+((target.charAt(i-1)== source.charAt(j-1)) ? 0 : 1));
			}
		}
		return dist[target.length()][source.length()]; 
	}
	
}