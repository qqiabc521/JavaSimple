package com.ljj.javasimple.pattern.decorator;

public class HongQiGong extends Master {

    public HongQiGong(Swordman swordman) {
        super(swordman);
    }

    public void teachAttackMagic() {
        System.out.println("欧阳锋教授蛤蟆功");
        System.out.println("杨过使用蛤蟆功");
    }

    @Override
    public void attackMagic() {
        super.attackMagic();
        teachAttackMagic();
    }

}
