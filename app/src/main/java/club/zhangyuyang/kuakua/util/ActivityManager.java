package club.zhangyuyang.kuakua.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-13 下午4:59
 * @FileName : ActivityManager
 * Content   : TODO
 * Other     :
 */
public class ActivityManager {

    private static List<Activity> sActivityList = new ArrayList<>();

    public static void add(Activity activity) {
        sActivityList.add(activity);
    }

    public static void remove(Activity activity) {
        sActivityList.remove(activity);
    }

    public static void closeAllActivities() {
        for (Activity activity : sActivityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
