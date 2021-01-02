package org.techtown.buttons.button;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import org.techtown.buttons.R;

public class MyButton extends AppCompatButton {


    public MyButton(@NonNull Context context) {
        super(context);
        init(context);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        //버튼 생성시 만든
        setBackgroundColor(Color.CYAN);
        setTextColor(Color.BLACK);
        setTextSize(30.0f);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MyButton", "onTouchEvent 호출됨");

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                setBackgroundColor(Color.BLUE);
                setTextColor(Color.RED);

                break;
            case MotionEvent.ACTION_OUTSIDE:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                setBackgroundColor(Color.CYAN);
                setTextColor(Color.BLACK);

                break;
        }

        invalidate();

        return true;
    }


}
