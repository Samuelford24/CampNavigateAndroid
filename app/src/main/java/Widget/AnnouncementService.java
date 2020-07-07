package Widget;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.samuelford48gmail.campnavigateandroid.Announcement;
import com.samuelford48gmail.campnavigateandroid.R;

import java.util.ArrayList;

public class AnnouncementService extends IntentService {
    // public final static String ACTION_RELOAD_ANNOUNCEMENTS = "com.samuelford48gmail.campnavigateandroid.Widget.reload_announcements";
    public final static String ACTION_UPDATE_LISTVIEW = "com.samuelford48gmail.campnavigateandroid.Widget.update_lv";
    ArrayList<Announcement> announcements;

    public AnnouncementService() {
        super("com.samuelford48gmail.campnavigateandroid.Widget.AnnouncementService");

    }


    public static void startupdateListView(Context context) {
        Log.i("startupdateListView", "received");
        Intent intent = new Intent(context, AnnouncementService.class);
        intent.setAction(ACTION_UPDATE_LISTVIEW);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("onHandleIntent", "Received");
        if (intent.getAction().equals(ACTION_UPDATE_LISTVIEW)) {
            Log.i("onHandleIntent", "Got Action");
            updateListView();
        }
    }

    private void updateListView() {
        Log.i("updateListView", "Received");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, AnnouncementWidget.class));
        //Trigger data update to handle the GridView widgets and force a data refresh
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widgetLV);
        //Now update all widgets
        AnnouncementWidget.updateAnnouncementWidgets(this, appWidgetManager, appWidgetIds);

    }


}
