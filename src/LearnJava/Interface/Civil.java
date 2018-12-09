package LearnJava.Interface;

import LearnJava.Interface.Comportements.*;

public class Civil extends Personnage {
    public Civil() {
        this.deplacement = new Courir();
    }

    public Civil(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
        super(espritCombatif, soin, deplacement);
    }
}
