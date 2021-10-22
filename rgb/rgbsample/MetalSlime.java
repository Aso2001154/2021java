package rpgcreature;

import java.util.Random;

/**
 * メタルスライムクラス
 */
public class MetalSlime extends Monster{
    private final static String NAME = "メタルスライム";
    private final static int HP = 12;
    private final static int ESCAPE_RATE = 40;
    private final static int DEFENSE = 5;
    protected final static int MONEY = 250;
    
    /**
     * メタルスライムのコンストラクタ
     */
    public MetalSlime(){
        super(NAME,HP,MONEY,DEFENSE);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        if( r.nextInt(100) < ESCAPE_RATE ){
            System.out.printf("%sは逃げ出した！\n",getName());
            escapeFlag = true;
        }else{
            int damage = r.nextInt(5) - opponent.defense;
            if(damage<=0){
                damage = 0;
            }
            System.out.printf("%sの攻撃！\n",getName());
            
            opponent.damaged(damage);
            
            displayMessage(opponent,damage);
        }
    }

}
