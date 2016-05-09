package mx.edu.utng.franciscojs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GaleriaUtng extends AppCompatActivity implements View.OnClickListener {



    ImageView foto;
    TextView tv;

    int[]fotoId = {R.drawable.escuuno,R.drawable.escdos,R.drawable.esctres,R.drawable.esccuatro,R.drawable.esccinco,R.drawable.escseis,
    R.drawable.escsiete,R.drawable.escocho,R.drawable.escnueve};
    String[]texto={"texto foto1","texto foto2","texto foto3","texto foto4","texto foto5","texto foto6","texto foto7","texto foto8",
            "texto foto9"};

    int i=0;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria_utng);


        Button Siguiente=(Button) findViewById(R.id.button1);
        Button Anterior=(Button)findViewById(R.id.button2);
        Siguiente.setOnClickListener(this);
        Anterior.setOnClickListener(this);

        foto =(ImageView)findViewById(R.id.imageView1);
        tv=(TextView)findViewById(R.id.textView1);
        total=fotoId.length;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();

        if (id ==R.id.button1){
            i--;
            if (i== -1){
                i= total -1;
            }
        }
        if (id==R.id.button2){
            i++;
            if (i==total){
                i=0;
            }
        }
        foto.setImageResource(fotoId[i]);
        tv.setText(texto[i]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_tem_util,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itm_uno_utileria:
                startActivity(new Intent(GaleriaUtng.this,Utilerias.class));
                break;

            case R.id.itm_uno_temario:
                startActivity(new Intent(GaleriaUtng.this,TemarioActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
