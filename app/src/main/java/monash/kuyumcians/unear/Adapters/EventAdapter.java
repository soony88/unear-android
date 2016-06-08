package monash.kuyumcians.unear.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import monash.kuyumcians.unear.Models.UnearEvent;
import monash.kuyumcians.unear.R;
import monash.kuyumcians.unear.Utils.DateUtils;

/**
 * Created by kuyumcians on 12/05/2016.
 */
public class EventAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<UnearEvent> events;

    public EventAdapter(Context context, ArrayList<UnearEvent> events) {
        this.context = context;
        this.events = events;
    }

    public static class ViewHolder {
        TextView eventName;
        TextView eventDate;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public UnearEvent getItem(int i) {
        return events.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh;

        // Check of view has been created for the row, if not we inflate it.
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // Reference list item layout here
            view = inflater.inflate(R.layout.list_event_result_item, null);

            // Setup ViewHolder and attach to view
            vh = new ViewHolder();
            vh.eventName = (TextView) view.findViewById(R.id.labelEventName);
            vh.eventDate = (TextView) view.findViewById(R.id.labelDateRange);
            view.setTag(vh);
        } else {
            // View has already been created, fetch our ViewHolder
            vh = (ViewHolder) view.getTag();
        }

        vh.eventName.setText(events.get(i).getEventName());

        String stringStartDate = DateUtils.dateToString(events.get(i).getStartDate());
        long diff = events.get(i).getEndDate().getTime() - events.get(i).getStartDate().getTime();
        String diffHours = Long.toString(diff / (60 * 60 * 1000));
        vh.eventDate.setText(stringStartDate + " - " + diffHours + "hrs");

        // Allow "Save Event" button to work in a listview
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.list_event_result_item, viewGroup, false);
        Button saveEvent = (Button) row.findViewById(R.id.buttonSaveEvent);
        saveEvent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Firebase stuff goes here
                System.out.println("Pingers");
            }
        });

        return view;
    }
}
