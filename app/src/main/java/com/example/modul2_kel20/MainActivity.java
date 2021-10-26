package com.example.modul2_kel20;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.modul2_kel20.DataItem;
import com.example.modul2_kel20.ListUserResponse;
import com.example.modul2_kel20.RecycleAdapter;
import com.example.modul2_kel20.R;
import com.example.modul2_kel20.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.modul2_kel20.ApiClient;

    public class MainActivity extends AppCompatActivity {

        RecyclerView rvListUser;

        private List<DataItem> listItem;
        private RecycleAdapter adapter;
        private Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button button = findViewById(R.id.button);

            button.setOnClickListener(v -> {
                        Intent intent = new Intent(this, DetailAbout.class);
                        startActivity(intent);
                    });


                    rvListUser = findViewById(R.id.rv_list_user);

            ApiClient.getService().getList().enqueue(new Callback<ListUserResponse>() {
                @Override
                public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                    if (response.isSuccessful()) {
                        listItem = response.body().getData();

                        adapter = new RecycleAdapter(listItem, MainActivity.this);
                        rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        rvListUser.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<ListUserResponse> call, Throwable t) {

                    Toast.makeText(getApplicationContext(), (CharSequence) t, Toast.LENGTH_LONG).show();
                }
            });

            }



    }

