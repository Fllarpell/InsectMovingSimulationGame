package classes;

import classes.board.Board;
import classes.board.EntityPosition;
import classes.board.FoodPoint;
import classes.insects.Insect;
import classes.insects.Ant;
import classes.insects.Butterfly;
import classes.insects.Spider;
import classes.insects.Grasshopper;
import enumerations.Direction;
import enumerations.InsectColor;
import exceptions.boards.InvalidBoardSizeException;
import exceptions.boards.InvalidEntityPositionException;
import exceptions.boards.InvalidNumberOfFoodPointsException;
import exceptions.boards.TwoEntitiesOnSamePositionException;
import exceptions.insects.DuplicateInsectException;
import exceptions.insects.InvalidInsectColorException;
import exceptions.insects.InvalidInsectTypeException;
import exceptions.insects.InvalidNumberOfInsectsException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class which is point of entry of the program, the method main get from the file "input.txt" information
 * about entities and board, after that write in the file "output.txt" information contains color of insect, type of
 * insect, amount of food that the insect collected and the best direction of movement.
 */
public class Main {
    private static Board gameBoard;

    /**
     * Invalid inputs.
     *
     * @param e the Exception
     * @throws IOException the IO exception
     */
    public static void invalidInputs(Exception e) throws IOException {
        try (FileOutputStream output = new FileOutputStream("output.txt")) {
            output.write(e.getMessage().getBytes());
            output.write("\n".getBytes());
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("input.txt");
             FileOutputStream output = new FileOutputStream("output.txt")) {
            List<Object> objects = new ArrayList<>();
            List<Insect> queueExecution = new ArrayList<>();
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                objects.add(scanner.nextLine());
            }
            if (Integer.parseInt((String) objects.get(0)) > 1000
                    || Integer.parseInt((String) objects.get(0)) < 4) {
                throw new InvalidBoardSizeException();
            } else if (Integer.parseInt((String) objects.get(1)) > 16
                    || Integer.parseInt((String) objects.get(1)) < 1) {
                throw new InvalidNumberOfInsectsException();
            } else if (Integer.parseInt((String) objects.get(2)) > 200
                    || Integer.parseInt((String) objects.get(2)) < 1) {
                throw new InvalidNumberOfFoodPointsException();
            }
            gameBoard = new Board(Integer.parseInt((String) objects.get(0)));
            for (int i = 3; i < Integer.parseInt((String) objects.get(1)) + 3; i++) {
                String[] line = objects.get(i).toString().split(" ");
                InsectColor insectColor = InsectColor.toColor(line[0]);
                if (insectColor == null) {
                    throw new InvalidInsectColorException();
                }
                int entityPositionX = Integer.parseInt(line[3]);
                int entityPositionY = Integer.parseInt(line[2]);
                if (entityPositionX > Board.getSize() || entityPositionY > Board.getSize()
                        || entityPositionY < 1 || entityPositionX < 1) {
                    throw new InvalidEntityPositionException();
                }

                EntityPosition entityPosition = new EntityPosition(entityPositionX, entityPositionY);
                if (gameBoard.getBoardData().containsKey(entityPosition)) {
                    throw new TwoEntitiesOnSamePositionException();
                }
                switch (line[1]) {
                    case "Ant":
                        Ant ant = new Ant(insectColor, entityPosition);
                        gameBoard.addEntity(ant);
                        queueExecution.add(ant);
                        break;
                    case "Butterfly":
                        Butterfly butterfly = new Butterfly(insectColor, entityPosition);
                        gameBoard.addEntity(butterfly);
                        queueExecution.add(butterfly);
                        break;
                    case "Grasshopper":
                        Grasshopper grasshopper = new Grasshopper(insectColor, entityPosition);
                        gameBoard.addEntity(grasshopper);
                        queueExecution.add(grasshopper);
                        break;
                    case "Spider":
                        Spider spider = new Spider(insectColor, entityPosition);
                        gameBoard.addEntity(spider);
                        queueExecution.add(spider);
                        break;
                    default:
                        throw new InvalidInsectTypeException();
                }

            }

            for (int i = 0; i < queueExecution.size(); i++) {
                for (Insect insect : queueExecution) {
                    if (queueExecution.get(i).getColor().equals(insect.getColor())
                            && queueExecution.get(i).getClass().getSimpleName().equals(insect.getClass().getSimpleName())
                            && queueExecution.get(i) != insect) {
                        throw new DuplicateInsectException();
                    }
                }
            }

            for (int i = Integer.parseInt((String) objects.get(1)) + 3; i < objects.size(); i++) {
                String[] line = objects.get(i).toString().split(" ");
                int foodPointCoordinateX = Integer.parseInt(line[2]);
                int foodPointCoordinateY = Integer.parseInt(line[1]);
                int foodPointValue = Integer.parseInt(line[0]);
                EntityPosition entityPosition = new EntityPosition(foodPointCoordinateX, foodPointCoordinateY);
                if (gameBoard.getBoardData().containsKey(entityPosition)) {
                    throw new TwoEntitiesOnSamePositionException();
                } else if (foodPointCoordinateX > Board.getSize() || foodPointCoordinateY > Board.getSize()
                        || foodPointCoordinateX < 1 || foodPointCoordinateY < 1) {
                    throw new InvalidEntityPositionException();
                }
                FoodPoint foodPoint = new FoodPoint(foodPointValue, entityPosition);
                gameBoard.addEntity(foodPoint);
            }

            for (Insect insect: queueExecution) {
                Direction direction = gameBoard.getDirection(insect);
                int amountFoodPoints = gameBoard.getDirectionSum(insect);
                String color = String.valueOf(insect.getColor()).substring(0, 1).toUpperCase()
                        + String.valueOf(insect.getColor()).substring(1).toLowerCase();
                output.write((color + " " + insect.getClass().getSimpleName() + " "
                        + direction.getTextRepresentation() + " " + amountFoodPoints + "\n").getBytes());
            }

        } catch (Exception e) {
            try {
                Main.invalidInputs(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Gets game board.
     *
     * @return the game board
     */
    public static Board getGameBoard() {
        return gameBoard;
    }
}
