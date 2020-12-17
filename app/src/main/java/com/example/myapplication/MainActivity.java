package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView NewsRecyclerview;
    NewsAdapter newsAdapter;
    List<NewsItem> mData;
    FloatingActionButton fabSwitcher;
    boolean isDark = false;
    ConstraintLayout rootLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ini view

        fabSwitcher = findViewById(R.id.fab_switcher);
        rootLayout = findViewById(R.id.root_layout);
        NewsRecyclerview = findViewById(R.id.news_rv);
        mData = new ArrayList<>();

        // load theme state

        isDark = getThemeStatePref();
        if(isDark) {
            // dark theme is on

            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));

        }
        else
        {
            // light theme is on
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));

        }



        // fill list news with data
        // just for testing purpose i will fill the news list with random data
        // you may get your data from an api / firebase or sqlite database ...
        mData.add(new NewsItem("مرحبا:","مرحبا","6 مرحبا",R.drawable.user));
        mData.add(new NewsItem("اهلا","اهلا,","6 ",R.drawable.circul6));
        mData.add(new NewsItem("السلام عليكم","السلام عليكم","6 ",R.drawable.uservoyager));

        mData.add(new NewsItem("مرحبا:","مرحبا","6 مرحبا",R.drawable.user));
        mData.add(new NewsItem("اهلا","اهلا,","6 ",R.drawable.circul6));
        mData.add(new NewsItem("السلام عليكم","السلام عليكم","6 ",R.drawable.uservoyager));

        mData.add(new NewsItem("مرحبا:","مرحبا","6 مرحبا",R.drawable.user));
        mData.add(new NewsItem("اهلا","اهلا,","6 ",R.drawable.circul6));
        mData.add(new NewsItem("السلام عليكم","السلام عليكم","6 ",R.drawable.uservoyager));

        mData.add(new NewsItem("مرحبا:","مرحبا","6 مرحبا",R.drawable.user));
        mData.add(new NewsItem("اهلا","اهلا,","6 ",R.drawable.circul6));
        mData.add(new NewsItem("السلام عليكم","السلام عليكم","6 ",R.drawable.uservoyager));

        mData.add(new NewsItem("مرحبا:","مرحبا","6 مرحبا",R.drawable.user));
        mData.add(new NewsItem("اهلا","اهلا,","6 ",R.drawable.circul6));
        mData.add(new NewsItem("السلام عليكم","السلام عليكم","6 ",R.drawable.uservoyager));

        mData.add(new NewsItem("مرحبا:","مرحبا","6 مرحبا",R.drawable.user));
        mData.add(new NewsItem("اهلا","اهلا,","6 ",R.drawable.circul6));
        mData.add(new NewsItem("السلام عليكم","السلام عليكم","6 ",R.drawable.uservoyager));

        mData.add(new NewsItem("مرحبا:","مرحبا","6 مرحبا",R.drawable.user));
        mData.add(new NewsItem("اهلا","اهلا,","6 ",R.drawable.circul6));
        mData.add(new NewsItem("السلام عليكم","السلام عليكم","6 ",R.drawable.uservoyager));


        // adapter ini and setup

        newsAdapter = new NewsAdapter(this,mData,isDark);
        NewsRecyclerview.setAdapter(newsAdapter);
        NewsRecyclerview.setLayoutManager(new LinearLayoutManager(this));


        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark ;
                if (isDark) {

                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));

                }
                else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                }

                newsAdapter = new NewsAdapter(getApplicationContext(),mData,isDark);

                NewsRecyclerview.setAdapter(newsAdapter);
                saveThemeStatePref(isDark);
            }
        });
    }

    private void saveThemeStatePref(boolean isDark) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private boolean getThemeStatePref () {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark",false) ;
        return isDark;

    }

}