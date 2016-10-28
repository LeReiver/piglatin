package com.example.mike.piglatin;

/**
* An android app that converts first and last names to Pig Latin.
* Output page
*@author Michael.LeReiver
*@version 2016.01.21
*/

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Scanner;


public class OutputActivity extends AppCompatActivity {

    @Override
    // Creates layout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        // Starts new activity
        Intent intent = getIntent();

        // Assigns variables from user input
        String pl_first_name = intent.getStringExtra(InputActivity.FIRST_NAME);
        String pl_last_name = intent.getStringExtra(InputActivity.LAST_NAME);

        // Transform string to lowercase
        String fName = pl_first_name.toLowerCase();
        String lName = pl_last_name.toLowerCase();

        // Declares data type char to first and last name before the conversion
        char firstBefore;
        char lastBefore;

        // Declares data type string to first and last name after conversion
        String firstLatin;
        String lastLatin;

        // Checks if first letter of name is a vowel, if so append "hay" to name, else append "ay" to name
        firstBefore = fName.charAt(0);
        if (firstBefore == 'a' ||  firstBefore == 'e' || firstBefore == 'i' ||
                firstBefore == 'o' || firstBefore == 'u') {
            firstLatin = fName + "hay";
        } else
            firstLatin = fName.substring(1) + fName.charAt(0) + "ay";

        // Checks if first letter of name is a vowel, if so append "hay" to name, else append "ay" to name
        lastBefore = lName.charAt(0);
        if (lastBefore == 'a' ||  lastBefore == 'e' || lastBefore == 'i' ||
                lastBefore == 'o' || lastBefore == 'u') {
            lastLatin = lName + "hay";
        } else
            lastLatin = lName.substring(1) + lName.charAt(0) + "ay";

        // Creates text view outputs
        TextView outputOutcomeStatement = (TextView) findViewById(R.id.pl_outcome);
        TextView outputFirstLatin = (TextView) findViewById(R.id.pl_first);
        TextView outputLastLatin = (TextView) findViewById(R.id.pl_last);

        // Sets text to output
        outputOutcomeStatement.setText(R.string.outcome);
        outputFirstLatin.setText(firstLatin.substring(0,1).toUpperCase() + firstLatin.substring(1) + " ");
        outputLastLatin.setText(lastLatin.substring(0,1).toUpperCase() + lastLatin.substring(1) + "!");

    }

    // Subclass for menu creation
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_output, menu);
        return true;
    }

    // Subclass for menu selection
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
