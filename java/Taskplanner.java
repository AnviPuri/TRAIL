package com.anvipuri.trail;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Taskplanner extends AppCompatActivity {

    private ListView list_todo;
    private EditText entertask;
    private Button click;
    private ArrayAdapter adapter;
    private ArrayList<String> arrayList;
    int n=0;
    List<Task> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskplanner);

    }
    public void backtohome(View view)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void onadd(View view)
    {
        DBHelper databasehandler=new DBHelper(this);
        entertask=(EditText)findViewById(R.id.entertask);
        String task=entertask.getText().toString();
        databasehandler.save(new Task(task));
        databasehandler=new DBHelper(this);
        list=databasehandler.findAll();
        String[] listtask = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            Task task1 = list.get(i);
            listtask[i] = task1.getTodo();
        }
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,listtask);
        list_todo=(ListView)findViewById(R.id.list_todo);
        list_todo.setAdapter(adapter);
    }
    public void oncomplete(View view)
    {
        DBHelper databasehandler=new DBHelper(this);
        entertask=(EditText)findViewById(R.id.entertask);
        String task=entertask.getText().toString();
        Boolean answer=databasehandler.delete(task);
        if(answer==false)
        {
            entertask.setText("Enter the right task.");


        }
        else {
            databasehandler = new DBHelper(this);
            list = databasehandler.findAll();
            String[] listtasks = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Task task2 = list.get(i);
                listtasks[i] = task2.getTodo();
            }
            adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, listtasks);
            //adapter=new MyAdapter(this,R.layout.list_inner_view , list);
            list_todo.setAdapter(adapter);
        }
    }
    public void onview(View view)
    {
        DBHelper databasehandler=new DBHelper(this);
        list_todo=(ListView)findViewById(R.id.list_todo);


        databasehandler=new DBHelper(this);
        list=databasehandler.findAll();
        String[] listtasks = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            Task task = list.get(i);
            listtasks[i] = task.getTodo();
        }
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,listtasks);
        //adapter=new MyAdapter(this,R.layout.list_inner_view , list);
        list_todo.setAdapter(adapter);
    }
}
