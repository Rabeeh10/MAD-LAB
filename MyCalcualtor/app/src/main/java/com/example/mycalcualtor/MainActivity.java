package com.example.mycalcualtor;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // TextView to display the input and results
    private TextView tvInput;

    // Variables to hold the operands and operators
    private String currentInput = "";
    private String operator = "";
    private double firstOperand = Double.NaN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the TextView
        tvInput = findViewById(R.id.tvInput);

        // Set OnClickListener for all buttons
        // This is a more efficient way than creating a new listener for each button
        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide,
                R.id.btnDot, R.id.btnClear, R.id.btnDelete, R.id.btnEquals
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        // Get the button that was clicked
        Button button = (Button) v;
        String buttonText = button.getText().toString();

        // Use a switch statement to handle different button clicks
        switch (buttonText) {
            case "C":
                clear();
                break;
            case "DEL":
                delete();
                break;
            case "=":
                calculate();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                handleOperator(buttonText);
                break;
            case ".":
                handleDecimal();
                break;
            default: // Number buttons
                appendNumber(buttonText);
                break;
        }
        // Update the display after every button press
        updateDisplay();
    }

    // Appends a number to the current input string
    private void appendNumber(String number) {
        currentInput += number;
    }

    // Handles the logic for operator buttons
    private void handleOperator(String op) {
        if (!currentInput.isEmpty()) {
            if (!Double.isNaN(firstOperand)) {
                calculate();
            }
            firstOperand = Double.parseDouble(currentInput);
            currentInput = "";
        }
        operator = op;
    }

    // Handles the logic for the decimal point
    private void handleDecimal() {
        // Prevent adding multiple decimal points in one number
        if (!currentInput.contains(".")) {
            currentInput += ".";
        }
    }

    // Performs the calculation
    private void calculate() {
        if (Double.isNaN(firstOperand) || operator.isEmpty() || currentInput.isEmpty()) {
            return;
        }

        double secondOperand = Double.parseDouble(currentInput);
        double result = 0;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                // Handle division by zero
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    currentInput = "Error";
                    updateDisplay();
                    // Reset calculator state after showing error
                    firstOperand = Double.NaN;
                    operator = "";
                    return;
                }
                break;
        }

        // Format result to remove .0 for whole numbers
        if (result == (long) result) {
            currentInput = String.format("%d", (long) result);
        } else {
            currentInput = String.format("%s", result);
        }

        firstOperand = Double.NaN;
        operator = "";
    }

    // Clears the calculator state
    private void clear() {
        currentInput = "";
        operator = "";
        firstOperand = Double.NaN;
    }

    // Deletes the last character from the input
    private void delete() {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
        }
    }

    // Updates the TextView display
    private void updateDisplay() {
        tvInput.setText(currentInput);
    }
}
