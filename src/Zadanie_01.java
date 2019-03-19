import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zadanie_01 {
    public static void main(String[] args) {

        Scanner scannerKonzola = new Scanner(System.in);

        int moznost = 0;

        while (moznost != 4) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("Vyberte moznost: ");
            System.out.println("------------------------");
            System.out.println("1. Nacitanie z konzoly");
            System.out.println("2. Nacitanie zo suboru");
            System.out.println("3. Prednastavena matica");
            System.out.println("4. Koniec");
            System.out.println("+++++++++++++++++++++++++++++++++");
            moznost = scannerKonzola.nextInt();

            if (moznost == 1) {
                System.out.println("Zadajte velkost matice prilahlosti: ");
                int velkostMatice = scannerKonzola.nextInt();                          // velkost = pocet vrcholov

                int[][] matica = new int[velkostMatice][velkostMatice];

                for (int i = 0; i < matica.length; i++) {
                    System.out.println("Zadajte " + (i + 1) + ".riadok: ");
                    for (int j = 0; j < matica.length; j++) {
                        matica[i][j] = scannerKonzola.nextInt();
                    }
                }

                vypisMatice(matica, velkostMatice + "x" + velkostMatice + " - nacitana z konzoly");

                reflexivna(matica);
                symetricka(matica);
                antisymetrica(matica);
                tranzitivna(matica);
            }

            if (moznost == 2) {
                int velkostMatice = 0;

                File file = new File("matica.txt");

                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                    velkostMatice = scanner.nextInt();
                    int[][] matica2 = new int[velkostMatice][velkostMatice];
                    for (int i = 0; i < matica2.length; i++) {
                        for (int j = 0; j < matica2.length; j++) {
                            matica2[i][j] = scanner.nextInt();
                        }
                    }

                    vypisMatice(matica2, velkostMatice + "x" + velkostMatice + " - nacitana zo suboru");

                    reflexivna(matica2);
                    symetricka(matica2);
                    antisymetrica(matica2);
                    tranzitivna(matica2);

                } catch (FileNotFoundException e) {
                    System.out.println("Subor " + file.getName() + " neexistuje");
                } finally {
                    if (scanner != null)
                        scanner.close();
                }
            }

            if (moznost == 3) {
                int[][] matica3 = new int[][]{
                        {1, 0, 0, 0},
                        {0, 1, 0, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 1}
                };

                vypisMatice(matica3, "4x4 - testovacia matica");

                reflexivna(matica3);
                symetricka(matica3);
                antisymetrica(matica3);
                tranzitivna(matica3);
            }
        }
    }

    public static void reflexivna(int[][] matica) {
        // reflexivna   - na hlavnej diagonale musia byt jednotky
        boolean vysledok = true;
        for (int i = 0; i < matica.length; i++) {
            if (matica[i][i] != 1) {
                vysledok = false;
                break;
            }
        }
        if (vysledok == true) {
            System.out.println("Graf je reflexivny.");
        } else {
            System.out.println("Graf nie je reflexivny");
        }
    }

    public static void symetricka(int[][] matica) {
        // symetricka   - prvky musia byt symetricke podla hlavnej diagonaly
        boolean vysledok = true;
        for (int i = 0; i < matica.length; i++) {
            for (int j = 0; j < matica.length; j++) {
                if (matica[i][j] != matica[j][i]) {
                    vysledok = false;
                    break;
                }
            }
        }
        if (vysledok == true) {
            System.out.println("Graf je symetricky.");
        } else {
            System.out.println("Graf nie je symetricky");
        }
    }

    public static void antisymetrica(int[][] matica) {
        // antisymetricka   - vylucuje dvojicu proti sebe iducich hran
        //                  - B + Bt - nesmie mat 2ku mimo diagonaly
        boolean vysledok = true;
        int[][] matica_transponovana = new int[matica.length][matica.length];
        for (int i = 0; i < matica.length; i++) {
            for (int j = 0; j < matica.length; j++) {
                matica_transponovana[j][i] = matica[i][j];
            }
        }
        for (int i = 0; i < matica.length; i++) {
            for (int j = 0; j < matica.length; j++) {
                matica_transponovana[i][j] += matica[i][j];
                if ((i != j) && (matica_transponovana[i][j] == 2)) {
                    vysledok = false;
                    break;
                }
            }
        }
        if (vysledok == true) {
            System.out.println("Graf je antisymetricky.");
        } else {
            System.out.println("Graf nie je antisymetricky");
        }
    }

    public static void tranzitivna(int[][] matica) {
        // tranzitivna - ak existuje cesta z X do Y a zaroven z Y do Z musi byt cesta aj z X do Z
        boolean vysledok = true;
        int[][] maticaNaDruhu = new int[matica.length][matica.length];

        for (int i = 0; i < matica.length; i++) {       // nasobenie matic
            for (int j = 0; j < matica.length; j++) {
                for (int k = 0; k < matica.length; k++) {
                    maticaNaDruhu[i][j] += matica[i][k] * matica[k][j];

                    if (maticaNaDruhu[i][j] == 0 || matica[i][j] == 0) {
                        vysledok = false;
                    }
                }
            }
        }
        if (vysledok == true) {
            System.out.println("Graf je tranzitivny.");
        } else {
            System.out.println("Graf nie je tranzitivny.");
        }
    }

    public static void vypisMatice(int[][] matica, String nazov) {
        System.out.println(" ");
        System.out.println("Matica - " + nazov);
        System.out.println("-----------------------");
        for (int i = 0; i < matica.length; i++) {
            for (int j = 0; j < matica.length; j++) {
                System.out.print(matica[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}
