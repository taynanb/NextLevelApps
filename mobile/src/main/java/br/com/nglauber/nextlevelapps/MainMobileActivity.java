package br.com.nglauber.nextlevelapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainMobileActivity extends ActionBarActivity {

    private static final int NOTIFICATION_SIMPLE = 0;
    private static final int NOTIFICATION_ACTION = 1;
    private static final int NOTIFICATION_STACKED = 2;
    private static final int NOTIFICATION_PAGES = 3;
    private static final int NOTIFICATION_VOICE_REPLY = 4;
    private static final int SYNC = 5;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mobile);

        mListView = (ListView)findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.notificacoes)));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                handleItemClick(position);
            }
        });
    }

    private void handleItemClick(int position) {
        switch (position){
            case NOTIFICATION_SIMPLE:
                NotificationUtils.simpleNotification(this);
                break;
            case NOTIFICATION_ACTION:
                NotificationUtils.notificationWithAction(this, false);
                break;
            case NOTIFICATION_STACKED:
                NotificationUtils.stackedNotification(this);
                break;
            case NOTIFICATION_PAGES:
                NotificationUtils.notificationWithPages(this);
                break;
            case NOTIFICATION_VOICE_REPLY:
                NotificationUtils.notificationWithVoiceReply(this);
                break;
            case SYNC:
                startActivity(new Intent(this, SyncActivity.class));
                break;
        }
    }

}
