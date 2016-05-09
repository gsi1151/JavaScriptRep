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
public class VideoActivityCinco extends Activity {
    private VideoView videoView;
    private MediaController mController;
    private Uri uriYouTube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_primarykey);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r17---sn-q4f7snsd.googlevideo.com/Cj0LENy73wIaNAnUTrl08mIzlhMYDSANFC1KBjBXMOCoAUIASARgydD7zISx4ZVXigELakxvemhpbXl6MU0M/B88D9CA3363B0D655414F0A6E799B3B1F091608C.1E9807E0BFC082106BFA557926E9330D9B34F92A/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}