package com.anvipuri.trail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class Activity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] citynames={"Ahmedabad","Agra","Amritsar","Bangalore","Bhopal","Bhubaneshwar","Chandigarh","Chennai","Dehradun","Delhi","Gangtok","Goa","Hyderabad","Jaipur","Kochi","Kolkata","Lucknow","Mumbai","Patna","Pune","Shillong","Simla","Srinagar","Trivandrum","Udaipur"};
    Spinner spinner;

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


//Getting the instance of Spinner and applying OnItemSelectedListener on it

        Spinner spinner2 = (Spinner) findViewById(R.id.spinnerto);
        spinner2.setOnItemSelectedListener(this);

//Creating the ArrayAdapter instance having the citynames list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,citynames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,citynames);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner
        spinner2.setAdapter(aa2);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), citynames[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }
    public void gotohome(View view)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void gotoinfo(View view)
    {
        spinner=(Spinner) findViewById(R.id.spinnerto);
        String spin=spinner.getSelectedItem().toString();
        Intent i=new Intent(this,Activity_3.class);
        i.putExtra("Message",spin);
        startActivity(i);

    }
}
