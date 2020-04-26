package com.samuelford48gmail.campnavigateandroid;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    final Fragment fragment1 = new fragment_home();
    final Fragment fragment2 = new fragment_announcements();
    final Fragment fragment3 = new fragment_pictures();
    final Fragment fragment4 = new fragment_staff();
    final Fragment fragment5 = new fragment_more();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fm.beginTransaction().add(R.id.main_container, fragment5, "5").hide(fragment5).commit();
        fm.beginTransaction().add(R.id.main_container, fragment4, "4").hide(fragment4).commit();
       fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_container, fragment1, "1").commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    // mTextMessage.setText(R.string.title_home);
                    fm.beginTransaction().hide(active).show(fragment1).commit();

                    active = fragment1;
                    fm.popBackStack();
                    return true;
                case R.id.navigation_dashboard:
                    // mTextMessage.setText(R.string.title_dashboard);
                    fm.beginTransaction().hide(active).show(fragment2).commit();
                    active = fragment2;
                    fm.popBackStack();
                    return true;
                case R.id.pictures:
                    //mTextMessage.setText(R.string.title_notifications);
                    fm.beginTransaction().hide(active).show(fragment3).commit();
                    active = fragment3;
                    fm.popBackStack();
                    return true;
                    case R.id.staff:
                    //mTextMessage.setText(R.string.title_notifications);
                    fm.beginTransaction().hide(active).show(fragment4).commit();
                    active = fragment4;
                    fm.popBackStack();
                    return true;
                case R.id.more:
                    //mTextMessage.setText(R.string.title_notifications);
                    fm.beginTransaction().hide(active).show(fragment5).commit();
                    active = fragment5;
                    fm.popBackStack();
                    return true;

            }
            return false;
        }
    };
}
