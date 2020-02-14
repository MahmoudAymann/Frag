package com.mayman.frag;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mayman.frag.databinding.FragmentProductsBinding;

import java.sql.DatabaseMetaData;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    private FragmentProductsBinding binding;
    private ProductsViewModel viewModel;

    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false);
        viewModel = new ViewModelProvider(this).get(ProductsViewModel.class);
        binding.setViewModel(viewModel);

        viewModel.getMutableLiveData().observe(getViewLifecycleOwner(), o -> {
             if (o instanceof String) {
                String text = o.toString();
                Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.productsAdapter.getMutableLiveData().observe(getViewLifecycleOwner(), o -> {
            if (o instanceof ProductItem) {
                ProductItem item = (ProductItem) o;
                Toast.makeText(getActivity(), "" + item.getName(), Toast.LENGTH_SHORT).show();
            } else if (o instanceof String) {
                String text = o.toString();
                Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }
}
