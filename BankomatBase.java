abstract public class BankomatBase {

    static int lastSerialNumber = 0; // factory serial number counter
    int serialNumber = 0; // serial number of this bankomat
    int bankomatCash = 1000; // base amount of cash

    int minWithDraw = 100; // minimal summ of withdraw
    int maxWithDraw = 150000; // maximum summ of withdraw per day

    abstract void initializeBankomat();
    abstract void bankServiceCashLoad(int cash); // method for filling bankomat with cash by bank service




    abstract int customerWithdraw(int cash);
}
