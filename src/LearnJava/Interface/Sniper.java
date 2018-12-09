package LearnJava.Interface;

import LearnJava.Interface.Comportements.*;

public class Sniper extends Personnage {
    public Sniper() {
        this.espritCombatif = new CombatFusil();
    }

    public Sniper(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }
}
