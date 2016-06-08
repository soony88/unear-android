package monash.kuyumcians.unear.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import monash.kuyumcians.unear.Models.SearchFilter;
import monash.kuyumcians.unear.Models.UnearEvent;

/**
 * Created by kuyumcians on 7/06/2016.
 */
public class EventUtils {

    public static UnearEvent convertMapToEvent(Map<String, String> map) {
        long id = Long.parseLong(map.get("id"));
        String name = map.get("name");
        String campus = map.get("campus");
        double latitude = Double.parseDouble(map.get("latitude"));
        double longitude = Double.parseDouble(map.get("longitude"));
        Date startDate = DateUtils.stringToDate(map.get("startDate"));
        Date endDate = DateUtils.stringToDate(map.get("endDate"));
        String description = map.get("description");

        UnearEvent event = new UnearEvent(id, name, campus, latitude, longitude, startDate, endDate, "type", description);
        return event;
    }

    public static void updateEventsList(ArrayList<UnearEvent> events, SearchFilter sf) {

    }
}