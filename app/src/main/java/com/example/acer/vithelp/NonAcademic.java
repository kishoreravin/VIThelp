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

public class NonAcademic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<Word> nA = new ArrayList<Word>();
        nA.add(new Word("Foodies 1", R.drawable.ic_launcher_background));
        nA.add(new Word("Foodies 2", R.drawable.ic_launcher_background));
        nA.add(new Word("Foodies 3", R.drawable.ic_launcher_background));
        nA.add(new Word("Food Street", R.drawable.ic_launcher_background));
        nA.add(new Word("Greenos", R.drawable.ic_launcher_background));
        nA.add(new Word("Dominos", R.drawable.ic_launcher_background));
        nA.add(new Word("Anna Auditorium", R.drawable.ic_launcher_background));
        nA.add(new Word("CS Hall", R.drawable.ic_launcher_background));
        nA.add(new Word("SJT Ground", R.drawable.ic_launcher_background));
        WordAdapter wordAdapter = new WordAdapter(this, nA);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = nA.get(i);
                Intent intent = new Intent(listView.getContext(), SuggestionPage.class);
                intent.putExtra("from", word.getName());
                intent.putExtra("blocks","nonacademic");
                startActivity(intent);
            }
        });


    }

}
