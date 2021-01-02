package org.techtown.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);

        Button button  = findViewById(R.id.button);
        Background background = new Background();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.execute();
            }
        });
        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.cancel(true);
            }
        });
    }

    class Background extends AsyncTask<Integer,Integer, Integer>{
        @Override
        //실행되기전
        protected void onPreExecute() {
            value = 0;
            progressBar.setProgress(value);
        }

        @Override
        //실행된 상태
        protected void onPostExecute(Integer integer) {
            progressBar.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            while(isCancelled() == false){
                value +=1;
                if(value >= 100){
                    break;
                }
                publishProgress(value);
                try {
                    Thread.sleep(1000);
                }catch(Exception e){}
            }
            return value;
        }
    }


}