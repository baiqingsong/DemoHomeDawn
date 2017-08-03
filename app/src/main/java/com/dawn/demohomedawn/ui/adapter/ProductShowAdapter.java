package com.dawn.demohomedawn.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dawn.demohomedawn.R;
import com.dawn.demohomedawn.model.ProductModel;

import java.util.List;

/**
 * Created by 90449 on 2017/8/3.
 */

public class ProductShowAdapter extends BaseQuickAdapter<ProductModel, BaseViewHolder> {
    public ProductShowAdapter(@Nullable List<ProductModel> data) {
        super(R.layout.item_product_show, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductModel item) {
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_description, item.getDescription());
    }
}
