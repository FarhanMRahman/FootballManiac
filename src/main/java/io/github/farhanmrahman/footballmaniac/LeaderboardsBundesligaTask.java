package io.github.farhanmrahman.footballmaniac;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class LeaderboardsBundesligaTask extends AsyncTask<String, Void, String> {

    protected String doInBackground(String... urls) {

        StringBuilder result = new StringBuilder();
        URL url;
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {

            url = new URL(urls[0]);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("X-Auth-Token", "246adef6a1264e14ad6a95ccd8ab735b");

            inputStream = urlConnection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = reader.readLine();

            while(line != null){
                result.append(line + "\n");
                line = reader.readLine();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(urlConnection != null){
                urlConnection.disconnect();
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result.toString();
    }

    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {

            JSONObject root = new JSONObject(s);

            JSONArray standing = root.getJSONArray("standing");

            Leaderboards.bundesliga1Name.setText(standing.getJSONObject(0).getString("teamName"));
            Leaderboards.bundesliga1Points.setText(standing.getJSONObject(0).getString("points"));
            Leaderboards.bundesliga2Name.setText(standing.getJSONObject(1).getString("teamName"));
            Leaderboards.bundesliga2Points.setText(standing.getJSONObject(1).getString("points"));
            Leaderboards.bundesliga3Name.setText(standing.getJSONObject(2).getString("teamName"));
            Leaderboards.bundesliga3Points.setText(standing.getJSONObject(2).getString("points"));
            Leaderboards.bundesliga4Name.setText(standing.getJSONObject(3).getString("teamName"));
            Leaderboards.bundesliga4Points.setText(standing.getJSONObject(3).getString("points"));
            Leaderboards.bundesliga5Name.setText(standing.getJSONObject(4).getString("teamName"));
            Leaderboards.bundesliga5Points.setText(standing.getJSONObject(4).getString("points"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
