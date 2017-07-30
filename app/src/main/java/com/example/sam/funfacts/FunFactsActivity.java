package com.example.sam.funfacts;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {

    private TextView mFactTextView;
    private Button mShowFactButton;
    private ConstraintLayout mContraintLayout;

    // Our collection of facts
    private FactBook factBook = new FactBook();
    // our colelction of colors
    private Colorwheel colors = new Colorwheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign the Views from the layout file to the corresponding variables
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mContraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        // The button was clicked, so update the fact TextView with a new fact
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update the screen with a new dynamic fact
                mFactTextView.setText(factBook.getRandomFact());
                // Get a random color from the color wheel
                int color = colors.getRandomColor();
                // Change the layout background color
                mContraintLayout.setBackgroundColor(color);
                // Change the button text color
                mShowFactButton.setTextColor(color);
            }
        };
        mShowFactButton.setOnClickListener(listener);
    }
}
