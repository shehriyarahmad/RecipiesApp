package com.heightincreasingfood.a10heightincreasingfood.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.heightincreasingfood.a10heightincreasingfood.Main2Activity;
import com.heightincreasingfood.a10heightincreasingfood.Models.ReipieModels;
import com.heightincreasingfood.a10heightincreasingfood.R;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RecipieAdapters extends RecyclerView.Adapter<RecipieAdapters.viewHolder> implements Filterable {

    ArrayList<ReipieModels> list;
    ArrayList<ReipieModels> fulllist;
     Context context;


    public RecipieAdapters(ArrayList<ReipieModels> list, Context context) {
        this.list = list;
        fulllist = new ArrayList<>(list);
        this.context = context;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.sample_rcv,parent,false);

        return new viewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {

        holder.imageView.setImageResource(list.get(position).getPic());
        holder.tv1.setText(list.get(position).getTxt1());
        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it =new Intent(context, Main2Activity.class);
                it.putExtra("pic",list.get(position).getPic());
                it.putExtra("txt1",list.get(position).getTxt1());
                it.putExtra("txt2",list.get(position).getTxt2());
                it.putExtra("txt3",list.get(position).getTxt3());
                it.putExtra("txt4",list.get(position).getTxt4());

                context.startActivity(it);

            }

        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ReipieModels> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(fulllist);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ReipieModels item : fulllist) {
                    if (item.getTxt1().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv1;
        CardView cd,cds;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
             imageView =itemView.findViewById(R.id.iv1);
             tv1 =itemView.findViewById(R.id.tv1);
             cd =itemView.findViewById(R.id.cd);
            cds =itemView.findViewById(R.id.cds);
        }
    }

}
