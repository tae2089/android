package org.techtown.callintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //액션정보와, 데이터를 통해 구분해준다.
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1000-1000"));
                //응답을 받기 싫으면 이함수를 쓴다
                startActivity(intent);
                //응답을 받고 싶으면
//                startActivityForResult(intent,101);

                //부가데이터
                //intent안에 번들이라는 것이 있는데 여기에 데이터를 넣고 빼고 한다.





//                Intent intent = new Intent();
//                //activity를 가르킬때 componentname으로 가리킨다.
//                ComponentName name = new ComponentName("org.techtown.callintent", "org.techtown.callintent.Menuactivity");
//                intent.setComponent(name);
//                startActivityForResult(intent,101);

            }
        });
    }
}