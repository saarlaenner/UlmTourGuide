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
        locations.add (new Destination( "Zur Brezel", "City", "Bavarian"));
        locations.add (new Destination( "Hacker Pschorr", "City", "Bavarian"));
        locations.add (new Destination( "Sushi Lounge", "City", "Sushi"));
        locations.add (new Destination( "Peppers", "City", "Mexican"));
        locations.add (new Destination( "SWU Kantine", "City", "Mixed"));
        locations.add (new Destination( "Damn Burger", "City", "Burger"));
        locations.add (new Destination( "Fräulein Lecker", "City", "German"));
        locations.add (new Destination( "Wilder Mann", "Fischerviertel", "German"));

        LocationsAdapter itemsAdapter = new LocationsAdapter(getActivity(), locations, R.color.category_restaurants);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Destination location = locations.get(position);
                Bundle details=new Bundle();
                details.putInt("pos",position);
                details.putSerializable("locations", locations);
                Intent a = new Intent(getActivity(), RestaurantsActivity.class);
                a.putExtras(details);
                startActivity(a);
            }
        });
        return rootView;
    }
}
