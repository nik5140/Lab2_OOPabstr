/*
Simple bankomat class
from abstract superclass BankomatBase

 */
import java.util.Scanner;


public class BankomatSimple extends BankomatBase{

    //validation of user is outside of bankomat in bank server backend
    boolean userValidated = false;
    String enteredPin = "";
    String usersId = "";

    BankomatSimple(){
        this.serialNumber = lastSerialNumber+1;
        lastSerialNumber++;
        initializeBankomat();
        bankServiceCashLoad(500000);
    }

    @Override
    void initializeBankomat() {
        // initializing or waking up bankomat
        System.out.println("Power on...");
        System.out.println("Booting... standby");
    }

    @Override
    void bankServiceCashLoad(int cash) {
        bankomatCash += cash;
    }

    @Override
    int customerWithdraw(int cash) {


        if(userValidated){
            if (cash>=minWithDraw&&cash<=maxWithDraw)
                if (bankomatCash-cash>0)
                {
                    bankomatCash-= cash;
                    return cash;
                }
                else
                    System.out.println("problems: to low cash in bankomat, please wait for our service or chose another" +
                            "bankomat");
            else
                System.out.println("cash amount error - out of single withDraw summ limit");
                    }

        return 0;

    }

    void auth(String id)
    {
        Scanner sc = new Scanner(System.in);
        usersId = id;
        System.out.println("Please insert your card\n");
        System.out.println("Greetings, dear ");
        System.out.println("Enter your pin code");
        enteredPin = sc.nextLine();
    }

}