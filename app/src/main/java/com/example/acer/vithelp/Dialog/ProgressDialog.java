package com.example.acer.vithelp.Dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.acer.vithelp.AsyncTasks.SetProgressAsync;
import com.example.acer.vithelp.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ProgressDialog extends DialogFragment {

    private JSONObject postData = new JSONObject();
    String id ;


    public void setPostData(String ID) {
        id = ID;
        try {
            postData.put("id", ID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.setprogress, container, false);
        Button rejected = v.findViewById(R.id.rejected);
        rejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),id,Toast.LENGTH_SHORT).show();

                try {
                    postData.put("Progress", "Rejected");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                SetProgressAsync setProgressAsync = new SetProgressAsync();
                setProgressAsync.setContext(getContext());
                setProgressAsync.execute(postData);
                ProgressDialog.this.dismiss();
            }
        });
        Button onprogress = v.findViewById(R.id.onprogress);
        onprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    postData.put("Progress", "On Process");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                SetProgressAsync setProgressAsync = new SetProgressAsync();
                setProgressAsync.setContext(getContext());
                setProgressAsync.execute(postData);
                ProgressDialog.this.dismiss();
            }
        });

        Button complete = v.findViewById(R.id.completed);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    postData.put("Progress", "Completed");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                SetProgressAsync setProgressAsync = new SetProgressAsync();
                setProgressAsync.setContext(getContext());
                setProgressAsync.execute(postData);
                ProgressDialog.this.dismiss();
            }
        });
        return v;
    }
}
