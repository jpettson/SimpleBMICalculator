package nu.pettson.bmicalculatorlogger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImperialActivity extends AppCompatActivity {

    double bmi;
    DecimalFormat format = new DecimalFormat("##.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imperial);
    }

    public void calculateImperialBMI(View view) {
        EditText heightFeetEditText = findViewById(R.id.lengthIDFeet);
        EditText heightInchesEditText = findViewById(R.id.lengthIDInches);
        EditText weightEditText = findViewById(R.id.weightIDLbs);

        if (weightEditText.getText().length() > 0 && heightFeetEditText.getText().length() > 0 && heightInchesEditText.getText().length() > 0) {
            double height = (Double.parseDouble(heightFeetEditText.getText().toString())*12) +
                    Double.parseDouble(heightInchesEditText.getText().toString());
            double weight = Double.parseDouble(weightEditText.getText().toString());
            bmi = (weight/(height*height))*703;

            TextView bmiTextView = findViewById(R.id.bmiIDImperial);

            bmiTextView.setText(format.format(bmi));

            hideKeyboard(view);
        } else {
            heightFeetEditText.setText("Something's wrong!");
        }

    }

    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void changeToMainView(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
