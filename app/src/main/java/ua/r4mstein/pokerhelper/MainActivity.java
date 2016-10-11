package ua.r4mstein.pokerhelper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import ua.r4mstein.pokerhelper.adapter.ViewPagerAdapter;
import ua.r4mstein.pokerhelper.fragments.ItemFragment;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(ItemFragment.newInstance(0), "UTG");
        pagerAdapter.addFragment(ItemFragment.newInstance(1), "MP");
        pagerAdapter.addFragment(ItemFragment.newInstance(2), "CO");
        pagerAdapter.addFragment(ItemFragment.newInstance(3), "BTN");
        pagerAdapter.addFragment(ItemFragment.newInstance(4), "SB");
        pagerAdapter.addFragment(ItemFragment.newInstance(5), "BB");
        mViewPager.setAdapter(pagerAdapter);
    }

}
