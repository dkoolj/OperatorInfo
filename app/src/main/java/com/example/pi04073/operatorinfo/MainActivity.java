package com.example.pi04073.operatorinfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
// import org.simalliance.openmobileapi.*;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions); */

        TelephonyManager tManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        String getLine1Number = tManager.getLine1Number();
        TextView getLine1NumberText=(TextView)findViewById(R.id.getLine1Number);
        getLine1NumberText.setText("Phone number (MSISDN): " + getLine1Number + "\n");

        String networkOperatorName = tManager.getNetworkOperatorName();
        TextView networkOperatorNameText=(TextView)findViewById(R.id.networkOperatorName);
        networkOperatorNameText.setText("Name of current registered operator: " + networkOperatorName + "\n");

        String simOperatorName = tManager.getSimOperatorName();
        TextView simOperatorNameText=(TextView)findViewById(R.id.simOperatorName);
        simOperatorNameText.setText("Service Provider Name (SPN): " + simOperatorName + "\n");

        String getNetworkCountryIso = tManager.getNetworkCountryIso();
        TextView getNetworkCountryIsoText=(TextView)findViewById(R.id.getNetworkCountryIso);
        getNetworkCountryIsoText.setText("ISO country code equivalent for the SIM provider's country code: " + getNetworkCountryIso + "\n");

        String getNetworkOperator = tManager.getNetworkOperator();
        TextView getNetworkOperatorText=(TextView)findViewById(R.id.getNetworkOperator);
        getNetworkOperatorText.setText("Numeric name (MCC+MNC) of current registered operator: " + getNetworkOperator + "\n");

        String getSimOperator = tManager.getSimOperator();
        TextView getSimOperatorText=(TextView)findViewById(R.id.getSimOperator);
        getSimOperatorText.setText("MCC+MNC (mobile country code + mobile network code) of the provider of the SIM: " + getSimOperator + "\n");

        int getNetworkType = tManager.getNetworkType();
        switch (getNetworkType) {
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                TextView getNetworkTypeText0 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText0.setText("Network type is unknown. Constant Value: " + getNetworkType + " (0x00000000)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_GPRS:
                TextView getNetworkTypeText1 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText1.setText("Current network is GPRS. Constant Value: " + getNetworkType + " (0x00000001)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_EDGE:
                TextView getNetworkTypeText2 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText2.setText("Current network is EDGE. Constant Value: " + getNetworkType + " (0x00000002)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_UMTS:
                TextView getNetworkTypeText3 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText3.setText("Current network is UMTS. Constant Value: " + getNetworkType + " (0x00000003)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_CDMA:
                TextView getNetworkTypeText4 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText4.setText("Current network is CDMA: Either IS95A or IS95B. Constant Value: " + getNetworkType + " (0x00000004)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                TextView getNetworkTypeText5 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText5.setText("Current network is EVDO revision 0. Constant Value: " + getNetworkType + " (0x00000005)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                TextView getNetworkTypeText6 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText6.setText("Current network is EVDO revision A. Constant Value: " + getNetworkType + " (0x00000006)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                TextView getNetworkTypeText7 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText7.setText("Current network is 1xRTT. Constant Value: " + getNetworkType + " (0x00000007)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                TextView getNetworkTypeText8 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText8.setText("Current network is HSDPA. Constant Value: " + getNetworkType + " (0x00000008)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                TextView getNetworkTypeText9 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText9.setText("Current network is HSUPA. Constant Value: " + getNetworkType + " (0x00000009)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_HSPA:
                TextView getNetworkTypeText10 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText10.setText("Current network is HSPA. Constant Value: " + getNetworkType + " (0x0000000a)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_IDEN:
                TextView getNetworkTypeText11 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText11.setText("Current network is iDen. Constant Value: " + getNetworkType + " (0x0000000b)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                TextView getNetworkTypeText12 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText12.setText("Current network is EVDO revision B. Constant Value: " + getNetworkType + " (0x0000000c)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_LTE:
                TextView getNetworkTypeText13 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText13.setText("Current network is LTE. Constant Value: " + getNetworkType + " (0x0000000d)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                TextView getNetworkTypeText14 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText14.setText("Current network is eHRPD. Constant Value: " + getNetworkType + " (0x0000000e)\n");
                break;
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                TextView getNetworkTypeText15 = (TextView) findViewById(R.id.getNetworkType);
                getNetworkTypeText15.setText("Current network is HSPA+. Constant Value: " + getNetworkType + " (0x0000000f)\n");
                break;
        }

        int getPhoneType = tManager.getPhoneType();
        switch (getPhoneType) {
            case TelephonyManager.PHONE_TYPE_NONE :
                TextView getPhoneTypeText0 = (TextView) findViewById(R.id.getPhoneType);
                getPhoneTypeText0.setText("No phone radio. Constant Value: " + getPhoneType + " (0x00000000)\n");
                break;
            case TelephonyManager.PHONE_TYPE_GSM :
                TextView getPhoneTypeText1 = (TextView) findViewById(R.id.getPhoneType);
                getPhoneTypeText1.setText("Phone radio is GSM. Constant Value: " + getPhoneType + " (0x00000001)\n");
                break;
            case TelephonyManager.PHONE_TYPE_CDMA :
                TextView getPhoneTypeText2 = (TextView) findViewById(R.id.getPhoneType);
                getPhoneTypeText2.setText("Phone radio is CDMA. Constant Value: " + getPhoneType + " (0x00000002)\n");
                break;
            case TelephonyManager.PHONE_TYPE_SIP :
                TextView getPhoneTypeText3 = (TextView) findViewById(R.id.getPhoneType);
                getPhoneTypeText3.setText("Phone is via SIP. Constant Value: " + getPhoneType + " (0x00000003)\n");
                break;
        }

        int getCallState=tManager.getCallState();
        switch (getCallState) {
            case TelephonyManager.CALL_STATE_IDLE :
                TextView getCallStateText0=(TextView)findViewById(R.id.getCallState);
                getCallStateText0.setText("Device call state: No activity. Constant Value: "+getCallState + " (0x00000000)\n");
                break;
            case TelephonyManager.CALL_STATE_RINGING :
                TextView getCallStateText1=(TextView)findViewById(R.id.getCallState);
                getCallStateText1.setText("Device call state: Ringing. A new call arrived and is ringing or waiting. In the latter case, another call is already active. Constant Value: "+getCallState + " (0x00000001)\n");
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK :
                TextView getCallStateText2=(TextView)findViewById(R.id.getCallState);
                getCallStateText2.setText("Device call state: Off-hook. At least one call exists that is dialing, active, or on hold, and no calls are ringing or waiting. Constant Value: "+getCallState + " (0x00000002)\n");
                break;
        }

        String getCellLocation=tManager.getCellLocation().toString();
        TextView getCellLocationText=(TextView)findViewById(R.id.getCellLocation);
        getCellLocationText.setText("Current location of the device: " + getCellLocation + "\n");

        int getDataActivity=tManager.getDataActivity();
        switch (getDataActivity) {
            case TelephonyManager.DATA_ACTIVITY_NONE :
                TextView getDataActivityText0=(TextView)findViewById(R.id.getDataActivity);
                getDataActivityText0.setText("Data connection activity: No traffic. Constant Value: " + getDataActivity + " (0x00000000)\n");
                break;
            case TelephonyManager.DATA_ACTIVITY_IN :
                TextView getDataActivityText1=(TextView)findViewById(R.id.getDataActivity);
                getDataActivityText1.setText("Data connection activity: Currently receiving IP PPP traffic. Constant Value: " + getDataActivity + " (0x00000001)\n");
                break;
            case TelephonyManager.DATA_ACTIVITY_OUT :
                TextView getDataActivityText2=(TextView)findViewById(R.id.getDataActivity);
                getDataActivityText2.setText("Data connection activity: Currently sending IP PPP traffic. Constant Value: " + getDataActivity + " (0x00000002)\n");
                break;
            case TelephonyManager.DATA_ACTIVITY_INOUT :
                TextView getDataActivityText3=(TextView)findViewById(R.id.getDataActivity);
                getDataActivityText3.setText("Data connection activity: Currently both sending and receiving IP PPP traffic. Constant Value: " + getDataActivity + " (0x00000003)\n");
                break;
            case TelephonyManager.DATA_ACTIVITY_DORMANT :
                TextView getDataActivityText4=(TextView)findViewById(R.id.getDataActivity);
                getDataActivityText4.setText("Data connection is active, but physical link is down. Constant Value: " + getDataActivity + " (0x00000004)\n");
                break;
        }

        int getDataState=tManager.getDataState();
        switch (getDataState) {
            case TelephonyManager.DATA_DISCONNECTED :
                TextView getDataStateText0=(TextView)findViewById(R.id.getDataState);
                getDataStateText0.setText("Data connection state: Disconnected. IP traffic not available. Constant Value: " + getDataState + " (0x00000000)\n");
                break;
            case TelephonyManager.DATA_CONNECTING :
                TextView getDataStateText1=(TextView)findViewById(R.id.getDataState);
                getDataStateText1.setText("Data connection state: Currently setting up a data connection. Constant Value: " + getDataState + " (0x00000001\n)");
                break;
            case TelephonyManager.DATA_CONNECTED :
                TextView getDataStateText2=(TextView)findViewById(R.id.getDataState);
                getDataStateText2.setText("Data connection state: Connected. IP traffic should be available. Constant Value: " + getDataState + " (0x00000002)\n");
                break;
            case TelephonyManager.DATA_SUSPENDED :
                TextView getDataStateText3=(TextView)findViewById(R.id.getDataState);
                getDataStateText3.setText("Data connection state: Suspended. The connection is up, but IP traffic is temporarily unavailable. Constant Value: " + getDataState + " (0x00000003)\n");
                break;
        }

        String getDeviceId=tManager.getDeviceId();
        TextView getDeviceIdText=(TextView)findViewById(R.id.getDeviceId);
        getDeviceIdText.setText("Unique device ID (IMEI): " + getDeviceId + "\n");

        String getDeviceSoftwareVersion=tManager.getDeviceSoftwareVersion();
        TextView getDeviceSoftwareVersionText=(TextView)findViewById(R.id.getDeviceSoftwareVersion);
        getDeviceSoftwareVersionText.setText("Software version number for the device (IMEI/SV): " + getDeviceSoftwareVersion + "\n");

        String getSimSerialNumber=tManager.getSimSerialNumber();
        TextView getSimSerialNumberText=(TextView)findViewById(R.id.getSimSerialNumber);
        getSimSerialNumberText.setText("Serial number of the SIM (ICCID): " + getSimSerialNumber + "\n");

        int getSimState=tManager.getSimState();
        switch(getSimState)
        {
            case TelephonyManager.SIM_STATE_UNKNOWN :
                TextView getSimStateText0=(TextView)findViewById(R.id.getSimState);
                getSimStateText0.setText("SIM card state: Unknown. Signifies that the SIM is in transition between states. Constant Value: " + getSimState + " (0x00000000)\n");
                break;
            case TelephonyManager.SIM_STATE_ABSENT :
                TextView getSimStateText1=(TextView)findViewById(R.id.getSimState);
                getSimStateText1.setText("SIM card state: no SIM card is available in the device. Constant Value: " + getSimState + " (0x00000001)\n");
                break;
            case TelephonyManager.SIM_STATE_PIN_REQUIRED :
                TextView getSimStateText2=(TextView)findViewById(R.id.getSimState);
                getSimStateText2.setText("SIM card state: Locked: requires the user's SIM PIN to unlock. Constant Value: " + getSimState + " (0x00000002)\n");
                break;
            case TelephonyManager.SIM_STATE_PUK_REQUIRED :
                TextView getSimStateText3=(TextView)findViewById(R.id.getSimState);
                getSimStateText3.setText("SIM card state: Locked: requires the user's SIM PUK to unlock. Constant Value: " + getSimState + " (0x00000003)\n");
                break;
            case TelephonyManager.SIM_STATE_NETWORK_LOCKED :
                TextView getSimStateText4=(TextView)findViewById(R.id.getSimState);
                getSimStateText4.setText("SIM card state: Locked: requries a network PIN to unlock. Constant Value: " + getSimState + " (0x00000004)\n");
                break;
            case TelephonyManager.SIM_STATE_READY :
                TextView getSimStateText5=(TextView)findViewById(R.id.getSimState);
                getSimStateText5.setText("SIM card state: Ready. Constant Value: " + getSimState + " (0x00000005)\n");
                break;
        }

        String getSubscriberId=tManager.getSubscriberId();
        TextView getSubscriberIdText=(TextView)findViewById(R.id.getSubscriberId);
        getSubscriberIdText.setText("Unique subscriber ID (IMSI): " + getSubscriberId + "\n");

        boolean hasIccCard=tManager.hasIccCard();
        TextView hasIccCardText=(TextView)findViewById(R.id.hasIccCard);
        hasIccCardText.setText("ICC card is present: " + hasIccCard + "\n");

        boolean isNetworkRoaming=tManager.isNetworkRoaming();
        TextView isNetworkRoamingText=(TextView)findViewById(R.id.isNetworkRoaming);
        isNetworkRoamingText.setText("Roaming network: " + isNetworkRoaming + "\n");

        boolean isSmsCapable=tManager.isSmsCapable();
        TextView isSmsCapableText=(TextView)findViewById(R.id.isSmsCapable);
        isSmsCapableText.setText("Device supports both sending and receiving SMS: " + isSmsCapable + "\n");

        String getGroupIdLevel1=tManager.getGroupIdLevel1();
        TextView getGroupIdLevel1Text=(TextView)findViewById(R.id.getGroupIdLevel1);
        getGroupIdLevel1Text.setText("Group Identifier Level1: " + getGroupIdLevel1 + "\n");

        String getNeighboringCellInfo=tManager.getNeighboringCellInfo().toString();
        TextView getNeighboringCellInfoText=(TextView)findViewById(R.id.getNeighboringCellInfo);
        getNeighboringCellInfoText.setText("Neighboring cell information of the device: " + getNeighboringCellInfo + "\n");

        String getAllCellInfo=tManager.getAllCellInfo().toString();
        TextView getAllCellInfoText=(TextView)findViewById(R.id.getAllCellInfo);
        getAllCellInfoText.setText("All observed cell information from all radios on the device including the primary and neighboring cells: " + getAllCellInfo);
    }
}