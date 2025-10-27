abstract class CashHandler {
    CashHandler nextHandler;

    public void setNextHandler(CashHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    abstract void dispenshCash(double amount);
}