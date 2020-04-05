package com.cra.aakash.kiwi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton pirates;
    RadioButton ninjas;
    // this will be key for the key value pair
    public static final String BUTTON_STATE1 = "Button_State1";
    public static final String BUTTON_STATE2 = "Button_State2";
    public static final String BUTTON_STATE3 = "Button_State3";
    public static final String BUTTON_STATE4 = "Button_State4";
    // this is name of shared preferences file, must be same whenever accessing
    // the key value pair.
    public static final String MyPREFERENCES = "MyPrefs";

    SharedPreferences sharedpreferences;
//    private Toolbar mTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        mTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        setSupportActionBar(mTopToolbar);

        // helper method to open up the file.
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        // grab the last saved state here on each activity start
        Boolean lastButtonState1 = sharedpreferences.getBoolean(BUTTON_STATE1, false);
        Boolean lastButtonState2 = sharedpreferences.getBoolean(BUTTON_STATE2, false);
        Boolean lastButtonState3 = sharedpreferences.getBoolean(BUTTON_STATE3, false);
        Boolean lastButtonState4 = sharedpreferences.getBoolean(BUTTON_STATE4, false);

        final RadioButton rb = (RadioButton) findViewById(R.id.radio_pirates);
        final RadioButton rc = (RadioButton) findViewById(R.id.radio_ninjas);
        final RadioButton rf = (RadioButton) findViewById(R.id.radio_flash);
        final RadioButton ra = (RadioButton) findViewById(R.id.radio_superman);


        rb.setChecked(lastButtonState1);
        rc.setChecked(lastButtonState2);
        rf.setChecked(lastButtonState3);
        ra.setChecked(lastButtonState4);


    }


    public void onRadioButtonClicked(View view) {
//         pirates = (RadioButton) findViewById(R.id.radio_pirates);
//         ninjas = (RadioButton)findViewById(R.id.radio_ninjas);
        // Is the button now checked?
        SharedPreferences.Editor editor = sharedpreferences.edit();
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_pirates: {
                editor.putBoolean(BUTTON_STATE1, checked);
                editor.putBoolean(BUTTON_STATE2, !checked);
                editor.apply();
                break;
            }

            case R.id.radio_ninjas: {
                editor.putBoolean(BUTTON_STATE2, checked);
                editor.putBoolean(BUTTON_STATE1, !checked);
                editor.apply();
                break;
            }
        }
    }


    public void onRadioButtonClicked2(View view) {
//         pirates = (RadioButton) findViewById(R.id.radio_pirates);
//         ninjas = (RadioButton)findViewById(R.id.radio_ninjas);
        // Is the button now checked?
        SharedPreferences.Editor editor = sharedpreferences.edit();
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_flash: {
                editor.putBoolean(BUTTON_STATE3, checked).putBoolean(BUTTON_STATE4, !checked);
                //editor.putBoolean(BUTTON_STATE4, !checked);
                editor.apply();
                break;
            }

            case R.id.radio_superman: {
                editor.putBoolean(BUTTON_STATE4, checked).putBoolean(BUTTON_STATE3, !checked);
                //editor.putBoolean(BUTTON_STATE3, !checked);
                editor.apply();
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorite) {
            Toast.makeText(MainActivity.this, "you are being missed! :P", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
