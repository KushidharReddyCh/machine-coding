public class FiveHundredCashHandler extends CashHandler{

    @Override
    public void dispenshCash(double amount){
        double numOfNotes = amount % 500;
        System.out.println("Number of 500 notes = " + numOfNotes);
        double amountDue = amount - (numOfNotes * 500);
        if (amountDue > 0){
            nextHandler.dispenshCash(amountDue);
        }
    }

}