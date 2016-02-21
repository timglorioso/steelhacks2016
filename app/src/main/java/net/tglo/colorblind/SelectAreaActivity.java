package net.tglo.colorblind;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SelectAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_area);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button acceptAreaButton = (Button) findViewById(R.id.accept_button);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showMatchesIntent = new Intent(getApplicationContext(), ShowMatches.class);
                startActivity(showMatchesIntent);
            }
        };
        acceptAreaButton.setOnClickListener(clickListener);
    }
}
