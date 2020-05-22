/*
package com.heightincreasingfood.a10heightincreasingfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import com.heightincreasingfood.a10heightincreasingfood.Adapters.categoryAdapter;
import com.heightincreasingfood.a10heightincreasingfood.Models.categoryModel;

import java.util.ArrayList;
import java.util.Locale;

public class Main3Activity extends AppCompatActivity {

RecyclerView rcvs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rcvs =findViewById(R.id.rcvss);

        ArrayList<categoryModel> list = new ArrayList<>();



        GridLayoutManager glm =new GridLayoutManager(this,2);
        rcvs.setLayoutManager(glm);

        list.add(new categoryModel("hello"));
        list.add(new categoryModel("hello"));
        list.add(new categoryModel("hello"));
        list.add(new categoryModel("hello"));






        categoryAdapter adapters = new categoryAdapter(list,this);
        rcvs.setAdapter(adapters);




    }}
*/
