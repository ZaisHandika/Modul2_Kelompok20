package com.example.modul2_kel20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.modul2_kel20.R;


public class DetailActivity extends AppCompatActivity {

    private TextView tvNama;
    private TextView tvNama2;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNama = findViewById(R.id.tv_first_name);
        tvNama2 = findViewById(R.id.tv_last_name);
        tvEmail = findViewById(R.id.tv_email);


        if (getIntent().hasExtra("name")) {

            String nama = getIntent().getStringExtra("name");
            tvNama.setText(nama);
        }

        if (getIntent().hasExtra("name2")) {

            String nama2 = getIntent().getStringExtra("name2");
            tvNama2.setText(nama2);
        }
        if (getIntent().hasExtra("email")) {

            String email = getIntent().getStringExtra("email");
            tvEmail.setText(email);
        }


    }
}