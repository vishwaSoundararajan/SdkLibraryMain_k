package com.librarysdkexample;

import com.facebook.react.bridge.ReactApplicationContext;
import android.app.Application;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.soloader.SoLoader;
import java.util.List;
import java.util.Map;
//import io.mob.resu.reandroidsdk.ReAndroidSDK;
//import io.mob.resu.reandroidsdk.ReReactNativeSDKPackage;
//import io.mob.resu.reandroidsdk.AppConstants;
import com.librarysdk.LibrarysdkModule;
public class MainApplication extends Application implements ReactApplication {
  ReactApplicationContext reactContext;
  public MainApplication(){
    this.reactContext = reactContext;
  }
  private final ReactNativeHost mReactNativeHost =
      new DefaultReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
          return BuildConfig.DEBUG;
        }
        @Override
        protected List<ReactPackage> getPackages() {
          @SuppressWarnings("UnnecessaryLocalVariable")
          List<ReactPackage> packages = new PackageList(this).getPackages();
          // Packages that cannot be autolinked yet can be added manually here, for example:
          // packages.add(new MyReactNativePackage());
          //packages.add(new CustomModulePackage());
          //packages.add(new LibrarysdkPackage());
          return packages;
        }

        @Override
        protected String getJSMainModuleName() {
          return "index";
        }

        @Override
        protected boolean isNewArchEnabled() {
          return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
        }

        @Override
        protected Boolean isHermesEnabled() {
          return BuildConfig.IS_HERMES_ENABLED;
        }
      };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
//    ReAndroidSDK.getInstance(this);
    //LibrarySdkModule.initSDK(this);
    LibrarysdkModule o = new LibrarysdkModule(reactContext);
    SoLoader.init(this, /* native exopackage */ false);
    if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
      // If you opted-in for the New Architecture, we load the native entry point for this app.
      DefaultNewArchitectureEntryPoint.load();
    }
    if (BuildConfig.DEBUG) {
      //ReactNativeFlipper.initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
    }
  }
//  public boolean isReNotification(Map<String, String> data){
//    LibrarysdkModule o = new LibrarysdkModule(reactContext);
//    o.isReNotification(data);
//  }
}
