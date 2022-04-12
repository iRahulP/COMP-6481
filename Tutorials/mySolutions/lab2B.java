import java.util.*;


public class lab2B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine(); 
        // String[] snakesAndLadders = new String[n];
        // for(int i = 0; i < snakesAndLadders.length; i++) {
        //     snakesAndLadders[i] = sc.nextLine().trim();
        // }
        
        Map<Integer,Integer> snakesAndLadders=new HashMap<Integer,Integer>();
        for(int i = 0;i < n;i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            snakesAndLadders.put(first, second);
        }

        int d = sc.nextInt();
        sc.nextLine();
        if(d > 0 && d %2 ==0){
            String[] diceThrows = sc.nextLine().trim().split(" ");
            System.out.println(gameDriver(snakesAndLadders, diceThrows));            
            sc.close();
        }
	}


	private static String gameDriver(Map<Integer,Integer> snakesAndLadders, String[] diceThrows) {
		
		//Initial positions of A and B
		int currA = 1;
		int currB = 1;
		
		for(int i = 0; i < diceThrows.length; i++) {
            if(currA == 100 || currB == 100){
                break;
            }
            if(i % 2 == 0) {
                //Moves of A
                currA += Integer.parseInt(diceThrows[i]);
                if(snakesAndLadders.containsKey(currA)){
                    currA = snakesAndLadders.get(currA);
                    while(snakesAndLadders.containsKey(currA)){
                        currA = snakesAndLadders.get(currA);
                    }
                }
                // System.out.println(currA);
            }else {
                //Moves of B
                currB += Integer.parseInt(diceThrows[i]);
                if(snakesAndLadders.containsKey(currB)){
                    currB = snakesAndLadders.get(currB);
                    while(snakesAndLadders.containsKey(currB)){
                        currB = snakesAndLadders.get(currB);
                    }
                }
            }
		}

		if(currA > currB) {
			return "A "+currA;
		}
		else {
			return "B "+currB;	
		}
	}
}
