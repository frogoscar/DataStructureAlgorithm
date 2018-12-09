package LearnJava.Interface;

import LearnJava.Interface.Comportements.*;

public abstract class Personnage {
    protected EspritCombatif espritCombatif = new Pacifiste();
    protected Soin soin = new AucunSoin();
    protected Deplacement deplacement = new Marcher();

    public Personnage() {}

    public Personnage(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        this.espritCombatif = espritCombatif;
        this.soin = soin;
        this.deplacement = deplacement;
    }

    public void combattre() {
        espritCombatif.combat();
    }

    public void soigner() {
        soin.soigner();
    }

    public void seDeplacer() {
        deplacement.deplacer();
    }

    public void setEspritCombatif(EspritCombatif espritCombatif) {
        this.espritCombatif = espritCombatif;
    }

    public void setSoin(Soin soin) {
        this.soin = soin;
    }

    public void setDeplacement(Deplacement deplacement) {
        this.deplacement = deplacement;
    }
}
