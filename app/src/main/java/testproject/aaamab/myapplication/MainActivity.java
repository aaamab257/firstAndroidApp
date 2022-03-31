package testproject.aaamab.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    Button secondScreen , start , stop ;
    EditText edYear ;
    String year ;
    int currentYear = 2022 ;
    int age  ;
    int userYear ;
    FloatingActionButton fab ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intialViews();
        secondScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = edYear.getText().toString();
                if (year.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter the year", Toast.LENGTH_LONG).show();
                }else {
                    userYear = Integer.parseInt(year);
                    age = currentYear - userYear ;
                    Intent goToSecondScreen = new Intent(MainActivity.this , MainActivity2.class);
                    goToSecondScreen.putExtra("userAge" , age);
                    startActivity(goToSecondScreen);
                }

            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToGoogle = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.google.com/"));
                startActivity(goToGoogle);
            }
        });

        loadFragment();


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this , MyService.class));
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this , MyService.class));
            }
        });



    }

    private void loadFragment( ) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, new FirstFragment());
        fragmentTransaction.commit();
    }

    private void intialViews() {
        edYear = findViewById(R.id.ed_year);
        secondScreen = findViewById(R.id.btn_goToSecondScreen);
        fab = findViewById(R.id.fabUrl);
        start = findViewById(R.id.btn_start);
        stop = findViewById(R.id.btn_stop);
    }
}