package io.github.farhanmrahman.footballmaniac;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PastResultAdapter extends ArrayAdapter<Team> {

    public PastResultAdapter(Activity context, ArrayList<Team> teams) {
        super(context, 0, teams);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.past_results_list_item, parent, false);
        }

        Team currentTeam = getItem(position);

        TextView pastDateView = (TextView) listItemView.findViewById(R.id.date_past_results);
        pastDateView.setText(currentTeam.getDate());

        TextView pastTimeView = (TextView) listItemView.findViewById(R.id.time_past_results);
        pastTimeView.setText(currentTeam.getTime());

        TextView pastHomeView = (TextView) listItemView.findViewById(R.id.homeTeam_past_results);
        pastHomeView.setText(currentTeam.getHomeName());

        TextView pastHomeGoalView = (TextView) listItemView.findViewById(R.id.homeScore);
        pastHomeGoalView.setText(currentTeam.getHomeGoals() + "");

        TextView dashView = (TextView) listItemView.findViewById(R.id.dash);
        dashView.setText("-");

        TextView pastAwayGoalView = (TextView) listItemView.findViewById(R.id.awayScore);
        pastAwayGoalView.setText(currentTeam.getAwayGoals() + "");

        TextView pastAwayView = (TextView) listItemView.findViewById(R.id.awayTeam_past_results);
        pastAwayView.setText(currentTeam.getAwayName());

        return listItemView;
    }
}
