package rpgcreature;

import java.util.Random;

/**
 * 勇者クラス
 */
public class Golem extends Monster{
    private final static String NAME = "ゴーレム";
    private final static int HP = 100;
    private final static int CRITICAL_HIT_RATE = 5;
    private final static int DEFENSE = 5;
    protected final static int MONEY = 100;
    private final static int max = 10;
    private final static int min = 5;
    /**
     * ゴーレムのコンストラクタ
     */
    public Golem(){
        super(NAME,HP,MONEY,DEFENSE);
    }
    
    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent){
        Random r = new Random();
        int damage = 0;
        System.out.printf("%sの攻撃！\n",getName());
        //クリティカルヒットかのチェック
        if( r.nextInt(100) < CRITICAL_HIT_RATE ){
            //クリティカルヒット
            damage = 30 - opponent.defense;
            if(damage<=0){
                damage = 0;
            }
            System.out.printf("%sのクリティカルヒット！\n",getName());
        }else{
            damage = r.nextInt(max+min)+min - opponent.defense;
            if(damage<=0){
                damage = 0;
            }
            
        }
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
    }

}
