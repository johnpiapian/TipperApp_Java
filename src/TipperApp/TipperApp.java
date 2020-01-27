package TipperApp;

import java.util.Scanner;
import java.time.format.FormatStyle;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class TipperApp {

    String restaurantName;
    double bill;
    double total;
    double tip;
    double tipPercent;
    int exit=0;
    int billSharedBy=1;
    
    TipperApp(){
        do{
            introduction();
            userInput();
            TipCalc();
            TotalBill();
            ExitContinue();
        }while(exit > 0);
    }
    
    public void introduction(){
        System.out.println("This app will calculate the amount of tip you should to play.(Note: Do not input signs such as $,%)");
    }
    
    public void userInput(){
        Scanner userInput = new Scanner(System.in);  // Create a Scanner object
        
        System.out.println("Enter the restaurent name!"); // Displaying instruction
        restaurantName = userInput.nextLine();  // Read user input
        
        System.out.println("Enter the total bill!"); // Displaying instruction
        bill = userInput.nextDouble();  // Read user input
        
        System.out.println("Enter tip percentage between 1% and 50%."); // Displaying instruction
        tipPercent = userInput.nextDouble();  // Read user input
        
        System.out.println("How many people are sharing the bill?"); // Displaying instruction
        billSharedBy = userInput.nextInt();  // Read user input
    }
    
    public void TipCalc(){
        tip = bill * (tipPercent/100); //Calculate the total amount of tip
        total = bill + tip; // Total amount due for payment including the tip
    }
    
    public void TotalBill(){
        
        DecimalFormat df = new DecimalFormat(".00"); //used for 2 decimal places
        
        System.out.println("---------Your Answer-------");
        System.out.print(java.time.LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))+"\t"); 
        System.out.println(java.time.LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))); 
        
        System.out.println("You are at "+restaurantName+" restaurant!");
        System.out.println("The bill is $"+df.format(bill)+".");
        System.out.println("Total tip is $"+df.format(tip)+"("+df.format(tipPercent)+"%).");
        System.out.println("Total owed amount is $"+df.format(total)+".");
        if(billSharedBy > 1){
            System.out.println("Shared by "+billSharedBy+" people, each person will have to put $"+df.format(total/billSharedBy)+".");
        }
    }
    
    public void ExitContinue(){
        Scanner userInput = new Scanner(System.in); 
        System.out.println("Enter 0 to quit and 1 to continue!");
        exit = userInput.nextInt();  // Read user input
    }

}
