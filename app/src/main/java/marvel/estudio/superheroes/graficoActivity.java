package marvel.estudio.superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class graficoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
    }/*

                if( registroTemp.getString("key").equals("temperatura")){
                    if( superHeroes.containsKey(registroId) && fechasTVs.containsKey(registroId) ){
                        fechaRegistro = fechasTVs.get(registroId);
                        valorRegistro = superHeroes.get(registroId);
                        fechaRegistro.setText(registroTemp.getString("date_created"));
                        valorRegistro.setText(registroTemp.getString("value") + " C");
                    } else {
                        nuevoRegistro = new LinearLayout(this);
                        nuevoRegistro.setOrientation(LinearLayout.HORIZONTAL);
                        fechaRegistro = new TextView(this);
                        fechaRegistro.setLayoutParams(parametrosLayout);
                        fechaRegistro.setText(registroTemp.getString("date_created"));
                        nuevoRegistro.addView(fechaRegistro);
                        valorRegistro = new TextView(this);
                        valorRegistro.setLayoutParams(parametrosLayout);
                        valorRegistro.setText(registroTemp.getString("value") + " C");
                        nuevoRegistro.addView(valorRegistro);
                        ContenedorSuperheroes.addView(nuevoRegistro);
                        fechasTVs.put(registroId, fechaRegistro);
                        superHeroes.put(registroId, valorRegistro);
                    }
                }
                else{ }*/
}
