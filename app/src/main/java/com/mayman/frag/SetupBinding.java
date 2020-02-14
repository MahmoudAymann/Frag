package com.mayman.frag;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by MahmoudAyman on 2/14/2020.
 **/
public class SetupBinding {

    @BindingAdapter("app:adapter")
    public static void bindRecycler(RecyclerView recyclerView, ProductsAdapter productsAdapter){
        //do any you want with recycler view
        recyclerView.setAdapter(productsAdapter);
        recyclerView.hasFixedSize();         //optional
    }

}
