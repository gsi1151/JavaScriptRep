package mx.edu.utng.franciscojs.contactos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import mx.edu.utng.franciscojs.DatabaseHelperPoints;
import mx.edu.utng.franciscojs.R;


public class Eliminar extends ActionBarActivity {
    DatabaseHelperPoints helperPoints = new DatabaseHelperPoints(this);

    MyDBHandler dbHandler;
    EditText elimina_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_contacto);
        elimina_input = (EditText) findViewById(R.id.modificar_input);
        dbHandler = new MyDBHandler(this, null, null, 1);

        RelativeLayout temario = (RelativeLayout) findViewById(R.id.ScrollView01);
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

    public void eliminar_clicked(View view){

        dbHandler.borrarPersona(Integer.parseInt(elimina_input.getText().toString()));
        confirmacion();


    }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(elimina_input.getText());
        dlgAlert.setTitle("Se ha eliminado satisfactoriamente!!!");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eliminar, menu);
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
