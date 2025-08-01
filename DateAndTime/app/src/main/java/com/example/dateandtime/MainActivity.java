package com.example.dateandtime;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Declare UI elements
    private Button btnShowDateTime;
    private TextView tvDate;
    private TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements by finding them in the layout
        btnShowDateTime = findViewById(R.id.btnShowDateTime);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);

        // Set a click listener on the button
        btnShowDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This method will be called when the button is clicked
                displayDateTime();
            }
        });
    }

    /**
     * Gets the current date and time and displays them in the TextViews.
     */
    private void displayDateTime() {
        // Get the current date and time instance
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        // Format the date
        // Example format: "Friday, August 1, 2025"
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.getDefault());
        String formattedDate = dateFormat.format(currentDate);

        // Format the time
        // Example format: "10:06 AM"
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String formattedTime = timeFormat.format(currentDate);

        // Set the formatted date and time to the TextViews
        tvDate.setText(formattedDate);
        tvTime.setText(formattedTime);
    }
}
