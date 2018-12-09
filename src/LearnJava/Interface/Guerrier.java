package LearnJava.Interface;

import LearnJava.Interface.Comportements.*;

public class Guerrier extends Personnage {
    public Guerrier() {
        this.espritCombatif = new CombatPistolet();
    }

    public Guerrier(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }
}
