import java.util.*;

public class Field implements Cloneable {
    private int xSize;
    private int ySize;
    private ArrayList<ArrayList<Integer>> field = new ArrayList();

    public Field(int x, int y, ArrayList<ArrayList<Integer>> input) {
        this.xSize = x;
        this.ySize = y;
        this.field = input;
    }

    public Field(int x, int y) {
        this.xSize = x;
        this.ySize = y;
        for (int i = 0; i < xSize; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < ySize; j++) {
                arr.add(0);
            }
            field.add(arr);
        }
    }

    public ArrayList<ArrayList<Integer>> getField() {
        return field;
    }

    public int getySize() {
        return ySize;
    }

    public int getxSize() {
        return xSize;
    }

    public Integer getValue(int i, int j) {
        return field.get(j).get(i);
    }

    public void setValue(int i, int j, Integer value) {
        try {
            field.get(j).set(i, value);

        } catch (Exception e) {
            System.out.print("");
        }
    }

    public void setValue(int i, List<Integer> value) {
        try {
            field.set(i, (ArrayList<Integer>) value);

        } catch (Exception e) {
            System.out.print("");
        }
    }

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
                Objects.equals(field, field1.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xSize, ySize, field);
    }

    @Override
    public Field clone() {
        Field clone = null;
        try {
            clone = (Field) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
