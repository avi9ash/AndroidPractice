package com.example.android.justjava; /**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.justjava.R;

import static android.R.id.message;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int q = 0;

    /**
     * This method is called when the order button is clicked.s
     */
    public void increment(View view) {
        q++;
        display(q);
    }

    public void submitOrder(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.chbox1);
        boolean h = checkBox.isChecked();
        CheckBox cb = (CheckBox) findViewById(R.id.chbox2);
        boolean h1 = cb.isChecked();
        EditText e1 = (EditText) findViewById(R.id.ed1);
        String s = e1.getText().toString();
        display(q);
        displayPrice(q * 5);
        String priceMessage = "Total = " + (q * 5);
        displayMessage(priceMessage, h, h1, s);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message, boolean w, boolean w1, String e1) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this

        intent.putExtra(Intent.EXTRA_SUBJECT, "Hello "+e1);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        priceTextView.setText(e1 + "\n" + message + "\n Thank you" + "\n Whipped Cream:" + w + "\nChoclate:" + w1);


    }



    public void decrement(View view) {

        q--;
        if (q < 0) {
            q = 0;
        }
        display(q);
    }
}