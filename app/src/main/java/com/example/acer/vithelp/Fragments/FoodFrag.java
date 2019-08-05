package com.example.acer.vithelp.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.acer.vithelp.Adapter.FeedAdminAdapter;
import com.example.acer.vithelp.Adapter.FeedStudentAdapter;
import com.example.acer.vithelp.Model.FeedbackWord;
import com.example.acer.vithelp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FoodFrag extends Fragment {
    String jsonresponse;
    String prblm;
    String from;
    View v;

    public void setFrom(String fr){
        from = fr;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.list_frame, container, false);
        updateui();
        return v;
    }

    private void updateui() {
        SharedPreferences json = getContext().getSharedPreferences("JSON", Context.MODE_PRIVATE);
        jsonresponse = json.getString("JSONresp", "{\"Feedback\":[]}");
        ArrayList<FeedbackWord> feedbackWords;
        feedbackWords = ExtractFeaturesFromJson(jsonresponse);
        Toast.makeText(getContext(), prblm + "/////" + jsonresponse, Toast.LENGTH_SHORT).show();

        if (from.equals("Admin")) {
            UpdateAdminUi(feedbackWords);
        } else if (from.equals("Student")) {
            UpdateStudentUi(feedbackWords);
        }
    }

    private void UpdateAdminUi(ArrayList<FeedbackWord> feedbackWords) {
        FeedAdminAdapter feedbackAdapter = new FeedAdminAdapter(getContext(), feedbackWords, getFragmentManager());
        ListView listView = (ListView) v.findViewById(R.id.list);
        listView.setAdapter(feedbackAdapter);
    }

    private void UpdateStudentUi(ArrayList<FeedbackWord> feedbackWords) {
        FeedStudentAdapter feedbackAdapter = new FeedStudentAdapter(getContext(), feedbackWords);
        ListView listView = (ListView) v.findViewById(R.id.list);
        listView.setAdapter(feedbackAdapter);
    }

    private ArrayList<FeedbackWord> ExtractFeaturesFromJson(String jsonresponse) {
        if (TextUtils.isEmpty(jsonresponse)) {
            return null;
        }
        ArrayList<FeedbackWord> ar = new ArrayList<FeedbackWord>();

        try {
            JSONObject basejson = new JSONObject(jsonresponse);
            JSONArray feedback = basejson.getJSONArray("Feedback");
            for (int i = 0; i < feedback.length(); i++) {
                JSONObject feed = feedback.getJSONObject(i);
                String id = feed.getString("id");
                String prob = feed.getString("Problem");
                String date = feed.getString("Date");
                String time = feed.getString("Time");
                String type = feed.getString("Type");
                String blty = feed.getString("BlockType");
                String block = feed.getString("Block");
                String des = feed.getString("Des");
                String pr = feed.getString("Progress");

                if (prob.equals("Food Quality")) {
                    ar.add(new FeedbackWord(id, prob, date, time, type, blty, block, des, pr));
                }
            }
            return ar;
        } catch (JSONException e) {
            Log.e("JSON error", "Problem parsing the JSON results", e);
        }
        return null;
    }

}
