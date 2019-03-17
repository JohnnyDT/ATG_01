import java.util.Scanner;

public class Zadanie_01 {
    public static void main(String[] args) {

        //NACITANIE Z KONZOLY
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadajte velkost matice prilahlosti: ");
        int velkostMatice = scanner.nextInt();                          // velkost = pocet vrcholov

        int[][] matica = new int[velkostMatice][velkostMatice];

        for (int i = 0; i < matica.length; i++) {
            System.out.println("Zadajte " + (i + 1) + ".riadok: ");
            for (int j = 0; j < matica.length; j++) {
                matica[i][j] = scanner.nextInt();
            }
        }
        */
        int[][] matica = new int[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        reflexivna(matica);
        symetricka(matica);
        antisymetrica(matica);
        tranzitivna(matica);
    }

    public static void reflexivna(int[][] matica) {
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
        boolean vysledok = true;
        int[][] matica_transponovana = new int[matica.length][matica.length];
        for (int i = 0; i < matica.length; i++) {
            for (int j = 0; j < matica.length; j++) {
                matica_transponovana[j][i] = matica[i][j];
            }
        }
        for (int i = 0; i < matica.length; i++) {
            for (int j = 0; j < matica.length; j++) {
                matica[i][j] += matica_transponovana[i][j];
                if ((i != j) && (matica[i][j] == 2)) {
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

    public static void tranzitivna(int[][] matica)  {
        //TODO - tranzitovnost
        try {
            throw new Exception("Not implemented");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void vypisMatice(int[][] matica, String nazov) {
        System.out.println(" ");
        System.out.println("Matica - " + nazov);
        System.out.println("------------");
        for (int i = 0; i < matica.length; i++) {
            for (int j = 0; j < matica.length; j++) {
                System.out.print(matica[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
