package com.example.dataadaptermanager.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dataadaptermanager.R;
import com.example.dataadaptermanager.data.MyListItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyListAdapter extends ArrayAdapter<MyListItem> {

    private Context context;
    private int layoutResource;
    private List<MyListItem> listItems;

    public MyListAdapter(@NonNull Context context, int resource, @NonNull List<MyListItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResource = resource;
        this.listItems = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layoutResource, null);
        TextView title = convertView.findViewById(R.id.custom_adapter_main__tv__title);
        title.setText(listItems.get(position).getTitle());
        TextView body = convertView.findViewById(R.id.custom_adapter_main__tv__body);
        body.setText(listItems.get(position).getBody());

        return convertView;
    }
}
