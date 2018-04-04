package com.example.trisys.dogether;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trisys.dogether.Adapter.RepoIssueAdapter;
import com.example.trisys.dogether.Model.GitHubRepoIssue;
import com.example.trisys.dogether.Model.GitHubRepository;
import com.example.trisys.dogether.Utils.GitHubClient;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RepoIssueAdapter adapter = new RepoIssueAdapter();
    private Subscription subscription;
    private TextView currentRepoName;
    private GitHubRepository githubRepo;
    private String repoIsuueUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final ListView listView = findViewById(R.id.list_view_repos);
//        listView.setAdapter(adapter);
        final RecyclerView recyclerView = findViewById(R.id.list_view_repos);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        final EditText editTextRepoName = findViewById(R.id.edit_text_repoName);
        final Button buttonSearch = findViewById(R.id.button_search);
        currentRepoName=findViewById(R.id.current_repo_tv);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String repoName = editTextRepoName.getText().toString();
                if (!TextUtils.isEmpty(repoName)) {

                    getRepository(repoName);
                }
            }
        });
    }

    private void getRepository(final String repoName) {
        subscription = GitHubClient.getInstance()
                .getSingleRepo(repoName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GitHubRepository>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "In onCompleted()");
                        currentRepoName.setText(githubRepo.getName().toUpperCase()+"  Repo Issues List");
                        //repoIsuueUrl=githubRepo.getIssues_url();
                        getReposIssuesList(repoName);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "In onError()");
                    }

                    @Override
                    public void onNext(GitHubRepository gitHubRepos) {
                        githubRepo=gitHubRepos;
                        Log.d(TAG, "In onNext()");



                    }
                });
    }

    @Override
    protected void onDestroy() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        super.onDestroy();
    }

    private void getReposIssuesList(String repoName) {
        subscription = GitHubClient.getInstance()
                .getReposIssue(repoName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GitHubRepoIssue>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "In onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "In onError()");
                    }

                    @Override
                    public void onNext(List<GitHubRepoIssue> gitHubRepoIssues) {
                        Log.d(TAG, "In onNext()");
                        adapter.setGitHubRepoIssues(gitHubRepoIssues);
                    }
                });
    }

}
