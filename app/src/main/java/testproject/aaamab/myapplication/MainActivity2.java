package testproject.aaamab.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtAge ;
    Button btnBack ;
    Intent data ;
    int ageData = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intialViews();
        data = getIntent();
        ageData = data.getIntExtra("userAge" , 0);
        txtAge.setText(ageData+"");
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void intialViews() {
        btnBack = findViewById(R.id.btn_back);
        txtAge = findViewById(R.id.txt_age);
    }
}