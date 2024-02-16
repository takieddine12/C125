package com.bottom.rv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SampleAdapter sampleAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        setRecyclerView();
    }

    private void setRecyclerView(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
        sampleAdapter = new SampleAdapter(Utils.getImages());
        recyclerView.setAdapter(sampleAdapter);
        sampleAdapter.onClick(new SampleAdapter.OnClickListener() {
            @Override
            public void onClicked(int height, int width) {
                Toast.makeText(MainActivity.this,
                           "Height : " + height +
                                " Width : " + width +
                                " Row Count : " + sampleAdapter.getItemCount(),Toast.LENGTH_LONG).show();
            }
        });
    }

}