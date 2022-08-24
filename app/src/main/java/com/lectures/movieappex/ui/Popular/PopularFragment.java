package com.lectures.movieappex.ui.Popular;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.lectures.movieappex.databinding.FragmentPopularBinding;
import com.lectures.movieappex.enums.MovieListType;
import com.lectures.movieappex.listener.OnClickItemListener;
import com.lectures.movieappex.tools.MovieRecycleViewService;

public class PopularFragment extends Fragment  {

    private OnClickItemListener onClickItemListener;
    private FragmentPopularBinding binding;
    private PopularViewModel PopularViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PopularViewModel = new ViewModelProvider(this).get(PopularViewModel.class);
        binding = FragmentPopularBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PopularViewModel.getMovies(MovieListType.POPULAR).observe(getViewLifecycleOwner(), movies -> {
            MovieRecycleViewService.setRecycleView(binding.rvPopular,movies);

        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}