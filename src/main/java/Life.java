import java.io.*;

public class Life {
    private int xSize = 10;
    private int ySize = 10;
    private Field firstGeneration;
    private Field secondGeneration;

    void life() throws IOException {
        //set and print start state
        Config config = new Config();
        JSONParser parser = new JSONParser();
        config = parser.jsonParser("settings.txt");
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
                    neighbours = neighboursCounter(i, j, firstGeneration, xSize, ySize);
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

    int neighboursCounter(int i, int j, Field generation, int xSize, int ySize) {
        int count = 0;
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                int iX = i + x;
                int jY = j + y;
                if (iX < 0) {
                    iX = xSize - 1;
                }
                if (jY < 0) {
                    jY = ySize - 1;
                }
                if (iX > xSize - 1) {
                    iX = 0;
                }
                if (jY > ySize - 1) {
                    jY = 0;
                }
                if (generation.getValue(iX, jY) == 1) {
                    count += 1;
                }

            }
        }
        if (generation.getValue(i, j) == 1) {
            count--;
        }
        return count;
    }
}
