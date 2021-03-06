package com.example.trisys.dogether;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trisys.dogether.Adapter.RepoIssueAdapter;
import com.example.trisys.dogether.Model.GitHubRepoIssue;
import com.example.trisys.dogether.Model.GitHubRepository;
import com.example.trisys.dogether.Utils.GitHubClient;
import com.example.trisys.dogether.View.SearchButtonState;
//import com.example.trisys.dogether.databinding.ActivityMainBinding;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RepoIssueAdapter adapter;
    private Subscription subscription;
    private TextView currentRepoName;
    private GitHubRepository githubRepo;
    private String repoIsuueUrl;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
////        setContentView(R.layout.activity_main);
//        binding.setSearchButton(new SearchButtonState());
        adapter=new RepoIssueAdapter(this);
        progressDialog = new ProgressDialog(MainActivity.this);
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
                    if (progressDialog != null) {
                        progressDialog.setMessage("Please wait...");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                    }
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
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

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
                        progressDialog.dismiss();

                        Log.d(TAG, "In onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "In onError()");
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(List<GitHubRepoIssue> gitHubRepoIssues) {
                        Log.d(TAG, "In onNext()");
                        adapter.setGitHubRepoIssues(gitHubRepoIssues);

                    }
                });
    }

}
