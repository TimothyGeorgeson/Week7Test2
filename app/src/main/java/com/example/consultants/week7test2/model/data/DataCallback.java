package com.example.consultants.week7test2.model.data;

import com.example.consultants.week7test2.model.github.GithubResponse;

public interface DataCallback {

    void onSuccess(GithubResponse githubResponse);

    void onFailure(String error);
}
