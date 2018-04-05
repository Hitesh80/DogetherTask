package com.example.trisys.dogether.Utils;

import android.support.v7.util.DiffUtil;

import com.example.trisys.dogether.Model.GitHubRepoIssue;

import java.util.List;

/**
 * Created by Hitesh on 4/4/18.
 */

public class RepoIssueDiffCallBack extends DiffUtil.Callback{
    private final List<GitHubRepoIssue> mOldGitHubRepoIssueList;
    private final List<GitHubRepoIssue> mNewGitHubRepoIssueList;

    public RepoIssueDiffCallBack(List<GitHubRepoIssue> oldGitHubRepoIssueList,List<GitHubRepoIssue> newGitHubRepoIssueList) {
        this.mOldGitHubRepoIssueList=oldGitHubRepoIssueList;
        this.mNewGitHubRepoIssueList=newGitHubRepoIssueList;
    }

    @Override
    public int getOldListSize() {
        return mOldGitHubRepoIssueList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewGitHubRepoIssueList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldGitHubRepoIssueList.get(oldItemPosition).getId() == mNewGitHubRepoIssueList.get(
                newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final GitHubRepoIssue oldEmployee = mOldGitHubRepoIssueList.get(oldItemPosition);
        final GitHubRepoIssue newEmployee = mNewGitHubRepoIssueList.get(newItemPosition);

        return oldEmployee.getState().equals(newEmployee.getState());
    }
}
