package mx.edu.utng.franciscojs.contactos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import mx.edu.utng.franciscojs.DatabaseHelperPoints;
import mx.edu.utng.franciscojs.R;


public class Agregar extends ActionBarActivity {
    DatabaseHelperPoints helperPoints= new DatabaseHelperPoints(this);

    MyDBHandler dbHandler;
    EditText nombre_input;
    EditText apellido_input;
    EditText edad_input;
    EditText telefono_input;
    EditText email_input;
    EditText sangre_input;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);
        nombre_input = (EditText) findViewById(R.id.nombre_input);
        apellido_input = (EditText) findViewById(R.id.apellido_input);
        edad_input = (EditText) findViewById(R.id.edad_input);
        telefono_input = (EditText) findViewById(R.id.telefono_input);
        email_input = (EditText) findViewById(R.id.email_input);
       sangre_input = (EditText) findViewById(R.id.sangre_input);
        dbHandler = new MyDBHandler(this, null, null, 1);




        ScrollView temario=(ScrollView)findViewById(R.id.ScrollView01);
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

    //Añade una Persona a la Base de Datos

   public void agregar_clicked(View view){

    Personas persona = new Personas(nombre_input.getText().toString(), apellido_input.getText().toString(), Integer.parseInt(edad_input.getText().toString()), telefono_input.getText().toString(), email_input.getText().toString(),sangre_input.getText().toString());
    dbHandler.addPersona(persona);
    confirmacion();
    limpiarcampos();
   }


   //Limpia los valores entrados para efectos de estetica
   public void limpiarcampos(){

       nombre_input.setText("");
       apellido_input.setText("");
       edad_input.setText("");
       telefono_input.setText("");
       email_input.setText("");
     //  sangre_input.setText("");

   }

   public void confirmacion(){

       AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
       dlgAlert.setMessage("Se ha agregado exitosamente!");
       dlgAlert.setTitle("Agregar Persona");
       dlgAlert.setPositiveButton("Ok",
               new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {
                       //dismiss the dialog
                   }
               });
       dlgAlert.setCancelable(true);
       dlgAlert.create().show();
   }



}
