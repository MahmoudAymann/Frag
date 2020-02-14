package com.mayman.frag;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public abstract class MovementManager {

    public static void replaceFragment(Context context, Fragment fragment, int container,String backStackText) {
        try {
            FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().replace(container, fragment);
            if (!backStackText.equals("")) {
                fragmentTransaction.addToBackStack(backStackText);
            }
            fragmentTransaction.commit();
        } catch (Exception e) {
        }
    }

    public static void replaceFragment(Context context, Fragment fragment, int container, String backStackText, Bundle bundle) {
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().replace(container, fragment);
        if (!backStackText.equals("")) {
            fragmentTransaction.addToBackStack(backStackText);
        }
        fragmentTransaction.commit();
    }


}
