package online_code.whasapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelecLocal extends Activity {


    Spinner spLocal ;
    Button btnSiguiente,btnVolver;
    String selectedLocal = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selec_local);
        setTitle("Seleccione Local");
        spLocal = (Spinner) findViewById(R.id.spLocal);
        btnSiguiente = (Button) findViewById(R.id.btnSiguienteLocal);
        btnVolver = (Button) findViewById(R.id.btnVolverLocal);


        LoadSpinner();

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spLocal.getSelectedItemPosition() > 0) {

                    Intent i = new Intent(SelecLocal.this, SelectServicios.class);
                    i.putExtra("NomLocal", selectedLocal);
                    startActivity(i);
                } else {


                    Toast.makeText(SelecLocal.this, "Seleccione un local", Toast.LENGTH_SHORT).show();


                }


            }
        });


        spLocal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    String item = parent.getItemAtPosition(position).toString();
                    selectedLocal = item;
                } else if (position == 0) {

                    Toast.makeText(SelecLocal.this, "Seleccione un local", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public  void  LoadSpinner (){

        List<String> listLocal = new ArrayList<String>();
        listLocal.add("-- Seleccione Local --");
        listLocal.add("CarWash 1");
        listLocal.add("CarWash 2");
        listLocal.add("CarWash 3");
        listLocal.add("CarWash 4");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SelecLocal.this,android.R.layout.simple_list_item_checked,listLocal);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        spLocal.setAdapter(adapter);

    }
}
