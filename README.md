# Naivgation Android with MapLibre
Fork of the flitsmeister-navigation-android with the following changes:
* We added the navigation-ui
* Migrated from Mapbox to [MapLibre](https://github.com/maplibre/maplibre-gl-native)

# Getting started

1. Configure the base_url by your own directions API service (self hosted or for example GraphHopper)
```xml
<string name="base_url" translatable="false">https://graphhopper.com/api/1/navigate/</string>
```

2. Configure the map_view_style_url by your own tiles API service (self hosted or for example MapTiler)
```xml
<string name="base_url" translatable="false">https://api.maptiler.com/maps/streets/style.json?key=YOUR_MAP_TILER_API_KEY</string>
```

# License

[100% MIT License](LICENSE)


