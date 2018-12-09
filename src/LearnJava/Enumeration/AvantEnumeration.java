package LearnJava.Enumeration;

public class AvantEnumeration {

    public void fait(Langage lang) {
        if (lang.equals(Langage.JAVA)) {
            System.out.println("Fait à la façon N°1");
        } else if (lang.equals(Langage.PHP)) {
            System.out.println("Fait à la façon N°2");
        }
    }

    public static void main(String[] args) {
        AvantEnumeration ae = new AvantEnumeration();
        ae.fait(Langage.JAVA);
        ae.fait(Langage.PHP);
    }
}
