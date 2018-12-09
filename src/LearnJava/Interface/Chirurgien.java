package LearnJava.Interface;

import LearnJava.Interface.Comportements.*;

public class Chirurgien extends Personnage {
    public Chirurgien() {
        this.soin = new Operation();
    }

    public Chirurgien(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }
}
