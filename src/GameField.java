class GameField {

    char[][] yourGameField = new char[10][10];
    char[][] enemyGameField = new char[10][10];
    char[][] radarGameField = new char[10][10];
    int[][] shadowFieldEn = new int[10][10];
    int[][] shadowFieldYou = new int[10][10];

    void createField(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                yourGameField[i][j] = '~';
            }
        }
    }

    void createEnemyField(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                enemyGameField[i][j] = '~';
            }
        }
    }

    void createRadarField(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                radarGameField[i][j] = '~';
            }
        }
    }
  /*
    void initializeField() {
        int hello = 0;
        System.out.println("   0 1 2 3 4 5 6 7 8 9          0 1 2 3 4 5 6 7 8 9");
        System.out.println("0| " + yourGameField[hello][0] + " " + yourGameField[hello][1] + " "+ yourGameField[hello][2] + " "+ yourGameField[hello][3] + " "+ yourGameField[hello][4] + " "+ yourGameField[hello][5] + " " +
                yourGameField[hello][6] + " "+ yourGameField[hello][7] + " "+ yourGameField[hello][8] + " " + yourGameField[hello][9] + " |0    0| " + radarGameField[hello][0] + " " + radarGameField[hello][1] + " "
                + radarGameField[hello][2] + " " + radarGameField[hello][3] + " " + radarGameField[hello][4] + " " + radarGameField[hello][5] + " " + radarGameField[hello][6] + " " + radarGameField[hello][7] + " "
                + radarGameField[hello][8] + " " + radarGameField[hello][9] + " |0");
        hello++;
        System.out.println("1| " + yourGameField[hello][0] + " " + yourGameField[hello][1] + " "+ yourGameField[hello][2] + " "+ yourGameField[hello][3] + " "+ yourGameField[hello][4] + " "+ yourGameField[hello][5] + " " +
                yourGameField[hello][6] + " "+ yourGameField[hello][7] + " "+ yourGameField[hello][8] + " " + yourGameField[hello][9] + " |1    1| " + radarGameField[hello][0] + " " + radarGameField[hello][1] + " "
                + radarGameField[hello][2] + " " + radarGameField[hello][3] + " " + radarGameField[hello][4] + " " + radarGameField[hello][5] + " " + radarGameField[hello][6] + " " + radarGameField[hello][7] + " "
                + radarGameField[hello][8] + " " + radarGameField[hello][9] + " |1");
        hello++;
        System.out.println("2| " + yourGameField[hello][0] + " " + yourGameField[hello][1] + " "+ yourGameField[hello][2] + " "+ yourGameField[hello][3] + " "+ yourGameField[hello][4] + " "+ yourGameField[hello][5] + " " +
                yourGameField[hello][6] + " "+ yourGameField[hello][7] + " "+ yourGameField[hello][8] + " " + yourGameField[hello][9] + " |2    2| " + radarGameField[hello][0] + " " + radarGameField[hello][1] + " "
                + radarGameField[hello][2] + " " + radarGameField[hello][3] + " " + radarGameField[hello][4] + " " + radarGameField[hello][5] + " " + radarGameField[hello][6] + " " + radarGameField[hello][7] + " "
                + radarGameField[hello][8] + " " + radarGameField[hello][9] + " |2");
        hello++;
        System.out.println("3| " + yourGameField[hello][0] + " " + yourGameField[hello][1] + " "+ yourGameField[hello][2] + " "+ yourGameField[hello][3] + " "+ yourGameField[hello][4] + " "+ yourGameField[hello][5] + " " +
                yourGameField[hello][6] + " "+ yourGameField[hello][7] + " "+ yourGameField[hello][8] + " " + yourGameField[hello][9] + " |3    3| " + radarGameField[hello][0] + " " + radarGameField[hello][1] + " "
                + radarGameField[hello][2] + " " + radarGameField[hello][3] + " " + radarGameField[hello][4] + " " + radarGameField[hello][5] + " " + radarGameField[hello][6] + " " + radarGameField[hello][7] + " "
                + radarGameField[hello][8] + " " + radarGameField[hello][9] + " |3");
        hello++;
        System.out.println("4| " + yourGameField[hello][0] + " " + yourGameField[hello][1] + " "+ yourGameField[hello][2] + " "+ yourGameField[hello][3] + " "+ yourGameField[hello][4] + " "+ yourGameField[hello][5] + " " +
                yourGameField[hello][6] + " "+ yourGameField[hello][7] + " "+ yourGameField[hello][8] + " " + yourGameField[hello][9] + " |4    4| " + radarGameField[hello][0] + " " + radarGameField[hello][1] + " "
                + radarGameField[hello][2] + " " + radarGameField[hello][3] + " " + radarGameField[hello][4] + " " + radarGameField[hello][5] + " " + radarGameField[hello][6] + " " + radarGameField[hello][7] + " "
                + radarGameField[hello][8] + " " + radarGameField[hello][9] + " |4");
        hello++;
        System.out.println("5| " + yourGameField[hello][0] + " " + yourGameField[hello][1] + " "+ yourGameField[hello][2] + " "+ yourGameField[hello][3] + " "+ yourGameField[hello][4] + " "+ yourGameField[hello][5] + " " +
                yourGameField[hello][6] + " "+ yourGameField[hello][7] + " "+ yourGameField[hello][8] + " " + yourGameField[hello][9] + " |5    5| " + radarGameField[hello][0] + " " + radarGameField[hello][1] + " "
                + radarGameField[hello][2] + " " + radarGameField[hello][3] + " " + radarGameField[hello][4] + " " + radarGameField[hello][5] + " " + radarGameField[hello][6] + " " + radarGameField[hello][7] + " "
                + radarGameField[hello][8] + " " + radarGameField[hello][9] + " |5");
        hello++;
        System.out.println("6| " + yourGameField[hello][0] + " " + yourGameField[hello][1] + " "+ yourGameField[hello][2] + " "+ yourGameField[hello][3] + " "+ yourGameField[hello][4] + " "+ yourGameField[hello][5] + " " +
                yourGameField[hello][6] + " "+ yourGameField[hello][7] + " "+ yourGameField[hello][8] + " " + yourGameField[hello][9] + " |6    6| " + radarGameField[hello][0] + " " + radarGameField[hello][1] + " "
                + radarGameField[hello][2] + " " + radarGameField[hello][3] + " " + radarGameField[hello][4] + " " + radarGameField[hello][5] + " " + radarGameField[hello][6] + " " + radarGameField[hello][7] + " "
                + radarGameField[hello][8] + " " + radarGameField[hello][9] + " |6");
        hello++;
        System.out.println("7| " + yourGameField[hello][0] + " " + yourGameField[hello][1] + " "+ yourGameField[hello][2] + " "+ yourGameField[hello][3] + " "+ yourGameField[hello][4] + " "+ yourGameField[hello][5] + " " +
                yourGameField[hello][6] + " "+ yourGameField[hello][7] + " "+ yourGameField[hello][8] + " " + yourGameField[hello][9] + " |7    7| " + radarGameField[hello][0] + " " + radarGameField[hello][1] + " "
                + radarGameField[hello][2] + " " + radarGameField[hello][3] + " " + radarGameField[hello][4] + " " + radarGameField[hello][5] + " " + radarGameField[hello][6] + " " + radarGameField[hello][7] + " "
                + radarGameField[hello][8] + " " + radarGameField[hello][9] + " |7");
        hello++;
        System.out.println("8| " + yourGameField[hello][0] + " " + yourGameField[hello][1] + " "+ yourGameField[hello][2] + " "+ yourGameField[hello][3] + " "+ yourGameField[hello][4] + " "+ yourGameField[hello][5] + " " +
                yourGameField[hello][6] + " "+ yourGameField[hello][7] + " "+ yourGameField[hello][8] + " " + yourGameField[hello][9] + " |8    8| " + radarGameField[hello][0] + " " + radarGameField[hello][1] + " "
                + radarGameField[hello][2] + " " + radarGameField[hello][3] + " " + radarGameField[hello][4] + " " + radarGameField[hello][5] + " " + radarGameField[hello][6] + " " + radarGameField[hello][7] + " "
                + radarGameField[hello][8] + " " + radarGameField[hello][9] + " |8");
        hello++;
        System.out.println("9| " + yourGameField[hello][0] + " " + yourGameField[hello][1] + " "+ yourGameField[hello][2] + " "+ yourGameField[hello][3] + " "+ yourGameField[hello][4] + " "+ yourGameField[hello][5] + " " +
                yourGameField[hello][6] + " "+ yourGameField[hello][7] + " "+ yourGameField[hello][8] + " " + yourGameField[hello][9] + " |9    9| " + radarGameField[hello][0] + " " + radarGameField[hello][1] + " "
                + radarGameField[hello][2] + " " + radarGameField[hello][3] + " " + radarGameField[hello][4] + " " + radarGameField[hello][5] + " " + radarGameField[hello][6] + " " + radarGameField[hello][7] + " "
                + radarGameField[hello][8] + " " + radarGameField[hello][9] + " |9");
        System.out.println("   0 1 2 3 4 5 6 7 8 9          0 1 2 3 4 5 6 7 8 9");
    }

 */


    void initializeField() {
        char letter = '0';
        System.out.println("   0 1 2 3 4 5 6 7 8 9          0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.print(letter + "| ");
            for (int j = 0; j < 10; j++) {
                System.out.print(yourGameField[j][i] + " ");
            }
            System.out.print("|" + letter + "    "+ letter +"| ");
            for (int j = 0; j < 10; j++) {
                System.out.print(radarGameField[j][i] + " ");
            }
            System.out.println("|" + letter);
            letter++;
        }
        System.out.println("   0 1 2 3 4 5 6 7 8 9          0 1 2 3 4 5 6 7 8 9");
    }


    void firstInitializeField() throws InterruptedException {
        System.out.println("Hello! You playing at pre-alpha version SeaWar game.");
        System.out.println("Initialize game field, please wait.");
        System.out.println();
        char letter = '0';
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.print(letter + "| ");
            for (int j = 0; j < 10; j++) {
                Thread.sleep(250);
                System.out.print(yourGameField[j][i] + " ");
            }
            System.out.println("|" + letter);
            letter++;
        }
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        System.out.println("Thank you for waiting. Game field created. Enjoy!");
    }


}
