package org.techtown.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toastView = Toast.makeText(getApplicationContext(), "토스트 메시지 입니다", Toast.LENGTH_LONG);
                //setView를 통해 토스트의 모양도 바뀔 수 있다. 토스트의 모양은 xml파일을 통해서 만드는 것이 가능하다.
                toastView.setGravity(Gravity.TOP|Gravity.LEFT,800,800);
                toastView.show();
            }
        });
    }
}