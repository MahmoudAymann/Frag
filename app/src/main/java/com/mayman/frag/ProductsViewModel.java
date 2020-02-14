package com.mayman.frag;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MahmoudAyman on 2/14/2020.
 **/
public class ProductsViewModel extends BaseViewModel{
   public ProductsAdapter productsAdapter = new ProductsAdapter();

    public ProductsViewModel() {
        setValue("getting data");
        getData();
    }

    private void getData() {
        List<ProductItem> productItems = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            ProductItem item = new ProductItem();
            item.setId(++i);
            item.setDescription("description:" + i);
            item.setName("name: "+ i);
            item.setSelected(false);
            productItems.add(item);
        }

        productsAdapter.updateDataList(productItems);
        setValue("all ready");
    }


}
