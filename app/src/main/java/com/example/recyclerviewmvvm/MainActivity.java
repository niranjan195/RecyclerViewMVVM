package com.example.recyclerviewmvvm;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemsAdapter.OnItemClickListener {

    private ArrayList<Items> mItems;
    private RecyclerView mRecyclerView;
    private ItemsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        initItems();

    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.items_recycler_view);
        mAdapter = new ItemsAdapter(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initItems() {
        this.mItems = new ArrayList<>();
        this.mItems.add(new Items(R.drawable.ic_launcher, getResources().getString(R.string.ration)));
        this.mItems.add(new Items(R.drawable.ic_launcher, getResources().getString(R.string.buy_giftcard)));
        this.mItems.add(new Items(R.drawable.ic_launcher, getResources().getString(R.string.recharge)));
        this.mItems.add(new Items(R.drawable.ic_launcher, getResources().getString(R.string.pay_dth_bills)));
        this.mItems.add(new Items(R.drawable.ic_launcher, getResources().getString(R.string.pay_electricity_bills)));
        this.mItems.add(new Items(R.drawable.ic_launcher, getResources().getString(R.string.pay_postpaid_bills)));
        mAdapter.createItems(mItems);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Items item = mItems.get(position);
        Toast.makeText(this, "Clicked: " + item.getDescription(), Toast.LENGTH_SHORT).show();
    }
}

