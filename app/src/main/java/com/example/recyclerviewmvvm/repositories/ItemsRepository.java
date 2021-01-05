package com.example.recyclerviewmvvm.repositories;


import androidx.lifecycle.MutableLiveData;

import com.example.recyclerviewmvvm.R;
import com.example.recyclerviewmvvm.model.Items;

import java.util.ArrayList;
import java.util.List;

// representing singleton class
public class ItemsRepository {

    private static ItemsRepository instance;
    private ArrayList<Items> mItems = new ArrayList<>();

    private ItemsRepository() {
    }

    public static ItemsRepository getInstance() {
        if (instance == null) instance = new ItemsRepository();
        return instance;
    }

    public MutableLiveData<List<Items>> getItems() {
        setItems(); // This would be an api service or database request
        MutableLiveData<List<Items>> data = new MutableLiveData<>();
        data.setValue(mItems);
        return data;
    }

    public void setItems() {
        // Add the Items to the ArrayList
        this.mItems.add(new Items(R.drawable.ic_launcher, "Ration"));
        this.mItems.add(new Items(R.drawable.ic_launcher, "Recharge a prepaid number"));
        this.mItems.add(new Items(R.drawable.ic_launcher, "Buy a giftcard"));
        this.mItems.add(new Items(R.drawable.ic_launcher, "Pay electricity bills"));
        this.mItems.add(new Items(R.drawable.ic_launcher, "Pay postpaid bills"));
        this.mItems.add(new Items(R.drawable.ic_launcher, "Pay DTH bills"));
    }

}
