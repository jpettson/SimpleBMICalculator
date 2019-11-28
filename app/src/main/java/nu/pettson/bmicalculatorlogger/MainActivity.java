package nu.pettson.bmicalculatorlogger;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double bmi;
    DecimalFormat format = new DecimalFormat("##.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateMetricBMI(View view) {
        EditText heightEditText = findViewById(R.id.lengthID);
        EditText weightEditText = findViewById(R.id.weightID);
        if (weightEditText.getText().length() > 0 && heightEditText.getText().length() > 0) {
            double height = Double.parseDouble(heightEditText.getText().toString());
            double weight = Double.parseDouble(weightEditText.getText().toString());
            bmi = weight/((height/100)*(height/100));

            TextView bmiTextView = findViewById(R.id.bmiID);

            bmiTextView.setText(format.format(bmi));

            hideKeyboard(view);
        } else {
            heightEditText.setText("Something's wrong!");
        }
    }

    public void changeToImperial(View view) {
        Intent intent = new Intent(this, ImperialActivity.class);
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
