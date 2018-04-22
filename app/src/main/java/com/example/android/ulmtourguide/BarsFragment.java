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

public class BarsFragment extends Fragment {

    public BarsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        //define the ArrayList of locations
        final ArrayList<Destination> locations = new ArrayList<Destination>();
        //add locations to the array
        locations.add (new Destination( "Xinedome", "City", "Cocktails"));
        locations.add (new Destination( "Wilder Mann", "Fischerviertel", "Bar"));
        locations.add (new Destination( "Besitos", "City", "Cocktails"));
        locations.add (new Destination( "Murphys Law", "City", "Pub"));
        locations.add (new Destination( "Trödler Abraham", "Fischerviertel", "Cocktails"));
        locations.add (new Destination( "Glashaus", "City", "Cafe"));
        locations.add (new Destination( "Fräulein Lecker", "City", "Wein"));
        locations.add (new Destination( "Beckers", "Fischerviertel", "Cocktails"));

        //initialize the adapter and connect it with the listview
        LocationsAdapter itemsAdapter = new LocationsAdapter(getActivity(), locations, R.color.category_bars);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //define the OnClickListener on the listView
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //put details into the intent:
                //1. the clicked position
                //2. the whole array
                Bundle details=new Bundle();
                details.putInt("pos",position);
                details.putSerializable("locations", locations);
                Intent a = new Intent(getActivity(), BarsActivity.class);
                a.putExtras(details);
                startActivity(a);
            }
        });
        return rootView;
    }
}
