package com.example.consultants.week7test2.ui;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.consultants.week7test2.R;
import com.example.consultants.week7test2.model.github.GithubResponse;

public class MainActivity extends AppCompatActivity implements Observer<GithubResponse> {

    RecyclerView rvGithubList;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGithubList = findViewById(R.id.rvGithubList);
    }

    @Override
    public void onChanged(@Nullable GithubResponse githubResponse) {

    }
}
