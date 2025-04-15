import java.util.Scanner;
class FlamesCheck{
    void check(String name1, String name2){
        //Mutable string
        StringBuilder sb1=new StringBuilder(name1);
        StringBuilder sb2=new StringBuilder(name2);
        
        for (int i=0;i<sb1.length() ;i++ ){
            char n1=sb1.charAt(i);
            for (int j=0;j<sb2.length() ;j++ ) {
                if (n1==sb2.charAt(j)){
                    sb1.deleteCharAt(i);
                    sb2.deleteCharAt(j);
                    i--;
                    break;
                } 
            }
        } 
        //leftover letter
        String rem_letter=sb1.toString()+sb2.toString();
        int rem_letter_count=rem_letter.length();
        
        //System.out.println(rem_letter);
        //System.out.println(rem_letter_count);
        
        StringBuilder flames = new StringBuilder("FLAMES");
        int index = 0; // starting index for cyclic counting

        while (flames.length() > 1) {
            // calculate the index of letter to remove
            index = (index + rem_letter_count -1) % flames.length();
            flames.deleteCharAt(index);
        }
        String flames_=flames.toString();
        //System.out.println(flames); //FLAMES E M S L A= F
        
        if (flames_.equals("F")){
            System.out.println("Friends");
        } 
        else if(flames_.equals("L")){
            System.out.println("Love");
        }
        else if(flames_.equals("A")){
            System.out.println("Affection");
        }
        else if(flames_.equals("M")){
            System.out.println("Marriage");
        }
        else if(flames_.equals("E")){
            System.out.println("Enemies");
        }
        else if(flames_.equals("S")){
            System.out.println("Sister");
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		System.out.println("Weclome to FLAMES session!");
		Scanner ab=new Scanner(System.in);
		System.out.print("Enter the name of person 1: ");
		String person1=ab.nextLine().toLowerCase().replaceAll(" ","");
		System.out.print("Enter the name of person 2: ");
		String person2=ab.nextLine().toLowerCase().replaceAll(" ","");
		
		FlamesCheck bc=new FlamesCheck();
		bc.check(person1,person2);
	}
}