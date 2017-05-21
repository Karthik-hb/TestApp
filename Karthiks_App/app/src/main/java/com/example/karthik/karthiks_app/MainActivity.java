package com.example.karthik.karthiks_app;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("HOME");
        FragmentNaviDrw drawerFragment = (FragmentNaviDrw) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.main_content), toolbar);
        drawerFragment.setDrawerListener(MainActivity.this);


        VideoPagerAdapter videoPagerAdapter = new VideoPagerAdapter(getSupportFragmentManager());
        ViewPager mVideoViewPager = (ViewPager) findViewById(R.id.videocontainer);

        mVideoViewPager.setOffscreenPageLimit(0);
        mVideoViewPager.setAdapter(videoPagerAdapter);
        TabLayout tabVideoLayout = (TabLayout) findViewById(R.id.videodots);
        tabVideoLayout.setupWithViewPager(mVideoViewPager);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.videoiconbg);
        tabLayout.getTabAt(1).setIcon(R.drawable.imageiconbg);
        tabLayout.getTabAt(2).setIcon(R.drawable.milestoniconbg);

    }


    //content
    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            ArrayList<DataModel> data = new ArrayList<>();
            data.add(new DataModel("Em.ptiness FT.justin Tiblekar", "Lorem ipsum is simple dummy test of printig sng typsetting industy", "10 Hours Ago", R.drawable.imgone));
            data.add(new DataModel("Em.ptiness FT.justin Tiblekar", "Lorem ipsum is simple dummy test of printig sng typsetting industy", "15 Hours Ago", R.drawable.imgtow));
            data.add(new DataModel("Em.ptiness FT.justin Tiblekar", "Lorem ipsum is simple dummy test of printig sng typsetting industy", "08 Hours Ago", R.drawable.imgthree));
            data.add(new DataModel("Em.ptiness FT.justin Tiblekar", "Lorem ipsum is simple dummy test of printig sng typsetting industy", "18 Hours Ago", R.drawable.imgone));
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleView);

            HomeRecycleAdapter adapter = new HomeRecycleAdapter(getActivity().getApplicationContext(), data);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "VIDEOS";
                case 1:
                    return "IMAGES";
                case 2:
                    return "MILESTONE";
            }
            return null;
        }
    }


    //video
    public static class PlaceholdervVideoFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";
        private ProgressBar pDialog;
        private VideoView videoView;
        static int count = 0;
        private ImageView playButton;

        public PlaceholdervVideoFragment() {
        }

        public static PlaceholdervVideoFragment newInstance(int sectionNumber) {
            PlaceholdervVideoFragment fragment = new PlaceholdervVideoFragment();
            count = sectionNumber;
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            Log.v("mainactivity" + count, "onCreateView");

            View rootView = inflater.inflate(R.layout.videofragment, container, false);
            videoView = (VideoView) rootView.findViewById(R.id.videoView);
            pDialog = (ProgressBar) rootView.findViewById(R.id.prograssbar);
            playButton = (ImageView) rootView.findViewById(R.id.playbutton);
            pDialog.setIndeterminate(false);
            return rootView;
        }


        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            Log.v("mainactivity" + count, "onActivityCreated");

        }


        @Override
        public void onResume() {
            super.onResume();
            Log.v("mainactivity" + count, "onResume");
           /* try {
                MediaController mediacontroller = new MediaController(
                        getActivity());

                mediacontroller.setKeepScreenOn(false);
                mediacontroller.setAnchorView(videoView);
           */
            Uri uri = Uri.parse("http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
            videoView.setVideoURI(uri);
           /* } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
           */ //videoView.requestFocus();


            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    videoView.start();
                }
            });

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    pDialog.setVisibility(View.GONE);
                    playButton.setClickable(true);
                    Log.v("mainactivity" + count, "playing");
                }
            });

        }

        @Override
        public void onPause() {
            super.onPause();
            Log.v("mainactivity" + count, "onPause");
            videoView.pause();
        }


    }

    public class VideoPagerAdapter extends FragmentPagerAdapter {

        public VideoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholdervVideoFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }


    }


}
