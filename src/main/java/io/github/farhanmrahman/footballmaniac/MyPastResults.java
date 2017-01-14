package io.github.farhanmrahman.footballmaniac;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MyPastResults extends AppCompatActivity implements LoaderCallbacks<List<Team>>{

    private PastResultAdapter itemsAdapter;
    HashSet<String> myTeams = new HashSet<>();
    private ImageView emptyStateView, noInternetView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_past_results);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPref = getSharedPreferences("myTeams", Context.MODE_PRIVATE);

        if(sharedPref.getBoolean("teams84", false)) myTeams.add("Málaga CF");
        if(sharedPref.getBoolean("teams79", false)) myTeams.add("CA Osasuna");
        if(sharedPref.getBoolean("teams560", false)) myTeams.add("RC Deportivo La Coruna");
        if(sharedPref.getBoolean("teams278", false)) myTeams.add("SD Eibar");
        if(sharedPref.getBoolean("teams81", false)) myTeams.add("FC Barcelona");
        if(sharedPref.getBoolean("teams90", false)) myTeams.add("Real Betis");
        if(sharedPref.getBoolean("teams83", false)) myTeams.add("Granada CF");
        if(sharedPref.getBoolean("teams94", false)) myTeams.add("Villarreal CF");
        if(sharedPref.getBoolean("teams559", false)) myTeams.add("Sevilla FC");
        if(sharedPref.getBoolean("teams80", false)) myTeams.add("RCD Espanyol");
        if(sharedPref.getBoolean("teams96", false)) myTeams.add("Sporting Gijón");
        if(sharedPref.getBoolean("teams77", false)) myTeams.add("Athletic Club");
        if(sharedPref.getBoolean("teams92", false)) myTeams.add("Real Sociedad de Fútbol");
        if(sharedPref.getBoolean("teams86", false)) myTeams.add("Real Madrid CF");
        if(sharedPref.getBoolean("teams78", false)) myTeams.add("Club Atlético de Madrid");
        if(sharedPref.getBoolean("teams263", false)) myTeams.add("Deportivo Alavés");
        if(sharedPref.getBoolean("teams558", false)) myTeams.add("RC Celta de Vigo");
        if(sharedPref.getBoolean("teams745", false)) myTeams.add("CD Leganes");
        if(sharedPref.getBoolean("teams95", false)) myTeams.add("Valencia CF");
        if(sharedPref.getBoolean("teams275", false)) myTeams.add("UD Las Palmas");
        if(sharedPref.getBoolean("teams322", false)) myTeams.add("Hull City FC");
        if(sharedPref.getBoolean("teams338", false)) myTeams.add("Leicester City FC");
        if(sharedPref.getBoolean("teams340", false)) myTeams.add("Southampton FC");
        if(sharedPref.getBoolean("teams346", false)) myTeams.add("Watford FC");
        if(sharedPref.getBoolean("teams343", false)) myTeams.add("Middlesbrough FC");
        if(sharedPref.getBoolean("teams70", false)) myTeams.add("Stoke City FC");
        if(sharedPref.getBoolean("teams62", false)) myTeams.add("Everton FC");
        if(sharedPref.getBoolean("teams73", false)) myTeams.add("Tottenham Hotspur FC");
        if(sharedPref.getBoolean("teams354", false)) myTeams.add("Crystal Palace FC");
        if(sharedPref.getBoolean("teams74", false)) myTeams.add("West Bromwich Albion FC");
        if(sharedPref.getBoolean("teams328", false)) myTeams.add("Burnley FC");
        if(sharedPref.getBoolean("teams72", false)) myTeams.add("Swansea City FC");
        if(sharedPref.getBoolean("teams65", false)) myTeams.add("Manchester City FC");
        if(sharedPref.getBoolean("teams71", false)) myTeams.add("Sunderland AFC");
        if(sharedPref.getBoolean("teams1044", false)) myTeams.add("AFC Bournemouth");
        if(sharedPref.getBoolean("teams66", false)) myTeams.add("Manchester United FC");
        if(sharedPref.getBoolean("teams57", false)) myTeams.add("Arsenal FC");
        if(sharedPref.getBoolean("teams64", false)) myTeams.add("Liverpool FC");
        if(sharedPref.getBoolean("teams61", false)) myTeams.add("Chelsea FC");
        if(sharedPref.getBoolean("teams563", false)) myTeams.add("West Ham United FC");
        if(sharedPref.getBoolean("teams5", false)) myTeams.add("FC Bayern München");
        if(sharedPref.getBoolean("teams12", false)) myTeams.add("Werder Bremen");
        if(sharedPref.getBoolean("teams16", false)) myTeams.add("FC Augsburg");
        if(sharedPref.getBoolean("teams11", false)) myTeams.add("VfL Wolfsburg");
        if(sharedPref.getBoolean("teams4", false)) myTeams.add("Borussia Dortmund");
        if(sharedPref.getBoolean("teams15", false)) myTeams.add("1. FSV Mainz 05");
        if(sharedPref.getBoolean("teams19", false)) myTeams.add("Eintracht Frankfurt");
        if(sharedPref.getBoolean("teams6", false)) myTeams.add("FC Schalke 04");
        if(sharedPref.getBoolean("teams7", false)) myTeams.add("Hamburger SV");
        if(sharedPref.getBoolean("teams31", false)) myTeams.add("FC Ingolstadt 04");
        if(sharedPref.getBoolean("teams1", false)) myTeams.add("1. FC Köln");
        if(sharedPref.getBoolean("teams55", false)) myTeams.add("SV Darmstadt 98");
        if(sharedPref.getBoolean("teams18", false)) myTeams.add("Bor. Mönchengladbach");
        if(sharedPref.getBoolean("teams3", false)) myTeams.add("Bayer Leverkusen");
        if(sharedPref.getBoolean("teams9", false)) myTeams.add("Hertha BSC");
        if(sharedPref.getBoolean("teams17", false)) myTeams.add("SC Freiburg");
        if(sharedPref.getBoolean("teams2", false)) myTeams.add("TSG 1899 Hoffenheim");
        if(sharedPref.getBoolean("teams721", false)) myTeams.add("Red Bull Leipzig");
        if(sharedPref.getBoolean("teams100", false)) myTeams.add("AS Roma");
        if(sharedPref.getBoolean("teams109", false)) myTeams.add("Juventus Turin");
        if(sharedPref.getBoolean("teams98", false)) myTeams.add("AC Milan");
        if(sharedPref.getBoolean("teams108", false)) myTeams.add("FC Internazionale Milano");
        if(sharedPref.getBoolean("teams524", false)) myTeams.add("Paris Saint-Germain");
        if(sharedPref.getBoolean("teams503", false)) myTeams.add("FC Porto");

        itemsAdapter = new PastResultAdapter(this, new ArrayList<Team>());
        ListView listView = (ListView) findViewById(R.id.my_past_results_layout);
        listView.setAdapter(itemsAdapter);

        emptyStateView = (ImageView) findViewById(R.id.nothing_mp);
        listView.setEmptyView(emptyStateView);

        noInternetView = (ImageView) findViewById(R.id.no_int_mp);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(1, null, this);
        }

        else{
            View loadingIndicator = findViewById(R.id.loading_indicator_mp);
            loadingIndicator.setVisibility(View.GONE);
            noInternetView.setImageResource(R.drawable.no_int);
        }

    }

    public Loader<List<Team>> onCreateLoader(int id, Bundle args) {
        return new MyPastLoader(this, "http://api.football-data.org/v1/fixtures/?timeFrame=p30", myTeams);
    }

    public void onLoadFinished(Loader<List<Team>> loader, List<Team> teams) {
        emptyStateView.setImageResource(R.drawable.nothing_found);
        View loadingIndicator = findViewById(R.id.loading_indicator_mp);
        loadingIndicator.setVisibility(View.GONE);
        itemsAdapter.clear();
        if(teams != null && !teams.isEmpty()){
            itemsAdapter.addAll(teams);
        }
    }

    public void onLoaderReset(Loader<List<Team>> loader) {
        itemsAdapter.clear();
    }
}
