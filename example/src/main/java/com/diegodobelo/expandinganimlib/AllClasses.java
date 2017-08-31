package com.diegodobelo.expandinganimlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class AllClasses extends AppCompatActivity {
    private GridLayoutManager lLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_classes);
        Button btx = (Button) findViewById(R.id.button_cross);
        btx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllClasses.this,CrossfadeDrawerLayout.class);
                startActivity(intent);
            }
        });

        List<String> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(AllClasses.this, 3);
        RecyclerView rView = (RecyclerView)findViewById(R.id.rv);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        AllClassesAdapter rcAdapter = new AllClassesAdapter(AllClasses.this, rowListItem);
        rView.setAdapter(rcAdapter);

    }


    private List<String> getAllItemList(){
        List<String> allItems = new ArrayList<String>();
        for(int i=1;i<=12;i++){
            allItems.add(""+i);
        }
        return allItems;
    }
}