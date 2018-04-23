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
        locations.add (new Destination( getString(R.string.xinedome), getString(R.string.city), getString(R.string.cocktails)));
        locations.add (new Destination( getString(R.string.wilder_mann), getString(R.string.fischerviertel), getString(R.string.bar)));
        locations.add (new Destination( getString(R.string.besitos), getString(R.string.city), getString(R.string.cocktails)));
        locations.add (new Destination( getString(R.string.murphys_law), getString(R.string.city), getString(R.string.pub)));
        locations.add (new Destination( getString(R.string.troedler_abraham), getString(R.string.fischerviertel), getString(R.string.cocktails)));
        locations.add (new Destination( getString(R.string.glashaus), getString(R.string.city), getString(R.string.cafe)));
        locations.add (new Destination( getString(R.string.fraeulein_lecker), getString(R.string.city), getString(R.string.wein)));
        locations.add (new Destination( getString(R.string.beckers), getString(R.string.fischerviertel), getString(R.string.cocktails)));

        //initialize the adapter and connect it with the listview
        LocationsAdapter locationItemsAdapter = new LocationsAdapter(getActivity(), locations, R.color.category_bars);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(locationItemsAdapter);

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
                Intent barDetailsActivity = new Intent(getActivity(), BarsActivity.class);
                barDetailsActivity.putExtras(details);
                startActivity(barDetailsActivity);
            }
        });
        return rootView;
    }
}