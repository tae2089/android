package org.techtown.sliding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Animation translateLeftAnimation;
    Animation translateRightAnimation;

    LinearLayout page;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = findViewById(R.id.page);
        translateLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page.setVisibility(View.VISIBLE);
                page.startAnimation(translateLeftAnimation);
            }
        });

    }
}