import java.util.Scanner;
class CricketOrder{
    void randomBatting(String[] p_name, int o_count, int p_count) {
    int n = p_name.length;
    int[] randomOrder = new int[n];
    boolean[] used = new boolean[n];

    // Generate random unique indices
    for (int i = 0; i < n; i++) {
        int rand;
        do {
            rand = (int)(Math.random() * n);
        } while (used[rand]);
        used[rand] = true;
        randomOrder[i] = rand;
    }

    // Batting order
    System.out.println("\n--- Batting Order ---");
    for (int i = 0; i < n; i++) {
        System.out.println("Bat " + (i + 1) + " player: " + p_name[randomOrder[i]]);
    }

    // Wicket keeping order
    System.out.println("\n--- Wicket Keeping Order ---");
    for (int i = 0; i < n; i++) {
        int keeperIndex = (i + 1) % n;
        System.out.println("Wicket keeper while player " + (i + 1) + " is batting: " + p_name[randomOrder[keeperIndex]]);
    }

    // Bowling order
    System.out.println("\n--- Bowling Order ---");
    for (int i = 0; i < n; i++) {
        System.out.println("\nBowling order when player " + (i + 1) + " (" + p_name[randomOrder[i]] + ") is batting:");
        int overNumber = 1;
        int bowlerIndex = (i - 1 + n) % n;
        for (int j = 0; j < o_count; j++) {
            while (bowlerIndex == i) {
                bowlerIndex = (bowlerIndex - 1 + n) % n;
            }
            System.out.println("  Over " + (overNumber++) + ": Bowler - " + p_name[randomOrder[bowlerIndex]]);
            bowlerIndex = (bowlerIndex - 1 + n) % n;
        }
    }
}
    void manualBatting(String[] p_name,int o_count,int p_count){
        //batting order
        for (int i=0;i<p_name.length ;i++ ){
            System.out.println("Bat "+(i+1)+" player: "+p_name[i]);
        } 
        //wicket keeping order
        for (int i = 0; i < p_count; i++) {
        int keeper_index=(i + 1)%p_count;
        System.out.println("Wicket keeper while player " + (i + 1) + " is batting: " + p_name[keeper_index]);
        }

        //bowling order
        for (int i = 0; i < p_count; i++) {
        System.out.println("\nBowling order when player " + (i + 1) + " (" + p_name[i] + ") is batting:");
        int over_number=1;
        int bowler_index=(i - 1 + p_count)%p_count; // start before the batter
        for (int j = 0; j < o_count; j++) {
            while(bowler_index==i) { // skip if bowler is same as batter
                bowler_index=(bowler_index-1+p_count)%p_count;
            }
            System.out.println("  Over "+(over_number++)+": Bowler - "+p_name[bowler_index]);
            bowler_index=(bowler_index-1+p_count)%p_count;// go to previous for next over
        }
    }
    }
}
public class Cricket
{
	public static void main(String[] args) {
	    
	    CricketOrder bc=new CricketOrder();//creating an object to access the class
	    
		System.out.println("Weclome to STREET_CRICKET!");
		Scanner ab=new Scanner(System.in);
		System.out.print("Enter the number of players: ");
		int player_count=ab.nextInt();
		System.out.print("Enter the number of overs per player: ");
		int overs_count=ab.nextInt();
		ab.nextLine();
		
		String[] player_names=new String[player_count];
		for (int i=0;i<player_names.length ;i++ ){
		    System.out.print("Enter the player "+(i+1)+" name: ");
		    player_names[i]=ab.nextLine();
		} 
		
		System.out.print("Enter 'Y' for random batting order or 'N' for manual (ie. The entered player name's order) batting order: ");
		String batting_order_format=ab.next();
		
		if (batting_order_format.equals("Y")||batting_order_format.equals("y")){
		    bc.randomBatting(player_names,overs_count,player_count);
		}
		else if(batting_order_format.equals("N")||batting_order_format.equals("n")){
		    bc.manualBatting(player_names,overs_count,player_count);
		}
		else{
		    System.out.println("Invalid entry. Try again!"); //better to use Exception handling concept
		}
	}
}