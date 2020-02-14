package com.mayman.frag;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mayman.frag.databinding.ItemProductViewBinding;

public class ProductsViewHolder extends RecyclerView.ViewHolder {

    private ItemProductViewBinding binding;

    public ProductsViewHolder(@NonNull ItemProductViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind() {
        if (binding == null) {
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public void unbind() {
        if (binding != null) {
            binding.unbind(); // Don't forget to unbind
        }
    }

    public void setViewModel(ItemProductViewModel viewModel) {
        if (binding != null) {
            binding.setViewModel(viewModel);
        }
    }

    public void setAnimation() {
        Context baseContext = BaseApplication.getInstance().getApplicationContext();
        Animation anim = AnimationUtils.loadAnimation(baseContext, R.anim.left_in);
        itemView.startAnimation(anim);

    }
}
