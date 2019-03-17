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
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1}
        };

        reflexivna(matica);
        symetricka(matica);
        antisymetrica(matica);
        tranzitivna(matica);
    }

    public static void reflexivna(int[][] matica) {
        boolean vysledok = true;
        for (int i = 0; i < matica.length; i++) {
            if (matica[i][i] != 1){
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
                if (matica[i][j] != matica[j][i]){
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
        //TODO doplnit funkciu
        // -B
        // -Bt transponovane
        // -sucet B+Bt

        //FIXME
        System.out.println("Antisymetricky - Not implemented.");
    }

    public static void tranzitivna(int[][] matica) {
        //TODO doplnit funkciu

        System.out.println("Tranzitivny - Not implemented.");
    }
}
