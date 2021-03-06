package hu.lokter.mi.model;

import java.util.ArrayList;

/**
 * Created by Balint on 2017. 10. 08..
 */
public class Koffer {
   private ArrayList<Item> items ;
   private int height;
   private int width;
    private int[][] matrix;

    public Koffer(ArrayList<Item> items, int height, int width) {
        this.items = items;
        this.height = height;
        this.width = width;
        initialize();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void initialize(){
        matrix = new int[width][height];
        for(int i = 0;i<width;i++)
            for(int j = 0;j<height;j++)
                matrix[i][j] = 0;
    }
    public void putItemToMatrix(Item item,int x,int y)
    {
        for (int i = x;i< x + item.getWidth();i++)
            for(int j = y; j < y + item.getHeight();j++)
                matrix[i][j] = item.getId();
        items.remove(item);
    }
    public boolean enoughSpace(Item item,int x,int y)
    {
        for (int i = x;i< x + item.getWidth();i++)
            for(int j = y; j < y + item.getHeight();j++)
                if( i >= width || j >= height || matrix[i][j] != 0)
                    return false;
        return true;
    }

    @Override
    public String toString()
    {
        String resault = "";
        for(int j = 0;j<height;j++) {
            for (int i = 0; i < width; i++) {
                resault += matrix[i][j] + ( i == width-1 ? "" : "\t");
            }
            resault+="\n";
        }
        return resault;
    }
    public ArrayList<Item> getUnselectedItems()
    {
        ArrayList<Item> unselected = new ArrayList<>();
        for (Item item:items) {
            if(!item.selected)
                unselected.add(item);
        }
        return unselected;
    }
}
