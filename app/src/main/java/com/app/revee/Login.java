package com.app.revee;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Login extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    TextView txtRejistu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        overridePendingTransition(0, 0);

        TextView txtFpassword = findViewById(R.id.txtFpassword);
        txtFpassword.setPaintFlags(txtFpassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        TextView txtRejistu = findViewById(R.id.txtRejistu);
        txtRejistu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().setBackgroundDrawable(
        new ColorDrawable(Color.parseColor("#1C4CF3")));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.login_toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
        }

        ImageView backButton = getSupportActionBar().getCustomView().findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setVisibility(View.GONE);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        Intent intent1 = new Intent(Login.this, MainActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_edukasaun:
                        Intent intent2 = new Intent(Login.this, Favoritu.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_servisu:
                        Intent intent3 = new Intent(Login.this, Tips.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_sertifikadu:
                        break;
                }
                return false;
            }
        });
    }
}
