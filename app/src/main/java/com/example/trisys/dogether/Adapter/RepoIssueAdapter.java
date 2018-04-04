package com.example.trisys.dogether.Adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trisys.dogether.Model.GitHubRepoIssue;
import com.example.trisys.dogether.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hitesh on 3/4/18.
 */

public class RepoIssueAdapter extends RecyclerView.Adapter<RepoIssueAdapter.GitHubRepoViewHolder> {

    private List<GitHubRepoIssue> gitHubRepoIssues = new ArrayList<>();

    public void setGitHubRepoIssues(@Nullable List<GitHubRepoIssue> repos) {
        if (repos == null) {
            return;
        }
        gitHubRepoIssues.clear();
        gitHubRepoIssues.addAll(repos);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return gitHubRepoIssues.size();
    }

    @Override
    public GitHubRepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_github_repo, parent, false);

        return new GitHubRepoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GitHubRepoViewHolder holder, int position) {
        GitHubRepoIssue gitHubRepoIssue = gitHubRepoIssues.get(position);
        holder.textRepoIssueName.setText(gitHubRepoIssue.title);
        holder.textRepoIssueCommentUrl.setText("Comments Url: " + gitHubRepoIssue.comments_url);
        holder.textIssueState.setText("State: " + gitHubRepoIssue.state);
        holder.textIssueCreatedAt.setText("Created at: " + gitHubRepoIssue.created_at);
    }

    public static class GitHubRepoViewHolder extends RecyclerView.ViewHolder {

        private TextView textRepoIssueName;
        private TextView textRepoIssueCommentUrl;
        private TextView textIssueState;
        private TextView textIssueCreatedAt;

        public GitHubRepoViewHolder(View view) {
            super(view);
            textRepoIssueName = view.findViewById(R.id.text_repo_issue_name);
            textRepoIssueCommentUrl = view.findViewById(R.id.text_repo_issue_comments_url);
            textIssueState = view.findViewById(R.id.text_state);
            textIssueCreatedAt = view.findViewById(R.id.text_created_at);
        }
    }
}
