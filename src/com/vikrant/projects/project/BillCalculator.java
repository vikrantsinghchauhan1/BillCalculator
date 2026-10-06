package com.vikrant.projects.project;
//I write a new code 

import java.util.Scanner;

public class BillCalculator {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter you name : ");
        String name = sc.nextLine();

        System.out.print("Enter your monthly rent : ");
        int rent =sc.nextInt();

        System.out.print("Enter how match electriCity unit you used : ");
        int electricityUnit=sc.nextInt();
        sc.nextLine();
        System.out.print("Is there is any plenty Yes or No : ");
        String penaltyChoice =sc.nextLine();

        int penaltyAmount=0;

        if (penaltyChoice.equalsIgnoreCase("Yes")) {
            System.out.print("Enter penalty amount: ");
            penaltyAmount = sc.nextInt();
        }
        System.out.print("Enter Water charges : ");
        int waterCharges=sc.nextInt();
        sc.nextLine();


        System.out.print("Which types of Card you have : ");
        String cardType=sc.nextLine();

        User user=new User(name,rent,electricityUnit,penaltyAmount,waterCharges,cardType);

        //Write the business logic

        //calculate electricity bill

        int electricityRate=12;//perunit
        int commonAreaCharges= 14*30;
        int totalelecCahrges=electricityRate*electricityUnit+commonAreaCharges;

        //Want to calculate total rent
        int totalRent = rent+totalelecCahrges+waterCharges+penaltyAmount;
        //Enter discount on Card type
        //Hdfc card-->15% discount
        //SbiCard-->10% discount
        //PnbCard -->7% discount
        //IcicCard-->5% disocunt

        int discount =0;
        switch (cardType){
            case "HDFC":
                //Hdfc card-->15% discount
                discount=totalRent*15/100;
                totalRent=totalRent-discount;
                rent=totalRent;
                System.out.println("In this Month rent is : "+rent);
                break;
            case "SBI":
                //SBI card-->15% discount
                discount=totalRent*10/100;
                totalRent=totalRent-discount;
                System.out.println("In this Month rent is : "+totalRent);
                break;
            case "PNB":
                //PNB card-->7% discount
                discount=totalRent*7/100;
                totalRent=totalRent-discount;
                System.out.println("In this Month rent is : "+totalRent);
                break;
            case "ICIC":
                //PNB card-->5% discount
                discount=totalRent*5/100;
                totalRent=totalRent-discount;
                System.out.println("In this Month rent is : "+totalRent);
                break;
            default:
                System.out.println("Sorry NO Discount Available");
        }

        System.out.println("\n----- PG Rent BILL -----");
        System.out.println("Name              : " + name);
        System.out.println("Monthly Rent      : " + rent);
        System.out.println("Electricity Bill  : " + totalelecCahrges);
        System.out.println("Water Charges     : " + waterCharges);
        System.out.println("Penalty           : " + penaltyAmount);
        System.out.println("Card              : " + cardType);
        System.out.println("Discount          : " + discount);
        System.out.println("Final Amount      : " + totalRent);

        System.out.println("\nPayment successful!");
        System.out.println("Thank you :)");

        sc.close();
    }
}
