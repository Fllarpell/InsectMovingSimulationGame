package LAB12.EX1;

import java.io.*;

public class ExceptionsWithFile {

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt");
            FileOutputStream out = new FileOutputStream("output.txt")) {
            byte[] buffer = new byte[in.available()];
            in.read(buffer, 0, buffer.length);
            out.write(buffer, 0, buffer.length);

        } catch (FileNotFoundException e) {
            System.out.println("One of files does not exist");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
