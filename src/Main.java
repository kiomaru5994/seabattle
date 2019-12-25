import java.util.ArrayList;


public class Main {
    static GameField field = new GameField();
    static Logic logic = new Logic();
    static ArrayList<Ship> yourHangar = logic.createShips();
    static ArrayList<Ship> enemyHangar = logic.createShips();
    static int yourShipLive = 10;
    static int enemyShipLive = 10;
    static boolean missCheck = true;
    static boolean lastTurnSuccess = false;
    static int bufferX;
    static int bufferY;

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException, InterruptedException {
        logic.createShips();
        field.createField();
        field.createRadarField();
        field.createEnemyField();
        System.out.println();
        //field.firstInitializeField();
        field.initializeField();
        System.out.println();
        logic.firstLesson();
        //logic.fillSea(field.yourGameField);
        logic.enemyFillSea(field.yourGameField, yourHangar);
        logic.enemyFillSea(field.enemyGameField, enemyHangar);
        logic.secondLesson();
        field.initializeField();
        while (yourShipLive > 0 && enemyShipLive > 0) {
           // logic.torpedoShootPlayer();
            Thread.sleep(1000);
            logic.torpedoShootEnemy();
            Thread.sleep(1000);
        }
        if (enemyShipLive == 0) {
            System.out.println("Вы победили, капитан!");
        } else {
            System.out.println("Покормите рыбок своим телом, капитан.");
        }
    }


}
