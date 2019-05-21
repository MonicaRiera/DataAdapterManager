package com.example.dataadaptermanager.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dataadaptermanager.R;
import com.example.dataadaptermanager.data.MyListItem;
import com.example.dataadaptermanager.view.adapter.MyListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] listItems = {"Android", "iPhone", "WindowsMobile","Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2", "Ubuntu","Windows7", "Max OS X", "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux","OS/2", "Android", "iPhone", "WindowsMobile"};
        //String[] listItems = {"Viktor", "Vanessa", "Alessandro","Pedro", "Carlos", "Monica", "Ayça", "Stefano", "Pablo"};

        List<MyListItem> myListItems = new ArrayList<>();
        for (String os : listItems) {
            MyListItem item = new MyListItem("", os, "A body displaying some information about the operating system");
            myListItems.add(item);
        }

        final ListView listView = findViewById(R.id.activity_main__list_view__data);
        //listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems));
        listView.setAdapter(new MyListAdapter(this, R.layout.custom_adapter_main, myListItems));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Position " + position + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
