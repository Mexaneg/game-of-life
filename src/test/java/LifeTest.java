import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class LifeTest {

    @Test
    public void jsonParser() throws IOException {
        Config conf = new Config();
        Field expected = new Field(10,10);
        JSONParser p = new JSONParser();
        conf = p.jsonParser("test.txt");
        int x = conf.getxSize();
        int y = conf.getySize();
        Field actual = new Field(x, y, conf.getField());
        assertEquals(expected,actual);
    }

    @Test
    public void neighboursCounter() {
        int[][] generation =
                {{1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                 {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        Field testGeneration = new Field(10,10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                testGeneration.setValue(i,j,generation[i][j]);
            }
        }
        int[][] expected = {{3, 3, 2}, {3, 3, 2},{2, 2, 1}};
        int actual = 0;
        Life counter = new Life();
        for (int i=0; i<3;i++)
        {
            for (int j =0;j<3;j++){
                actual = counter.neighboursCounter(i,j,testGeneration,10,10);
                assertEquals(expected[i][j],actual);
            }
        }


    }
}