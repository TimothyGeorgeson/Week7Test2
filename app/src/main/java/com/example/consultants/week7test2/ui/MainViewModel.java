package com.example.consultants.week7test2.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.consultants.week7test2.model.data.GithubRepository;
import com.example.consultants.week7test2.model.data.remote.RemoteDataSource;
import com.example.consultants.week7test2.model.github.GithubResponse;

public class MainViewModel extends ViewModel {
    private GithubRepository githubRepository;

    public MainViewModel() {
        githubRepository = new GithubRepository(new RemoteDataSource());
    }

    public LiveData<GithubResponse> getGithub() {
        return githubRepository.getGithub();
    }
}
