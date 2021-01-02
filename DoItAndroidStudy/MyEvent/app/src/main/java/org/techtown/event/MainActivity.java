package org.techtown.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    //제스처 인식 api
    GestureDetector getDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        View view = findViewById(R.id.view);
        View view2 = findViewById(R.id.view2);
        // 이 뷰를 터치했을때 ->  터치는 눌린상태에서 하는 거
        // motionevent를 통해 값을 전달함
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                 int action = event.getAction(); //정수값이 반환됨
                    float curx = event.getX();
                    float cury = event.getY();
                    //손가락이 눌린 상태
                    if (action == MotionEvent.ACTION_DOWN){
                        println("손가락 눌림 : "+curx+", "+cury);
                    }else if(action == MotionEvent.ACTION_MOVE){
                        println("손가락 움직임 : "+curx+", "+cury);
                    }else if(action == MotionEvent.ACTION_UP){
                        println("손가락 땜 : "+curx+", "+cury);
                    }
                return true;
            }
        });

        getDetector = new GestureDetector(this, new OnGestureListener() {
            // 눌렸을때
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                println("onLongPress 호출됨");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                println("onFling 호출됨: " + velocityX + ", " + velocityY);
                return true;
            }
        });

        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                getDetector.onTouchEvent(event);
                return true;
            }
        });

    }
    //오버라이드 메소드를 통해 함수를 재정의 할 수 있음
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            println("시스템 [back] 버튼이 눌렸어요.");
            return true;
        }else{
            return false;
        }
    }
    //back 버튼은 onback함수 재정의 하기
    public void println(String data){
        textView.append(data+"\n");
    }


}