package com.mapbox.services.android.navigation.testapp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions;
import com.mapbox.mapboxsdk.style.layers.LineLayer;
import com.mapbox.mapboxsdk.style.layers.Property;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.mapboxsdk.utils.BitmapUtils;

import java.util.ArrayList;
import java.util.List;

public class NavigationFragment extends Fragment {
    private static final String PIN_ICON = "PIN_ICON";
    private static final String ROUTE_LAYER_SOURCE_ID = "ROUTE_LAYER_SOURCE_ID";
    private static final String DASHED_DIRECTIONS_LINE_LAYER_ID = "DASHED_DIRECTIONS_LINE_LAYER_ID";
    private static final List<LatLng> locations;

    static {
        locations = new ArrayList<>();
        locations.add(new LatLng(51.570807414969806, 8.105689080310754));
        locations.add(new LatLng(51.57167506092857, 8.105625516904789));
        locations.add(new LatLng(51.572130175199604, 8.104649160151135));
        locations.add(new LatLng(51.574524860140734, 8.104575702919684));
        locations.add(new LatLng(51.57683195700199, 8.103340406611443));
    }

    private MapView mapView;
    private SymbolManager symbolManager;
    private MapboxMap mapboxMap;

    public NavigationFragment() {
        super(R.layout.navigation_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = view.findViewById(R.id.mapView);
        setupMap(mapView, savedInstanceState);
    }



    private void setupMap(MapView mapView, Bundle savedInstanceState) {
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(mapboxMap -> {
            mapboxMap.setStyle(new Style.Builder().fromUri(getString(R.string.map_view_style_url)), style -> {
                symbolManager = new SymbolManager(mapView, mapboxMap, style);
                this.mapboxMap = mapboxMap;
                addPinIcon(style);
                addRouteLayer(style);
                showLocations();
            });
        });
    }

    private void addRouteLayer(Style style) {
        style.addSource(new GeoJsonSource(ROUTE_LAYER_SOURCE_ID));
        style.addLayer(new LineLayer(DASHED_DIRECTIONS_LINE_LAYER_ID, ROUTE_LAYER_SOURCE_ID)
                .withProperties(
                        PropertyFactory.lineWidth(3f),
                        PropertyFactory.lineJoin(Property.LINE_JOIN_ROUND)
                ));
    }

    private void addPinIcon(Style style) {
        style.addImage(PIN_ICON, BitmapUtils.getBitmapFromDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_new_location, null)), true);
    }

    private void showLocations() {
        List<SymbolOptions> symbolOptionsList = new ArrayList<>();

        for (LatLng latLng : locations) {
            symbolOptionsList.add(new SymbolOptions().withLatLng(latLng).withIconImage(PIN_ICON));
        }

        symbolManager.setIconAllowOverlap(true);
        symbolManager.create(symbolOptionsList);

        LatLngBounds latLngBounds = new LatLngBounds.Builder().includes(locations).build();
        mapboxMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 100));
    }


    /*
     * Activity lifecycle methods
     */
    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mapboxMap != null) {
            mapView.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
