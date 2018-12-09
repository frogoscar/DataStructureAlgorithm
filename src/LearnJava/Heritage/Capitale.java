package LearnJava.Heritage;

public class Capitale extends Ville {
    private String monument;

    public Capitale() {
        super();
        monument = "aucun";
    }

    public Capitale(String nomVille, int nbreHab, String nomPays, String monument) {
        super(nomVille, nbreHab, nomPays);
        this.monument = monument;
    }

    public String getMonument() {
        return monument;
    }

    public void setMonument(String monument) {
        this.monument = monument;
    }

    /**
     * Description d'une capitale
     * @return String retourne la description de l'objet
     */
    public String decrisToi() {
        String str = super.decrisToi() + "\n \t ==> " + monument + " en est un monument";
        return str;
    }

    public String toString() {
        String str = super.toString() + "\n \t ==> " + monument + " en est un monument";
        return str;
    }
}
