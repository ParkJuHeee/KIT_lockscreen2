package com.example.kit_lockscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.ncorti.slidetoact.SlideToActView;

public class MainActivity extends AppCompatActivity {

    SlideToActView slideToActView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(
                //기본 잠금화면보다 우선 출력
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                //기본 잠금화면 해제시키기
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

        setContentView(R.layout.activity_main);

        slideToActView = (SlideToActView) findViewById(R.id.slide_to_unlock);
        slideToActView.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {
                       @Override
            public void onSlideComplete(SlideToActView slideToActView) {
                           //슬라이딩 후 화면
                startActivity(new Intent(MainActivity.this, HomeScreen.class));
            }
        });
    }

}
