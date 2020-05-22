package com.heightincreasingfood.a10heightincreasingfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.CompoundButton;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.ToggleButton;


import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.heightincreasingfood.a10heightincreasingfood.Adapters.RecipieAdapters;
import com.heightincreasingfood.a10heightincreasingfood.Models.ReipieModels;

import java.util.ArrayList;

public class MainActivityaa extends AppCompatActivity {

    RecipieAdapters adapter;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ToggleButton toggleButton;

    RecyclerView rcv;
    ArrayList<ReipieModels> list;
    ReipieModels rm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.rcv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rcv.setLayoutManager(llm);
        LayoutAnimationController lac = AnimationUtils.loadLayoutAnimation(this, R.anim.layoutanimation);
        rcv.setLayoutAnimation(lac);


        list = new ArrayList<>();
        list.add(new ReipieModels(R.drawable.aa, "Almonds:", "Almonds are jam-packed with many of the vitamins and minerals necessary for growing taller Besides bringing a host of healthy fats to the table, they’re high in fiber, manganese, and magnesium Plus, almonds are rich in vitamin E, a fat-soluble vitamin that doubles as an antioxidant. A deficiency in this important vitamin can come with serious side effects, including stunted growth in children. Almonds may also help foster bone h" +
                "ealth. In one small study in 14 people, consuming almonds was found to inhibit the formation of osteoclasts, which are a type of cell that breaks down bone tissue.", "Note:", "Almonds are high in vitamin E and have been shown to inhibit the formation of osteoclasts, a type of cell that breaks down bone tissue."));
        list.add(new ReipieModels(R.drawable.e, "Eggs:", "Eggs are truly a powerhouse of nutrition.\n" +
                "\n" +
                "They’re especially rich in protein, with 6 grams packed into a single large egg.\n" +
                "\n" +
                "Plus, they contain a wealth of other vitamins and minerals necessary for growth, including vitamin D, which can increase calcium absorption to help maintain skeletal health.\n" +
                "\n" +
                "One small study found that giving children with low vitamin D levels a vitamin D supplement resulted in increased growth over a 6-month period.\n" +
                "\n" +
                "What’s more, one study in 874 children observed that regularly eating eggs was associated with increased monthly height gains.", "Note:", "Eggs are rich in protein and vitamin D, along with several other important micronutrients. Studies show that regular egg intake could be associated with increases in height."));
        list.add(new ReipieModels(R.drawable.b, "Beans:", "Beans are incredibly nutritious and an especially good source of protein.\n" +
                "\n" +
                "Protein has been shown to increase levels of insulin-like growth factor 1 (IGF-1), an important hormone that regulates growth in children.\n" +
                "\n" +
                "Beans are also high in iron and B vitamins, which can help protect against anemia, a condition characterized by a lack of healthy red blood cells in the body.\n" +
                "\n" +
                "Not only is iron required for tissue growth, but iron deficiency anemia may also contribute to delayed growth in children.\n" +
                "\n" +
                "Furthermore, beans are rich in several other nutrients, such as fiber, copper, magnesium, manganese, and zinc.", "Note:", "Beans are high in protein and iron, which can protect against anemia and promote proper growth."));
        list.add(new ReipieModels(R.drawable.p, "Sweet potatoes:", "Besides being vibrant and versatile, sweet potatoes are incredibly healthy.\n" +
                "\n" +
                "They’re especially rich in vitamin A, which can improve bone health and help you grow taller or maintain your height.\n" +
                "\n" +
                "They also contain both soluble and insoluble fiber, which can promote digestive health and foster the growth of good gut bacteria.\n" +
                "\n" +
                "Maintaining a healthy gut microbiome can also boost nutrient absorption to ensure that you’re getting the vitamins and minerals you need for growth and development.\n" +
                "\n" +
                "Plus, sweet potatoes are packed with other important nutrients, including vitamin C, manganese, vitamin B6, and potassium (27Trusted Source).", "Note:", "Sweet potatoes are rich in vitamin A, which helps enhance bone health. They’re likewise high in fiber to promote digestive health and nutrient absorption."));
        list.add(new ReipieModels(R.drawable.c, "Chicken:", "Rich in protein along with a range of other essential nutrients, chicken can be an excellent addition to a healthy diet.\n" +
                "\n" +
                "It’s particularly high in vitamin B12, a water-soluble vitamin that’s crucial when it comes to growing taller and maintaining your height.\n" +
                "\n" +
                "It’s also loaded with taurine, an amino acid that regulates bone formation and growth.\n" +
                "\n" +
                "What’s more, chicken is loaded with protein, containing around 20 grams in a 3-ounce (85-gram) serving.\n" +
                "\n" +
                "Although the precise nutritional profile can vary a bit based on the cut and cooking method, chicken is also a good source of niacin, selenium, phosphorus, and vitamin B6 (12Trusted Source).", "Note:", "Chicken is an excellent source of many nutrients for growth, such as protein, vitamin B12, and taurine."));
        list.add(new ReipieModels(R.drawable.f, "Salmon:", "Salmon is a fatty fish that’s loaded with omega-3 fatty acids.\n" +
                "\n" +
                "Omega-3 fatty acids are a type of heart-healthy fat that’s crucial to growth and development.\n" +
                "\n" +
                "Some research also suggests that omega-3 fatty acids could be involved in bone health and may promote bone turnover to maximize growth.\n" +
                "\n" +
                "Plus, low levels of omega-3 fatty acids could be linked to an increased risk of sleep problems in children, which can negatively affect growth as well.\n" +
                "\n" +
                "Additionally, salmon is high in protein, B vitamins, selenium, and potassium (45Trusted Source).", "Note:", "Salmon is high in omega-3 fatty acids, which can improve sleep and bone turnover to increase growth."));
        list.add(new ReipieModels(R.drawable.bee, "Berries:", "Berries, such as blueberries, strawberries, blackberries, and raspberries, are all brimming with important nutrients.\n" +
                "\n" +
                "They’re especially high in vitamin C, which promotes cell growth and tissue repair.\n" +
                "\n" +
                "Vitamin C also increases the synthesis of collagen, which is the most abundant protein in your body.\n" +
                "\n" +
                "Studies show that collagen can increase bone density and improve bone health, which could help you grow taller or maintain your height.\n" +
                "\n" +
                "Berries also offer a range of other vitamins and minerals, including fiber, vitamin K, and manganese.", "Note:", "Berries are high in vitamin C, which promotes cell growth, supports tissue repair, and increases collagen production."));
        list.add(new ReipieModels(R.drawable.l, "Leafy greens:", "Leafy greens, such as spinach, kale, arugula, and cabbage, are superstars when it comes to nutrition.\n" +
                "\n" +
                "While the exact amount of nutrients fluctuates between different types, leafy greens generally offer a concentrated amount of vitamin C, calcium, iron, magnesium, and potassium.\n" +
                "\n" +
                "They’re also rich in vitamin K, a nutrient that can increase bone density to support enhanced growth and help maintain your height.\n" +
                "\n" +
                "One study in 103 women even showed that regular intake of greens was associated with a significantly lower risk of decreased bone mass.", "Note:", "Leafy greens are high in vitamin K, which supports bone health. One study found that regular intake of greens could preserve bone mass."));
        list.add(new ReipieModels(R.drawable.y, " Yogurt:", "Yogurt is a great source of several key nutrients that are important for growth, including protein.\n" +
                "\n" +
                "In fact, just 7 ounces (200 grams) of Greek yogurt pack in nearly 20 grams of protein.\n" +
                "\n" +
                "Certain types also contain probiotics, which are a type of beneficial bacteria that can help support gut health.\n" +
                "\n" +
                "In addition to improving immune function and decreasing inflammation, some research shows that probiotics can help increase growth in children.\n" +
                "\n" +
                "Yogurt is likewise an excellent source of several nutrients involved in bone metabolism, including calcium, magnesium, phosphorus, and potassium.", "Note:", "Yogurt is high in protein, as well as calcium, magnesium, phosphorus, and potassium. Some types may also contain probiotics, which may help improve growth."));
        list.add(new ReipieModels(R.drawable.m, "Milk:", "Milk is often considered a key component of a healthy, well-rounded diet.\n" +
                "\n" +
                "It can also help support growth by supplying several nutrients that are important for bone health, including calcium, phosphorus, and magnesium (3Trusted Source, 46Trusted Source).\n" +
                "\n" +
                "Additionally, milk is rich in protein, with nearly 8 grams of the nutrient in a single 1-cup (244-ml) serving.\n" +
                "\n" +
                "Not only that, but research shows that cow’s milk can stimulate increased growth in children and may help support weight gain and muscle building.\n" +
                "\n" +
                "However, milk should be avoided if there’s an allergy or intolerance.", "Note:", "Milk contains a good amount of protein in each serving, along with several micronutrients that can support bone health to increase or maintain growth."));



        adapter = new RecipieAdapters(list, this);
        rcv.setAdapter(adapter);










        drawerLayout = findViewById(R.id.drawer);
        navigationView =findViewById(R.id.nv);




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.i1:

                        break;

                    case R.id.i2:
                    String sharebody="'Your body here";
                    String sharesubject="Your subject here";
                    Intent si = new Intent(Intent.ACTION_SEND);
                    si.setType("Text/Plain");
                    si.putExtra(Intent.EXTRA_SUBJECT,sharesubject);
                    si.putExtra(Intent.EXTRA_TEXT,sharebody);
                    startActivity(Intent.createChooser(si,"share using"));

                    break;


                    /*--your code--*/





                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;       //you need to return true here, not false

            }
        });

        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toolbar.setTitle("Recipie App");





        // LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //rcv.setLayoutManager(llm);
        //GridLayoutManager glm =new GridLayoutManager(this,2);
        //rcv.setLayoutManager(glm);
        // StaggeredGridLayoutManager sglm =new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL);
        //rcv.setLayoutManager(sglm);
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem mi = menu.findItem(R.id.sv);
        SearchView sv = (SearchView) mi.getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }



}





