package io.github.farhanmrahman.footballmaniac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MyTeamsActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_teams);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView selectMyTeamsTextView = (TextView) findViewById(R.id.select_my_teams);
        selectMyTeamsTextView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent selectMyTeamsIntent = new Intent(MyTeamsActivity.this, SelectMyTeams.class);
                startActivity(selectMyTeamsIntent);
            }
        });

        TextView myPastResultsTextView = (TextView) findViewById(R.id.my_past_results);
        myPastResultsTextView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent myPastResultsIntent = new Intent(MyTeamsActivity.this, MyPastResults.class);
                startActivity(myPastResultsIntent);
            }
        });

        TextView myNextFixturesTextView = (TextView) findViewById(R.id.my_next_features);
        myNextFixturesTextView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent myNextFixturesIntent = new Intent(MyTeamsActivity.this, MyNextFixtures.class);
                startActivity(myNextFixturesIntent);
            }
        });

    }
}
