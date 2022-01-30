import java.util.HashMap;

/* users class */

public class Users {
    String name;
    private String pinCode;
    private int currentdepositMoney;

    int getCurrentdepositMoney(String pin)
    {
        if (pin.equals(this.pinCode))
            return currentdepositMoney;
        return 0;
    }

    void setCurrentdepositMoney(int delta)
    {
         if (this.currentdepositMoney-delta>0)
        {
            System.out.println("from account "+this.name+" now we will get some money");
            this.currentdepositMoney=this.currentdepositMoney-delta;
        }
        else System.out.println("Sorry, not enough money on deposit");
    }

    void setPinCode(String pinCode)
    {
        this.pinCode = pinCode;
    }

    String getPinCode(String pin)
    {
        if (pin.equals(this.pinCode))
            return pinCode;
        return "";
    }

}
