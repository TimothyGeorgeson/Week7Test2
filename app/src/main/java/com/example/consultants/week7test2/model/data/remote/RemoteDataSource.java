package com.example.consultants.week7test2.model.data.remote;

import android.util.Log;

import com.example.consultants.week7test2.model.GithubObserver;
import com.example.consultants.week7test2.model.data.DataCallback;
import com.example.consultants.week7test2.model.data.GithubRepository;
import com.example.consultants.week7test2.model.github.GithubResponse;
import com.example.consultants.week7test2.utils.NetworkAPI;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    public static final String TAG = GithubRepository.class.getSimpleName() + "_TAG";

    private Retrofit createClient() {

        return new Retrofit.Builder()
                .baseUrl(NetworkAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private Observable<GithubResponse> getGithubObs() {
        return createClient().create(RemoteService.class).getGithub("created:>2018-11-30", "stars", "desc");
    }

    public void getGithub(final DataCallback callback) {

        getGithubObs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(GithubObserver.addCallback(new GithubObserver.Callback() {
                    @Override
                    public void onNext(GithubResponse githubResponse) {
                        callback.onSuccess(githubResponse);
                    }

                    @Override
                    public void onError(String error) {
                        Log.d(TAG, "onError: " + error);
                        callback.onFailure(error);
                    }
                }));
    }
}
