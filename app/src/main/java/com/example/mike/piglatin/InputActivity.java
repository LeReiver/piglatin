package com.example.mike.piglatin;

/**
* An android app that converts first and last names to Pig Latin.
* Input page
*@author Michael.LeReiver
*@version 2016.01.21
*/

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class InputActivity extends AppCompatActivity {

    // Declares first and last name variables
    public final static String FIRST_NAME = "com.example.mike.piglatin.FIRST";
    public final static String LAST_NAME = "com.example.mike.piglatin.LAST";

    // Subclass to create saved instance states
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }



    // Subclass for creating menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_input, menu);
        return true;
    }

    // Subclass for creating menu items
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


    // User name input interface

    // Creates text view for name ids
    public void submit (View button) {
        TextView fText = (TextView) findViewById(R.id.f_name);
        TextView lText = (TextView) findViewById(R.id.l_name);

        // Gets user input, converts to string, and assigns variables
        String fString = fText.getText().toString();
        String lString = lText.getText().toString();

        // Checks for user input. If no input, create warning toast
        if(fString.length() == 0) {
            Toast.makeText(this, "You Must Enter Your First Name!", Toast.LENGTH_LONG).show();
            return;
        }

        // Checks for user input. If no input, create warning toast
        if(lString.length() == 0) {
            Toast.makeText(this, "You Must Enter Your Last Name!", Toast.LENGTH_LONG).show();
            return;
        }


        // Crates new Activity for utilization of user input
        Intent intent = new Intent(this, OutputActivity.class);

        intent.putExtra(FIRST_NAME, fString);
        intent.putExtra(LAST_NAME, lString);

        startActivity(intent);
    }

}
