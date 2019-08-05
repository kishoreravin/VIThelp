package com.example.acer.vithelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.acer.vithelp.Adapter.WordAdapter;
import com.example.acer.vithelp.Model.Word;

import java.util.ArrayList;

public class MessCaters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Word> mess = new ArrayList<Word>();
        mess.add(new Word("Kamadenu Caters",R.drawable.ic_launcher_background));
        mess.add(new Word("CRC Caters",R.drawable.ic_launcher_background));
        mess.add(new Word("Zenith Caters",R.drawable.ic_launcher_background));
        mess.add(new Word("A2C Caters",R.drawable.ic_launcher_background));
        mess.add(new Word("Foodcy Caters",R.drawable.ic_launcher_background));
        mess.add(new Word("Darling Caters",R.drawable.ic_launcher_background));
        mess.add(new Word("Rajeshwari Caters",R.drawable.ic_launcher_background));
        WordAdapter wordAdapter = new WordAdapter(this,mess);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = mess.get(i);
                Intent intent = new Intent(listView.getContext(),SuggestionPage.class);
                intent.putExtra("from",word.getName());
                intent.putExtra("blocks","mess");
                startActivity(intent);
            }
        });
    }
}
