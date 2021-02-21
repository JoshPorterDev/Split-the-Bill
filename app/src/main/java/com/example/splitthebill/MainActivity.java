package com.example.splitthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button button;
    private TextView totalTextView, tipTextView, perPersonTextView;
    private EditText billTotal, numPeople;
    double price, tip, total, tipTotal, perPerson;
    int noPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get widgets
                spinner = findViewById(R.id.spinner3);
                billTotal = findViewById(R.id.BillTotalText);
                numPeople = findViewById(R.id.noOfPeopleText);

                // Get values from widgets
                price = Double.parseDouble(billTotal.getText().toString());
                tip = (Double.parseDouble(spinner.getSelectedItem().toString())) / 100;
                noPeople = Integer.parseInt(numPeople.getText().toString());

                // Calculate
                total = price + (price * tip);
                tipTotal = price * tip;
                perPerson = total / noPeople;

                // Grab textView, change visibility to visible and change text to total cost
                totalTextView = findViewById(R.id.textView3);
                totalTextView.setVisibility(View.VISIBLE);
                // Instead of concatenating "total: " + total
                // I created a string resource that receives and formats a double value
                // found in the bottom of my strings.xml file
                totalTextView.setText(getString(R.string.totalTextViewPlaceholder, total));

                tipTextView = findViewById(R.id.textView4);
                tipTextView.setVisibility(View.VISIBLE);
                tipTextView.setText(getString(R.string.tipTextViewPlaceholder, tipTotal));

                perPersonTextView = findViewById(R.id.textView5);
                perPersonTextView.setVisibility(View.VISIBLE);
                perPersonTextView.setText(getString(R.string.perPersonTextViewPlaceholder, perPerson));
            }
        });
    }
}