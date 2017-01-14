package io.github.farhanmrahman.footballmaniac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent i;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView myTeamsTextView = (TextView) findViewById(R.id.my_teams);
        myTeamsTextView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent myTeamsIntent = new Intent(MainActivity.this, MyTeamsActivity.class);
                startActivity(myTeamsIntent);
            }
        });

        TextView pastResultsTextView = (TextView) findViewById(R.id.past_results);
        pastResultsTextView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent pastResultsIntent = new Intent(MainActivity.this, PastReslutsActivity.class);
                startActivity(pastResultsIntent);
            }
        });

        TextView nextFixturesTextView = (TextView) findViewById(R.id.next_features);
        nextFixturesTextView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent nextFixturesIntent = new Intent(MainActivity.this, NextFixturesActivity.class);
                startActivity(nextFixturesIntent);
            }
        });

        TextView leaderboardsTextView = (TextView) findViewById(R.id.leaderboards);
        leaderboardsTextView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent leaderboardsIntent = new Intent(MainActivity.this, Leaderboards.class);
                startActivity(leaderboardsIntent);
            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.musicSwitch);
        item.setActionView(R.layout.switch_layout);

        final Switch muteSwitch = (Switch) menu.findItem(R.id.musicSwitch).getActionView().findViewById(R.id.music_switch);

        muteSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    i = new Intent(MainActivity.this, MusicService.class);
                    startService(i);
                }

                else{
                    stopService(i);
                }

            }

        });

        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        stopService(i);
    }

}
