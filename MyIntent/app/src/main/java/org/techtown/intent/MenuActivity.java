package org.techtown.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //부가 정보를 보내주는 것 httpdㅔ서 param으로 하는 거랑 비슷
                intent.putExtra("name","mike");
                //응답코드 main으로 돌아갈떄 보내지는 것
                setResult(RESULT_OK, intent);
                //데이터를 보내는 것
                finish();
            }
        });
    }
}