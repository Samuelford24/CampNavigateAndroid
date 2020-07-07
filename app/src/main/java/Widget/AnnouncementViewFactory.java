package Widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.samuelford48gmail.campnavigateandroid.Announcement;
import com.samuelford48gmail.campnavigateandroid.R;

import java.util.ArrayList;

class AnnouncementViewFactory implements RemoteViewsService.RemoteViewsFactory {
    //  ArrayList<Announcement> announcements = new ArrayList<>();
    String[] announcementArray;
    Context context;
    Intent intent;
    boolean loading = true;

    public AnnouncementViewFactory(Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
    }

    private void getData() {
        Log.i("View Factory", "getData");
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.announcements), Context.MODE_PRIVATE);
        String temp = sharedPreferences.getString(context.getString(R.string.announcements), "");
        Log.i("View Factory", temp);

        announcementArray = temp.split(",");

    }
    @Override
    public void onCreate() {
getData();
    }

    @Override
    public void onDataSetChanged() {
getData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {

        Log.i("AnnouncementViewFactory", String.valueOf(announcementArray.length));
        return announcementArray.length;
    }

    @Override
    public RemoteViews getViewAt(int i) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widgetlv_item);
        remoteViews.setTextViewText(R.id.textView3, announcementArray[i]);
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
