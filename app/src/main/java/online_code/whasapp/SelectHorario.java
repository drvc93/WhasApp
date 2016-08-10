package online_code.whasapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SelectHorario extends Activity {

    ListView listViewHorarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_horario);
        setTitle("Horarios disponibles");

        listViewHorarios = (ListView)findViewById(R.id.LVHorarios);
        LoadListView();
    }

    public  void  LoadListView (){

        List<String> listHoras = new ArrayList<String>();

        listHoras.add("11:00 am");
        listHoras.add("11:15 am");
        listHoras.add("11:30 am");
        listHoras.add("11:45 am");
        listHoras.add("12:00 am");
        listHoras.add("12:15 am");
        listHoras.add("12:30 am");
        listHoras.add("12:45 am");
        listHoras.add("01:00 pm");
        listHoras.add("01:15 pm");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SelectHorario.this,android.R.layout.simple_list_item_single_choice,listHoras);
        listViewHorarios.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listViewHorarios.setAdapter(adapter);



    }
}
