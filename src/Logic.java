import java.util.ArrayList;
import java.util.Scanner;

class Logic {
    void firstLesson() {
        System.out.println("Добро пожаловать в SeaBattle.");
        System.out.println("У вас есть 10 кораблей. Один 4-палубный, два 3-палубных, три 2-палубных, четыре 1-палубных.");
        System.out.println("Сейчас все ваши корабли находятся в ангаре.");
        System.out.println("Давайте спустим их на воду.");
    }

    ArrayList<Ship> createShips() {
        ArrayList<Ship> shipBase = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            shipBase.add(new Ship(1));
        }
        for (int i = 0; i < 3; i++) {
            shipBase.add(new Ship(2));
        }
        for (int i = 0; i < 2; i++) {
            shipBase.add(new Ship(3));
        }
        shipBase.add(new Ship(4));
        return shipBase;
    }

    void fillSea (char[][] field, ArrayList<Ship> hangar) throws ArrayIndexOutOfBoundsException {
        int X;
        int Y;
        String orientation;
        while (hangar.size() > 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Нам нужно установить " + hangar.get(0).size +"-палубный корабль.");
            System.out.println("Введите координаты X Y корабля, а так-же его ориентацию в прострастве (^, >) example(0 2 >):");
            X = scan.nextInt();
            Y = scan.nextInt();
            orientation = scan.next();
            if (!orientation.matches(".*>.*") && (!orientation.matches(".*\\^.*"))) {
                System.out.println("Командир, я не нашел как ставить корабль. Горизонтально (>) или вертикально (^)?");
                continue;
            }
            if (orientation.matches(".*>.*") ) {
                if (hangar.get(0).size == 4 && X + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X + 1, Y)) || (!checkShipAtSea(field, X + 2, Y)) || (!checkShipAtSea(field, X + 3, Y))) {
                        System.out.println("Судно столкнется с другим.");
                        continue;
                    }
                    for (int i = X; i < X+4; i++) {
                        field[Y][i] = 'O';
                    }
                    hangar.remove(0);
                }else if (hangar.get(0).size == 3 && X + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X + 1, Y)) || (!checkShipAtSea(field, X + 2, Y))) {
                        System.out.println("Судно столкнется с другим.");
                        continue;
                    }
                    for (int i = X; i < X+3; i++) {
                        field[Y][i] = 'O';
                    }
                    hangar.remove(0);
                }else if (hangar.get(0).size == 2 && X + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X + 1, Y))) {
                        System.out.println("Судно столкнется с другим.");
                        continue;
                    }
                    for (int i = X; i < X+2; i++) {
                        field[Y][i] = 'O';
                    }
                    hangar.remove(0);
                } else if (hangar.get(0).size == 1 && X + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y)) {
                        System.out.println("Судно столкнется с другим.");
                        continue;
                    }
                    field[Y][X] = 'O';
                    hangar.remove(0);
                } else {
                    System.out.println("Здесь нельзя поставить корабль.");
                }
            }
            if (orientation.matches(".*\\^.*") ) {
                if (hangar.get(0).size == 4 && Y + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X, Y + 1)) || (!checkShipAtSea(field, X, Y + 2)) || (!checkShipAtSea(field, X, Y + 3))) {
                        System.out.println("Судно столкнется с другим.");
                        continue;
                    }
                    for (int i = Y; i < Y+4; i++) {
                        field[i][X] = 'O';
                    }
                    hangar.remove(0);
                }else if (hangar.get(0).size == 3 && Y + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X, Y + 1)) || (!checkShipAtSea(field, X, Y + 2))) {
                        System.out.println("Судно столкнется с другим.");
                        continue;
                    }
                    for (int i = Y; i < Y+3; i++) {
                        field[i][X] = 'O';
                    }
                    hangar.remove(0);
                }else if (hangar.get(0).size == 2 && Y + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X, Y + 1))) {
                        System.out.println("Судно столкнется с другим.");
                        continue;
                    }
                    for (int i = Y; i < Y+2; i++) {
                        field[i][X] = 'O';
                    }
                    hangar.remove(0);
                }else if (hangar.get(0).size == 1) {
                    if (!checkShipAtSea(field, X, Y)) {
                        System.out.println("Судно столкнется с другим.");
                        continue;
                    }
                    field[Y][X] = 'O';
                    hangar.remove(0);
                } else {
                    System.out.println("Здесь нельзя поставить корабль.");
                }
            }
            Main.field.initializeField();
        }
        System.out.println("Ангар пуст. Начинаем бой!");
    }

    private int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    void enemyFillSea (char[][] field, ArrayList<Ship> hangar){
        int X;
        int Y;
        String orientation;
        while (hangar.size() > 0) {
            X = rnd(0,9);
            Y = rnd(0,9);
            if (rnd(0,9)%2 == 0) {
                orientation = "^";
            } else {
                orientation = ">";
            }
            if (!orientation.matches(".*>.*") && (!orientation.matches(".*\\^.*"))) {
            continue;
            }
            if (orientation.matches(".*>.*") ) {
                if (hangar.get(0).size == 4 && X + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X + 1, Y)) || (!checkShipAtSea(field, X + 2, Y)) || (!checkShipAtSea(field, X + 3, Y))) {
                        continue;
                    } else {
                        for (int i = X; i < X + 4; i++) {
                            field[Y][i] = 'O';
                        }
                        hangar.remove(0);
                    }
                }else if (hangar.get(0).size == 3 && X + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X + 1, Y)) || (!checkShipAtSea(field, X + 2, Y))) {
                        continue;
                    } else {
                        for (int i = X; i < X + 3; i++) {
                            field[Y][i] = 'O';
                        }
                        hangar.remove(0);
                    }
                }else if (hangar.get(0).size == 2 && X + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X + 1, Y))) {
                        continue;
                    } else {
                        for (int i = X; i < X + 2; i++) {
                            field[Y][i] = 'O';
                        }
                        hangar.remove(0);
                    }
                } else if (hangar.get(0).size == 1 && X + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y)) {
                        continue;
                    } else {
                        field[Y][X] = 'O';
                        hangar.remove(0);
                    }
                }
            }
            if (orientation.matches(".*\\^.*") ) {
                if (hangar.get(0).size == 4 && Y + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X, Y + 1)) || (!checkShipAtSea(field, X, Y + 2)) || (!checkShipAtSea(field, X, Y + 3))) {
                        continue;
                    } else {
                        for (int i = Y; i < Y + 4; i++) {
                            field[i][X] = 'O';
                        }
                        hangar.remove(0);
                    }
                }else if (hangar.get(0).size == 3 && Y + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X, Y + 1)) || (!checkShipAtSea(field, X, Y + 2))) {
                        continue;
                    } else {
                        for (int i = Y; i < Y + 3; i++) {
                            field[i][X] = 'O';
                        }
                        hangar.remove(0);
                    }
                }else if (hangar.get(0).size == 2 && Y + hangar.get(0).size <= 10) {
                    if (!checkShipAtSea(field, X, Y) || (!checkShipAtSea(field, X, Y + 1))) {
                        continue;
                    } else {
                        for (int i = Y; i < Y + 2; i++) {
                            field[i][X] = 'O';
                        }
                        hangar.remove(0);
                    }
                }else if (hangar.get(0).size == 1) {
                    if (!checkShipAtSea(field, X, Y)) {
                        continue;
                    } else {
                        field[Y][X] = 'O';
                        hangar.remove(0);
                    }
                }
            }
            }
    }

    void secondLesson(){
        System.out.println("Хорошо. Наши корабли установлены.\n" +
                "Теперь мы создадим точно такое же поле для вражеских кораблей для тестирования программы.\n" +
                "Отрисуем второе поле (простите, пока только вертикально), где корабли будут скрыты от вас.\n" +
                "При попадании появится X.");
    }

    void torpedoShootPlayer() {
        int X;
        int Y;
        System.out.println("Введите координаты для удара, командир.");
        Main.missCheck = true;
        Scanner scan = new Scanner(System.in);
        while (Main.missCheck) {
            X = scan.nextInt();
            Y = scan.nextInt();
            if(Main.field.enemyGameField[X][Y] == 'O') {
                Main.field.enemyGameField[X][Y] = 'X';
                Main.field.radarGameField[X][Y] = 'X';
                Main.field.initializeField();
                if (!checkShipAtSea(Main.field.enemyGameField, Y, X)) {
                    System.out.println("Попал!");
                } else if (checkShipAtSea(Main.field.enemyGameField, Y, X)) {
                    System.out.println("Потопил!");
                    Main.enemyShipLive--;
                }
            } else if (Main.field.enemyGameField[X][Y] == '~') {
                Main.field.enemyGameField[X][Y] = ' ';
                Main.field.radarGameField[X][Y] = ' ';
                Main.field.initializeField();
                System.out.println("Мимо!");
                Main.missCheck = false;
            } else if (Main.field.enemyGameField[X][Y] == 'X' || Main.field.enemyGameField[X][Y] == ' ') {
                Main.field.initializeField();
                System.out.println("Кажись, вы сюда уже стреляли, командир.");
            }
        }

    }

    private boolean checkShipAtSea(char[][] field, int Y, int X){
        if (field[X][Y] == 'O') {
            return false;
        }
        if (X == 0 && Y == 0) {
            if (field[X + 1][Y] == 'O' || field[X][Y + 1] == 'O' || field[X + 1][Y + 1] == 'O') {
                return false;
            }
        }
        if (X == 9 && Y == 0) {
            if (field[X - 1][Y] == 'O' || field[X][Y + 1] == 'O' || field[X - 1][Y + 1] == 'O') {
                return false;
            }
        }
        if (X == 0 && Y == 9) {
            if (field[X][Y - 1] == 'O' || field[X + 1][Y] == 'O' || field[X + 1][Y - 1] == 'O') {
                return false;
            }
        }
        if (X == 9 && Y == 9) {
            if (field[X - 1][Y] == 'O' || field[X][Y - 1] == 'O' || field[X - 1][Y - 1] == 'O') {
                return false;
            }
        }
        if (X > 0 && Y == 0) {
            if (X < 9) {
                if (field[X - 1][Y] == 'O' || field[X - 1][Y + 1] == 'O' || field[X][Y + 1] == 'O' || field[X + 1][Y + 1] == 'O' || field[X + 1][Y] == 'O') {
                    return false;
                }
            }
        }
        if (X == 0 && Y > 0) {
            if (Y < 9) {
                if (field[X][Y + 1] == 'O' || field[X + 1][Y + 1] == 'O' || field[X + 1][Y] == 'O' || field[X+1][Y-1] == 'O' || field[X][Y-1] == 'O') {
                    return false;
                }
            }
        }
        if (X > 0 && Y == 9) {
            if (X < 9) {
                if (field[X-1][Y] == 'O' || field[X - 1][Y - 1] == 'O' || field[X][Y - 1] == 'O' || field[X+1][Y-1] == 'O' || field[X + 1][Y] == 'O') {
                    return false;
                }
            }
        }
        if (X == 9 && Y > 0) {
            if (Y < 9) {
                if (field[X][Y - 1] == 'O' || field[X - 1][Y - 1] == 'O' || field[X - 1][Y] == 'O' || field[X - 1][Y + 1] == 'O' || field[X][Y + 1] == 'O') {
                    return false;
                }
            }
        }
        if (X > 0 && Y > 0) {
            if (X < 9 && Y < 9) {
                if (field[X - 1][Y - 1] == 'O' || field[X][Y - 1] == 'O' || field[X - 1][Y] == 'O' || field[X - 1][Y + 1] == 'O' || field[X][Y + 1] == 'O' || field[X + 1][Y - 1] == 'O' || field[X + 1][Y] == 'O' || field[X + 1][Y + 1] == 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    void torpedoShootEnemy() {
        int X;
        int Y;
        X = rnd(0, 9);
        Y = rnd(0, 9);
        Main.missCheck = true;
        System.out.println("Ход противника.");
            /*
            if (Main.lastTurnSuccess) {
                X = Main.bufferX;
                Y = Main.bufferY;
                if (X + 1 < 10 && X - 1 >= 0) {
                    X = rnd(X - 1, X + 1);
                } else if (X - 1 < 0) {
                    X = rnd(X, X + 1);
                } else {
                    X = rnd(X - 1, X);
                }
                if (Y + 1 < 10 && Y - 1 >= 0) {
                    Y = rnd(Y - 1, Y + 1);
                } else if (Y - 1 < 0) {
                    Y = rnd(Y, Y + 1);
                } else {
                    Y = rnd(Y - 1, Y);
                }
            }

             */
            if (Main.field.yourGameField[X][Y] == 'O') {
                Main.field.yourGameField[X][Y] = 'X';
                Main.field.initializeField();
                System.out.println("Попал!");
            } else if (Main.field.yourGameField[X][Y] == '~') {
                Main.field.yourGameField[X][Y] = ' ';
                Main.field.initializeField();
                System.out.println("Мимо!");
            }
    }

    void checkCrashOrLive(){

    }
}
