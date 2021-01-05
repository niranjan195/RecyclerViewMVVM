package com.example.recyclerviewmvvm;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewmvvm.adapter.ItemsAdapter;
import com.example.recyclerviewmvvm.model.Items;
import com.example.recyclerviewmvvm.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemsAdapter.OnItemClickListener {

    private ArrayList<Items> mItems;
    private RecyclerView mRecyclerView;
    private ItemsAdapter mAdapter;
    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mItems = new ArrayList<Items>();
        mRecyclerView = (RecyclerView) findViewById(R.id.items_recycler_view);
        mMainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        mMainActivityViewModel.init();
        mMainActivityViewModel.getItems().observe(this, new Observer<List<Items>>() {
            @Override
            public void onChanged(List<Items> items) {
                mAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }

    private void initRecyclerView() {

        mAdapter = new ItemsAdapter(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // set the items in the Adapter
        mAdapter.createItems(mMainActivityViewModel.getItems().getValue());
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onItemClick(int position) {
        Items item = mItems.get(position);
        Toast.makeText(this, "Clicked: " + item.getDescription(), Toast.LENGTH_SHORT).show();
    }
}

