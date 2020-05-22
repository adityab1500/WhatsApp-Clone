package com.kunaljuneja.whatsappclone;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    private final int behavior = FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;
    private final Fragment[] fragmentList = new Fragment[]{new ContactFragment(), new ChatFragment(), new StatusFragment()};
    private final int[] titleList = new int[]{R.string.tab1_home, R.string.tab2_home, R.string.tab3_home};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.main_toolbar);
        tabLayout = findViewById(R.id.home_tabs);
        viewPager = findViewById(R.id.home_viewpager);

        setSupportActionBar(toolbar);
        setupViewPager();
    }

    private void setupViewPager() {
        tabLayout.setupWithViewPager(viewPager);

        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager(), this, behavior, fragmentList, titleList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_search:
                Toast.makeText(this, "Search Selected!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_settings:
                Toast.makeText(this, "Settings Selected!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_new_group:
                Toast.makeText(this, "New Group Selected!", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
