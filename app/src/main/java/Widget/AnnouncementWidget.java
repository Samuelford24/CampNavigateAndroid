package Widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.RemoteViews;

import com.samuelford48gmail.campnavigateandroid.MainActivity;
import com.samuelford48gmail.campnavigateandroid.R;

/**
 * Implementation of App Widget functionality.
 */
public class AnnouncementWidget extends AppWidgetProvider {
    // WIDGET_BUTTON
    public static String WIDGETBUTTON = "com.samuelford48gmail.campnavigateandroid.Widget.WIDGET_BUTTON";
    ImageButton imageButton;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        appWidgetManager.updateAppWidget(appWidgetId, getView(context));
    }

    public static void updateAnnouncementWidgets(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    private static RemoteViews getView(Context context) {
        ///    CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.announcement);
        // views.setTextViewText(R.id.appwidget_text, widgetText);
        Intent intent = new Intent(context, AnnouncementWidgetService.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setPendingIntentTemplate(R.id.widgetLV, pendingIntent);
        Intent intent2 = new Intent(WIDGETBUTTON);
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(context, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.reload, pendingIntent2);
        views.setRemoteAdapter(R.id.widgetLV, intent);


        // Instruct the widget manager to update the widget
        // appWidgetManager.updateAppWidget(appWidgetId, views);
        return views;
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //Start the intent service update widget action, the service takes care of updating the widgets UI
        AnnouncementService.startReloadService(context);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.i("onReceive", "Received");
        if (WIDGETBUTTON.equals(intent.getAction())) {
            AnnouncementService.startReloadService(context);
//your code here

        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

