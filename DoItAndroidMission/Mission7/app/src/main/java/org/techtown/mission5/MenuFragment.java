package org.techtown.mission5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import org.techtown.mission5.MainActivity;
import org.techtown.mission5.R;

public class MenuFragment extends Fragment {
    //엑티비티에서 onCreate와 동일한 역할을 한다.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //메모리에 올려주는 과정
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_menu, container, false);
//        Button button =  rootView.findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.onFragmentChanged(0);
//            }
//        });
        return rootView;
    }





}