package io.github.farhanmrahman.footballmaniac;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.HashSet;
import java.util.List;

public class MyPastLoader extends AsyncTaskLoader<List<Team>>{

    private String url;
    private HashSet<String> myTeams;

    public MyPastLoader(Context context, String url, HashSet<String> myTeams){
        super(context);
        this.url = url;
        this.myTeams = myTeams;
    }

    protected void onStartLoading() {
        forceLoad();
    }

    public List<Team> loadInBackground() {
        if(url == null) return null;

        List<Team> teams = QueryUtils.fetchMyPastData(url, myTeams);

        return teams;
    }
}
