package com.example.christophe.demoapp.activities;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.example.christophe.demoapp.R;
import com.example.christophe.demoapp.adapters.PageAdapter;
import com.example.christophe.demoapp.fragments.Tab1Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Tab1Fragment.ActionListener {

    @BindView(R.id.toolbar) Toolbar mtoolbar;
    @BindView(R.id.tablayout) TabLayout tabLayout;
    @BindView(R.id.viewPager) ViewPager viewPager;
    private SharedPreferences sharedPreferences;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mtoolbar);

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    protected void onResume() {
        super.onResume();
        sharedPreferences=getApplication().getSharedPreferences("SaveName", MODE_PRIVATE);
        String prevName=sharedPreferences.getString("Value","0");
        if(prevName!="0"){
            Toast.makeText(this, "Welcome Back you selected:"+prevName+" previously!", Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this, "Welcome Back ", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Please don't leave me!", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onAction() {

        viewPager.setCurrentItem(1);
        count++;
        Toast.makeText(this, "You have visited :"+count+" times via 'FIND ME A PARTNER'", Toast.LENGTH_LONG).show();
    }
}
