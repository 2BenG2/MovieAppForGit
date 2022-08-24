package com.lectures.movieappex.ui.top_rated;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lectures.movieappex.databinding.FragmentTopRatedBinding;
import com.lectures.movieappex.enums.MovieListType;
import com.lectures.movieappex.models.Movie;
import com.lectures.movieappex.tools.MovieRecycleViewService;

import java.util.List;

public class TopRatedFragment extends Fragment {

    private FragmentTopRatedBinding binding;
    private TopRatedViewModel topRatedViewModel;
    private List<Movie> movieList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        topRatedViewModel = new ViewModelProvider(this).get(TopRatedViewModel.class);
        binding = FragmentTopRatedBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        topRatedViewModel.getMovies(MovieListType.TOP_RATED).observe(getViewLifecycleOwner(), movies -> {
            MovieRecycleViewService.setRecycleView(binding.rvTopRated,movies);
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}