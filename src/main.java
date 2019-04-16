import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main {
    static int index;
    static int windex;
    static String token3;
    static String token2;
    static String token1;
    static String[] table = new String[100];
    static int[] tableA = new int[100];
    static int[] tableB = new int[100];
    static int[] tableC = new int[100];
    static int k;

    public static void main(String[] args) throws FileNotFoundException {
        int index = 0;

        String fileName = "C:\\Users\\Maciej\\IdeaProjects\\zadanie\\src\\learning.txt";


        String[] table = new String[100];
        int[] tableA = new int[100];
        int[] tableB = new int[100];
        int[] tableC = new int[100];


        File plik = new File(fileName);
        //BufferedReader test=new BufferedReader();
        Scanner odczyt = new Scanner(plik);
        StringTokenizer token;
        System.out.println(index);
        while (odczyt.hasNextLine()) {

            if (index == 0) {
                token = new StringTokenizer(odczyt.nextLine(), "|");
                token3 = token.nextToken();
                System.out.println(token3);
                if (token.hasMoreElements()) {
                    token1 = token.nextToken();
                    windex = 1;
                    System.out.println(token1);
                }
                String temp = token3 + token1;
                windex = 1;
                table[windex] = token3 + token1;
                index++;
                if (token.hasMoreElements()) {
                    String token2 = token.nextToken();
                    System.out.println(token2);

                    if (token2.equals("A")) {
                        tableA[windex] = tableA[index] + 1;
                    } else if (token2.equals("B")) {
                        tableB[windex] = tableB[index] + 1;
                    } else if (token2.equals("C")) {
                        tableC[windex] = tableC[index] + 1;
                    }

                }


            } else {


//while z warunkiem znajdzie taki sam elemet lub dojdzie do konca tabeli

                token = new StringTokenizer(odczyt.nextLine(), "|");
                token3 = token.nextToken();

                if (token.hasMoreElements()) {
                    token1 = token.nextToken();
                    windex = 1;

                }
                String temp = token3 + token1;

                windex = 1;

                while (windex <= index) {

                    if (windex <= index) {

                        if (table[windex].equals(temp) == true) {

                            break;
                        }
                    }

                    windex++;
                }

                if (windex > index) {
                    table[windex] = token3 + token1;
                    index++;
                }

                if (token.hasMoreElements()) {
                    String token2 = token.nextToken();


                    if (token2.equals("A") == true) {
                        tableA[windex] = tableA[windex] + 1;
                    } else if (token2.equals("B") == true) {
                        tableB[windex] = tableB[windex] + 1;
                    } else if (token2.equals("C") == true) {
                        tableC[windex] = tableC[windex] + 1;
                    }

                }
            }

        }

        System.out.println(index);
        for (int i = 1; i <= index; i++) {
            System.out.println(table[i] + " " + tableA[i] + " " + tableB[i] + " " + tableC[i]);

        }

        int wybor = wybor();

        while (wybor != 0) {
            switch (wybor) {
                case 1:
                    System.out.println(index);
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Hej");
                    System.out.println("Podaj dolna granice pierwszego przedziału: ");
                    String choice = scanner.nextLine();
                    System.out.println("Podaj górną granice pierwszego przedziału: ");
                    String choice2 = scanner.nextLine();
                    System.out.println("Podaj dolna granice drugiego przedziału: ");
                    String choice3 = scanner.nextLine();
                    System.out.println("Podaj górną granice drugiego przedziału: ");
                    String choice4 = scanner.nextLine();
                    String test = "[" + choice + "; " + choice2 + ")[" + choice3 + "; " + choice4 + ")";
                    System.out.println(test);
                    int a = 1;


                    while (a <= index) {
                        if (a <= index) {


                            if (table[a].equals(test) == true) {
                                break;
                            }
                        }
                        a++;

                    }
                    if (a <= index) {
                        if (tableA[a] > tableB[a] && tableA[a] > tableC[a]) {
                            System.out.println("A");
                            break;
                        } else if (tableB[a] > tableA[a] && tableB[a] > tableC[a]) {
                            System.out.println("B");
                            break;
                        }
                        if (tableC[a] > tableB[a] && tableC[a] > tableA[a]) {
                            System.out.println("C");
                            break;
                        }

                    } else {
                        System.out.println("Nie ma takiego przedziału");
                        break;
                    }
                    break;


                case 0:
                    System.out.println("wyjście");

                    break;
                default:
                    System.out.println("Zły numer");


            }
            wybor = wybor();
        }


    }


    public static int wybor() {
        System.out.println("1. Podaj przedział do sprawdzenia");
        System.out.println("0. Wyjście");
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        return w;
    }


}


