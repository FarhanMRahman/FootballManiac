package io.github.farhanmrahman.footballmaniac;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service{

    private MediaPlayer player;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.i_know_its_you_guards);
        player.setLooping(true);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player.seekTo(MusicVariable.currentPosition);
        player.start();
        return START_STICKY;
    }

    public void onDestroy() {
        super.onDestroy();
        MusicVariable.currentPosition = player.getCurrentPosition();
        player.stop();
        player.release();
        player = null;
    }
}

class MusicVariable{
    static int currentPosition = 0;
}
