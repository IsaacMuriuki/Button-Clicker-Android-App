package com.example.buttonclickerapp;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String RESTORE_CONTENTS = "TextContents";
    private EditText userInput;
    private Button button;
    private Button count;
    private Button reset;
    private Button resetCount;
    private TextView textView;
    private int numClicked = 0;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        count = (Button) findViewById(R.id.count);
        reset = (Button) findViewById(R.id.reset);
        resetCount = (Button) findViewById(R.id.reset_count);
        textView.setText("");

        // Allows the text area to be scrollable
        textView.setMovementMethod(new ScrollingMovementMethod());

        // Creates an event listener for the text field button that writes the content of the text field in the text view
        View.OnClickListener buttonListener = v -> {
                String result = userInput.getText().toString();
                result += "\n";
                textView.append(result);
                userInput.setText("");
        };
        button.setOnClickListener(buttonListener);

        // Creates an event listener for the count button that writes the number of times it has been pressed in the text view
        View.OnClickListener countListener = x -> {
            numClicked++;
            String result = "The count button has been clicked " + numClicked + " time\n";
            if (numClicked > 1) result = "The count button has been clicked " + numClicked + " times\n";
            textView.append(result);
        };
        count.setOnClickListener(countListener);

        // Clears the text view area on click of the reset button
        View.OnClickListener resetListener = v -> {
            textView.setText("");
        };
        reset.setOnClickListener(resetListener);

        // Resets the count button's count
        View.OnClickListener resetCountListener = v -> {
            String notify = "Count has been reset to 0 !";
            textView.append(notify);
            numClicked = 0;
        };
        resetCount.setOnClickListener(resetCountListener);

        // Clears placeholder text when user clicks the text input area
        View.OnClickListener userInputListener = v -> userInput.setText("");
        userInput.setOnClickListener(userInputListener);

        Log.d(TAG, "onCreate: out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: in");
        super.onDestroy();
        Log.d(TAG, "onDestroy: out");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    // Restores the text contents from before the screen was rotated
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString(RESTORE_CONTENTS));
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    // Saving the text contents on rotation of the screen
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(RESTORE_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }


}

