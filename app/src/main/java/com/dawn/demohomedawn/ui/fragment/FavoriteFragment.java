package com.dawn.demohomedawn.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawn.demohomedawn.R;
import com.dawn.demohomedawn.ui.adapter.FavoriteAdapter;
import com.dawn.demohomedawn.view.ChildViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 90449 on 2017/8/3.
 */

public class FavoriteFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, null);
        ChildViewPager viewPager = (ChildViewPager) view.findViewById(R.id.viewpager);
        TabLayout tabLayout= (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(getChildFragmentManager(), getFragment(), getTitle());
        viewPager.setAdapter(favoriteAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        return view;
    }
    private List<Fragment> getFragment(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ProductShowFragment());
        fragments.add(new ProductAddFragment());
        return fragments;
    }
    private List<String> getTitle(){
        List<String> names = new ArrayList<>();
        names.add("产品展示");
        names.add("产品添加");
        return names;
    }


}
