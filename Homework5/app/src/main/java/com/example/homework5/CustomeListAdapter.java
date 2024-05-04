package com.example.homework5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomeListAdapter extends BaseAdapter {
    private List<Location> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomeListAdapter(Context context, List<Location> listData) {
        this.context = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.listview, null);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) view.findViewById(R.id.titleTextView);
            viewHolder.subTitle = (TextView) view.findViewById(R.id.subTitleTextView);
            viewHolder.icon = (ImageView) view.findViewById(R.id.row_icon);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Location location = listData.get(i);
        String city = location.getName();
        viewHolder.title.setText(city);
        String latlong = location.getLatitude() + ":" + location.getLongtitude();
        viewHolder.subTitle.setText(latlong);
        int iconId = context.getResources().getIdentifier(city, "drawable", context.getPackageName());
        viewHolder.icon.setImageResource(iconId);
        return view;
    }

    static class ViewHolder {
        TextView title;
        TextView subTitle;
        ImageView icon;
    }
}
