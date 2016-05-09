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
public class VideoActivityDos extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_dos);

        VideoView videoView = (VideoView) findViewById(R.id.videoViewdos);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r2---sn-q4f7sner.googlevideo.com/Cj0LENy73wIaNAkuuguCe6AvYRMYDSANFC3qADBXMOCoAUIASARgydD7zISx4ZVXigELakxvemhpbXl6MU0M/8E7EA1B1363BA1D99B95050C59BC9206D94CD3D8.DD444D57EF407C3B956D260A5B47F65D1F9F8569/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}
