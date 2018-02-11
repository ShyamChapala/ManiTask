package com.example.manikandan.wipro.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.manikandan.wipro.R;
import com.example.manikandan.wipro.model.ApiResponse;
import com.example.manikandan.wipro.view.adapter.LoadDataAdapter;
import com.example.manikandan.wipro.view_model.MainActivityViewModel;

public class MainActivity extends BaseActivity {

    private MainActivityViewModel mainActivityViewModel;
    private RecyclerView recyclerView;
    private LoadDataAdapter loadDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        initWidget();
        loadAdapter();
    }

    public void initWidget(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mainActivityViewModel.callApi();
    }

    public void loadAdapter(){

        mainActivityViewModel.getLoading().observe(this, isLoading -> {

            if (isLoading != null && isLoading) {
                showProcess(null);
            } else {
                hideProcess();
            }

        });

        mainActivityViewModel.getReactiveResponse().observe(this, apiResponse -> {
            loadDataAdapter = new LoadDataAdapter(this, apiResponse);
            Toolbar toolbar = findViewById(R.id.tool_bar);
            toolbar.setTitle(apiResponse.getTitle());
            recyclerView.setAdapter(loadDataAdapter);
        });
    }

}
