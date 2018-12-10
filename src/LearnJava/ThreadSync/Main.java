package LearnJava.ThreadSync;

public class Main {
    public static void main(String[] args) {
        TestThread tA = new TestThread("A");
        TestThread tB = new TestThread(" B", tA);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("statut du thread " + tA.getName() + " = " + tA.getState());
        System.out.println("statut du thread " + tB.getName() + " = " + tB.getState());
    }
}
