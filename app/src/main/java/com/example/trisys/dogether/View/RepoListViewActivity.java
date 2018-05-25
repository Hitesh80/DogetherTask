package com.example.trisys.dogether.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.trisys.dogether.Adapter.RepoIssueListAdapter;
import com.example.trisys.dogether.R;

public class RepoListViewActivity extends AppCompatActivity {

    private RepoIssueListAdapter mAdapter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list_view);
        mAdapter=new RepoIssueListAdapter();

        lv=findViewById(R.id.repolv);

    }
}
