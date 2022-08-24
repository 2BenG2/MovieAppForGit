package com.lectures.movieappex.listener;



import com.lectures.movieappex.models.Movie;


import java.util.List;

public interface MovieDBResponseListener {

    void onMovieArrived(List<Movie> starships);

}
