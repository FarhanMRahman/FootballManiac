package io.github.farhanmrahman.footballmaniac;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class SelectMyTeams extends AppCompatActivity {

    private static CheckBox teams84, teams79, teams560, teams278, teams81, teams90, teams83, teams94, teams559,
            teams80, teams96, teams77, teams92, teams86, teams78, teams263, teams558, teams745, teams95,
            teams275, teams322, teams338, teams340, teams346, teams343, teams70, teams62, teams73,
            teams354, teams74, teams328, teams72, teams65, teams71, teams1044, teams66, teams57, teams64,
            teams61, teams563, teams5, teams12, teams16, teams11, teams4, teams15, teams19, teams6,
            teams7, teams31, teams1, teams55, teams18, teams3, teams9, teams17, teams2, teams721,
            teams100, teams109, teams98, teams108, teams524, teams503;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_my_teams);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        teams84 = (CheckBox) findViewById(R.id.teams84);
        teams79 = (CheckBox) findViewById(R.id.teams79);
        teams560 = (CheckBox) findViewById(R.id.teams560);
        teams278 = (CheckBox) findViewById(R.id.teams278);
        teams81 = (CheckBox) findViewById(R.id.teams81);
        teams90 = (CheckBox) findViewById(R.id.teams90);
        teams83 = (CheckBox) findViewById(R.id.teams83);
        teams94 = (CheckBox) findViewById(R.id.teams94);
        teams559 = (CheckBox) findViewById(R.id.teams559);
        teams80 = (CheckBox) findViewById(R.id.teams80);
        teams96 = (CheckBox) findViewById(R.id.teams96);
        teams77 = (CheckBox) findViewById(R.id.teams77);
        teams92 = (CheckBox) findViewById(R.id.teams92);
        teams86 = (CheckBox) findViewById(R.id.teams86);
        teams78 = (CheckBox) findViewById(R.id.teams78);
        teams263 = (CheckBox) findViewById(R.id.teams263);
        teams558 = (CheckBox) findViewById(R.id.teams558);
        teams745 = (CheckBox) findViewById(R.id.teams745);
        teams95 = (CheckBox) findViewById(R.id.teams95);
        teams275 = (CheckBox) findViewById(R.id.teams275);
        teams322 = (CheckBox) findViewById(R.id.teams322);
        teams338 = (CheckBox) findViewById(R.id.teams338);
        teams340 = (CheckBox) findViewById(R.id.teams340);
        teams346 = (CheckBox) findViewById(R.id.teams346);
        teams343 = (CheckBox) findViewById(R.id.teams343);
        teams70 = (CheckBox) findViewById(R.id.teams70);
        teams62 = (CheckBox) findViewById(R.id.teams62);
        teams73 = (CheckBox) findViewById(R.id.teams73);
        teams354 = (CheckBox) findViewById(R.id.teams354);
        teams74 = (CheckBox) findViewById(R.id.teams74);
        teams328 = (CheckBox) findViewById(R.id.teams328);
        teams72 = (CheckBox) findViewById(R.id.teams72);
        teams65 = (CheckBox) findViewById(R.id.teams65);
        teams71 = (CheckBox) findViewById(R.id.teams71);
        teams1044 = (CheckBox) findViewById(R.id.teams1044);
        teams66 = (CheckBox) findViewById(R.id.teams66);
        teams57 = (CheckBox) findViewById(R.id.teams57);
        teams64 = (CheckBox) findViewById(R.id.teams64);
        teams61 = (CheckBox) findViewById(R.id.teams61);
        teams563 = (CheckBox) findViewById(R.id.teams563);
        teams5 = (CheckBox) findViewById(R.id.teams5);
        teams12 = (CheckBox) findViewById(R.id.teams12);
        teams16 = (CheckBox) findViewById(R.id.teams16);
        teams11 = (CheckBox) findViewById(R.id.teams11);
        teams4 = (CheckBox) findViewById(R.id.teams4);
        teams15 = (CheckBox) findViewById(R.id.teams15);
        teams19 = (CheckBox) findViewById(R.id.teams19);
        teams6 = (CheckBox) findViewById(R.id.teams6);
        teams7 = (CheckBox) findViewById(R.id.teams7);
        teams31 = (CheckBox) findViewById(R.id.teams31);
        teams1 = (CheckBox) findViewById(R.id.teams1);
        teams55 = (CheckBox) findViewById(R.id.teams55);
        teams18 = (CheckBox) findViewById(R.id.teams18);
        teams3 = (CheckBox) findViewById(R.id.teams3);
        teams9 = (CheckBox) findViewById(R.id.teams9);
        teams17 = (CheckBox) findViewById(R.id.teams17);
        teams2 = (CheckBox) findViewById(R.id.teams2);
        teams721 = (CheckBox) findViewById(R.id.teams721);
        teams100 = (CheckBox) findViewById(R.id.teams100);
        teams109 = (CheckBox) findViewById(R.id.teams109);
        teams98 = (CheckBox) findViewById(R.id.teams98);
        teams108 = (CheckBox) findViewById(R.id.teams108);
        teams524 = (CheckBox) findViewById(R.id.teams524);
        teams503 = (CheckBox) findViewById(R.id.teams503);


        Button update = (Button) findViewById(R.id.update);
        update.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                updateTeams();
            }
        });

        displayTeams();
    }

    private void displayTeams() {
        SharedPreferences sharedPref = getSharedPreferences("myTeams", Context.MODE_PRIVATE);

        teams84.setChecked(sharedPref.getBoolean("teams84", false));
        teams79.setChecked(sharedPref.getBoolean("teams79", false));
        teams560.setChecked(sharedPref.getBoolean("teams560", false));
        teams278.setChecked(sharedPref.getBoolean("teams278", false));
        teams81.setChecked(sharedPref.getBoolean("teams81", false));
        teams90.setChecked(sharedPref.getBoolean("teams90", false));
        teams83.setChecked(sharedPref.getBoolean("teams83", false));
        teams94.setChecked(sharedPref.getBoolean("teams94", false));
        teams559.setChecked(sharedPref.getBoolean("teams559", false));
        teams80.setChecked(sharedPref.getBoolean("teams80", false));
        teams96.setChecked(sharedPref.getBoolean("teams96", false));
        teams77.setChecked(sharedPref.getBoolean("teams77", false));
        teams92.setChecked(sharedPref.getBoolean("teams92", false));
        teams86.setChecked(sharedPref.getBoolean("teams86", false));
        teams78.setChecked(sharedPref.getBoolean("teams78", false));
        teams263.setChecked(sharedPref.getBoolean("teams263", false));
        teams558.setChecked(sharedPref.getBoolean("teams558", false));
        teams745.setChecked(sharedPref.getBoolean("teams745", false));
        teams95.setChecked(sharedPref.getBoolean("teams95", false));
        teams275.setChecked(sharedPref.getBoolean("teams275", false));
        teams322.setChecked(sharedPref.getBoolean("teams322", false));
        teams338.setChecked(sharedPref.getBoolean("teams338", false));
        teams340.setChecked(sharedPref.getBoolean("teams340", false));
        teams346.setChecked(sharedPref.getBoolean("teams346", false));
        teams343.setChecked(sharedPref.getBoolean("teams343", false));
        teams70.setChecked(sharedPref.getBoolean("teams70", false));
        teams62.setChecked(sharedPref.getBoolean("teams62", false));
        teams73.setChecked(sharedPref.getBoolean("teams73", false));
        teams354.setChecked(sharedPref.getBoolean("teams354", false));
        teams74.setChecked(sharedPref.getBoolean("teams74", false));
        teams328.setChecked(sharedPref.getBoolean("teams328", false));
        teams72.setChecked(sharedPref.getBoolean("teams72", false));
        teams65.setChecked(sharedPref.getBoolean("teams65", false));
        teams71.setChecked(sharedPref.getBoolean("teams71", false));
        teams1044.setChecked(sharedPref.getBoolean("teams1044", false));
        teams66.setChecked(sharedPref.getBoolean("teams66", false));
        teams57.setChecked(sharedPref.getBoolean("teams57", false));
        teams64.setChecked(sharedPref.getBoolean("teams64", false));
        teams61.setChecked(sharedPref.getBoolean("teams61", false));
        teams563.setChecked(sharedPref.getBoolean("teams563", false));
        teams5.setChecked(sharedPref.getBoolean("teams5", false));
        teams12.setChecked(sharedPref.getBoolean("teams12", false));
        teams16.setChecked(sharedPref.getBoolean("teams16", false));
        teams11.setChecked(sharedPref.getBoolean("teams11", false));
        teams4.setChecked(sharedPref.getBoolean("teams4", false));
        teams15.setChecked(sharedPref.getBoolean("teams15", false));
        teams19.setChecked(sharedPref.getBoolean("teams19", false));
        teams6.setChecked(sharedPref.getBoolean("teams6", false));
        teams7.setChecked(sharedPref.getBoolean("teams7", false));
        teams31.setChecked(sharedPref.getBoolean("teams31", false));
        teams1.setChecked(sharedPref.getBoolean("teams1", false));
        teams55.setChecked(sharedPref.getBoolean("teams55", false));
        teams18.setChecked(sharedPref.getBoolean("teams18", false));
        teams3.setChecked(sharedPref.getBoolean("teams3", false));
        teams9.setChecked(sharedPref.getBoolean("teams9", false));
        teams17.setChecked(sharedPref.getBoolean("teams17", false));
        teams2.setChecked(sharedPref.getBoolean("teams2", false));
        teams721.setChecked(sharedPref.getBoolean("teams721", false));
        teams100.setChecked(sharedPref.getBoolean("teams100", false));
        teams109.setChecked(sharedPref.getBoolean("teams109", false));
        teams98.setChecked(sharedPref.getBoolean("teams98", false));
        teams108.setChecked(sharedPref.getBoolean("teams108", false));
        teams524.setChecked(sharedPref.getBoolean("teams524", false));
        teams503.setChecked(sharedPref.getBoolean("teams503", false));

    }


    private void updateTeams() {
        SharedPreferences sharedPref = getSharedPreferences("myTeams", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putBoolean("teams84", teams84.isChecked());
        editor.putBoolean("teams79", teams79.isChecked());
        editor.putBoolean("teams560", teams560.isChecked());
        editor.putBoolean("teams278", teams278.isChecked());
        editor.putBoolean("teams81", teams81.isChecked());
        editor.putBoolean("teams90", teams90.isChecked());
        editor.putBoolean("teams83", teams83.isChecked());
        editor.putBoolean("teams94", teams94.isChecked());
        editor.putBoolean("teams559", teams559.isChecked());
        editor.putBoolean("teams80", teams80.isChecked());
        editor.putBoolean("teams96", teams96.isChecked());
        editor.putBoolean("teams77", teams77.isChecked());
        editor.putBoolean("teams92", teams92.isChecked());
        editor.putBoolean("teams86", teams86.isChecked());
        editor.putBoolean("teams78", teams78.isChecked());
        editor.putBoolean("teams263", teams263.isChecked());
        editor.putBoolean("teams558", teams558.isChecked());
        editor.putBoolean("teams745", teams745.isChecked());
        editor.putBoolean("teams95", teams95.isChecked());
        editor.putBoolean("teams275", teams275.isChecked());
        editor.putBoolean("teams322", teams322.isChecked());
        editor.putBoolean("teams338", teams338.isChecked());
        editor.putBoolean("teams340", teams340.isChecked());
        editor.putBoolean("teams346", teams346.isChecked());
        editor.putBoolean("teams343", teams343.isChecked());
        editor.putBoolean("teams70", teams70.isChecked());
        editor.putBoolean("teams62", teams62.isChecked());
        editor.putBoolean("teams73", teams73.isChecked());
        editor.putBoolean("teams354", teams354.isChecked());
        editor.putBoolean("teams74", teams74.isChecked());
        editor.putBoolean("teams328", teams328.isChecked());
        editor.putBoolean("teams72", teams72.isChecked());
        editor.putBoolean("teams65", teams65.isChecked());
        editor.putBoolean("teams71", teams71.isChecked());
        editor.putBoolean("teams1044", teams1044.isChecked());
        editor.putBoolean("teams66", teams66.isChecked());
        editor.putBoolean("teams57", teams57.isChecked());
        editor.putBoolean("teams64", teams64.isChecked());
        editor.putBoolean("teams61", teams61.isChecked());
        editor.putBoolean("teams563", teams563.isChecked());
        editor.putBoolean("teams5", teams5.isChecked());
        editor.putBoolean("teams12", teams12.isChecked());
        editor.putBoolean("teams16", teams16.isChecked());
        editor.putBoolean("teams11", teams11.isChecked());
        editor.putBoolean("teams4", teams4.isChecked());
        editor.putBoolean("teams15", teams15.isChecked());
        editor.putBoolean("teams19", teams19.isChecked());
        editor.putBoolean("teams6", teams6.isChecked());
        editor.putBoolean("teams7", teams7.isChecked());
        editor.putBoolean("teams31", teams31.isChecked());
        editor.putBoolean("teams1", teams1.isChecked());
        editor.putBoolean("teams55", teams55.isChecked());
        editor.putBoolean("teams18", teams18.isChecked());
        editor.putBoolean("teams3", teams3.isChecked());
        editor.putBoolean("teams9", teams9.isChecked());
        editor.putBoolean("teams17", teams17.isChecked());
        editor.putBoolean("teams2", teams2.isChecked());
        editor.putBoolean("teams721", teams721.isChecked());
        editor.putBoolean("teams100", teams100.isChecked());
        editor.putBoolean("teams109", teams109.isChecked());
        editor.putBoolean("teams98", teams98.isChecked());
        editor.putBoolean("teams108", teams108.isChecked());
        editor.putBoolean("teams524", teams524.isChecked());
        editor.putBoolean("teams503", teams503.isChecked());

        editor.apply();

        Toast.makeText(SelectMyTeams.this, "Updated", Toast.LENGTH_SHORT).show();
    }
}
