import java.util.*;


public class Config {
    private int xSize;
    private int ySize;
    private ArrayList<Inner> field = new ArrayList();

    public Config() {
    }

    public void setxSize(int x) {
        xSize = x;
    }

    public int getxSize() {
        return xSize;
    }

    public void setySize(int y) {
        ySize = y;
    }

    public int getySize() {
        return ySize;
    }

    public ArrayList<ArrayList<Integer>> getField() {
        ArrayList<ArrayList<Integer>> data = new ArrayList();
        for (int i = 0; i < this.field.size(); i++) {
            data.add(field.get(i).getIntegerArrayList());
        }
        return data;
    }

    public void setField(ArrayList<ArrayList<Integer>> field) {
        ArrayList<Inner> data = new ArrayList();

        for (int i = 0; i < field.size(); i++) {
            Inner in = new Inner(field.get(i));
            data.add(in);

        }
        this.field = data;
    }
}

class Inner {
    private ArrayList<Integer> integerArrayList;

    public Inner(final ArrayList<Integer> integerArrayList) {
        this.integerArrayList = integerArrayList;
    }

    public ArrayList<Integer> getIntegerArrayList() {
        return integerArrayList;
    }

    public void setIntegerArrayList(ArrayList<Integer> integerArrayList) {
        this.integerArrayList = integerArrayList;
    }

    @Override
    public String toString() {
        return "Inner{" +
                "intlist=" + integerArrayList +
                '}';
    }
}

