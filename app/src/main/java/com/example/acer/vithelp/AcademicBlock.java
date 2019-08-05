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

public class AcademicBlock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<Word> academic_blocks = new ArrayList<Word>();
        academic_blocks.add(new Word("Main building",R.drawable.ic_launcher_background));
        academic_blocks.add(new Word("Silver Jublee Tower",R.drawable.ic_launcher_background));
        academic_blocks.add(new Word("Technology Tower",R.drawable.ic_launcher_background));
        academic_blocks.add(new Word("Sir M Vishveshvaraiya Building",R.drawable.ic_launcher_background));
        academic_blocks.add(new Word("CBMR",R.drawable.ic_launcher_background));
        academic_blocks.add(new Word("G.D.Naidu Block",R.drawable.ic_launcher_background));
        academic_blocks.add(new Word("CDMM Building",R.drawable.ic_launcher_background));
        academic_blocks.add(new Word("CDMM Building",R.drawable.ic_launcher_background));
        academic_blocks.add(new Word("A.L. Mudailar Block",R.drawable.ic_launcher_background));

        WordAdapter wordAdapter = new WordAdapter(this,academic_blocks);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = academic_blocks.get(i);
                Intent intent = new Intent(listView.getContext(),SuggestionPage.class);
                intent.putExtra("from",word.getName());
                intent.putExtra("blocks","academic");
                startActivity(intent);
            }
        });

    }
}
