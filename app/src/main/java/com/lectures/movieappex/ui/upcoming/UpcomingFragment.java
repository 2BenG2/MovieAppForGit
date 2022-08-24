package com.lectures.movieappex.ui.upcoming;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.lectures.movieappex.R;
import com.lectures.movieappex.adapters.MovieAdapter;
import com.lectures.movieappex.databinding.FragmentUpcomingBinding;
import com.lectures.movieappex.enums.MovieListType;
import com.lectures.movieappex.models.Movie;
import com.lectures.movieappex.tools.MovieRecycleViewService;

import java.util.List;

public class UpcomingFragment extends Fragment {

    private FragmentUpcomingBinding binding;
    private UpcomingViewModel upcomingViewModel;
    private List<Movie> movieList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        upcomingViewModel = new ViewModelProvider(this).get(UpcomingViewModel.class);
        binding = FragmentUpcomingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        upcomingViewModel.getMovies(MovieListType.UP_COMING).observe(getViewLifecycleOwner(), movies -> {
            MovieRecycleViewService.setRecycleView(binding.rvUpcoming,movies);
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}