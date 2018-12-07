package com.example.consultants.week7test2.model;

import com.example.consultants.week7test2.model.github.GithubResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class GithubObserver implements Observer<GithubResponse> {

    Callback callback;

    public static GithubObserver addCallback(Callback callback) {

        GithubObserver githubObserver = new GithubObserver();
        githubObserver.setCallback(callback);
        return githubObserver;
    }

    private void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(GithubResponse githubResponse) {
        callback.onNext(githubResponse);
    }

    @Override
    public void onError(Throwable e) {
        callback.onError(e.getMessage());
    }

    @Override
    public void onComplete() {

    }

    public interface Callback {

        void onNext(GithubResponse githubResponse);

        void onError(String error);
    }
}
