package com.example.acer.vithelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //displayDatabaseInfo();

        TextView academic = (TextView) findViewById(R.id.academic);
        TextView hostel = (TextView) findViewById(R.id.hsotel);
        TextView mess = (TextView) findViewById(R.id.mess);
        TextView nonacademic = (TextView) findViewById(R.id.nonacademic);
        Button dbview = (Button) findViewById(R.id.dbview);

        academic.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent academicIntent = new Intent(UserActivity.this, AcademicBlock.class);

                // Start the new activity
                startActivity(academicIntent);
            }
        });

        hostel.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent hostelIntent = new Intent(UserActivity.this, HostelBlocks.class);

                // Start the new activity
                startActivity(hostelIntent);
            }
        });
        mess.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent messIntent = new Intent(UserActivity.this, MessCaters.class);

                // Start the new activity
                startActivity(messIntent);
            }
        });
        nonacademic.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent nonacademicIntent = new Intent(UserActivity.this, NonAcademic.class);

                // Start the new activity
                startActivity(nonacademicIntent);
            }
        });
        dbview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),FeedbackView.class);
                i.putExtra("from","Student");
                startActivity(i);
            }
        });




    }

}
