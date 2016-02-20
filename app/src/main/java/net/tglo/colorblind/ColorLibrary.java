package net.tglo.colorblind;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ben on 2/20/16.
 */
public class ColorLibrary
{

    private ArrayList<colorItem> colorList;

    public ColorLibrary()
    {
        colorList = new ArrayList<colorItem>();
    }

    public void addColor(float[] color, String filePath)
    {
        colorItem item = new colorItem();
        item.color = color;
        item.filePath = filePath;
        colorList.add(item);
    }

    public matchItem[] getMatchList(float[] color)
    {
        matchItem[] matchList = new matchItem[colorList.size()];
        for(int i = 0; i < matchList.length; i++)
        {
            double matchLevel = getMatchLevel(colorList.get(i).color, color);
            matchItem item = new matchItem();
            item.item = colorList.get(i);
            item.matchLevel = matchLevel;
            matchList[i] = item;
        }
        Arrays.sort(matchList);
        return matchList;
    }

    //solely based on hue as of now
    private double getMatchLevel(float[] color0, float[] color1)
    {
        double matchLevel = 0;

        double difference = Math.abs(color0[0] - color1[0]);
        if(difference > 180.0)
            difference = difference - 180.0;
        matchLevel += (difference / 180.0) * 1.0;

        return matchLevel;
    }

    public class matchItem implements Comparator<matchItem>
    {
        public double matchLevel;
        public colorItem item;

        public int compare(matchItem m0, matchItem m1)
        {
            return (int) (m0.matchLevel - m1.matchLevel);
        }
    }

    public class colorItem
    {
        public float[] color;
        public String filePath;
    }
}