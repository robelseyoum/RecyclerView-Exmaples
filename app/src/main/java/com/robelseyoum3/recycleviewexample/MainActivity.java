package com.robelseyoum3.recycleviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.onPersonClickListener {

    private ArrayList<Person> personList;
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //generateData();
        recyclerView = findViewById(R.id.recylereview_list);
        personAdapter = new PersonAdapter(generateData(), this);

        //here we create to design the values
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //or we can use
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //here we send the person list to person adapter
        recyclerView.setAdapter(personAdapter);


    }

    private ArrayList<Person> generateData(){

        personList = new ArrayList<>();

        for(int i = 0 ; i < 30 ; i++){
            Person person = new Person("firstname"+i, "lastname"+i, i);
            personList.add(person);
        }

        // for testing perpose
        //Log.i(TAG, "Firstname: "+ personList.get(3).getFirstName());
        return personList;
    }

    @Override
    public void onItemClicked(Person person) {

        Toast.makeText(getApplicationContext(), "Firstname: "+ personList.get(3).getFirstName(),Toast.LENGTH_SHORT).show();


    }
}
