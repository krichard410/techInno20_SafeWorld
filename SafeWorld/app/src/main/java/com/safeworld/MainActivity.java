package com.safeworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
/**
 * The MainActivity for hosting the fragment (news, course, posts, profile, upgrade)
 * @author nieruize
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        // instantiate the bottom navigation bar
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                new NewsFragment()).commit();
    }

    // control the bottom navigation function based on each specific cases
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_news:
                            openFragment(new NewsFragment());
                            break;
                        case R.id.navigation_courses:
                            openFragment(new CoursesFragment());
                            break;
                        case R.id.navigation_posts:
                            openFragment(new PostsFragment());
                            break;
                        case R.id.navigation_profile:
                            openFragment(new ProfileFragment());
                            break;
                        case R.id.navigation_upgrade:
                            openFragment(new UpgradeFragment());
                            break;
                    }
                    return true;
                }
            };

    // jump to specific page when user clicked
    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
