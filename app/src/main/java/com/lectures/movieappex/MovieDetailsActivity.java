package com.lectures.movieappex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.lectures.movieappex.MainActivity;
import com.lectures.movieappex.R;
import com.lectures.movieappex.models.Movie;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Movie movie = (Movie) getIntent().getSerializableExtra("MOVIE");
        TextView textView = findViewById(R.id.test_test);
        textView.setText(movie.getTitle());
    }

}