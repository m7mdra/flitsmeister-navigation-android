package com.mapbox.services.android.navigation.testapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StartNavigationFragment extends Fragment {
    public StartNavigationFragment() {
        super(R.layout.start_navigation_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button startNavigationButton = view.findViewById(R.id.startNavigationButton);
        startNavigationButton.setOnClickListener(v -> {
            EmbeddedFragmentActivity activity = (EmbeddedFragmentActivity) getActivity();
            activity.onStartNavigationClicked();
        });
    }
}
