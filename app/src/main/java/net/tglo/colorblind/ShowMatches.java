package net.tglo.colorblind;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ShowMatches extends AppCompatActivity {

    private int baseColor = 0;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_matches);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getColors();
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
}
