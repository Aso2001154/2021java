public class Mainsenkan{
    public static void main(String[] args) {
        System.out.println("***************************");
        System.out.println("         戦艦ゲーム         ");
        System.out.println("***************************");
        Gamesenkan game = new Gamesenkan();
        game.init();
        game.start();
    }
}