package com.lixinxinlove.hencoderpluspro;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {


    private RatingBar ratingBar;

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ratingBar = findViewById(R.id.rating_bar);

        ratingBar.setMax(5);
        ratingBar.setStepSize(1f);
        //ratingBar.setIsIndicator(true);
        ratingBar.setNumStars(4);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.e("ratingBar", "rating=" + rating);
            }
        });


        button1 = findViewById(R.id.btn_1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("--","--");
            }
        });


    }
}
