package org.techtown.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
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
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                //intent에서 MenuAcitivity를 참조할 수 있다.
                //코드를 넣는 이유는 어떤 곳에서 요청이 왔는지 구분하기 위함
                startActivityForResult(intent,101);
                //startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){
            if(data != null){
                String name = data.getStringExtra("name");
                if (name != null) {
                    Toast.makeText(this,"응답으로 받은 데이터: "+name, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}