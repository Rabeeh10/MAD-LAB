package com.example.tost;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declare the UI elements
    private EditText editTextUserInput;
    private Button btnShowToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI elements by finding them in the layout
        editTextUserInput = findViewById(R.id.editTextUserInput);
        btnShowToast = findViewById(R.id.btnShowToast);

        // Set a click listener on the button
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the EditText
                String inputText = editTextUserInput.getText().toString().trim();

                // Check if the input text is not empty
                if (!inputText.isEmpty()) {
                    // Create and show the Toast message
                    Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_LONG).show();
                } else {
                    // Show a default message if the input is empty
                    Toast.makeText(MainActivity.this, "Please enter some text!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
