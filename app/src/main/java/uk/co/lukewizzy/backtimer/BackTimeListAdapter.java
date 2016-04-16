package uk.co.lukewizzy.backtimer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Calendar;
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
        String[] strs = getItem(position);

        ((TextView)rowView.findViewById(R.id.rowTimeLeft)).setText(strs[0]);
        ((TextView)rowView.findViewById(R.id.rowTimeMinus)).setText(strs[1]);

        Calendar cal = Calendar.getInstance();
        int mins = Integer.parseInt(strs[2]);
        int secs = Integer.parseInt(strs[3]);

        if (cal.get(Calendar.MINUTE) > mins || cal.get(Calendar.MINUTE) == mins && cal.get(Calendar.SECOND) >= secs) {
            rowView.findViewById(R.id.rowLayout).setBackgroundColor(Color.parseColor("#e8e8e8"));
        }

        return rowView;
    }
}