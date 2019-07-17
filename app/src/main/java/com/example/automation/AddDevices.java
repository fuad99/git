package com.example.automation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.automation.models.AutoModel;

public class AddDevices extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    TextView tvNama;
    public static final String  Key_Register="Key_Register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_devices);
        spinner = findViewById(R.id.spinner);
        tvNama = findViewById(R.id.etName);

        String Auto[]={"Lampu","Air Conditioner","Microwave","Televisi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.activity_add_devices,Auto);
        spinner.setAdapter(adapter);


    }
    public Integer hasil;


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (i){
            case 0:
                    hasil = i;
                break;
            case 1:
                    hasil = i;
                break;
            case 2:
                    hasil = i;
                break;
            case 3:
                    hasil = i;
                break;

        }
       String ini = String.valueOf(hasil);
        if (i==0){
            ini="Lampu";
        } else if(i==1) {
            ini="Air Conditioner";
        } else if(i==2){
            ini="Microwave";
        } else if(i==3){
            ini="Televisi";
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void add (View view){
        String device = tvNama.getText().toString().trim();

    }


}
