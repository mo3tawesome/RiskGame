package com.example.lapstore.riskgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity implements View.OnClickListener {
 Button playing;
 Button simulation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playing=(Button)findViewById(R.id.playing);
        simulation=(Button)findViewById(R.id.simulation);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        switch (id){
            case R.id.playing:
            {
               break;
            }
            case R.id.simulation:{

                break;
            }


        }
    }
}
