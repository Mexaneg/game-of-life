public class main {
    final int FIELD_SIZE = 10;
    Field firstGeneration = new Field(FIELD_SIZE, FIELD_SIZE);
    Field secondGeneration = new Field(FIELD_SIZE, FIELD_SIZE);

    int[][] startGeneration =
            {{1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                    {1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                    {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0}};

    public static void main(String[] args) {
        //System.out.println("Hello, World!!!");
        new main().life();

    }

    void life() {
        //set and print start state
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                firstGeneration.setValue(i,j,startGeneration[i][j]);
            }
        }
        System.out.print(firstGeneration.toString());
        int neighbours = 0;
        while (true) {//life process
            for (int i = 0; i < FIELD_SIZE; i++) {
                for (int j = 0; j < FIELD_SIZE; j++) {
                    //neighbours count
                    neighbours = neighboursCounter(i, j);
                    secondGeneration.setValue(i , j, firstGeneration.getValue(i , j));
                    //cell will be live
                    if (neighbours == 3) {
                        secondGeneration.setValue(i , j, 1);
                    }
                    //cell will be die
                    else if ((neighbours < 2) || (neighbours > 3)) {
                        secondGeneration.setValue(i , j, 0);
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
                iX = (iX < 0) ? FIELD_SIZE - 1 : iX;
                jY = (jY < 0) ? FIELD_SIZE - 1 : jY;
                iX = (iX > FIELD_SIZE - 1) ? 0 : iX;
                jY = (jY > FIELD_SIZE - 1) ? 0 : jY;
                if (firstGeneration.getValue(iX , jY) == 1) {
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
