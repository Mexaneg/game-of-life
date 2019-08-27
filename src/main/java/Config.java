import com.fasterxml.jackson.annotation.*;

import java.util.*;

class Inner {
    private ArrayList<Integer> integerArrayList;

    @JsonCreator
    public Inner(final ArrayList<Integer> integerArrayList) {
        this.integerArrayList = integerArrayList;
    }

    public ArrayList<Integer> getIntegerArrayList() {
        return integerArrayList;
    }

    @Override
    public String toString() {
        return "Inner{" +
                "intlist=" + integerArrayList +
                '}';
    }
}

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

    public void setField(ArrayList<Inner> data) {
        this.field = data;
    }

    public ArrayList<ArrayList<Integer>> getField() {
        ArrayList<ArrayList<Integer>> data = new ArrayList();
        for (int i = 0; i < this.field.size(); i++) {
            data.add(field.get(i).getIntegerArrayList());
        }
        return data;
    }
}

