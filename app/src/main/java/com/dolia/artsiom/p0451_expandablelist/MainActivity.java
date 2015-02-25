package com.dolia.artsiom.p0451_expandablelist;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    // Groups names
    String[] groups = new String[] {"HTC", "Samsung", "LG"};

    // Elements names
    String[] phonesHTC = new String[] {"Sensation", "Desire", "Wildfire", "Hero"};
    String[] phonesSams = new String[] {"Galaxy S II", "Galaxy Nexus", "Wave"};
    String[] phonesLG = new String[] {"Optimus", "Optimus Link", "Optimus Black", "Optimus One"};

    // Groups list
    ArrayList<Map<String, String>> groupData;

    // Elements list
    ArrayList<Map<String, String>> childDataItem;

    // Entire list
    ArrayList<ArrayList<Map<String, String>>> childData;

    // The list of attributes
    Map<String, String> m;

    ExpandableListView elvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //fill the groups list from groups names
        groupData = new ArrayList<Map<String , String>>();

        for (String group : groups){
            m = new HashMap<String, String>();
            m.put("groupName", group);
            groupData.add(m);
        }

        //List of group attributes
        String groupFrom[] = new String[] {"groupName"};

        //List of elements ID to put attributes
        int groupTo[] = new int[] {android.R.id.text1};

        //List for lists of elements
        childData = new ArrayList<ArrayList<Map<String,String>>>();

        //Elements for 1st group
        childDataItem = new ArrayList<Map<String, String>>();

        //Fill attributes for each element
        for(String phone : phonesHTC){

            m = new HashMap<String , String >();
            m.put("phoneName", phone);
            childDataItem.add(m);
        }

        //Add to the list of lists
        childData.add(childDataItem);

        //Elements for 2nd group
        childDataItem = new ArrayList<Map<String, String>>();

        //Fill attributes for each element
        for(String phone : phonesSams){

            m = new HashMap<String , String >();
            m.put("phoneName", phone);
            childDataItem.add(m);
        }

        //Add to the list of lists
        childData.add(childDataItem);

        //Elements for 3rd group
        childDataItem = new ArrayList<Map<String, String>>();

        //Fill attributes for each element
        for(String phone : phonesLG){

            m = new HashMap<String , String >();
            m.put("phoneName", phone);
            childDataItem.add(m);
        }

        //Add to the list of lists
        childData.add(childDataItem);

        //List of attributes
        String childFrom[] = new String[] {"phoneName"};

        //list of elements ID to put attributes
        int childTo[] = new int[] {android.R.id.text1};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom,
                groupTo,
                childData,
                android.R.layout.simple_list_item_1,
                childFrom,
                childTo
        );

        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(adapter);
    }
}
