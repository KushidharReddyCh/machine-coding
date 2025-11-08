abstract class CashHandler {
    CashHandler nextHandler;
    int noteValue;
    int numOfNotes;

    public CashHandler(int noteValue, int numOfNotes){
        this.noteValue = noteValue;
        this.numOfNotes = numOfNotes;
    }



    public void setNextHandler(CashHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void dispenshCash(int amount){
        System.out.println("DISPENSER AMONUT = " + amount);
        if(amount >= noteValue){
            int numOfNotesNeeded = amount / noteValue;
            int notesAvailable = Math.min(numOfNotesNeeded, numOfNotes);
            this.numOfNotes -= notesAvailable;
            int amountDue = amount - (noteValue * notesAvailable);
            System.out.println("NOTES DISPENSED :: " + noteValue + " = " + notesAvailable);
//            System.out.println("amount ");
            if(amountDue != 0 ){
                System.out.println("nextHandler = " + nextHandler);
                if(nextHandler != null){
                    nextHandler.dispenshCash(amountDue);
                }else{
                    System.out.println("failure raise exception!!");
                }
            }else{
                System.out.println("dispensing ended succesfully!");
                return;
            }
        }else{
            if(nextHandler != null){
                nextHandler.dispenshCash(amount);
            }else{
                System.out.println("failure raise exception!!");
            }
        }
    }

    public boolean canDispensh(int amount){
        if (amount < 0) return false;
        if(amount >= noteValue){
            int numOfNotesNeeded = amount / noteValue;
            int notesAvailable = Math.min(numOfNotesNeeded, numOfNotes);
            int amountDue = amount - (noteValue * notesAvailable);
            if(amountDue == 0) return true;
            if(nextHandler != null){
                return nextHandler.canDispensh(amountDue);
            }
            return false;
        }else{
            if(nextHandler != null){
                return nextHandler.canDispensh(amount);
            }
            return false;
        }
    }
}