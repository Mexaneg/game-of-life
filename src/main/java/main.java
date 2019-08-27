import com.fasterxml.jackson.databind.*;

import java.io.*;
import java.nio.file.*;

public class main {
    private int xSize = 10;
    private int ySize = 10;
    private Field firstGeneration;
    private Field secondGeneration;

    public static void main(String[] args) throws IOException {
        //System.out.println("Hello, World!!!");
        new main().life();

    }

    void life() throws IOException {
        //set and print start state

        byte[] jsonData = Files.readAllBytes(Paths.get("test.txt"));
        ObjectMapper objectMapper = new ObjectMapper();
        Config config = null;
        try {
            config = objectMapper.readValue(jsonData, Config.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        xSize = config.getxSize();
        ySize = config.getySize();
        firstGeneration = new Field(xSize, ySize, config.getField());
        secondGeneration = new Field(xSize, ySize);
        System.out.print(firstGeneration.toString());
        int neighbours = 0;
        while (true) {//life process
            for (int i = 0; i < ySize; i++) {
                for (int j = 0; j < xSize; j++) {
                    //neighbours count
                    neighbours = neighboursCounter(i, j);
                    secondGeneration.setValue(i, j, firstGeneration.getValue(i, j));
                    //cell will be live
                    if (neighbours == 3) {
                        secondGeneration.setValue(i, j, 1);
                    }
                    //cell will be die
                    else if ((neighbours < 2) || (neighbours > 3)) {
                        secondGeneration.setValue(i, j, 0);
                    }


                }
            }
            firstGeneration = secondGeneration.clone();
            System.out.print(firstGeneration.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }


        }


    }

    int neighboursCounter(int i, int j) {
        int count = 0;
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                int iX = i + x;
                int jY = j + y;
                iX = (iX < 0) ? xSize - 1 : iX;
                jY = (jY < 0) ? ySize - 1 : jY;
                iX = (iX > xSize - 1) ? 0 : iX;
                jY = (jY > ySize - 1) ? 0 : jY;
                if (firstGeneration.getValue(iX, jY) == 1) {
                    count += 1;
                }

            }
        }
        if (firstGeneration.getValue(i, j) == 1) {
            count--;
        }
        return count;
    }

}
