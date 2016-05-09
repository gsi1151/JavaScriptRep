package mx.edu.utng.franciscojs.contactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

import mx.edu.utng.franciscojs.DatabaseHelperPoints;
import mx.edu.utng.franciscojs.R;


public class MainActivity extends ActionBarActivity {
    DatabaseHelperPoints helperPoints = new DatabaseHelperPoints(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contacto);



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

    public void onClick(View view){

        Intent i = new Intent(this, Agregar.class);
        startActivity(i);
    }

    public void onListar(View view){
        Intent i = new Intent(this, BuscarPersona.class);
        startActivity(i);
    }

    public void onEliminar(View view){
        Intent i = new Intent(this, Eliminar.class);
        startActivity(i);
    }

    public void premodificar(View view){
        Intent i = new Intent(this, PreModificar.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
