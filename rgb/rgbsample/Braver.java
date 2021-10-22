package rpgcreature;

import java.util.Random;

/**
 * 勇者クラス
 */
public class Braver extends Creature{
    private final static int MAX_HP = 100;
    private final static int RECOVERY_POINT = 20;
    private final static int CRITICAL_HIT_RATE = 10;
    private final static int DEFENSE = 3;
    private static int SUM_MONEY = 0;

    

    /**
     * 勇者クラスのコンストラクタ
     */
    public Braver(String name){
        super(name,MAX_HP,SUM_MONEY,DEFENSE);
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
            damage = 50 - opponent.defense;
            if(damage<=0){
                damage = 0;
            }
            System.out.printf("%sのクリティカルヒット！\n",getName());
        }else{
            damage = r.nextInt(10)+1 - opponent.defense;
            if(damage<=0){
                damage = 0;
            }
            
        }
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
    }

    /**
     * HP回復処理
     */
    public void recovery(){
        System.out.printf("%sはHPを回復した！\n",getName());
        hp += RECOVERY_POINT;
        if( hp > MAX_HP ){
            hp = MAX_HP;
        }
    }
    public void money(Monster mon){
        SUM_MONEY = SUM_MONEY + mon.money;
    }
    public void end(){
        System.out.printf("%dゴールド獲得！\n",SUM_MONEY);
        SUM_MONEY = 0;
    }
}
