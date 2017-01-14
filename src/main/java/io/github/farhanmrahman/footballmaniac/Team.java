package io.github.farhanmrahman.footballmaniac;

public class Team {

    private String homeName;
    private String homeGoals;
    private String awayName;
    private String awayGoals;
    private String date;
    private String time;

    public Team(String date, String time, String homeName, String homeGoals, String awayGoals, String awayName){
        this.date = date;
        this.time = time;
        this.homeName = homeName;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.awayName = awayName;
    }

    public Team(String date, String time, String homeName, String awayName){
        this.date = date;
        this.time = time;
        this.homeName = homeName;
        this.awayName = awayName;
    }

    public String getHomeName() {
        return homeName;
    }

    public String getHomeGoals() {
        return homeGoals;
    }

    public String getAwayName() {
        return awayName;
    }

    public String getAwayGoals() {
        return awayGoals;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
