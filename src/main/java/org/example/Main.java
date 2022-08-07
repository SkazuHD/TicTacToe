package org.example;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int currentMove = 0;
        char icon = 'X';
        boolean GameIsOver = false;
        char[][] field = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        startGame(GameIsOver,icon,field,currentMove);

    }
    public static void startGame(boolean GameIsOver,char icon,char[][] field,int currentMove){

        while (!GameIsOver && currentMove < 9){
            PrintBoard(field);
            setPosition(field,icon);
            GameIsOver = GameIsOver(field,GameIsOver,icon);
            currentMove++;
            System.out.println(currentMove);
            if (!GameIsOver){
                icon = ChangeIcon(icon);
            }
        }
        System.out.println("-------");
        PrintBoard(field);
        if(GameIsOver){
            System.out.println("-------");
            System.out.println(icon+" Wins");
            System.out.println("-------");
        }else {
            System.out.println("-------");
            System.out.println("Nobody Wins");
            System.out.println("-------");
        }


    }
    public static void PrintBoard(char[][] field){
        for(int i=0; i<5;i++){
            for (int j=0;j<5;j++)
                System.out.print(field[i][j]);
            System.out.println();
        }
    }
    public static void setPosition(char[][] field,char icon){
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

    }
    public static char ChangeIcon(char icon){
        if(icon == 'X'){
            icon = 'O';
            return icon ;
        }else {
            return 'X';
        }
    }
    public static boolean GameIsOver(char[][] field, boolean GameIsOver, char icon){
        if(field[0][0] == icon && field[0][2] == icon && field[0][4] == icon){
            return true;
        }
        if(field[2][0] == icon && field[2][2] == icon && field[2][4] == icon){
            return true;
        }
        if(field[4][0] == icon && field[4][2] == icon && field[4][4] == icon){
            return true;
        }
        if (field[0][0]== icon && field[2][0]== icon && field[4][0]== icon){
            return true;
        }
        if (field[0][2]== icon && field[2][2]== icon && field[4][2]== icon){
            return true;
        }
        if (field[0][4]== icon && field[2][4]== icon && field[4][4]== icon){
            return true;
        }
        if(field[0][0] == icon && field[2][2]== icon& field[4][4]==icon){
            return true;
        }
        if (field[0][4] == icon && field[2][2]== icon& field[4][0]==icon){
            return true;
        }

        return false;
    }
}