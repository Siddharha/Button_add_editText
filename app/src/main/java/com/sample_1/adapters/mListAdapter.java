package com.sample_1.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample_1.R;
import com.sample_1.bean.Items;

import java.util.List;

/**
 * Created by Siddhartha on 25/09/2015.
 */
public class mListAdapter extends  RecyclerView.Adapter<mListAdapter.ViewHolder> {
    private List<Items> items;
    private int itemLayout;

    public mListAdapter(List<Items> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Items item = items.get(i);
        viewHolder.textView.setText(item.getNames());
        viewHolder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

}
