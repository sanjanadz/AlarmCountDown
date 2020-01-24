package com.example.alarmapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText plain;
    private TextView text;
    private Button click_r;
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       plain =findViewById(R.id.time_EditText);
        text = findViewById(R.id.textview);
        click_r= findViewById(R.id.button1);
        mediaPlayer =MediaPlayer.create(MainActivity.this, R.raw.alarmTone);


        click_r.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                try {

                    int time = Integer.parseInt(plain.getText().toString());
                    Log.i("time",String.valueOf(time));

                    final int millisecond = time *1000;

                    new CountDownTimer(millisecond, 1000) {
                        @Override
                        public void onTick(long l) {
                            text.setText(String.valueOf(l/1000));

                        }

                        @Override
                        public void onFinish() {

                        }
                    }.start();

                }
                catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this,"Enter data in integer", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
