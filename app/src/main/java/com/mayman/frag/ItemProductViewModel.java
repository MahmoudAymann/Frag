package com.mayman.frag;

import androidx.databinding.ObservableBoolean;

public class ItemProductViewModel extends BaseViewModel {

    public ProductItem item;
    public ObservableBoolean isSelected = new ObservableBoolean();

    public ItemProductViewModel(ProductItem item) {
        this.item = item;
        isSelected.set(item.isSelected());
    }

    public void onItemClick() {
        setValue(Codes.ITEM_CLICK);
    }

    public void onFavClick() {
        if (isSelected.get()) {
            isSelected.set(false);
            item.setSelected(false);
            setValue(Codes.FAV_UN_SELECTED);
        } else {
            isSelected.set(true);
            item.setSelected(true);
            setValue(Codes.FAV_SELECTED);
        }
    }

}
