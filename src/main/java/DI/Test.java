package DI;

public class Test {

    private DITest diTest;
//    private  T1 t1;
    public Test(DITest diTest) {
        this.diTest = diTest;
//        t1 = new T1();
    }

    public void show() {
        diTest.testPrint();
//        t1.t1Print();
    }
}
