package rpgcreature;

import java.util.Random;

/**
 * スライムクラス
 */
public class Slime extends Monster{
    private final static String NAME = "スライム";
    private final static int HP = 12;
    private final static int DEFENSE = 1;
    protected final static int MONEY = 10;
    /**
     * スライムクラスのコンストラクタ
     */
    public Slime(){
        super(NAME,HP,MONEY,DEFENSE);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        int damage = r.nextInt(5) - opponent.defense;
        if(damage<=0){
            damage = 0;
        }
        System.out.printf("%sの攻撃！\n",getName());
        
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
        
    }

    
}
