package com.ljj.javasimple.pattern.decorator;

public class OuYangFeng extends Master {

	public OuYangFeng(Swordman swordman) {
		super(swordman);
	}
	
	public void teachAttackMagic(){
        System.out.println("洪七公教授打狗棒法");
        System.out.println("杨过使用打狗棒法");
    }
	
    @Override
    public void attackMagic() {
        super.attackMagic();
        teachAttackMagic();
    }

}
