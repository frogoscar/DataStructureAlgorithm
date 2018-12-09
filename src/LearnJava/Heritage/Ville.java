package LearnJava.Heritage;

import java.util.Objects;

public class Ville {
    public static int nbreInstances = 0;

    protected static int nbreInstancesBis = 0;

    protected String nomVille;
    protected String nomPays;
    protected int nbreHabitants;
    protected char categorie;

    public String getNomVille() {
        return nomVille;
    }

    public String getNomPays() {
        return nomPays;
    }

    public int getNbreHabitants() {
        return nbreHabitants;
    }

    public char getCategorie() {
        return categorie;
    }

    public static int getNbreInstancesBis() {
        return nbreInstancesBis;
    }

    public void setNomVille(String pNom) {
        nomVille = pNom;
    }

    public void setNomPays(String pPays) {
        nomPays = pPays;
    }

    public void setNbreHabitants(int pNbre) {
        nbreHabitants = pNbre;
        this.setCategorie();
    }

    private void setCategorie() {
        int[] bornesSuperieures = {0, 1000, 10000, 100000, 500000, 1000000, 5000000, 10000000};
        char[] categories = {'?', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        int i = 0;
        while (i < bornesSuperieures.length && nbreHabitants > bornesSuperieures[i]) {
            i++;
        }
        categorie = categories[i];
    }

    public String decrisToi() {
        return "\t" + nomVille + " est une ville de " + nomPays + ", elle comporte : " + nbreHabitants +
                " habitant(s) => elle est donc de categorie : " + categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return nbreHabitants == ville.nbreHabitants &&
                categorie == ville.categorie &&
                Objects.equals(nomVille, ville.nomVille) &&
                Objects.equals(nomPays, ville.nomPays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomVille, nomPays, nbreHabitants, categorie);
    }

    public String toString() {
        return "\t" + nomVille + " est une ville de " + nomPays + ", elle comporte : " + nbreHabitants +
                " habitant(s) => elle est donc de categorie : " + categorie;
    }

    public String comparer(Ville v1) {
        String str;
        if (v1.getNbreHabitants() > nbreHabitants) {
            str = v1.getNomVille() + " est une ville plus peuplee que " + nomVille;
        } else {
            str = nomVille + " est une ville plus peuplee que " + v1.getNomVille();
        }
        return str;
    }

    public Ville() {
        nbreInstances++;
        nbreInstancesBis++;
        System.out.println("Creation d'une ville");
        nomVille = "Inconnu";
        nomPays = "Inconnu";
        nbreHabitants = 0;
        this.setCategorie();
    }

    public Ville(String pNom, int pNbre, String pPays) {
        nbreInstances++;
        nbreInstancesBis++;
        System.out.println("Creation d'une ville avec des parametres");
        nomVille = pNom;
        nomPays = pPays;
        nbreHabitants = pNbre;
        this.setCategorie();
    }


}
