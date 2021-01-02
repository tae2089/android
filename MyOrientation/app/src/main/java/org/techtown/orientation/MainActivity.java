package org.techtown.orientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast("onCreate 호출됨");

        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);
        if (button != null){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText != null) {
                     name = editText.getText().toString();
                    showToast("사용자 입력값을 name변수에 할당함");
                }
            }
        });
        }
        if(savedInstanceState != null){
            if(textView2 != null){
                name = savedInstanceState.getString("name");
                textView2.setText(name);

                showToast("값을 복원했습니다: " + name);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //bundle은 데이터를 간단하게 담는 것
        outState.putString("name",name);
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy 호출됨");
    }

    public void showToast(String data) {
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    }
}