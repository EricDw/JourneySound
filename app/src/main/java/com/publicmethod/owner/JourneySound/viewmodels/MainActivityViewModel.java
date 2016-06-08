package com.publicmethod.owner.JourneySound.viewmodels;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.BaseObservable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;

import com.publicmethod.owner.JourneySound.R;

/**
 * Created by Eric De Wildt on 2016-06-07.
 */

public class MainActivityViewModel extends BaseObservable {
    private Context mContext;

    private String mFacebookLink, mTwitterLink,
            mInstagramLink, mLinkedInLink, mPhoneNumber;


    public MainActivityViewModel(Context context) {
        mContext = context;
        mFacebookLink = context.getString(R.string.JourneySound_Facebook_Link);
        mTwitterLink = context.getString(R.string.JourneySound_Twitter_Link);
        mInstagramLink = context.getString(R.string.JourneySound_Instagram_Link);
        mLinkedInLink = context.getString(R.string.JourneySound_LinkedIn_Link);
        mPhoneNumber = context.getString(R.string.JourneySound_phoneNumber);
    }

    public void callJourneySound(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);

        intent.setData(Uri.parse("tel:" + mPhoneNumber));
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mContext.startActivity(intent);
    }

    public void sharePlayStoreLink(View view) {

        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, mContext.getString(R.string.play_store_link_bitly));

        try {
            mContext.startActivity(Intent.createChooser(sendIntent, mContext.getString(R.string.chooser_title_playstore)));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext, R.string.Error_message_no_application, Toast.LENGTH_SHORT).show();
        }


    }

    public void sendEmail(View view) {

        String[] TO = {view.getContext().getString(R.string.JourneySound_Email)};
        String[] CC = {""};

        Intent sendEmailIntent = new Intent(Intent.ACTION_SEND);

        sendEmailIntent.setData(Uri.parse(view.getContext().getString(R.string.mailTo)));
        sendEmailIntent.setType(view.getContext().getString(R.string.data_type_mime));
        sendEmailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        sendEmailIntent.putExtra(Intent.EXTRA_CC, CC);
        sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
        sendEmailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            mContext.startActivity(Intent.createChooser(sendEmailIntent, view.getContext().getString(R.string.chooser_title_email)));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext, R.string.Error_message_email, Toast.LENGTH_SHORT).show();
        }
    }

    public void openFaceBookLink(View view) {

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse(mContext.getString(R.string.JourneySound_Facebook_Link)));

        try {
            mContext.startActivity(Intent.createChooser(sendIntent, mContext.getString(R.string.Open_link_chooser_title)));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext, R.string.Error_message_no_application, Toast.LENGTH_SHORT).show();
        }
    }
    public void openTwitterLink(View view) {

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse(mContext.getString(R.string.JourneySound_Twitter_Link)));

        try {
            mContext.startActivity(Intent.createChooser(sendIntent, mContext.getString(R.string.Open_link_chooser_title)));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext, R.string.Error_message_no_application, Toast.LENGTH_SHORT).show();
        }
    }
    public void openInstagramLink(View view) {

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse(mContext.getString(R.string.JourneySound_Instagram_Link)));

        try {
            mContext.startActivity(Intent.createChooser(sendIntent, mContext.getString(R.string.Open_link_chooser_title)));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext, R.string.Error_message_no_application, Toast.LENGTH_SHORT).show();
        }
    }
    public void openLinkedInLink(View view) {

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse(mContext.getString(R.string.JourneySound_LinkedIn_Link)));

        try {
            mContext.startActivity(Intent.createChooser(sendIntent, mContext.getString(R.string.Open_link_chooser_title)));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext, R.string.Error_message_no_application, Toast.LENGTH_SHORT).show();
        }
    }
    public void openGooglePlusLink(View view) {

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse(mContext.getString(R.string.JourneySound_GooglePlus_Link)));

        try {
            mContext.startActivity(Intent.createChooser(sendIntent, mContext.getString(R.string.Open_link_chooser_title)));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext, R.string.Error_message_no_application, Toast.LENGTH_SHORT).show();
        }
    }
}
