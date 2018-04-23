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

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Destination> locations = new ArrayList<Destination>();
        locations.add (new Destination( getString(R.string.zur_brezel), getString(R.string.city), getString(R.string.bavarian)));
        locations.add (new Destination( getString(R.string.hacker_pschorr), getString(R.string.city), getString(R.string.bavarian)));
        locations.add (new Destination( getString(R.string.sushi_lounge), getString(R.string.city), getString(R.string.sushi)));
        locations.add (new Destination( getString(R.string.peppers), getString(R.string.city), getString(R.string.mexican)));
        locations.add (new Destination( getString(R.string.swu_cantina), getString(R.string.city), getString(R.string.mixed)));
        locations.add (new Destination( getString(R.string.damn_burger), getString(R.string.city), getString(R.string.burger)));
        locations.add (new Destination( getString(R.string.fraeulein_lecker), getString(R.string.city), getString(R.string.german)));
        locations.add (new Destination( getString(R.string.wilder_mann), getString(R.string.fischerviertel), getString(R.string.german)));

        LocationsAdapter locationItemsAdapter = new LocationsAdapter(getActivity(), locations, R.color.category_restaurants);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(locationItemsAdapter);

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //put details into the intent:
                //1. the clicked position
                //2. the whole array
                Bundle details=new Bundle();
                details.putInt("pos",position);
                details.putSerializable("locations", locations);
                Intent restaurantsDetailActivity = new Intent(getActivity(), RestaurantsActivity.class);
                restaurantsDetailActivity.putExtras(details);
                startActivity(restaurantsDetailActivity);
            }
        });
        return rootView;
    }
}
