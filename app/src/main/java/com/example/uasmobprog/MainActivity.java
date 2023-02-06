package com.example.uasmobprog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uasmobprog.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
// https://run.mocky.io/v3/6ecbb130-d541-4ab1-890a-efb9059b28c1
    private static String JSON = "https://run.mocky.io/v3/55fbb90d-e01a-472f-9ab3-ebd2a5ec3ec5";

    List<MovieModel> movieModelList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View activity_maps){
                startActivity(new Intent(MainActivity.this,MapsActivity.class));
            }
        });
        movieModelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);

        GetData getData = new GetData();
        getData.execute();
    }

    public class GetData extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            String curr = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(JSON);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream input = urlConnection.getInputStream();
                    InputStreamReader reader = new InputStreamReader(input);

                    int data = reader.read();
                    while(data != -1){
                        curr += (char) data;
                        data = reader.read();
                    }

                return curr;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                if(urlConnection != null){
                    urlConnection.disconnect();
                }
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return curr;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("Cinema CGP");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    MovieModel movieModel = new MovieModel();
                    movieModel.setMovieid(jsonObject1.getString("id"));
                    movieModel.setMoviename(jsonObject1.getString("MovieName"));
                    movieModel.setMovieurl(jsonObject1.getString("image"));

                    movieModelList.add(movieModel);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            PutDataIntoRecyclerView(movieModelList);
        }
        }
        private void PutDataIntoRecyclerView(List<MovieModel> movieModelList){
            MovieAdapter adapter = new MovieAdapter(this,movieModelList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }
    }
