package classes;

import classes.board.Board;
import classes.board.EntityPosition;
import classes.insects.Insect;
import enumerations.Direction;
import enumerations.InsectColor;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Board gameBoard;

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        try(FileInputStream in = new FileInputStream("input.txt");
            FileOutputStream out = new FileOutputStream("output.txt"))
        {
            Scanner scanner = new Scanner(in);
            while (scanner.hasNextLine()) {
                objects.add(scanner.nextLine());
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

