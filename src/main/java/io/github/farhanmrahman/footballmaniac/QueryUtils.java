package io.github.farhanmrahman.footballmaniac;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class QueryUtils {

    private QueryUtils() {}

    public static List<Team> fetchPastData(String stringUrl) {

        String result = readFromStream(stringUrl);

        List<Team> teams = new ArrayList<>();

        try {

            JSONObject root = new JSONObject(result.toString());

            int count = root.getInt("count");

            JSONArray fixtures = root.getJSONArray("fixtures");

            for (int i = 0; i < count; i++) {
                JSONObject temp = fixtures.getJSONObject(i);
                String date = temp.getString("date").substring(5, 10);
                String time = modifyTime(temp.getString("date").substring(11, 16));
                String homeTeam = temp.getString("homeTeamName");
                String homeGoals = temp.getJSONObject("result").getString("goalsHomeTeam");
                String awayGoals = temp.getJSONObject("result").getString("goalsAwayTeam");
                String awayTeam = temp.getString("awayTeamName");

                if (homeGoals.equals("null")) homeGoals = "POSTPND";
                if (awayGoals.equals("null")) awayGoals = "POSTPND";

                Team team = new Team(date, time, homeTeam, homeGoals, awayGoals, awayTeam);
                teams.add(team);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return teams;
    }

    public static List<Team> fetchFutureData(String stringUrl) {

        String result = readFromStream(stringUrl);

        List<Team> teams = new ArrayList<>();

        try {

            JSONObject root = new JSONObject(result.toString());

            int count = root.getInt("count");

            JSONArray fixtures = root.getJSONArray("fixtures");

            for (int i = 0; i < count; i++) {
                JSONObject temp = fixtures.getJSONObject(i);
                String date = temp.getString("date").substring(5, 10);
                String time = modifyTime(temp.getString("date").substring(11, 16));
                String homeTeam = temp.getString("homeTeamName");
                String awayTeam = temp.getString("awayTeamName");

                Team team = new Team(date, time, homeTeam, awayTeam);
                teams.add(team);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return teams;
    }

    public static List<Team> fetchMyPastData(String stringUrl, HashSet<String> myTeams) {

        String result = readFromStream(stringUrl);

        List<Team> teams = new ArrayList<>();

        try {

            JSONObject root = new JSONObject(result.toString());

            int count = root.getInt("count");

            JSONArray fixtures = root.getJSONArray("fixtures");

            for (int i = 0; i < count; i++) {
                JSONObject temp = fixtures.getJSONObject(i);

                if (myTeams.contains(temp.getString("homeTeamName")) || myTeams.contains(temp.getString("awayTeamName"))) {
                    String date = temp.getString("date").substring(5, 10);
                    String time = modifyTime(temp.getString("date").substring(11, 16));
                    String homeTeam = temp.getString("homeTeamName");
                    String homeGoals = temp.getJSONObject("result").getString("goalsHomeTeam");
                    String awayGoals = temp.getJSONObject("result").getString("goalsAwayTeam");
                    String awayTeam = temp.getString("awayTeamName");

                    if (homeGoals.equals("null")) homeGoals = "POSTPND";
                    if (awayGoals.equals("null")) awayGoals = "POSTPND";

                    Team team = new Team(date, time, homeTeam, homeGoals, awayGoals, awayTeam);
                    teams.add(team);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return teams;
    }

    public static List<Team> fetchMyFutureData(String stringUrl, HashSet<String> myTeams) {

        String result = readFromStream(stringUrl);

        List<Team> teams = new ArrayList<>();

        try {

            JSONObject root = new JSONObject(result.toString());

            int count = root.getInt("count");

            JSONArray fixtures = root.getJSONArray("fixtures");

            for (int i = 0; i < count; i++) {
                JSONObject temp = fixtures.getJSONObject(i);

                if (myTeams.contains(temp.getString("homeTeamName")) || myTeams.contains(temp.getString("awayTeamName"))) {
                    String date = temp.getString("date").substring(5, 10);
                    String time = modifyTime(temp.getString("date").substring(11, 16));
                    String homeTeam = temp.getString("homeTeamName");
                    String awayTeam = temp.getString("awayTeamName");

                    Team team = new Team(date, time, homeTeam, awayTeam);
                    teams.add(team);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return teams;
    }


    public static String modifyTime(String prevTime) {
        int h = Integer.parseInt(prevTime.substring(0, 2));
        String appendix = " AM\n(GMT 00:00)";

        if (h == 0) {
            h = 12;
        } else if (h > 12) {
            h -= 12;
            appendix = " PM\n(GMT 00:00)";
        }

        return Integer.toString(h) + prevTime.substring(2) + appendix;
    }


    public static String readFromStream(String stringUrl){
        StringBuilder result = new StringBuilder();
        URL url;
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {

            url = new URL(stringUrl);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("X-Auth-Token", "246adef6a1264e14ad6a95ccd8ab735b");

            inputStream = urlConnection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = reader.readLine();

            while (line != null) {
                result.append(line + "\n");
                line = reader.readLine();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result.toString();
    }
}
