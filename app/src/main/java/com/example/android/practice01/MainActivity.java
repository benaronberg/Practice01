package com.example.android.practice01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mFriendsList;
    private TextView mShowsIWatch;
    private TextView mShowsFriendsWatch;
    private TextView mShowsFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        // I Watch Tab
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab_i_watch);
        spec.setIndicator("I Watch");
        host.addTab(spec);

        // Populate I Watch shows
        mShowsIWatch = (TextView) findViewById(R.id.shows_i_watch);
        String[] Shows_I_Watch = Shows.getShowsIWatch();
        for (String IWatch : Shows_I_Watch) {
            mShowsIWatch.append(IWatch + "\n\n");
        }


        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab_friends_watch);
        spec.setIndicator("Friends Watch");
        host.addTab(spec);

        // Populate Friends Watch shows
        mShowsFriendsWatch = (TextView) findViewById(R.id.shows_friends_watch);
        String[] Shows_Friends_Watch = Shows.getShowsFriendsWatch();
        for (String FriendsWatch : Shows_Friends_Watch) {
            mShowsFriendsWatch.append(FriendsWatch + "\n\n");
        }

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab_favorites);
        spec.setIndicator("Favorites");
        host.addTab(spec);

            // Populate Favorite shows
        mShowsFavorites = (TextView) findViewById(R.id.shows_favorites);
        String[] Shows_Favorites = Shows.getShowsFavorites();
        for (String Favorite : Shows_Favorites) {
            mShowsFavorites.append(Favorite + "\n\n");
        }

        // Populate Friends List
        mFriendsList = (TextView) findViewById(R.id.friends_list);
        String[] friendsList = Friends.getFriendsList();
        for (String friend : friendsList) {
            mFriendsList.append(friend + "\n\n\n");
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
