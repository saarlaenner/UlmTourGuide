package com.example.android.ulmtourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Daniel on 15.04.2018.
 */

public class FamilyFragment extends Fragment {

    public FamilyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Destination> locations = new ArrayList<Destination>();
        locations.add(new Destination("Friedrichsau", "Outer City", "Nature"));
        locations.add(new Destination("Donaubad", "Neu-Ulm", "Sport"));
        locations.add(new Destination("Boulderhalle", "Söflingen", "Sport"));
        locations.add(new Destination("Munster", "City", "History"));
        locations.add(new Destination("Brotmuseum", "City", "History"));
        locations.add(new Destination("Spielplatz Karlsplatz", "City", "Fun"));
        locations.add(new Destination("Tiergarten", "Outer City", "Nature"));
        locations.add(new Destination("Blautopf", "Blaubeuren", "Nature"));

        LocationsAdapter itemsAdapter = new LocationsAdapter(getActivity(), locations, R.color.category_family);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Destination location = locations.get(position);
                Bundle details = new Bundle();
                details.putInt("pos", position);
                details.putSerializable("locations", locations);
                Intent a = new Intent(getActivity(), FamilyActivity.class);
                a.putExtras(details);
                startActivity(a);
            }
        });
        return rootView;
    }
}
