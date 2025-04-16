import java.util.Scanner;
class Menu{
    //discount method
	    void discount(int tot){
	        Scanner cd=new Scanner(System.in);
	        System.out.print("Enter the coupon code: ");
	        String dis=cd.nextLine();
	        if (dis.equals("WEL50")||dis.equals("wel50")){
	            System.out.println("Total amount after discount: "+(tot-50));
	        } 
	        else if(dis.equals("STUDENT10%")||dis.equals("student10%")){
	            System.out.println("Total amount after discount: "+(tot-(tot/10)));
	        }
	        else if(dis.equals("RANDISC")||dis.equals("randisc")){
	            int randomDis = (int)(Math.random() * 10) + 1;
	            System.out.println("Total amount after discount: "+(tot-(int)(tot/randomDis)));
	        }
	        else{
	            System.out.println("Invalid coupon.");
	        }
	    }
}
public class CafeList
{
	public static void main(String[] args) {
	    //Menu listing
	    System.out.println("     Welcome to ROG's CAFE!   ");
	    System.out.println("------------------------------");
	    System.out.println("          Menu List       ");
	    System.out.println("          ---------       ");
	    System.out.println("        Hot Beverages     ");
	    System.out.println("1. Coffee            Rs. 39.00");
	    System.out.println("2. Black Coffee      Rs. 29.00");
	    System.out.println("3. Herbal Tea        Rs. 79.00");
	    System.out.println("4. H-Chocolate(m)    Rs. 99.00");
	    System.out.println("5. H-Chocolate(l)    Rs.169.00");
	    System.out.println("        Cold Beverages    ");
	    System.out.println("6. Lime Soda         Rs. 49.00");
	    System.out.println("7. Iced Tea          Rs. 79.00");
	    System.out.println("8. Cold Coffee       Rs.169.00");
	    System.out.println("9. Brownie Shake     Rs.199.00");
	    System.out.println("10.Velvet Shake      Rs.219.00");
	    System.out.println("          Desserts       ");
	    System.out.println("11.Choco Lava        Rs. 89.00");
	    System.out.println("12.Swiss Kiss        Rs.119.00");
	    System.out.println("13.Sizzling Brownie  Rs.249.00");
	    System.out.println("14.Tiramisu          Rs.169.00");
	    System.out.println("15.Cheese Cake       Rs.229.00");
	    //scanner input
	    Scanner ab=new Scanner(System.in);
	    System.out.print("Enter the number of menu items to be purchased: ");
	    int item_count=ab.nextInt();
	    int[] price={39,29,79,99,169,49,79,169,199,219,89,119,249,169,229};
	    int[] menu_items=new int[item_count];
	    int[] count=new int[item_count];
	    for (int i=0;i<item_count ;i++ ){
	        System.out.print("Enter the item "+(i+1)+" from the menu listing: ");
	        menu_items[i]=ab.nextInt();
	        System.out.print("Enter the count of the item: ");
	        count[i]=ab.nextInt();
	    } 
	    int total=0;
	    for (int i=0;i<item_count ;i++ ){
	        total+=price[menu_items[i]-1]*count[i];
	    }
	    ab.nextLine();
	    System.out.println("Your total estimated cost: "+total);
	    System.out.print("Do have a discount coupon('Y' - Yes or 'N' - for No): ");
	    String C_avail=ab.nextLine();
	    if(C_avail.equals("Y")||C_avail.equals("y")){
	       Menu bc=new Menu();
	       bc.discount(total);
	    }
	    else if(C_avail.equals("N")||C_avail.equals("n")){
	        System.out.println("Your final total amount: "+total);
	    }
	    else{
	        System.out.println("Invalid entry.");
	    }
	    
	}
}