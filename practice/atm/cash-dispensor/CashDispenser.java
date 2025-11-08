public class CashDispenser {

    public static void main(String[] args) {
        CashHandler fiveHundredHandler = new FiveHundredCashHandler(10);
        CashHandler hundredHandler = new HundredCashHandler(5);
        CashHandler tenHandler = new TenRupeesCashHandler(3);
        fiveHundredHandler.setNextHandler(hundredHandler);
        hundredHandler.setNextHandler(tenHandler);
        int amount = 4740;
//        System.out.println("next handler = " + fiveHundredHandler.nextHandler);
//        if(fiveHundredHandler.canDispensh(amount)){
            fiveHundredHandler.dispenshCash(amount);
//        }else{
//            System.out.println("cant dispensh");
//        }

    }
}