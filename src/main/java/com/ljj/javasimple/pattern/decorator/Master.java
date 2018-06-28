package com.ljj.javasimple.pattern.decorator;

public abstract class Master extends Swordman {

    private Swordman swordman;

    public Master(Swordman swordman) {
        this.swordman = swordman;
    }

    @Override
    public void attackMagic() {
        swordman.attackMagic();
    }

}
