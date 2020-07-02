package Widget;

import android.content.Context;
import android.content.Intent;
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
    ArrayList<Announcement> announcements = new ArrayList<>();
Context context;
Intent intent;
boolean loading=true;
    public AnnouncementViewFactory(Context context, Intent intent) {
        this.context=context;
        this.intent=intent;
    }

    private void getData(){
        FirebaseFirestore.getInstance().collection("Announcements").orderBy("SortTimeStamp", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    //error
                }
                Log.i("AnnouncementViewFactory","GettingData");
                announcements.clear();
                for (DocumentSnapshot d:queryDocumentSnapshots){
                    announcements.add(new com.samuelford48gmail.campnavigateandroid.Announcement((String)d.get("announcement"),(String)d.get("timeStamp")));


                }

            }

        });
        loading=false;
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

        Log.i("AnnouncementViewFactory", String.valueOf(announcements.size()));
        return announcements.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widgetlv_item);
        remoteViews.setTextViewText(R.id.textView3, announcements.get(i).getAnnouncement());
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
