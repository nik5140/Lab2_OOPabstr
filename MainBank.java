import java.util.HashMap;

public class MainBank {


    public static void main(String[] args) {

        // building users data for lab № 2
        HashMap<String, Users> usersData = new HashMap<>();

        Users user1 = new Users();
        user1.name = "Василий Васильевич Иванов";
        user1.setPinCode("1234");
        user1.setCurrentdepositMoney(-100000);

        Users user2 = new Users();
        user2.name = "Иван Эдуардович Фомин";
        user2.setPinCode("4444");
        user2.setCurrentdepositMoney(-20000);

        Users user3 = new Users();
        user3.name = "Серафим Андричанович Алехин";
        user3.setPinCode("3131");
        user3.setCurrentdepositMoney(-10000);

        usersData.put("id_001", user1);
        usersData.put("id_002", user2);
        usersData.put("id_003", user3);
        // end of bank users data

        System.out.println("building bankomat № "+BankomatBase.lastSerialNumber+1); // bankomat factory count

        // building 3 bankomats
        BankomatSimple bankomat1 = new BankomatSimple();
        BankomatSimple bankomat2 = new BankomatSimple();
        BankomatSimple bankomat3 = new BankomatSimple();

        // user "id_001" session
        bankomat1.auth("id_001"); // put users id in method, ask for pinCode
     // System.out.println("Entered pin is "+bankomat1.enteredPin);
     // Let us imagine that user "id_001" stand infront of bankomat and tries to withdraw money

        if(bankBack(bankomat1,usersData)) // check if pin use true
        {
            bankomat1.userValidated=true;
            System.out.println("user validated...");
            user1.setCurrentdepositMoney(bankomat1.customerWithdraw(2000));

            System.out.println(user1.name+ " имеет сейчас на счету "+user1.getCurrentdepositMoney("1234"));
        }

        else
            System.out.println("Sorry, entered pin is not valid");


        System.out.println("Bankomat 1 serial number is "+bankomat1.serialNumber);
        System.out.println("Bankomat 1 Money amount aviable is "+bankomat1.bankomatCash);
        System.out.println("Bankomat 2 serial number is "+bankomat2.serialNumber);
        System.out.println("Bankomat 2 Money amount aviable is "+bankomat2.bankomatCash);
        System.out.println("Bankomat 3 serial number is "+bankomat3.serialNumber);
        System.out.println("Bankomat 3 Money amount aviable is "+bankomat3.bankomatCash);

        bankomat1.bankServiceCashLoad(300000);
        System.out.println("Bankomat 1 Money amount aviable is "+bankomat1.bankomatCash);

    }

    //method for checking if pinCode right, let it be on bank's server (not inside bankomat)
    static boolean bankBack(BankomatSimple bankomat, HashMap<String ,Users> usersData)
    {
        boolean result = bankomat.enteredPin.equals(usersData.get(bankomat.usersId).getPinCode(bankomat.enteredPin));
        return result;
    }

}
