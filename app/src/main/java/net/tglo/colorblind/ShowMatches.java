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
import android.widget.LinearLayout;
import android.widget.ImageView;

public class ShowMatches extends AppCompatActivity {
    DrawMatches drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_matches);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawColors();
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
        int baseColor = getIntent().getIntExtra("colorInt", 0);

        drawView = new DrawMatches(this, baseColor);
        setContentView(drawView);
    }
}
