package com.sample_1.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sample_1.R;
import com.sample_1.activity.MainActivity;
import com.sample_1.bean.Items;

import java.util.List;

/**
 * Created by Siddhartha on 25/09/2015.
 */
public class mListAdapter extends  RecyclerView.Adapter<mListAdapter.ViewHolder> {
    private List<Items> items;
    private int itemLayout;
    Button btn_del;
    View v;

    public mListAdapter(List<Items> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Items item = items.get(i);
        viewHolder.textView.setText(item.getNames());
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(v.getContext(), "Working!!", Toast.LENGTH_SHORT).show();
            }
        });
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
            btn_del = (Button)itemView.findViewById(R.id.btn_del);
        }
    }

}
