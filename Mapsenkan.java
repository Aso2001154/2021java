public class Mapsenkan{
    private final int noship = 0;
    private final int SHIP = 1;
    private int[][] map;

    public Mapsenkan(){
        ;
    }
    public void init(int mapSize){
        map = new int[mapSize][mapSize];
        for(int i = 0;i < mapSize;i++){
            for(int j = 0;j < mapSize;j++){
                map[i][j] = noship;
            }
        }
    }

    public boolean deployShip(Shipsenkan ship){
        int x = ship.getPosX();
        int y = ship.getPosY();
        if(x>=map.length||y>=map.length){
            return false;
        }
        if(map[x][y]!=noship){
            return false;
        }
        map[x][y]=SHIP;
        return true;
    }
    public void clear(int x,int y){
        if(x>=map.length||y>=map.length){
            return;
        }
        map[x][y]=noship;
    }
}