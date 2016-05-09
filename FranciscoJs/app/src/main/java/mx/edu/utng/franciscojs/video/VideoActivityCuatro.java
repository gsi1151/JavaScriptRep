package mx.edu.utng.franciscojs.video;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import mx.edu.utng.franciscojs.R;


/**
 * Created by LUISITO on 06/04/2016.
 */
public class VideoActivityCuatro extends Activity {
    private VideoView videoView;
    private MediaController mController;
    private Uri uriYouTube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_uno);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r3---sn-q4f7sn7d.googlevideo.com/Cj0LENy73wIaNAkKveCQVlpV7RMYDSANFC27BTBXMOCoAUIASARgydD7zISx4ZVXigELakxvemhpbXl6MU0M/3DF2FC40DDD951A4CBE55BBDAA3E7153CEE1B4F1.29109485DBFA4A706AE4E686D26ACC82CF78FFF6/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}