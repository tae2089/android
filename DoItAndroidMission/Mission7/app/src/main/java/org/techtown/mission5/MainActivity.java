package org.techtown.mission5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.techtown.mission5.MainFragment;
import org.techtown.mission5.MenuFragment;
import org.techtown.mission5.R;

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
            getSupportFragmentManager().beginTransaction().remove(menuFragment);
            getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();
        } else if (i == 1) {
            getSupportFragmentManager().beginTransaction().remove(mainFragment);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
        }
    }
}