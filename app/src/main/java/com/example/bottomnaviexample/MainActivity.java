package com.example.bottomnaviexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;

    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_friends:
                        setFrag(1);
                        break;
                    case R.id.action_message:
                        setFrag(2);
                        break;
                    case R.id.action_search:
                        setFrag(3);
                        break;
                    case R.id.action_setting:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();

        setFrag(1); // Frag1을 첫 화면으로
    }

    // Fragment 교체 실행
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch(n){
            case 1:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame, frag4);
                ft.commit();
                break;
        }
    }
}