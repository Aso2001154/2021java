import java.util.Scanner;

public class Gamesenkan{
    private final int shipsu = 3;
    private final int mapsize = 5;
    private Shipsenkan[] ships = new Shipsenkan[shipsu];
    private Mapsenkan map = new Mapsenkan();

    public Gamesenkan(){
        for(int i = 0;i < shipsu;i++){
            ships[i] = new Shipsenkan();
        }
    }

    public void init(){
        map.init(mapsize);
        for(int i = 0;i < shipsu;i++){
            do{
                ships[i].init(mapsize);
            }while(!map.deployShip(ships[i]));
        }
    }

    public void start(){
        int attackX;
        int attackY;
        Scanner scanner = new Scanner(System.in);
        int turn = 1;
        while(!isAllSink()){
            System.out.println("---------[ターン"+turn+"]---------");
            displaySituation();
            System.out.println("爆弾のx座標を入力してください(1-"+mapsize+")");
            attackX = scanner.nextInt();
            System.out.println("爆弾のy座標を入力してください(1-"+mapsize+")");
            attackY = scanner.nextInt();

            for(int i = 0;i < shipsu;i++){
                int result = ships[i].check(attackX-1,attackY-1);
                doByResult(ships[i],i+1,result);
            }
            turn++;
        }
        System.out.println("全て撃破！おめでとう");

        scanner.close();
    }
    private boolean isAllSink(){
        boolean allSink = true;
        for(int i = 0;i < shipsu;i++){
            if(ships[i].isAlive()){
                allSink = false;
                break;
            }
        }
        return allSink;
    }

    private void displaySituation(){
        for(int i = 0;i < shipsu;i++){
            if(ships[i].isAlive()){
                System.out.println("船"+(i+1)+"：生きている");
            }else{
                System.out.println("船"+(i+1)+"：撃沈済み"); 
            }
        }
    }

    private void doByResult(Shipsenkan ship,int no,int result){
        if(result == Shipsenkan.NO_HIT){
            System.out.println("船"+no+"：はずれ");
        }else if(result == Shipsenkan.NEAR){
            System.out.println("船"+no+"：波高し");
        }else if(result == Shipsenkan.HIT){
            System.out.println("船"+no+"：爆弾が当たった！しかし船はまだ沈まない！船は移動します");
            moveShip(ship);
        }else{
            System.out.println("船"+no+"：爆弾が当たった！撃沈しました。");
            map.clear(ship.getPosX(), ship.getPosY());
        }
    }

    private void moveShip(Shipsenkan ship){
        map.clear(ship.getPosX(), ship.getPosY());
        do{
            ship.move(mapsize);
        }while(!map.deployShip(ship));
    }
}