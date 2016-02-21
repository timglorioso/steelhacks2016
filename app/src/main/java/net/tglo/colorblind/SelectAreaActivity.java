package net.tglo.colorblind;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelectAreaActivity extends AppCompatActivity {

    Bitmap imageBitmap;
    ImageView imageView;
    int baseColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_area);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.image_view);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        imageBitmap = BitmapFactory.decodeFile(getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE));
        imageView.setMaxWidth(imageBitmap.getScaledWidth(metrics));
        imageView.setMaxHeight(imageBitmap.getScaledHeight(metrics));

        imageView.setImageBitmap(imageBitmap);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("Touch coordinates : " +
                        String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
                baseColor = imageBitmap.getPixel((int) event.getX(), (int) event.getY());
                //baseColor = getAverageOfRegion((int) event.getX(), (int) event.getY());
                return true;
            }
        });

        final Button acceptAreaButton = (Button) findViewById(R.id.accept_button);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showMatchesIntent = new Intent(getApplicationContext(), ShowMatches.class);
                showMatchesIntent.putExtra("colorInt", baseColor);
                startActivity(showMatchesIntent);
            }
        };
        acceptAreaButton.setOnClickListener(clickListener);
    }

    private int getAverageOfRegion(int x, int y)
    {
        int[] sum = new int[4];

        for(int X = x - 1; X <= (x + 1); X++)
        {
            for(int Y = y - 1; Y <= (y + 1); Y++)
            {
                sum[0] += Color.alpha(imageBitmap.getPixel(X, Y));
                sum[1] += Color.red(imageBitmap.getPixel(X, Y));
                sum[2] += Color.green(imageBitmap.getPixel(X, Y));
                sum[3] += Color.blue(imageBitmap.getPixel(X, Y));
            }
        }

        for(int i = 0; i < 4; i++)
        {
            sum[i] = sum[i] / (9);
        }

        System.out.println("A,R,G,B: " + sum[0] + "," + sum[1] + "," + sum[2] + "," + sum[3]);

        int color = Color.argb(sum[0], sum[1], sum[2], sum[3]);

        return color;
    }
}
