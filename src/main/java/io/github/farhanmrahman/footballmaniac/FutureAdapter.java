package io.github.farhanmrahman.footballmaniac;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FutureAdapter extends ArrayAdapter<Team> {

    public FutureAdapter(Activity context, ArrayList<Team> teams) {
        super(context, 0, teams);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.future_fixtures_list_item, parent, false);
        }

        Team currentTeam = getItem(position);

        TextView dateView = (TextView) listItemView.findViewById(R.id.date_future);
        dateView.setText(currentTeam.getDate());

        TextView timeView = (TextView) listItemView.findViewById(R.id.time_future);
        timeView.setText(currentTeam.getTime());

        TextView homeView = (TextView) listItemView.findViewById(R.id.homeTeam_future);
        homeView.setText(currentTeam.getHomeName());

        TextView vsView = (TextView) listItemView.findViewById(R.id.vs);
        vsView.setText("vs");

        TextView awayView = (TextView) listItemView.findViewById(R.id.awayTeam_future);
        awayView.setText(currentTeam.getAwayName());

        return listItemView;
    }
}
