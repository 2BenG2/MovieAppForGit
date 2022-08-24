package com.lectures.movieappex.tools;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lectures.movieappex.adapters.MovieAdapter;
import com.lectures.movieappex.models.Movie;
import com.lectures.movieappex.MovieDetailsActivity;

import java.util.List;

public interface MovieRecycleViewService {
    static String MOVIE = "MOVIE";
    static void setRecycleView(RecyclerView recyclerView, List<Movie> movieList){
        recyclerView.setAdapter(new MovieAdapter(movieList));
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
    }
    static void setOnClickToDetails(Movie movie,Context context){
        Intent intent = new Intent(context, MovieDetailsActivity.class);
        intent.putExtra(MOVIE,movie);
        context.startActivity(intent);
    }
}
