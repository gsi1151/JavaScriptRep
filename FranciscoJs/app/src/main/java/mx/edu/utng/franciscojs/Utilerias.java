package mx.edu.utng.franciscojs;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import mx.edu.utng.franciscojs.acerca.AcercaDeScrollingActivity;
import mx.edu.utng.franciscojs.answers.practicas.PracticasCodigo;
import mx.edu.utng.franciscojs.juegos.MenusJuegosActivity;


public class Utilerias extends AppCompatActivity implements View.OnClickListener {


    DatabaseHelperPoints helperPoints= new DatabaseHelperPoints(this);


//private Button btnGaleriaUtng;

//private  Button btnGaleria;
    private Button btnJuego;
    private Button btnCronometro;
    private Button btnUbicacion;
    private Button btnUtileria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilerias);

//Aqui borrar



       // btnGaleriaUtng=(Button)findViewById(R.id.btn_galeria_dos_utng);
        //btnGaleriaUtng.setOnClickListener(this);


        btnJuego=(Button)findViewById(R.id.btn_juego);
        btnJuego.setOnClickListener(this);

      //  btnGaleria=(Button)findViewById(R.id.btn_galeria);
       // btnGaleria.setOnClickListener(this);




        btnUtileria=(Button)findViewById(R.id.btn_utileria_doss);
        btnUtileria.setOnClickListener(this);


        btnUbicacion = (Button) findViewById(R.id.btn_canvas);
        btnUbicacion.setOnClickListener(this);

        btnCronometro = (Button) findViewById(R.id.btn_cronometro);
        btnCronometro.setOnClickListener(this);


        LinearLayout temario=(LinearLayout)findViewById(R.id.ScrollView01);
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
            case R.id.btn_cronometro:
                startActivity(new Intent(this, Cronometro.class));
                break;

                case R.id.btn_canvas:
                    startActivity(new Intent(this, DibujarImage.class));
                    break;

            case R.id.btn_utileria_doss:
                startActivity(new Intent(this, Galeria.class));
            break;
            case R.id.btn_juego:
                startActivity(new Intent(this, MenusJuegosActivity.class));
                break;


        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_utileria,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itm_galeria_uno:
                startActivity(new Intent(Utilerias.this,GaleriaProf.class));
                break;

            case R.id.itm_galeria_dos:
                startActivity(new Intent(Utilerias.this,GaleriaUtng.class));
                break;
            case R.id.itm_galeria_tres:
                startActivity(new Intent(Utilerias.this,GaleriaTres.class));
                break;
            case R.id.itm_temario:
                startActivity(new Intent(Utilerias.this,TemarioActivity.class));
                break;


        }
        return super.onOptionsItemSelected(item);
    }


}