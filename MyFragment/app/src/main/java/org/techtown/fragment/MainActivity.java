package org.techtown.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프래그먼트 메니저를 활용하기
        mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment = new MenuFragment();
    }

    public void onFragmentChanged(int i) {
        if (i == 0) {
            //tracnsaction은 여러개의 함수를 사용할떄
            //
            getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();
//            getSupportFragmentManager().beginTransaction().remove(menuFragment);
        } else if (i == 1) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
//            getSupportFragmentManager().beginTransaction().remove(mainFragment);
        }
    }
}