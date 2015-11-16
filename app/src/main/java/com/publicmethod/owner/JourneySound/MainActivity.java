package com.publicmethod.owner.JourneySound;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private CollapsingToolbarLayout mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_Toolbar);

    private FloatingActionButton mFab = (FloatingActionButton) findViewById(R.id.fab);

    private View.OnClickListener mOnClickListener;

    private ImageButton mEmailButton, mOpenInFacebookButton,
            mOpenInTwitterButton, mOpenInInstagramButton,
            mOpenInLinkedInButton;

    private Button mShareButton;

    private String mFacebookLink, mTwitterLink,
            mInstagramLink, mLinkedInLink, mPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStrings();

        setupToolbar();

        setUpListener();

        setupFab();

        setupCollapsingToolbar();

        SetUpButtons();


    }

    private void getStrings() {
        mFacebookLink = getString(R.string.JourneySound_Facebook_Link);
        mTwitterLink = getString(R.string.JourneySound_Twitter_Link);
        mInstagramLink = getString(R.string.JourneySound_Instagram_Link);
        mLinkedInLink = getString(R.string.JourneySound_LinkedIn_Link);
        mPhoneNumber = getString(R.string.JourneySound_phoneNumber);
    }

    private void setUpListener() {
        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.fab:
                        callJourneySound();
                        break;

                    case R.id.button_image_email:
                        sendEmail();
                        break;

                    case R.id.button_image_facebook:
                        openLink(mFacebookLink);
                        break;

                    case R.id.button_image_twitter:
                        openLink(mTwitterLink);
                        break;

                    case R.id.button_image_instagram:
                        openLink(mInstagramLink);
                        break;

                    case R.id.button_image_linkedIn:
                        openLink(mLinkedInLink);
                        break;

                    case R.id.button_share:
                        sharePlayStoreLink(getString(R.string.play_store_link_bitly));
                        break;


                }

            }
        };
    }

    private void callJourneySound() {
        Intent intent = new Intent(Intent.ACTION_DIAL);

        intent.setData(Uri.parse("tel:" + mPhoneNumber));
        startActivity(intent);
    }


    private void setupCollapsingToolbar() {
        mCollapsingToolbar.setTitle(getString(R.string.app_name));
    }


    private void setupFab() {
        mFab.setOnClickListener(mOnClickListener);
    }

    private void SetUpButtons() {

        mEmailButton = (ImageButton) findViewById(R.id.button_image_email);
        mEmailButton.setOnClickListener(mOnClickListener);


        mOpenInFacebookButton = (ImageButton) findViewById(R.id.button_image_facebook);
        mOpenInFacebookButton.setOnClickListener(mOnClickListener);


        mOpenInTwitterButton = (ImageButton) findViewById(R.id.button_image_twitter);
        mOpenInTwitterButton.setOnClickListener(mOnClickListener);

        mOpenInInstagramButton = (ImageButton) findViewById(R.id.button_image_instagram);
        mOpenInInstagramButton.setOnClickListener(mOnClickListener);

        mOpenInLinkedInButton = (ImageButton) findViewById(R.id.button_image_linkedIn);
        mOpenInLinkedInButton.setOnClickListener(mOnClickListener);

        mShareButton = (Button) findViewById(R.id.button_share);
        mShareButton.setOnClickListener(mOnClickListener);
    }

    public void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        Show menu icon
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
    }

    private void sharePlayStoreLink(String playStoreLink) {

        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, playStoreLink);

        try {
            startActivity(Intent.createChooser(sendIntent, getString(R.string.chooser_title_playstore)));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, R.string.Error_message_no_application, Toast.LENGTH_SHORT).show();
        }


    }

    public void sendEmail() {

        String[] TO = {getString(R.string.JourneySound_Email)};
        String[] CC = {""};

        Intent sendEmailIntent = new Intent(Intent.ACTION_SEND);

        sendEmailIntent.setData(Uri.parse(getString(R.string.mailTo)));
        sendEmailIntent.setType(getString(R.string.data_type_mime));
        sendEmailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        sendEmailIntent.putExtra(Intent.EXTRA_CC, CC);
        sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
        sendEmailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(sendEmailIntent, getString(R.string.chooser_title_email)));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, R.string.Error_message_email, Toast.LENGTH_SHORT).show();
        }
    }

    public void openLink(String url) {

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse(url));

        try {
            startActivity(Intent.createChooser(sendIntent, getString(R.string.Open_link_chooser_title)));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, R.string.Error_message_no_application, Toast.LENGTH_SHORT).show();
        }
    }
}
