package com.example.user.runtrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by user on 27/12/2016.
 */
public class RunsAdapter extends ArrayAdapter<Run>{
    public RunsAdapter(Context context, ArrayList<Run> runs){
        super(context, 0, runs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Run run = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_run, parent, false);
        }
        TextView runTitle = (TextView)convertView.findViewById(R.id.runTitle);
        TextView runDistance = (TextView)convertView.findViewById(R.id.runDistance);

        runTitle.setText(run.getRunTitle());
        runDistance.setText("" + run.getDistance());
        return convertView;
    }
}
