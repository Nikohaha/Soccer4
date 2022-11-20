package com.codingstuff.soccerlive;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.MediaController;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String url_hl = "https://www.scorebat.com//embed//v//637a688f8c5a7//?utm_source=api&utm_medium=video&utm_campaign=dflt";
        Uri videoURI = Uri.parse(url_hl);

        TextView mDate = findViewById(R.id.mDate);
        TextView mTitle = findViewById(R.id.mTitle);
        VideoView mVideo = findViewById(R.id.mVideo);
        Button mbtn = findViewById(R.id.mBtn);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mVideo);

        Bundle bundle = getIntent().getExtras();

        String Title = bundle.getString("title");
        String Date = bundle.getString("date");

        mDate.setText(Date);
        mTitle.setText(Title);

        mVideo.setMediaController(mediaController);
        mVideo.setVideoURI(videoURI);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mVideo.start();
            }
        });



    }
}