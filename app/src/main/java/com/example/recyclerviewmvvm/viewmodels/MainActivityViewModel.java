package com.example.recyclerviewmvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recyclerviewmvvm.adapter.ItemsAdapter;
import com.example.recyclerviewmvvm.model.Items;
import com.example.recyclerviewmvvm.repositories.ItemsRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel implements ItemsAdapter.OnItemClickListener {

    private MutableLiveData<List<Items>> mItems;
    public void init() {
        if (mItems != null) return;
        ItemsRepository repo = ItemsRepository.getInstance();
        mItems = repo.getItems();
    }
    public LiveData<List<Items>> getItems() {
        return mItems;
    }

    @Override
    public void onItemClick(int position) {
        List<Items> items = mItems.getValue();

    }
}