package com.dawn.demohomedawn.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.dawn.demohomedawn.R;
import com.dawn.demohomedawn.model.ProductModel;
import com.dawn.demohomedawn.ui.adapter.ProductShowAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 90449 on 2017/8/3.
 */

public class ProductShowFragment extends Fragment {
    private ProductShowAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_show, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        List<ProductModel> productModels = getData();
        mAdapter = new ProductShowAdapter(productModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);

        mAdapter.addHeaderView(getTitleView());

        return view;
    }
    private List<ProductModel> getData(){
        List<ProductModel> productModels = new ArrayList<>();
        ProductModel productModel;
        for(int i = 0; i < 10; i ++){
            productModel = new ProductModel(i, "dawn " + i, "dawn " + i + "描述。。。。。。。。。。。。", 0);
            productModels.add(productModel);
        }
        return productModels;
    }
    private View getTitleView(){
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_banner, null);
        SliderLayout sliderLayout = (SliderLayout) view.findViewById(R.id.slider_layout);
        setData(sliderLayout);
        return view;
    }
    private void setData(SliderLayout sliderLayout){
        List<Object> imageUrls = new ArrayList<>();
        final List<String> descriptions = new ArrayList<>();
        final List<String> jumpUrls = new ArrayList<>();
        imageUrls.add("http://www.baidu.com/img/bd_logo1.png");
        imageUrls.add("file:///sdcard/bd_logo.png");
        descriptions.add("网络请求");
        descriptions.add("sd卡下图片");
        jumpUrls.add("https://github.com/");
        jumpUrls.add("https://www.baidu.com");

        for (int i = 0; i < imageUrls.size(); i++) {
            //新建三个展示View，并且添加到SliderLayout
            final TextSliderView textSliderView = new TextSliderView(getActivity());
            if(imageUrls.get(i) instanceof String){
                textSliderView.image((String) imageUrls.get(i));
            }else if(imageUrls.get(i) instanceof Integer){
                textSliderView.image((Integer) imageUrls.get(i));
            }
            textSliderView.description(descriptions.get(i)).empty(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher);
            final int position = i;
            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {

                }
            });
            sliderLayout.addSlider(textSliderView);
        }
    }
}
