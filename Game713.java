import java.util.*;
public class Game713 {
        Ship713 ship1 = new Ship713();
        Ship713 ship2 = new Ship713();
        Ship713 ship3 = new Ship713();

    public void display(){
        Scanner sc = new Scanner(System.in);
        int turn = 1;int i = 1;
        while(Ship713.finish()!=true){
            System.out.println("-------[ターン"+turn+"]-------");
            if(ship1.shipdie() == false){
                System.out.println("戦艦1：生きてる");
            }else{
                System.out.println("戦艦1：撃沈");
            }
            if(ship2.shipdie() == false){
                System.out.println("戦艦2：生きてる");
            }else{
                System.out.println("戦艦2：撃沈");
            }
            if(ship3.shipdie() == false){
                System.out.println("戦艦3：生きてる");
            }else{
                System.out.println("戦艦3：撃沈");
            }
            if(ship1.shipdie() == true && ship2.shipdie() == true && ship3.shipdie() == true){
                System.out.println("全ての戦艦が沈みました！よくがんばりました。");
                break;
            }
            System.out.println("爆弾地点のX座標を入力してください(1-5)");
            int x = sc.nextInt();
            System.out.println("爆弾地点のY座標を入力してください(1-5)");
            int y = sc.nextInt();
            ship1.shipHp(x,y,i++);
            ship2.shipHp(x,y,i++);
            ship3.shipHp(x,y,i++);
            turn += 1;
            i = 1;
        }
        sc.close();
    }
}