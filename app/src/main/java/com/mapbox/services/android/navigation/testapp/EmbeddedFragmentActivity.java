package com.mapbox.services.android.navigation.testapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class EmbeddedFragmentActivity extends AppCompatActivity {

    private static final String BACK_STACK_ROOT_TAG = "root_fragment";

    public EmbeddedFragmentActivity() {
        super(R.layout.activity_embedded_fragment);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.main_container, StartNavigationFragment.class, null).addToBackStack(BACK_STACK_ROOT_TAG).commit();
        }
    }

    public void onStartNavigationClicked() {
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, NavigationFragment.class, null).addToBackStack(BACK_STACK_ROOT_TAG).commit();
    }


//    @Override
//    public void onBackPressed() {
//        if (getFragmentManager().getBackStackEntryCount() > 0) {
//            getFragmentManager().popBackStack();
//        } else {
//            super.onBackPressed();
//        }
//    }
}
