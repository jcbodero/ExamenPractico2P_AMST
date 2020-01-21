package marvel.estudio.superheroes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText ediiEditText;
    public static String heroe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ediiEditText = findViewById(R.id.nombre);
        heroe =  ediiEditText.getText().toString();
    }
    public void resultados(View view){
        final TextView busqueda = (TextView) findViewById(R.id.nombre);
        Intent Resultados = new Intent(getBaseContext(), resultados.class);
        Resultados.putExtra("idheroe", busqueda.getText().toString());
        startActivity(Resultados);
    }
    public void buscarHeroe(View view ){

    }


}
