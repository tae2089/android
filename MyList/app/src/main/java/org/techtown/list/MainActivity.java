package org.techtown.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.techtown.list.adapter.PersonAdapter;
import org.techtown.list.domain.Person;
import org.techtown.list.listener.onPersonItemClickListener;

public class MainActivity extends AppCompatActivity {
    PersonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PersonAdapter();
        adapter.addItem(new Person("김민수","010-1000-1000"));
        adapter.addItem(new Person("김하늘", "010-0000-0000"));
        adapter.addItem(new Person("홍길동", "010-3000-3000"));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new onPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                showToast("아이템 선택됨: " + item.getName());
            }
        });
    }

    private void showToast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}