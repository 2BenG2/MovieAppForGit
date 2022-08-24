package com.lectures.movieappex.repos;


import com.lectures.movieappex.enums.MovieListType;
import com.lectures.movieappex.listener.MovieDBResponseListener;
import com.lectures.movieappex.models.MovieResponse;
import com.lectures.movieappex.retrofit.MovieApiService;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDBApiRepository {

    MovieApiService retrofit;

    private MovieDBApiRepository() {
        retrofit = MovieApiService.create();
    }

    private static MovieDBApiRepository instance;

    public synchronized static MovieDBApiRepository getInstance() {

        if (instance == null) {
            instance = new MovieDBApiRepository();
        }

        return instance;
    }

    public void getMovies(MovieListType listType, MovieDBResponseListener listener) throws Exception {
        Call<MovieResponse> call;
        switch (listType){
            case POPULAR:
                call = retrofit.getPopularMovies();
                break;
            case TOP_RATED:
                call = retrofit.getTopRatedMovies();
                break;
            case UP_COMING:
                call = retrofit.getUpcomingMovies();
                break;
            default:throw new Exception("no MovieListType Found");
        }



        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                listener.onMovieArrived(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }



}
