package com.example.trisys.dogether.View;

import android.databinding.ObservableField;

import java.util.Observable;

/**
 * Created by trisys on 9/4/18.
 */

public class SearchButtonState {

    public ObservableField<Boolean> getSearchButtonState() {
        return searchButtonState;
    }

    public void setSearchButtonState(ObservableField<Boolean> searchButtonState) {
        this.searchButtonState = searchButtonState;
    }

    public ObservableField<Boolean> searchButtonState;
}
