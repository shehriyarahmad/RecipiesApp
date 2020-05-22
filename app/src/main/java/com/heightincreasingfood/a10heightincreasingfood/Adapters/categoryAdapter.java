/*
package com.heightincreasingfood.a10heightincreasingfood.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.heightincreasingfood.a10heightincreasingfood.Models.categoryModel;
import com.heightincreasingfood.a10heightincreasingfood.R;

import java.util.ArrayList;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.viewHolder>{
    ArrayList<categoryModel> lists;
    Context context;

    public categoryAdapter(ArrayList<categoryModel> list, Context context) {
        this.lists = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View views= LayoutInflater.from(context).inflate(R.layout.sample_category,parent,false);

        return new categoryAdapter.viewHolder(views);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holders, int position) {
        holders.tv3.setText(lists.get(position).getTxt());

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tv3;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }
}
*/
