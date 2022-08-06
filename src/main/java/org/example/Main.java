package org.example;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        char icon = 'X';
        char[][] field = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        for (int zug=0; zug<9;zug++){
        PrintBoard(field);
        icon = setPosition(field,icon);
        }
    }
    public static void PrintBoard(char[][] field){
        for(int i=0; i<5;i++){
            for (int j=0;j<5;j++)
                System.out.print(field[i][j]);
            System.out.println();
        }
    }
    public static char setPosition(char[][] field,char icon){
        Scanner scan = new Scanner(System.in);
        System.out.print("Place " + icon +":");
        int position = scan.nextInt();

        switch (position) {
            case 1 -> field[0][0] = icon;
            case 2 -> field[0][2] = icon;
            case 3 -> field[0][4] = icon;
            case 4 -> field[2][0] = icon;
            case 5 -> field[2][2] = icon;
            case 6 -> field[2][4] = icon;
            case 7 -> field[4][0] = icon;
            case 8 -> field[4][2] = icon;
            case 9 -> field[4][4] = icon;
            default -> {
                System.out.println("Wrong Input");
                setPosition(field, icon);
            }
        }
        if(icon == 'X'){
            icon = 'O';
            return icon ;
        }else {
           return 'X';
        }
    }
}