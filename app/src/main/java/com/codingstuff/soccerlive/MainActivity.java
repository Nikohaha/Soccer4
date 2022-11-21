package com.codingstuff.soccerlive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.codingstuff.soccerlive.Helpers.Soccer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Soccer> soccerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        soccerList = new ArrayList<>();
        fetchMatches();


    }

    private void fetchMatches() {

        String url = "https://www.scorebat.com/video-api/v1/";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0 ; i < response.length() ; i ++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String title = jsonObject.getString("title");
                        String dateUnFormat = jsonObject.getString("date");
                        String date = dateUnFormat.substring(0,10) + "  " +dateUnFormat.substring(12,16);
//                        String thumbnail = jsonObject.getString("thumbnail");
//                        String side1= jsonObject.getString("side1");
//                        String side2= jsonObject.getString("side2");


                        Soccer soccer = new Soccer(title,date);
                        soccerList.add(soccer);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    SoccerAdapter adapter = new SoccerAdapter(MainActivity.this , soccerList);

                    recyclerView.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}