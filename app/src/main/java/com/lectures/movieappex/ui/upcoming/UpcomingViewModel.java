package com.lectures.movieappex.ui.upcoming;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lectures.movieappex.enums.MovieListType;
import com.lectures.movieappex.listener.MovieDBResponseListener;
import com.lectures.movieappex.models.Movie;
import com.lectures.movieappex.repos.MovieDBApiRepository;

import java.util.List;

public class UpcomingViewModel extends ViewModel {

    private MutableLiveData<List<Movie>> upcomingMovieLiveData;

    public LiveData<List<Movie>> getMovies(MovieListType listType) {

        if (upcomingMovieLiveData == null) {
            upcomingMovieLiveData = new MutableLiveData<>();
        }

        try {
            MovieDBApiRepository.getInstance().getMovies(listType,new MovieDBResponseListener() {
                @Override
                public void onMovieArrived(List<Movie> Movies) {
                    upcomingMovieLiveData.postValue(Movies);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return upcomingMovieLiveData;
    }

}