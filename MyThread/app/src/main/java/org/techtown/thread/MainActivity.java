package org.techtown.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroudThread thread = new BackgroudThread();
                thread.start();
            }
        });
        textView = findViewById(R.id.textView);

    }
    class BackgroudThread extends Thread {
        int value = 0;
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) { }
                value +=1;
                Log.d("My Thread", "Value: " + value);
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("값: "+value);
//                    }
//                });

                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("value", value);
                message.setData(bundle);
            }
        }
    }
}