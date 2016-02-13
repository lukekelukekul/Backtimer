package uk.co.lukewizzy.backtimer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Luke on 11/02/2016.
 */
public class BackTimeListAdapter extends ArrayAdapter<String[]> {

    public BackTimeListAdapter(Context context, List<String[]> times) {
        super(context, R.layout.row_time, times);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = LayoutInflater.from(getContext()).inflate(R.layout.row_time, parent, false);

        ((TextView)rowView.findViewById(R.id.rowTimeLeft)).setText(getItem(position)[0]);
        ((TextView)rowView.findViewById(R.id.rowTimeMinus)).setText(getItem(position)[1]);

        return rowView;
    }
}