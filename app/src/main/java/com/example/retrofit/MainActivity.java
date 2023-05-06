package com.example.retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView superListView = new ListView() ;
    superListView = findViewById(R.id.SuperListView);


    private void getSuperHeroes(){

    Call<List<Results>> call = RetrofitClient.getInstance().getMyAPI().getSuperHeroes();
    call.enqueue(new Callback<List<Results>>() {

        @Override
        public void onResponse(@NonNull Call<List<Results>> call, @NonNull Response<List<Results>> response) {
            List<Results> myheroList = response.body();
            String[] oneHeroes;
            oneHeroes = new String[myheroList.size()];
            for (int i = 0; i < myheroList.size(); i++)
                oneHeroes[i] = myheroList.get(i).getName();
        }
        superListView.
        @Override
        public void onFailure(Call<List<Results>> call, Throwable t) {

        }
    });
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}