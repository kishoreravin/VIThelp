package com.example.acer.vithelp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.acer.vithelp.AsyncTasks.GetFeedAsync;

public class LoginActivity extends AppCompatActivity {

    RadioButton admin;
    RadioButton user;
    EditText un;
    EditText ps;
    String username;
    String password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        un = (EditText) findViewById(R.id.us_name);
        ps = (EditText) findViewById(R.id.password);


        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                username = un.getText().toString();
                password = ps.getText().toString();
                validateUser(username, password);
            }
        });
        if (isNetworkAvailable()) {
        GetFeedAsync getFeedAsync = new GetFeedAsync();
        getFeedAsync.setContext(getBaseContext());
        getFeedAsync.execute();

        } else {
            Toast.makeText(getBaseContext(), "Please connect to Internet to get latest feedback", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo active = cm.getActiveNetworkInfo();
        return active != null && active.isConnected();
    }

    private void validateUser(String un, String ps) {

        if (un.equals("user") && ps.equals("12345")) {
            Intent i = new Intent(this, UserActivity.class);
            startActivity(i);
        } else if (un.equals("admin") && ps.equals("12345")) {
            Intent i = new Intent(this, FeedbackView.class);
            i.putExtra("from", "Admin");
            startActivity(i);
        }

    }

}
