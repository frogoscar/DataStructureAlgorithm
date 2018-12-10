package LearnJava.ThreadSync;

public class Test1 {
    public static void main(String[] args) {
        CompteEnBanque cb = new CompteEnBanque();
        //CompteEnBanque cb2 = new CompteEnBanque();

        Thread t = new Thread(new RunImpl(cb, "Angel"));
        //Thread t2 = new Thread(new RunImpl(cb2, "Beatles"));
        Thread t2 = new Thread(new RunImpl(cb, "Beatles"));

        t.start();
        t2.start();
    }
}
