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
    public final static String ACTION_RELOAD_ANNOUNCEMENTS = "com.samuelford48gmail.campnavigateandroid.Widget.reload_announcements";
    public final static String ACTION_UPDATE_LISTVIEW = "com.samuelford48gmail.campnavigateandroid.Widget.update_lv";
    ArrayList<Announcement> announcements;

    public AnnouncementService(String name) {
        super(name);
    }

    public static void startReloadService(Context context) {
        Intent intent = new Intent(context, AnnouncementService.class);
        intent.setAction(ACTION_RELOAD_ANNOUNCEMENTS);

        context.startService(intent);

    }

    public static void startupdateListView(Context context) {
        Intent intent = new Intent(context, AnnouncementService.class);
        intent.setAction(ACTION_UPDATE_LISTVIEW);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent.getAction().equals(ACTION_RELOAD_ANNOUNCEMENTS)) {
            reloadAnnouncements();
        } else if (intent.getAction().equals(ACTION_UPDATE_LISTVIEW)) {
            updateListView();
        }
    }

    private void updateListView() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, AnnouncementWidget.class));
        //Trigger data update to handle the GridView widgets and force a data refresh
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widgetLV);
        //Now update all widgets
        AnnouncementWidget.updateAnnouncementWidgets(this, appWidgetManager, appWidgetIds);

    }


    private void reloadAnnouncements() {
        announcements = new ArrayList<>();
        FirebaseFirestore.getInstance().collection("Announcements").orderBy("SortTimeStamp", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    //error
                }
                announcements.clear();
                for (DocumentSnapshot d : queryDocumentSnapshots) {
                    announcements.add(new com.samuelford48gmail.campnavigateandroid.Announcement((String) d.get("announcement"), (String) d.get("timeStamp")));


                }

            }

        });
        startupdateListView(this);
    }
}
