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

public class HostelBlocks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<Word> hostel_blocks = new ArrayList<Word>();
        hostel_blocks.add(new Word("ALBERT EINSTEIN BLOCK (A - BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("SWAMI VIVEKANANDA (B- ANNEX)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("RABINDRANATH TAGORE BLOCK (C- BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("NELSON MANDELA BLOCK (D - BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("NELSON MANDELA (D- ANNEX)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("SIR C.V.RAMAN BLOCK(E- BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("RAMANUJAM BLOCK(F - BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("SOCRETES BLOCK(G - BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("JOHN F KENNEDY BLOCK(H - BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("JOHN F KENNEDY (J - BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("SARVEPALLI RADHAKRISHNAN BLOCK (K - BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("NETAJI SUBHAS CHANDRA BOSE BLOCK (L - BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("QUAID-E-MILLAT MUHAMMED ISMAIL BLOCK (M - BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("QUAID-E-MILLAT MUHAMMED ISMAIL BLOCK (M ANNEX)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("CHARLES DARWIN BLOCK (N - BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("SARDAR PATEL BLOCK (P -BLOCK)",R.drawable.ic_launcher_background,"MH"));
        hostel_blocks.add(new Word("INDHRA GANDHI BLOCK (A - BLOCK)",R.drawable.ic_launcher_background,"LH"));
        hostel_blocks.add(new Word("KALPANA CHAWLA BLOCK (B- BLOCK)",R.drawable.ic_launcher_background,"LH"));
        hostel_blocks.add(new Word("MOTHER TERASA BLOCK (C- BLOCK)",R.drawable.ic_launcher_background,"LH"));
        hostel_blocks.add(new Word("JHANSI RANI BLOCK (D - BLOCK)",R.drawable.ic_launcher_background,"LH"));
        hostel_blocks.add(new Word("IDA SCUDDER BLOCK (E- BLOCK)",R.drawable.ic_launcher_background,"LH"));
        hostel_blocks.add(new Word("SUU KYI BLOCK(F- BLOCK)",R.drawable.ic_launcher_background,"LH"));

        WordAdapter wordAdapter = new WordAdapter(this,hostel_blocks);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = hostel_blocks.get(i);
                Intent intent = new Intent(listView.getContext(),SuggestionPage.class);
                intent.putExtra("from",word.getName());
                intent.putExtra("blocks",word.getHostel());
                startActivity(intent);
            }
        });
    }
}
