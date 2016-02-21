package net.tglo.colorblind;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by ben on 2/20/16.
 */
public class DrawMatches extends View {

    private int baseColor;
    private int complementColor;
    private int split0Color;
    private int split1Color;
    private int triad0Color;
    private int triad1Color;
    private int analogous0Color;
    private int analogous1Color;
    private int square0Color;
    private int square1Color;
    private int square2Color;

    public DrawMatches(Context context, int color) {
        super(context);
        baseColor = color;
    }
    private void getColors()
    {
        complementColor = ColorMatching.getComplement(baseColor);
        int[] splitColors = ColorMatching.getSplitComplementary(baseColor, 60);
        split0Color = splitColors[0];
        split1Color = splitColors[1];
        int[] triadColors = ColorMatching.getTriad(baseColor);
        triad0Color = triadColors[0];
        triad1Color = triadColors[1];
        int[] analogousColors = ColorMatching.getAnalogous(baseColor, 60);
        analogous0Color = analogousColors[0];
        analogous1Color = analogousColors[1];
        int[] squareColors = ColorMatching.getSquare(baseColor);
        square0Color = squareColors[0];
        square1Color = squareColors[1];
        square2Color = squareColors[2];
    }

    @Override
    public void onDraw(Canvas canvas) {
        getColors();
        drawColors(canvas);
    }

    private void drawColors(Canvas canvas)
    {
        int y = 500;
        int x = 1000;
        int titleHeight = 50;
        int colorHeight = y - (5 * titleHeight);

        Paint basePaint = new Paint();
        basePaint.setColor(baseColor);

        Paint complementPaint = new Paint();
        complementPaint.setColor(complementColor);

        Paint split0Paint = new Paint();
        split0Paint.setColor(split0Color);
        Paint split1Paint = new Paint();
        split1Paint.setColor(split1Color);

        Paint triad0Paint = new Paint();
        triad0Paint.setColor(triad0Color);
        Paint triad1Paint = new Paint();
        triad1Paint.setColor(triad1Color);

        Paint analogous0Paint = new Paint();
        analogous0Paint.setColor(analogous0Color);
        Paint analogous1Paint = new Paint();
        analogous1Paint.setColor(analogous1Color);

        Paint square0Paint = new Paint();
        square0Paint.setColor(square0Color);
        Paint square1Paint = new Paint();
        square1Paint.setColor(square1Color);
        Paint square2Paint = new Paint();
        square2Paint.setColor(square2Color);

        Paint ink = new Paint();
        ink.setColor(Color.BLACK);
        ink.setTextSize(titleHeight);

        canvas.drawText("Complement", 0, 10, 0, titleHeight, ink);
        canvas.drawRect(0, titleHeight, x * (float) .5, titleHeight + colorHeight, basePaint);
        canvas.drawRect((float) .5 * x, titleHeight, x, titleHeight + colorHeight, complementPaint);

        canvas.drawText("Split Complement", 0, 16, 0, 2 * titleHeight + colorHeight, ink);
        canvas.drawRect(0, 2 * titleHeight + colorHeight, (float) (1.0 / 3.0) * x, (2 * titleHeight) + (2 * colorHeight), basePaint);
        canvas.drawRect((float) (1.0/3.0) * x, 2 * titleHeight + colorHeight, (float) (2.0/3.0) * x, (2 * titleHeight) + (2 * colorHeight), split0Paint);
        canvas.drawRect((float) (2.0 / 3.0) * x, 2 * titleHeight + colorHeight, x, (2 * titleHeight) + (2 * colorHeight), split1Paint);

        canvas.drawText("Triad", 0, 5, 0, 3 * titleHeight + 2 * colorHeight, ink);
        canvas.drawRect(0, 3 * titleHeight + 2 * colorHeight, (float) (1.0 / 3.0) * x, (3 * titleHeight) + (3 * colorHeight), basePaint);
        canvas.drawRect((float) (1.0/3.0) * x, 3 * titleHeight + 2 * colorHeight, (float) (2.0/3.0) * x, (3 * titleHeight) + (3 * colorHeight), triad0Paint);
        canvas.drawRect((float) (2.0/3.0) * x, 3 * titleHeight + 2 * colorHeight, x, (3 * titleHeight) + (3 * colorHeight), triad1Paint);

        canvas.drawText("Analogous", 0, 9, 0, 4 * titleHeight + 3 *colorHeight, ink);
        canvas.drawRect(0, 4 * titleHeight +  3 * colorHeight, (float) (1.0/3.0) * x, (4 * titleHeight) + (4 * colorHeight), basePaint);
        canvas.drawRect((float) (1.0/3.0) * x, 4 * titleHeight + 3 * colorHeight, (float) (2.0/3.0) * x, (4 * titleHeight) + (4 * colorHeight), analogous0Paint);
        canvas.drawRect((float) (2.0/3.0) * x, 4 * titleHeight + 3 * colorHeight, x, (4 * titleHeight) + (4 * colorHeight), analogous1Paint);

        canvas.drawText("Square", 0, 6, 0, 5 * titleHeight + 4 *colorHeight, ink);
        canvas.drawRect(0, 5 * titleHeight + 4 * colorHeight, (float) .25 * x, (5 * titleHeight) + (5 * colorHeight), basePaint);
        canvas.drawRect((float) .25 * x, 5 * titleHeight + 4 * colorHeight, (float) .5 * x, (5 * titleHeight) + (5 * colorHeight), square1Paint);
        canvas.drawRect((float) .5 * x, 5 * titleHeight + 4 * colorHeight, (float) .75 * x, (5 * titleHeight) + (5 * colorHeight), square0Paint);
        canvas.drawRect((float) .75 * x, 5 * titleHeight + 4 * colorHeight, x, (5 * titleHeight) + (5 * colorHeight), square2Paint);
    }

}