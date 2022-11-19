package com.codingstuff.soccerlive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ImageView imageView = findViewById(R.id.thumbnail);
        TextView rating_tv = findViewById(R.id.mRating);
        TextView title_tv = findViewById(R.id.mTitle);
        TextView overview_tv = findViewById(R.id.movervie_tv);

        Bundle bundle = getIntent().getExtras();

        String mTitle = bundle.getString("title");
        String mthumbnail = bundle.getString("thumbnail");
        String mOverView = bundle.getString("overview");
       String mDate = bundle.getString("date");

        Glide.with(this).load(mthumbnail).into(imageView);
        rating_tv.setText(mDate);
        title_tv.setText(mTitle);
        overview_tv.setText(mOverView);

    }
}