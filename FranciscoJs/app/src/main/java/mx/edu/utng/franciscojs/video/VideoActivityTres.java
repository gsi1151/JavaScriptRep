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
public class VideoActivityTres extends Activity {
    private VideoView videoView;
    private MediaController mController;
    private Uri uriYouTube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_relation);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r7---sn-q4f7snsz.googlevideo.com/Cj0LENy73wIaNAldVlXukhkOohMYDSANFC21BDBXMOCoAUIASARgydD7zISx4ZVXigELakxvemhpbXl6MU0M/8FD7D35D082EEA140024E7D3AFD2EA541BFB49E0.A17EA3EC71406B71E819449DB3A9EE981527C669/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}