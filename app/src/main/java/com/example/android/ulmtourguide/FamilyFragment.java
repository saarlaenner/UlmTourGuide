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
        locations.add(new Destination(getString(R.string.friedrichsau), getString(R.string.outer_city), getString(R.string.nature)));
        locations.add(new Destination(getString(R.string.donaubad), getString(R.string.neu_ulm), getString(R.string.sport)));
        locations.add(new Destination(getString(R.string.boulderhalle), getString(R.string.soeflingen), getString(R.string.sport)));
        locations.add(new Destination(getString(R.string.munster), getString(R.string.city), getString(R.string.history)));
        locations.add(new Destination(getString(R.string.brotmuseum), getString(R.string.city), getString(R.string.history)));
        locations.add(new Destination(getString(R.string.spielplatz_karlsplatz), getString(R.string.city), getString(R.string.fun)));
        locations.add(new Destination(getString(R.string.tiergarten), getString(R.string.outer_city), getString(R.string.nature)));
        locations.add(new Destination(getString(R.string.blautopf), getString(R.string.blaubeuren), getString(R.string.nature)));

        LocationsAdapter locationItemsAdapter = new LocationsAdapter(getActivity(), locations, R.color.category_family);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(locationItemsAdapter);

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //put details into the intent:
                //1. the clicked position
                //2. the whole array
                Bundle details = new Bundle();
                details.putInt("pos", position);
                details.putSerializable("locations", locations);
                Intent familyDetailsActivity = new Intent(getActivity(), FamilyActivity.class);
                familyDetailsActivity.putExtras(details);
                startActivity(familyDetailsActivity);
            }
        });
        return rootView;
    }
}
