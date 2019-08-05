package com.example.acer.vithelp.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.acer.vithelp.Model.FeedbackWord;
import com.example.acer.vithelp.Dialog.ProgressDialog;
import com.example.acer.vithelp.R;

import java.util.ArrayList;


public class FeedAdminAdapter extends ArrayAdapter<FeedbackWord> {
    FragmentManager fragmentManager;

    public FeedAdminAdapter(Context context, ArrayList<FeedbackWord> words, FragmentManager fm) {
        super(context, 0, words);
        fragmentManager = fm;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.feedbackadminlist, parent, false);
        }

        final FeedbackWord cword = getItem(position);
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(cword.getDate());
        TextView time = (TextView) listItemView.findViewById(R.id.time);
        time.setText(cword.getTime());
        TextView type = (TextView) listItemView.findViewById(R.id.type);
        type.setText(cword.getType());
        TextView to = (TextView) listItemView.findViewById(R.id.problem);
        to.setText(cword.getProb());
        TextView cc = (TextView) listItemView.findViewById(R.id.btype);
        cc.setText(cword.getBlocktype());
        TextView sub = (TextView) listItemView.findViewById(R.id.block);
        sub.setText(cword.getBlock());
        TextView des = (TextView) listItemView.findViewById(R.id.desp);
        des.setText(cword.getDesp());

        Button progress = (Button) listItemView.findViewById(R.id.set_progress);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog();
                progressDialog.setPostData(cword.getId());
                progressDialog.show(fragmentManager, "Dialog");
            }
        });

        return listItemView;
    }
}
