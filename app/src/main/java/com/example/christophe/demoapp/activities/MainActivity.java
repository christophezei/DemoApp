package com.example.christophe.demoapp.activities;




import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.christophe.demoapp.R;
import com.example.christophe.demoapp.adapters.PageAdapter;


import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar mtoolbar;
    @BindView(R.id.tablayout) TabLayout tabLayout;
    @Nullable
    @BindView(R.id.tab1) TabItem tab1;
    @Nullable
    @BindView(R.id.tab2) TabItem tab2;
    @BindView(R.id.viewPager) ViewPager viewPager;






    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mtoolbar);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"Please don't leave me!",
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Welcome Back",
                Toast.LENGTH_LONG).show();

    }
}
