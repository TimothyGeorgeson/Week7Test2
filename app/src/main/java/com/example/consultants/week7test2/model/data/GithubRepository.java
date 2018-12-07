package com.example.consultants.week7test2.model.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.consultants.week7test2.model.data.remote.RemoteDataSource;
import com.example.consultants.week7test2.model.github.GithubResponse;

public class GithubRepository {
    public static final String TAG = GithubRepository.class.getSimpleName() + "_TAG";

    private MutableLiveData<GithubResponse> listLiveData;
    private RemoteDataSource remoteDataSource;

    public GithubRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;

        listLiveData = new MutableLiveData<>();
    }

    public LiveData<GithubResponse> getGithub() {

        //load from remote source
        remoteDataSource.getGithub(new DataCallback() {
            @Override
            public void onSuccess(GithubResponse githubResponse) {
                listLiveData.setValue(githubResponse);
            }

            @Override
            public void onFailure(String error) {

            }
        });

        return listLiveData;
    }
}
