package com.example.naveengaur.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter = 5; // to check number of attempts


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning the variables to widget we created by ID

        userName = (EditText) findViewById(R.id.Name);
        password = (EditText) findViewById(R.id.Password);
        info = (TextView) findViewById(R.id.attempts);
        login = (Button) findViewById(R.id.loginButton);

        // initially the text view shows the number of attempts to be 5

        info.setText("No.of attempts remaining : 5");

        // when the login button is clicked we call the validate method

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate(userName.getText().toString(), password.getText().toString()); //toString() to convert to Strings

            }
        });

    }
// this function validates the userName and password
    private void validate(String userName, String userPassword) {
        if ((userName.equals("Admin")) && (userPassword.equals("1234"))) {

            // intent is used to move from one activity to another. Here we move from login activity to
            Intent intent = new Intent(MainActivity.this, DashBoard.class);
            startActivity(intent);




        } else {
            counter--;
            // Displays number of attempts remaining
            info.setText("No of attempts remaining: " + String.valueOf(counter));



            if (counter == 0) {
                // disables the login button after 5 attempts
                login.setEnabled(false);
            }
        }
    }

}
