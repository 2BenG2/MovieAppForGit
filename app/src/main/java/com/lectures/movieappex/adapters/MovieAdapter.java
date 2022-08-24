package com.lectures.movieappex.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lectures.movieappex.R;
import com.lectures.movieappex.listener.OnClickItemListener;
import com.lectures.movieappex.models.Movie;
import com.lectures.movieappex.tools.MovieRecycleViewService;
import com.lectures.movieappex.tools.PosterGetter;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    OnClickItemListener onClickItemListener;
    List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {

        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false);
        return new MovieViewHolder(view,onClickItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        PosterGetter.getPosterFromPath(movie.getPosterPath(),true,holder.movieImg);
        holder.movieTitle.setText(movie.getTitle());
        holder.movieReleaseDate.setText(movie.getReleaseDate());
        holder.movie = movie;

    }

    @Override
    public int getItemCount() {
        if (movies == null) {
            return 0;
        }

        return movies.size();
    }


    static class MovieViewHolder extends RecyclerView.ViewHolder {
        final ImageView movieImg ;
        final TextView movieTitle ;
        final TextView movieReleaseDate ;
        private Movie movie;

        public MovieViewHolder(@NonNull View itemView,OnClickItemListener onClickItemListener) {
            super(itemView);
            movieImg = itemView.findViewById(R.id.iv_movie_image);
            movieTitle = itemView.findViewById(R.id.tv_movie_title);
            movieReleaseDate = itemView.findViewById(R.id.tv_release_date);
            itemView.setOnClickListener(v->{
                MovieRecycleViewService.setOnClickToDetails(movie, v.getContext());
            });
        }

    }

}

