package pl.bsjhx.katas.intervals;

import java.util.Comparator;
import java.util.List;

class CanAttendMeetings {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (null == intervals || intervals.size() < 2) {
            return true;
        }

        intervals.sort(Comparator.comparingInt(o -> o.start));

        Interval prevInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (prevInterval.end > intervals.get(i).start) {
                return false;
            }
            prevInterval = intervals.get(i);
        }

        return true;
    }
}
