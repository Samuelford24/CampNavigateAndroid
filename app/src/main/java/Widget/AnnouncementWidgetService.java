package Widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class AnnouncementWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new AnnouncementViewFactory(getApplicationContext(),intent);
    }
}
