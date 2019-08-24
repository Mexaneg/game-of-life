import java.util.*;

public class Field  implements Cloneable{
    private int xSize = 10;
    private int ySize = 10;
    private int[][] field;

    public Field(int x, int y) {
        this.xSize = x;
        this.ySize = y;
        field = new int[xSize][ySize];
    }

    int getValue(int x, int y) {
        return field[x][y];
    }

    void setValue(int x, int y, int value) {
        field[x][y] = value;
    }

    /*void copyGeneration(Field generation) {
        for (int i = 0; i < xSize; i++) {
            System.arraycopy(generation[i], 0, firstGeneration[i], 0, FIELD_SIZE);
        }
    }

     */

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                s.append(" ").append(this.getValue(i, j));
            }
            s.append("\n");

        }
        s.append("\n");
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field1 = (Field) o;
        return xSize == field1.xSize &&
                ySize == field1.ySize &&
                Arrays.equals(field, field1.field);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(xSize, ySize);
        result = 31 * result + Arrays.hashCode(field);
        return result;
    }

    @Override
    public Field clone() {
        Field clone = null;
        try {
            clone = (Field) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < xSize; i++) {
            System.arraycopy(this.field[i], 0, clone.field[i], 0, xSize);

        }
        return clone;
    }
}
