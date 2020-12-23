package org.techtown.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;

    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //레이아웃에 있는 imageview들을 사용하기 위해 불러와야함
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
    }


    public void onButton1Clicked(View v){
        changeImage();
    }

    public void changeImage(){
        if(imageIndex  == 0){
            //imageView속성 제어
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex = 1;
        }else if (imageIndex == 1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex = 0;
        }
    }
}