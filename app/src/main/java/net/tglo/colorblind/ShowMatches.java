package net.tglo.colorblind;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
<<<<<<< HEAD
import android.widget.LinearLayout;
=======
import android.widget.ImageView;
>>>>>>> 3dadbe149ca287a694a70a73677487d62ced3ebc

public class ShowMatches extends AppCompatActivity {
    DrawMatches drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_matches);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD
        baseColor = getIntent().getIntExtra("colorInt", 0);
        getColors();
        drawColors();
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

    private void drawColors2() {
        LinearLayout complementaryGroup = (LinearLayout) findViewById(R.id.comp_swatches);
        LinearLayout splitComplementaryGroup = (LinearLayout) findViewById(R.id.splitcomp_swatches);
        LinearLayout triadGroup = (LinearLayout) findViewById(R.id.triad_swatches);
        LinearLayout analogousGroup = (LinearLayout) findViewById(R.id.anal_swatches);
        LinearLayout squareGroup = (LinearLayout) findViewById(R.id.square_swatches);
    }

    private void drawColors()
    {
        Canvas canvas = new Canvas();
        int y = canvas.getHeight();
        int x = canvas.getWidth();
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

        canvas.drawRect(0, titleHeight, x * (float) .5, titleHeight + colorHeight, basePaint);
        canvas.drawRect((float) .5 * x, titleHeight, x, titleHeight + colorHeight, complementPaint);

        canvas.drawRect(0, 2 * titleHeight + colorHeight, (float) (1.0/3.0) * x, (2 * titleHeight) + (2 * colorHeight), basePaint);
        canvas.drawRect((float) (1.0/3.0) * x, 2 * titleHeight + colorHeight, (float) (2.0/3.0) * x, (2 * titleHeight) + (2 * colorHeight), split0Paint);
        canvas.drawRect((float) (2.0/3.0) * x, 2 * titleHeight + colorHeight, x, (2 * titleHeight) + (2 * colorHeight), split1Paint);

        canvas.drawRect(0, 3 * titleHeight +  2 * colorHeight, (float) (1.0/3.0) * x, (3 * titleHeight) + (3 * colorHeight), basePaint);
        canvas.drawRect((float) (1.0/3.0) * x, 3 * titleHeight + 2 * colorHeight, (float) (2.0/3.0) * x, (3 * titleHeight) + (3 * colorHeight), triad0Paint);
        canvas.drawRect((float) (2.0/3.0) * x, 3 * titleHeight + 2 * colorHeight, x, (3 * titleHeight) + (3 * colorHeight), triad1Paint);

        canvas.drawRect(0, 4 * titleHeight +  3 * colorHeight, (float) (1.0/3.0) * x, (4 * titleHeight) + (4 * colorHeight), basePaint);
        canvas.drawRect((float) (1.0/3.0) * x, 4 * titleHeight + 3 * colorHeight, (float) (2.0/3.0) * x, (4 * titleHeight) + (4 * colorHeight), analogous0Paint);
        canvas.drawRect((float) (2.0/3.0) * x, 4 * titleHeight + 3 * colorHeight, x, (4 * titleHeight) + (4 * colorHeight), analogous1Paint);
=======
        int baseColor = getIntent().getIntExtra("colorInt", 0);
>>>>>>> 3dadbe149ca287a694a70a73677487d62ced3ebc

        drawView = new DrawMatches(this, baseColor);
        setContentView(drawView);
    }
}
