package org.techtown.volley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.volley.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    RecyclerView recyclerView;
    MovieAdapter adapter;

    static RequestQueue requestque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlStr = editText.getText().toString();
                request(urlStr);
            }
        });

        requestque = Volley.newRequestQueue(getApplicationContext());
    }

    public void request(String urlStr) {
        //요청객체를 만든다
        StringRequest request = new StringRequest(
                Request.Method.GET,
                urlStr,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        processResponse(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            //요청파라미터를 처리하는 것
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return super.getParams();
            }
        };
        //요청하는 큐가 있음
        //쓰레드 핸들러 처리를 하고 메인쓰레드가 응답할 수 있는 것을 만들어준다.
        request.setShouldCache(false);
        requestque.add(request);

    }

    public void processResponse(String response) {
        Gson gson = new Gson();

        MovieList movieList = gson.fromJson(response, MovieList.class);
        if(movieList != null){
        for(int i=0;i <movieList.tboxOfficeResult.dailyBoxOfficeList.size();i++){
            Movie movie = new Movie();
            movie = movieList.tboxOfficeResult.dailyBoxOfficeList.get(i);
            adapter.addItem(movie);
        }
        }else{
            movieList = new MovieList();
        }
        adapter.notifyDataSetChanged();
    }


}