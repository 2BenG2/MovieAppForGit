package com.lectures.movieappex.ui.top_rated;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lectures.movieappex.enums.MovieListType;
import com.lectures.movieappex.listener.MovieDBResponseListener;
import com.lectures.movieappex.models.Movie;
import com.lectures.movieappex.repos.MovieDBApiRepository;

import java.util.List;

public class TopRatedViewModel extends ViewModel {

    private MutableLiveData<List<Movie>> topRatedMovieLiveData;

    public LiveData<List<Movie>> getMovies(MovieListType listType) {

        if (topRatedMovieLiveData == null) {
            topRatedMovieLiveData = new MutableLiveData<>();
        }

        try {
            MovieDBApiRepository.getInstance().getMovies(listType,new MovieDBResponseListener() {
                @Override
                public void onMovieArrived(List<Movie> Movies) {
                    topRatedMovieLiveData.postValue(Movies);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return topRatedMovieLiveData;
    }
}