package io.github.farhanmrahman.footballmaniac;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Leaderboards extends AppCompatActivity {
    static TextView laLiga1Name, laLiga1Points, laLiga2Name, laLiga2Points, laLiga3Name, laLiga3Points,
            laLiga4Name, laLiga4Points, laLiga5Name, laLiga5Points, epl1Name, epl1Points, epl2Name,
            epl2Points, epl3Name, epl3Points, epl4Name, epl4Points, epl5Name, epl5Points, bundesliga1Name,
            bundesliga1Points, bundesliga2Name, bundesliga2Points, bundesliga3Name, bundesliga3Points,
            bundesliga4Name, bundesliga4Points, bundesliga5Name, bundesliga5Points;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            setContentView(R.layout.activity_leaderboards);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            laLiga1Name = (TextView) findViewById(R.id.la_liga_1_name);
            laLiga1Points = (TextView) findViewById(R.id.la_liga_1_points);
            laLiga2Name = (TextView) findViewById(R.id.la_liga_2_name);
            laLiga2Points = (TextView) findViewById(R.id.la_liga_2_points);
            laLiga3Name = (TextView) findViewById(R.id.la_liga_3_name);
            laLiga3Points = (TextView) findViewById(R.id.la_liga_3_points);
            laLiga4Name = (TextView) findViewById(R.id.la_liga_4_name);
            laLiga4Points = (TextView) findViewById(R.id.la_liga_4_points);
            laLiga5Name = (TextView) findViewById(R.id.la_liga_5_name);
            laLiga5Points = (TextView) findViewById(R.id.la_liga_5_points);

            epl1Name = (TextView) findViewById(R.id.epl_1_name);
            epl1Points = (TextView) findViewById(R.id.epl_1_points);
            epl2Name = (TextView) findViewById(R.id.epl_2_name);
            epl2Points = (TextView) findViewById(R.id.epl_2_points);
            epl3Name = (TextView) findViewById(R.id.epl_3_name);
            epl3Points = (TextView) findViewById(R.id.epl_3_points);
            epl4Name = (TextView) findViewById(R.id.epl_4_name);
            epl4Points = (TextView) findViewById(R.id.epl_4_points);
            epl5Name = (TextView) findViewById(R.id.epl_5_name);
            epl5Points = (TextView) findViewById(R.id.epl_5_points);

            bundesliga1Name = (TextView) findViewById(R.id.bundesliga_1_name);
            bundesliga1Points = (TextView) findViewById(R.id.bundesliga_1_points);
            bundesliga2Name = (TextView) findViewById(R.id.bundesliga_2_name);
            bundesliga2Points = (TextView) findViewById(R.id.bundesliga_2_points);
            bundesliga3Name = (TextView) findViewById(R.id.bundesliga_3_name);
            bundesliga3Points = (TextView) findViewById(R.id.bundesliga_3_points);
            bundesliga4Name = (TextView) findViewById(R.id.bundesliga_4_name);
            bundesliga4Points = (TextView) findViewById(R.id.bundesliga_4_points);
            bundesliga5Name = (TextView) findViewById(R.id.bundesliga_5_name);
            bundesliga5Points = (TextView) findViewById(R.id.bundesliga_5_points);

            LeaderboardsLaLigaTask task1 = new LeaderboardsLaLigaTask();
            task1.execute("http://api.football-data.org/v1/competitions/436/leagueTable");

            LeaderboardsEPLTask task2 = new LeaderboardsEPLTask();
            task2.execute("http://api.football-data.org/v1/competitions/426/leagueTable");

            LeaderboardsBundesligaTask task3 = new LeaderboardsBundesligaTask();
            task3.execute("http://api.football-data.org/v1/competitions/430/leagueTable");

        }

        else{
            setContentView(R.layout.no_internet_leaderboard);
        }


    }
}
