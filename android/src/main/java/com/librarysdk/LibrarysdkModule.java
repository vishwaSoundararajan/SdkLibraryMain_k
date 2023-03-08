package com.librarysdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import io.mob.resu.reandroidsdk.AppConstants;
import io.mob.resu.reandroidsdk.MRegisterUser;
import io.mob.resu.reandroidsdk.RNotification;
import io.mob.resu.reandroidsdk.ReAndroidSDK;

import com.facebook.react.modules.core.DeviceEventManagerModule;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

@ReactModule(name = LibrarysdkModule.NAME)
public class LibrarysdkModule extends ReactContextBaseJavaModule {
  public static final String NAME = "Librarysdk";
  private final ReactApplicationContext reactContext;
  public Context context = null;
  public LibrarysdkModule(ReactApplicationContext reactContext)
  {
    this.reactContext = reactContext;
    ReAndroidSDK.getInstance(reactContext);
    AppConstants.LogFlag = true;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }


  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void multiply(double a, double b) {
    System.out.println("SUPER! Results:  " + (a*b));
  }

  @ReactMethod
  public void location(double latitude, double longitude){
    ReAndroidSDK.getInstance(reactContext).onLocationUpdate(latitude, longitude);
    System.out.println("onLocationUpdate");
    //emitEvent();
  }

  @ReactMethod
  public void appConversionTracking() {
//    String jsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
//    org.json.JSONObject jsonObject = new org.json.JSONObject(jsonString);
    ReAndroidSDK.getInstance(reactContext).appConversionTracking();
    System.out.println("appConversionTracking");
  }

  @ReactMethod
  public void appConversionTracking1(String data) throws JSONException{
    JSONObject json1 = new JSONObject(data);
    ReAndroidSDK.getInstance(reactContext).appConversionTracking(json1);
  }

  @ReactMethod
  public void addNewNotification(String title, String body){
    ReAndroidSDK.getInstance(reactContext).addNewNotification(title, body, "MainActivity");
    System.out.println("addNewNotification");
  }

  @ReactMethod
  public void deleteNotificationByNID(String id){
    ReAndroidSDK.getInstance(reactContext).deleteNotificationByNotificationId(id);
    System.out.println("deleteNotificationByNotificationId");
  }


  @ReactMethod
  public void deleteNotificationByObject(String json) throws JSONException{
    JSONObject json1 = new JSONObject(json);
    ReAndroidSDK.getInstance(reactContext).deleteNotificationByObject(json1);
  }
  @ReactMethod
  public void getReadNotificationCount(){
    int readedCount = ReAndroidSDK.getInstance(reactContext).getUnReadNotificationCount();
    System.err.println("Notification readed count: " + readedCount);
  }

  @ReactMethod
  public void updatePushToken(){
    ReAndroidSDK.getInstance(reactContext).updatePushToken("em3EVov-Rzy3wkLqnmGipd:APA91bGQZzMMqY1u2HOdLBe3owHUSDkG52n55T6J6Tj-DwJeUpCX4Hks25NzL18tQ2kyMxZOtXLCBy7U5aaOMQsaf8cCnNgw9b9L4mBzXzXNtOB75rp6Mz8tK6Ag66GRlZoFtKRwNznk");
  }

  @ReactMethod
  public void onTrackEvent(){
    ReAndroidSDK.getInstance(reactContext).onTrackEvent("SampleEvent");
  }

  @ReactMethod
  public void onDeviceUserRegister(String json) throws JSONException{
    JSONObject json1 = new JSONObject(json);
    System.out.println(json1);
    MRegisterUser obj = new MRegisterUser();
    obj.setAdId(json1.getString("uid"));
    obj.setUserUniqueId(json1.getString("useruid"));
    obj.setName(json1.getString("name"));
    obj.setAge(json1.getString("age"));
    obj.setEmail(json1.getString("email"));
    obj.setPhone(json1.getString("phone"));
    obj.setGender(json1.getString("gender"));
    obj.setDeviceToken(json1.getString("token"));
    obj.setProfileUrl(json1.getString("profileURL"));
    obj.setDob(json1.getString("dob"));
    obj.setEducation(json1.getString("education"));
    obj.setEmployed(json1.getBoolean("employed"));
    obj.setMarried(json1.getBoolean("married"));
    ReAndroidSDK.getInstance(reactContext).onDeviceUserRegister(obj);
  }

  @ReactMethod
  public void formDataCapture(String json) throws JSONException {
    JSONObject json1 = new JSONObject(json);
    ReAndroidSDK.getInstance(reactContext).formDataCapture(json1);
  }

  @ReactMethod
  public void readNotification(){
    ReAndroidSDK.getInstance(reactContext).readNotification("1673591227344");
  }

  @ReactMethod
  public void unReadNotification(){
    ReAndroidSDK.getInstance(reactContext).unReadNotification("1673591227344");
  }

  @ReactMethod
  public void getDeepLinkData(){
    String deepLinkData = ReAndroidSDK.getInstance(reactContext).getDeepLinkData();
    System.out.println(deepLinkData);
  }

  @ReactMethod
  public void onReceivedCampaign(){
    Bundle data = new Bundle();
    data.putString("campaignId", "1673591227344");
    boolean value = ReAndroidSDK.getInstance(reactContext).onReceivedCampaign(data);
    System.out.println(value);
  }

  @ReactMethod
  public void getUnreadNotificationCount(){
    int unReadCount = ReAndroidSDK.getInstance(reactContext).getUnReadNotificationCount();
    System.out.println(unReadCount);
  }

  @ReactMethod
  public void getNotifications(){
    ArrayList<RNotification> arrayList = new ArrayList<>();
    arrayList = ReAndroidSDK.getInstance(reactContext).getNotifications();
    System.out.println(arrayList);
  }

//  @ReactMethod
//  public void emitEvent() {
//    String data = "Data";
//    reactContext
//      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
//      .emit("Sample Event", data);
//  }

//    public void initSDK(ReactApplicationContext context){
//
//    }
  @ReactMethod
  public boolean isReNotification(Map<String, String> data) {
    try {
      if (data.containsKey("navigationScreen")) {
        Intent intent = new Intent();
        for (String value :data.keySet()) {
          intent.putExtra(value, data.get(value));
        }
        intent.setAction("resu.io.NOTIFICATION");
        intent.setComponent(new ComponentName(reactContext.getPackageName(),
          "io.mob.resu.reandroidsdk.ReNotificationBroadcastReceiver"));
        reactContext.getApplicationContext().sendBroadcast(intent);
        return true;
      } else
        return true;
    } catch (Exception e) {
      Log.e("isReNotification", "" + e.getMessage());
      return false;
    }
  }
}
