package com.example.bug;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.bug.util.Bug70192Util.getUsageInLiters;

/**
 * Replicates the android studio bug at http://b.android.com/70192
 *
 * the bug will not be shown until the code analysis is completed, so either
 * enable inspections or run it.
 */
public class Bug70192Activity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug70192);

        final TextView usage = (TextView) findViewById(R.id.bug70192_usage);
        setStats(this, usage);
    }

    private static void setStats(final Context context, final TextView usage) {
        usage.setText(context.getString(R.string.bug70192_usage_stats,
                getUsageInLiters(135445))); // line of lint error
    }


}
