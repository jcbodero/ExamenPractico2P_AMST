package marvel.estudio.superheroes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class resultados extends AppCompatActivity {

    private RequestQueue mQueue;
    private String busqueda = "";
    private static String url_source = "https://superheroapi.com/api.php/2746969992025161/search/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        mQueue = Volley.newRequestQueue(this);
        Intent main = getIntent();
        this.busqueda = (String)main.getExtras().get("idheroe");
        buscarHeroe(busqueda);
    }


    public void buscarHeroe(String parametroDelHeroe){

        String url_Busqueda = url_source + parametroDelHeroe;

        final TextView txtResultadosLen = (TextView) findViewById(R.id.contResultados);
        Intent listado_heroes = new Intent(getBaseContext(), resultados.class);


        final ScrollView scrollContenedorHeroes = (ScrollView) findViewById(R.id.ContenedorHeroes);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url_Busqueda, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            txtResultadosLen.setText( String.valueOf(response.getJSONArray("results").length()));
                            LinearLayout linearHeroes = (LinearLayout) findViewById(R.id.listaHero3);

                            for(int i = 0 ; i<response.getJSONArray("results").length();i++){
                                TextView nombreHeroe = new TextView(resultados.this);
                                final JSONObject j = (JSONObject)response.getJSONArray("results").get(i);

                                nombreHeroe.setTextSize(24);
                                System.out.println(j.getString("name").toString());


                                nombreHeroe.setText(j.getString("name").toString());
                                linearHeroes.addView(nombreHeroe);

                            }
                            scrollContenedorHeroes.addView(linearHeroes);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog alertDialog = new
                        AlertDialog.Builder(resultados.this).create();

                alertDialog.setMessage("No se encontraron heroes");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int
                                    which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
        mQueue.add(request);
    }


    private void actualizarGrafico(JSONArray heroe){
        JSONObject registro;
        String her;
        String date; int
                count = 0; float
                her_val;
        ArrayList<BarEntry> dato_her = new ArrayList<>();
        try
        {
            for (int i = 0; i < heroe.length(); i++) {
                registro = (JSONObject) heroe.get(i);
                if( registro.getString("key").equals("powerstats")){
                    her = registro.getString("value");
                    date = registro.getString("date_created");
                    her_val = Float.parseFloat(her);
                    dato_her.add(new BarEntry(count, her_val));
                    count++;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("error");
        }

    }


}
