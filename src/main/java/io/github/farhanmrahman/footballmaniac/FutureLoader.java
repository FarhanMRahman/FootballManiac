package io.github.farhanmrahman.footballmaniac;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class FutureLoader extends AsyncTaskLoader<List<Team>>{

    private String url;

    public FutureLoader(Context context, String url){
        super(context);
        this.url = url;
    }

    protected void onStartLoading() {
        forceLoad();
    }

    public List<Team> loadInBackground() {
        if(url == null) return null;

        List<Team> teams = QueryUtils.fetchFutureData(url);

        return teams;
    }
}
