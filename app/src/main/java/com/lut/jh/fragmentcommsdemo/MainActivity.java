package com.lut.jh.fragmentcommsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends FragmentActivity implements IFragmentOwner {

    private ViewPager2 viewPager;
    private CommsDemoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.viewPager = (ViewPager2) findViewById(R.id.pager);
        this.adapter = new CommsDemoAdapter(this);
        this.viewPager.setAdapter(this.adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, this.viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("Receive Msg");
            } else {
                tab.setText("Send Msg");
            }
        }).attach();
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void sendMessageToFragment(String fragmentTag, String message) {
        this.adapter.sendMessageToFragment(fragmentTag, message);
    }
}