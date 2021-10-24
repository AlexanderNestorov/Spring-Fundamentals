package com.example.exam24_10_21.model.binding;


import javax.validation.constraints.NotNull;

public class AttackBindingModel {

    private String attacker;
    private String defender;

    public AttackBindingModel() {
    }

    @NotNull
    public String getAttacker() {
        return attacker;
    }

    public void setAttacker(String attacker) {
        this.attacker = attacker;
    }

    @NotNull
    public String getDefender() {
        return defender;
    }

    public void setDefender(String defender) {
        this.defender = defender;
    }
}
