package rpgcreature;

import java.util.Random;

/**
 * 魔法使いクラス
 */
public class Wizard extends Monster{
    private final static String NAME = "魔法使い";
    private final static int HP = 30;
    private final static int CRITICAL_HIT_RATE = 70;
    private final static int DEFENSE = 3;
    protected final static int MONEY = 50;
    
    /**
     * 魔法使いのコンストラクタ
     */
    public Wizard(){
        super(NAME,HP,MONEY,DEFENSE);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        int damage = 0;
        if( r.nextInt(100) < CRITICAL_HIT_RATE){
            System.out.printf("%sは魔法を唱えた！\n",getName());
            damage = r.nextInt(10)+5 - opponent.defense;
            if(damage<=0){
                damage = 0;
            }
        }else{
            System.out.printf("%sの攻撃！\n",getName());
            damage = r.nextInt(5)+1 - opponent.defense;
            if(damage<=0){
                damage = 0;
            }
        }
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
        
    }

}
