package com.lancoo.tangminglong.android_transparent_status;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne = (Button) findViewById(R.id.btn_one);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnThree = (Button) findViewById(R.id.btn_three);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                startActivity(new Intent(MainActivity.this,TestOneActivity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(MainActivity.this,TestTwoActivity.class));
                break;
            case R.id.btn_three:
                startActivity(new Intent(MainActivity.this,TestThreeActivity.class));
                break;
        }
    }
}
