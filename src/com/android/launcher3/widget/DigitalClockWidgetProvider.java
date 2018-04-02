package com.android.launcher3.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextClock;

import com.android.launcher3.R;

public class DigitalClockWidgetProvider extends AppWidgetProvider {
    private Context context = null;

    @Override
    public void onUpdate( Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds ) {
        this.context = context;

        final int N = appWidgetIds.length;
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];
            int color = context.getSharedPreferences("" + appWidgetId, Context.MODE_PRIVATE).getInt("color", Color.WHITE);
            updateAppWidget(context, appWidgetManager, appWidgetId, color);
        }
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId, int color) {

        // Construct the RemoteViews object.  It takes the package name (in our case, it's our
        // package, but it needs this because on the other side it's the widget host inflating
        // the layout from our package).
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.digital_clock_widget);
        /*TextClock tc = new TextClock(context);
        String clockText = tc.getText().toString();
        views.setTextViewText(R.id.textClockText, clockText);*/
        views.setTextColor(R.id.textClockText, color);

        // Tell the widget manager
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}
