package com.lectures.movieappex.retrofit;

import com.lectures.movieappex.models.MovieResponse;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface MovieApiService {


    @GET("movie/top_rated?api_key=e0d0db9e00d2b010268781d4e0630df7")
    Call<MovieResponse> getTopRatedMovies(); //e0d0db9e00d2b010268781d4e0630df7

    @GET("movie/popular?api_key=e0d0db9e00d2b010268781d4e0630df7")
    Call<MovieResponse> getPopularMovies();

    @GET("movie/upcoming?api_key=e0d0db9e00d2b010268781d4e0630df7")
    Call<MovieResponse> getUpcomingMovies();


    static MovieApiService create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
//        https://swapi.dev/api/
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MovieApiService.class);
    }


}
