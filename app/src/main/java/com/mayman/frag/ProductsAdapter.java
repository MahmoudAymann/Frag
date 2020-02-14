package com.mayman.frag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.mayman.frag.databinding.ItemProductViewBinding;
import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {
    private List<ProductItem> mDataList;
    private MutableLiveData<Object> mutableLiveData;
    private static final int layoutRes = R.layout.item_product_view;

    public ProductsAdapter() {
        mutableLiveData = new MutableLiveData<>();
    }

    public void updateDataList(final List<ProductItem> items) {
        if  (mDataList == null){
            mDataList = new ArrayList<>();
        }
        mDataList.clear();
        mDataList.addAll(items);
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemProductViewBinding binding = DataBindingUtil.inflate(layoutInflater, layoutRes
                , parent, false);
        return new ProductsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        holder.setAnimation();
        ItemProductViewModel viewModel = new ItemProductViewModel(getCurrentItem(position));
        holder.setViewModel(viewModel);
        viewModel.getMutableLiveData().observeForever(o -> {
            if (o instanceof Integer){
                int result = (Integer) o;
                if (result == Codes.ITEM_CLICK){
                    mutableLiveData.setValue(getCurrentItem(position));
                }else if (result == Codes.FAV_SELECTED){
                    mutableLiveData.setValue("fav on");
                }else if (result == Codes.FAV_UN_SELECTED){
                    mutableLiveData.setValue("fav off");
                }
            }
        });
    }

    private ProductItem getCurrentItem(int pos) {
        return mDataList.get(pos);
    }


    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    public MutableLiveData<Object> getMutableLiveData() {
        return mutableLiveData;
    }
}
