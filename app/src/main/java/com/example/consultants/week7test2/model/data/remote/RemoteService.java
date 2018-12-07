package com.example.consultants.week7test2.model.data.remote;

import com.example.consultants.week7test2.model.github.GithubResponse;
import com.example.consultants.week7test2.utils.NetworkAPI;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteService {

    //https://api.github.com/search/repositories?q=created:>2018-11-30&sort=stars&order=desc
    @GET(NetworkAPI.PATH)
    Observable<GithubResponse> getGithub (@Query("q") String date,
                                          @Query("sort") String stars,
                                          @Query("order") String desc);
}
