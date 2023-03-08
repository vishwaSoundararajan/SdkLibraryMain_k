//package com.librarysdkexample;
//
//import android.content.Context;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//
//import com.facebook.react.bridge.ReactApplicationContext;
//import com.facebook.react.bridge.ReactContextBaseJavaModule;
//import com.facebook.react.bridge.ReactMethod;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import io.mob.resu.reandroidsdk.MRegisterUser;
//import io.mob.resu.reandroidsdk.ReAndroidSDK;
//public class CustomModule extends ReactContextBaseJavaModule {
//  private static ReactApplicationContext reactContext;
//  public Context context = null;
//  CustomModule(ReactApplicationContext context){
//    //super(context);
//    this.context = reactContext;
//  }
//  @ReactMethod
//  public void show(){
//    Toast.makeText(reactContext, "Its Working", Toast.LENGTH_LONG).show();
//  }
//  @ReactMethod
//  public void onDeviceUserRegister(String json) throws JSONException {
//    JSONObject json1 = new JSONObject(json);
//    System.out.println(json1);
//    MRegisterUser obj = new MRegisterUser();
//    obj.setAdId(json1.getString("adid"));
//    obj.setUserUniqueId(json1.getString("uid"));
//    obj.setUserUniqueId(json1.getString("useruid"));
//    obj.setName(json1.getString("name"));
//    obj.setAge(json1.getString("age"));
//    obj.setEmail(json1.getString("email"));
//    obj.setPhone(json1.getString("phone"));
//    obj.setGender(json1.getString("gender"));
//    obj.setProfileUrl(json1.getString("profileURL"));
//    obj.setDob(json1.getString("dob"));
//    obj.setEducation(json1.getString("education"));
//    obj.setEmployed(json1.getBoolean("employed"));
//    obj.setMarried(json1.getBoolean("married"));
//    obj.setDeviceToken(json1.getString("token"));
//    ReAndroidSDK.getInstance(context).onDeviceUserRegister(obj);
//  }
//  @ReactMethod
//  public void updatePushToken(){
//    ReAndroidSDK.getInstance(context).updatePushToken("em3EVov-Rzy3wkLqnmGipd:APA91bGQZzMMqY1u2HOdLBe3owHUSDkG52n55T6J6Tj-DwJeUpCX4Hks25NzL18tQ2kyMxZOtXLCBy7U5aaOMQsaf8cCnNgw9b9L4mBzXzXNtOB75rp6Mz8tK6Ag66GRlZoFtKRwNznk");
//  }
//  @NonNull
//  @Override
//  public String getName() {
//    return "CustomModule";
//  }
//
//
//}
