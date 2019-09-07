package com.example.testuiapp;

import com.example.testuiapp.utils.ViewAnimation;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.widget.NestedScrollView;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.testuiapp.utils.Tools;

public class MainActivity extends AppCompatActivity {
    private View parent_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initComponent();

    }
    private void initToolbar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);;
//        toolbar.setNavigationIcon(R.drawable.ic_menu);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        Tools.setSystemBarColor(this);
    }

    private void initComponent() {
        parent_view = (View) findViewById(R.id.main_content);

        // display image
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_1), R.drawable.image_8);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_2), R.drawable.image_9);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_3), R.drawable.image_15);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_4), R.drawable.image_14);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_5), R.drawable.image_12);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_6), R.drawable.image_2);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_7), R.drawable.image_5);
    }
    public void onButtonTabClick(View v) {
        String title = ((Button) v).getText().toString();
        title = Tools.toCamelCase(title);
        switch (v.getId()) {
            case R.id.tab_home:
                Snackbar.make(parent_view, title, Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.tab_top_artists:
                Snackbar.make(parent_view, title, Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.tab_top_albums:
                Snackbar.make(parent_view, title, Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.tab_new_releases:
                Snackbar.make(parent_view, title, Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.tab_top_songs:
                Snackbar.make(parent_view, title, Snackbar.LENGTH_SHORT).show();
                break;
        }
        getSupportActionBar().setTitle(title);
        ViewAnimation.fadeOutIn(((NestedScrollView)findViewById(R.id.nested_content)));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
//            finish();
            Toast.makeText(getApplicationContext(), "Navigation Drawer appears here", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
