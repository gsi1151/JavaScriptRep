package mx.edu.utng.franciscojs;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class JuegoNumero extends Activity {
    DatabaseHelperPoints helperPoints= new DatabaseHelperPoints(this);

    private EditText numero;
    private Button jugar,reiniciar;
    private TextView mensaje;
    private int aleatorio;
    private int intentos=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_numero);
         numero=(EditText) findViewById(R.id.txt_numero);
        jugar=(Button)findViewById(R.id.btn_jugar);
        reiniciar=(Button)findViewById(R.id.btn_reiniciar);
        mensaje=(TextView)findViewById(R.id.lbl_mensaje);
        reiniciar.setEnabled(false);



        aleatorio=generarAleatorio();


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
        //mensaje.setText(aleatorio+"");
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numeroUsuario;
                numeroUsuario=Integer.parseInt(numero.getText().toString());
                if (aleatorio==numeroUsuario){
                    mensaje.setText("HAS GANADO");
                }
                else
                {
                    intentos=intentos-1;
                }
                if (intentos==0){
                    reiniciar.setEnabled(true);
                    jugar.setEnabled(false);
                    mensaje.setText("HAS PERDIDO");
                }

            }
        });
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentos=3;
                reiniciar.setEnabled(false);
                mensaje.setText("");
                numero.setText("");
                aleatorio=generarAleatorio();
                jugar.setEnabled(true);
            }
        });
    }

    private int generarAleatorio() {
        return (int)(Math.random()*10+1);
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
                startActivity(new Intent(JuegoNumero.this, TemarioActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}
