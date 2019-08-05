package com.example.acer.vithelp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.vithelp.AsyncTasks.PutFeedAsync;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class SuggestionPage extends AppCompatActivity {

    public String From;
    public String Type;
    public String Problem;
    public String Description;
    public String Cc;
    public String Cc2;
    public String Blocks;
    public String finalpath;
    public String subject;
    public String pro = "Sent";
    Uri u;
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    RadioButton suggestion;
    RadioButton issue;
    TextView block;
    Spinner problem;
    EditText description;
    Button addImage;
    Button sendMail;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion_page);

        Bundle b = getIntent().getExtras();
        if (b.getString("from") != null) {
            From = b.getString("from");
        }
        if (b.getString("blocks") != null) {
            Blocks = b.getString("blocks");
        }


        suggestion = (RadioButton) findViewById(R.id.suggestion);
        issue = (RadioButton) findViewById(R.id.issue);
        block = (TextView) findViewById(R.id.block);
        problem = (Spinner) findViewById(R.id.problem_spinner);
        description = (EditText) findViewById(R.id.description);
        addImage = (Button) findViewById(R.id.add_image);
        sendMail = (Button) findViewById(R.id.send);
        image = (ImageView) findViewById(R.id.image);

        block.setText(From);

        addStringsToSpinner(Blocks);

        problem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Problem = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getBaseContext(), "Please Select any problem", Toast.LENGTH_LONG).show();
            }

        });

        //Inent to select the image from gallery

        addImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);

                startActivityForResult(intent, 100);
            }
        });

        sendMail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Description = description.getText().toString();
                Log.i("description", Description);
                Type = getType();
                Cc = getCc();
                Cc2 = getCC2(From);
                String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                String time = new SimpleDateFormat("hh.mm aa", Locale.getDefault()).format(new Date());
                if (finalpath != null) {
                    //   emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(finalpath)));
                }
                Random rand = new Random();
                final int id = rand.nextInt(9999) + 1111;
                JSONObject data = new JSONObject();
                try {
                    data.put("id", id);
                    data.put("Problem", Problem);
                    data.put("Date", date);
                    data.put("Time", time);
                    data.put("Type", Type);
                    data.put("BlockType", Cc);
                    data.put("Block", From);
                    data.put("Des", Description);
                    data.put("Progress",pro);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (isNetworkAvailable()) {
                    PutFeedAsync task = new PutFeedAsync();
                    task.setContext(getBaseContext());
                    task.execute(data);
                } else {
                    Toast.makeText(getBaseContext(), "Please connect to Internet", Toast.LENGTH_LONG).show();
                }

            }

        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo active = cm.getActiveNetworkInfo();
        return active != null && active.isConnected();
    }


    private void addStringsToSpinner(String blocks) {

        if (blocks.equals("MH") && blocks.equals("LH")) {
            List<String> categories = new ArrayList<String>();
            categories.add("Cleaning");
            categories.add("Electrical");
            categories.add("Air Conditioner");
            categories.add("Water Problem");
            categories.add("Others");
            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            problem.setAdapter(dataAdapter);
        } else if (blocks.equals("academic")) {
            List<String> categories = new ArrayList<String>();
            categories.add("Cleaning");
            categories.add("Electrical");
            categories.add("Projector");
            categories.add("Water Problem");
            categories.add("Others");
            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            problem.setAdapter(dataAdapter);

        } else if (blocks.equals("nonacademic")) {
            List<String> categories = new ArrayList<String>();
            categories.add("Cleaning");
            categories.add("Electrical");
            categories.add("Water Problem");
            categories.add("Others");
            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            problem.setAdapter(dataAdapter);

        } else if (blocks.equals("mess")) {
            List<String> categories = new ArrayList<String>();
            categories.add("Cleaning");
            categories.add("Electrical");
            categories.add("Food Quality");
            categories.add("Water Problem");
            categories.add("Others");
            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            problem.setAdapter(dataAdapter);
        }

    }


    //Image selection activity

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            finalpath = getRealPathFromURI(uri, this);
            image.setImageURI(uri);
        }
    }

    //Get realpath for sharing image

    public String getRealPathFromURI(Uri contentURI, Activity context) {
        String[] projection = {MediaStore.Images.Media.DATA};
        @SuppressWarnings("deprecation")
        Cursor cursor = context.managedQuery(contentURI, projection, null,
                null, null);
        if (cursor == null)
            return null;
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        if (cursor.moveToFirst()) {
            String s = cursor.getString(column_index);
            // cursor.close();
            return s;
        }
        // cursor.close();
        return null;
    }

    public String getType() {

        String x = null;
        if (suggestion.isChecked()) {
            x = "Suggestion";
        } else if (issue.isChecked()) {
            x = "Issues";
        }
        return x;
    }

    public String getCc() {

        Bundle b = getIntent().getExtras();
        String hos = b.getString("blocks");
        String c = null;
        switch (hos) {
            case "MH":
                c = "Men's Hostel";
                break;
            case "LH":
                c = "Ladies Hostel";
                break;
            case "mess":
                c = "Mess";
                break;
            case "academic":
                c = "Academic Block";
                break;
            case "nonacademic":
                c = "Non-Academic Block";
                break;
        }
        return c;
    }

    public String getCC2(String mess) {

        String to = null;
        switch (mess) {
            case "Kamadenu Caters":
                to = "KamadenuCaters@gmail.com";
                break;
            case "CRC Caters":
                to = "CRCCaters@gmail.com";
                break;
            case "Zenith Caters":
                to = "ZenithCatersgmail.com";
                break;
            case "A2C Caters":
                to = "A2CCaters@gmail.com";
                break;
            case "Foodcy Caters":
                to = "Foodcy_Caters@gmail.com";
                break;
            case "Darling Caters":
                to = "Darling_Caters@gmail.com";
                break;
            case "Rajeshwari Caters":
                to = "Rajeshwari_Caters@gmail.com";
                break;
            default:
                to = null;
        }

        return to;
    }


}

