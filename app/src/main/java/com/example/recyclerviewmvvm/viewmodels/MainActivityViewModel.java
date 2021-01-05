package com.example.recyclerviewmvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recyclerviewmvvm.adapter.ItemsAdapter;
import com.example.recyclerviewmvvm.model.Items;
import com.example.recyclerviewmvvm.repositories.ItemsRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Items>> mItems;
    private ItemsAdapter mAdapter;
    private Items mItem;

    public void init() {
        if (mItems != null) return;
        ItemsRepository repo = ItemsRepository.getInstance();
        mItems = repo.getItems();
    }

    public LiveData<List<Items>> getItems() {
        return mItems;
    }

}