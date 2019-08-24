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

    /*int[][] secondGeneration = new int[FIELD_SIZE][FIELD_SIZE];
     */
    public static void main(String[] args) {
        //System.out.println("Hello, World!!!");
        new main().life();

    }

    void life() {
        //set and print start state
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                firstGeneration.setValue(i, j, startGeneration[i][j]);
            }
        }
        System.out.print(firstGeneration.toString());
        while (true) {//life process
            for (int i = 0; i < FIELD_SIZE; i++) {
                for (int j = 0; j < FIELD_SIZE; j++) {
                    //neighbours count
                    int neighbours = 0;
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            int iX = i + x;
                            int jY = j + y;
                            iX = (iX < 0) ? FIELD_SIZE - 1 : iX;
                            jY = (jY < 0) ? FIELD_SIZE - 1 : jY;
                            iX = (iX > FIELD_SIZE - 1) ? 0 : iX;
                            jY = (jY > FIELD_SIZE - 1) ? 0 : jY;
                            neighbours += (firstGeneration.getValue(iX, jY) == 1) ? 1 : 0;
                        }
                    }
                    if (firstGeneration.getValue(i, j) == 1) {
                        neighbours--;
                    }

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
            /*for (int i = 0; i < FIELD_SIZE; i++) {
                //transition to the next evolutionary step
                System.arraycopy(secondGeneration[i], 0, firstGeneration[i], 0, FIELD_SIZE);
            }

             */
            System.out.print(firstGeneration.toString());
                try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }


        }


    }


    /*String printMass(Field generation) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                s.append(" ").append(generation.getValue(i, j));
            }
            s.append("\n");

        }
        s.append("\n");
        return s.toString();
    }

     */
}
