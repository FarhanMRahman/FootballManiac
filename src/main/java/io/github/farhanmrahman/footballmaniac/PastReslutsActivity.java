package io.github.farhanmrahman.footballmaniac;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PastReslutsActivity extends AppCompatActivity implements LoaderCallbacks<List<Team>>{

    private PastResultAdapter itemsAdapter;
    private ImageView emptyStateView, noInternetView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_results);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itemsAdapter = new PastResultAdapter(this, new ArrayList<Team>());
        ListView listView = (ListView) findViewById(R.id.past_results_layout);
        listView.setAdapter(itemsAdapter);

        emptyStateView = (ImageView) findViewById(R.id.nothing_p);
        listView.setEmptyView(emptyStateView);

        noInternetView = (ImageView) findViewById(R.id.no_int_p);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(1, null, this);
        }

        else{
            View loadingIndicator = findViewById(R.id.loading_indicator_p);
            loadingIndicator.setVisibility(View.GONE);
            noInternetView.setImageResource(R.drawable.no_int);
        }

    }

    public Loader<List<Team>> onCreateLoader(int id, Bundle args) {
        return new PastLoader(this, "http://api.football-data.org/v1/fixtures/?timeFrame=p30");
    }

    public void onLoadFinished(Loader<List<Team>> loader, List<Team> teams) {
        emptyStateView.setImageResource(R.drawable.nothing_found);
        View loadingIndicator = findViewById(R.id.loading_indicator_p);
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
