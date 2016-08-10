package online_code.whasapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectServicios extends Activity {

    Spinner spServicios;
    TextView lblLocal;
    Button btnSiguiente, btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_servicios);
        setTitle("Seleccione servicio");
        spServicios = (Spinner)findViewById(R.id.spTipoServicio);
        lblLocal = (TextView)findViewById(R.id.lblLocal);
        btnSiguiente = (Button)findViewById(R.id.btnSigServicio);
        btnVolver  = (Button)findViewById(R.id.btnVolverServicio);


        String texLocal = getIntent().getExtras().getString("NomLocal");
        lblLocal.setText(texLocal);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spServicios.getSelectedItemPosition()>0){

                    Intent i = new Intent( getApplicationContext(),SelectHorario.class);
                    startActivity(i);

                }

                else
                {

                    Toast.makeText(SelectServicios.this,"Primero debe seleccionar un servicio",Toast.LENGTH_SHORT).show();
                }

            }
        });

        LoadDataSpinner();
    }

    public  void  LoadDataSpinner (){

        List<String> listServices = new ArrayList<String>();
        listServices.add("-- Seleccionar servicio --");
        listServices.add("Lavado simple de auto");
        listServices.add("Lavado  salón de auto");
        listServices.add("Lavado simple SUV O camioneta");
        listServices.add("Lavado salón SUV o camioneta");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SelectServicios.this,android.R.layout.simple_list_item_checked,listServices);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        spServicios.setAdapter(adapter);

    }
}
