package com.yorkyu.fragmentlifedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.yorkyu.fragmentlifedemo.R;
import com.yorkyu.fragmentlifedemo.fragment.AFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";
    @BindView(R.id.fl_content)
    FrameLayout mFlContent;
    private AFragment mAFragment;
    private FragmentManager mSupportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Log.d(TAG, "onCreate: ");

        initView();
    }

    private void initView() {
        mAFragment = AFragment.newInstance();
        mSupportFragmentManager = getSupportFragmentManager();
        FragmentManager supportFragmentManager = mSupportFragmentManager;
        mSupportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_content, mAFragment)
                .addToBackStack(null)
                .commit();

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: backstack num = " + mSupportFragmentManager.getBackStackEntryCount());
        for (int i = 0; i < mSupportFragmentManager.getBackStackEntryCount(); i++) {
            mSupportFragmentManager.popBackStackImmediate();
        }
        Log.d(TAG, "onSaveInstanceState: backstack num = " + mSupportFragmentManager.getBackStackEntryCount());

        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
    }


    public static void start(Context context) {
        Intent starter = new Intent(context, DetailActivity.class);
        context.startActivity(starter);
    }
}
