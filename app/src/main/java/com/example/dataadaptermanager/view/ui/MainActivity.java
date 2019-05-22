package com.example.dataadaptermanager.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dataadaptermanager.R;
import com.example.dataadaptermanager.data.MyListItem;
import com.example.dataadaptermanager.utils.Utils;
import com.example.dataadaptermanager.view.adapter.MyListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<MyListItem> myListItems = Utils.getListData();

        final ListView listView = findViewById(R.id.activity_main__list_view__data);
        //listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems));
        View header = LayoutInflater.from(this).inflate(R.layout.listview_header, null);
        listView.addHeaderView(header);
        listView.setAdapter(new MyListAdapter(this, R.layout.custom_adapter_main, myListItems));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Position " + position + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
