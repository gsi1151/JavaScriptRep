package mx.edu.utng.franciscojs.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import mx.edu.utng.franciscojs.DatabaseHelperPoints;
import mx.edu.utng.franciscojs.JuegoNumero;
import mx.edu.utng.franciscojs.MapsActivity;
import mx.edu.utng.franciscojs.MusicaActivity;
import mx.edu.utng.franciscojs.R;
import mx.edu.utng.franciscojs.TemarioActivity;
import mx.edu.utng.franciscojs.Utilerias;
import mx.edu.utng.franciscojs.acerca.AcercaDeScrollingActivity;
import mx.edu.utng.franciscojs.answers.practicas.PracticasCodigo;
import mx.edu.utng.franciscojs.answers.quiz1.PreguntasJava;
import mx.edu.utng.franciscojs.video.VideoActivityUno;


public class ModuloUno extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelperPoints helperPoints = new DatabaseHelperPoints(this);
    private Button btnCuest;
    private Button btnVideo;
    private Button btnAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulo_uno);  //se saca porque sino se solapan


        btnCuest = (Button) findViewById(R.id.btn_custionario);
        btnCuest.setOnClickListener(this);
        btnVideo = (Button) findViewById(R.id.btn_video);
        btnVideo.setOnClickListener(this);
        btnAudio = (Button) findViewById(R.id.btn_audio);
        btnAudio.setOnClickListener(this);

        ScrollView temario = (ScrollView) findViewById(R.id.ScrollView01);
        int tema = helperPoints.tema();
        if (tema == 1) {
            temario.setBackgroundResource(R.drawable.fondo1);
        } else {
            if (tema == 2) {
                temario.setBackgroundResource(R.drawable.fondo2);
            } else {
                if (tema == 3) {
                    temario.setBackgroundResource(R.drawable.fondo3);
                } else {
                    if (tema == 4) {
                        temario.setBackgroundResource(R.drawable.fondo4);
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_custionario:
                Intent i = new Intent(this, PreguntasJava.class);
                startActivity(i);
                System.exit(0);
                break;
            case R.id.btn_video:
                i = new Intent(this, VideoActivityUno.class);
                startActivity(i);
                break;
            case R.id.btn_audio:
                i = new Intent(this, MusicaActivity.class);
                startActivity(i);
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mod_uno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itm_mod_temario:
                startActivity(new Intent(ModuloUno.this, TemarioActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}
