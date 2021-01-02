package org.techtown.mission3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            moveImageDown();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveImageUp();
            }
        });
    }

    private void moveImageDown() {
    imageView.setImageResource(0);
    imageView2.setImageResource(R.drawable.ic_launcher_foreground);

    imageView.invalidate();
    imageView2.invalidate();
    }

    private void moveImageUp() {
        imageView.setImageResource(R.drawable.ic_launcher_background);
        imageView2.setImageResource(0);

        imageView.invalidate();
        imageView2.invalidate();
    }

}