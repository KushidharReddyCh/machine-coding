
interface TestInf {
    public void check();
}

public class Test implements TestInf{
    @Override
    public void check(){
        System.out.printf("checkkk");
    }

    public static void main(String args[]){
        Test t1 = new Test();
        TestInf tf1 = t1;
        tf1.check();
    }
}