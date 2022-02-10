import java.util.*;


public class lab2BOld {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
            String[] snakesAndLadders = new String[n];
            for(int i = 0; i < snakesAndLadders.length; i++) {
                snakesAndLadders[i] = sc.nextLine().trim();
            }
            
            int d = sc.nextInt();
            sc.nextLine();
            if(d > 0 && d %2 ==0){
                String[] diceThrows = sc.nextLine().trim().split(" ");
                System.out.println(gameDriver(snakesAndLadders, diceThrows));
                
                sc.close();
            }
	}

    private static boolean containsKey(String[] snakesAndLadders, int curr) {
        boolean res = false;
        for(int j =0 ; j < snakesAndLadders.length; j++) {
            int first = Integer.parseInt(snakesAndLadders[j].split(" ")[0]);
            if(curr == first) {
                res = true;
                break;
            }
        }
        return res;
    }

    private static int getVal(String[] snakesAndLadders, int curr) {
        int res = -(int)(1e9);
        for(int j =0 ; j < snakesAndLadders.length; j++) {
            int first = Integer.parseInt(snakesAndLadders[j].split(" ")[0]);
            int second = Integer.parseInt(snakesAndLadders[j].split(" ")[1]);
            if(curr == first) {
                res =  second;
                break;
            }
        }
        return res; 
    }


	private static String gameDriver(String[] snakesAndLadders, String[] diceThrows) {
		
		//Initial positions of A and B
		int currA = 1;
		int currB = 1;
		
		for(int i = 0; i < diceThrows.length; i++) {
            if(currA == 100 || currB == 100){
                break;
            }if(i % 2 == 0) {
                    //Moves of A
                    currA += Integer.parseInt(diceThrows[i]);
                    if(containsKey(snakesAndLadders, currA)){
                        currA = getVal(snakesAndLadders, currA);
                        while(containsKey(snakesAndLadders, currA)){
                            currA = getVal(snakesAndLadders, currA);
                        }
                    }
                    // System.out.println(currA);
                }else {
                    //Moves of B
                    currB += Integer.parseInt(diceThrows[i]);
                    if(containsKey(snakesAndLadders, currB)){
                        currB = getVal(snakesAndLadders, currB);
                        while(containsKey(snakesAndLadders, currB)){
                            currB = getVal(snakesAndLadders, currB);
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