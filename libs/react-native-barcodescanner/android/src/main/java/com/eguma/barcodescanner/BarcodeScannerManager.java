package com.eguma.barcodescanner;

import android.view.View;

import javax.annotation.Nullable;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import android.util.Log;

public class BarcodeScannerManager extends ViewGroupManager<BarcodeScannerView> implements LifecycleEventListener {
    private static final String REACT_CLASS = "RNBarcodeScannerView";

    private static final String DEFAULT_TORCH_MODE = "off";
    private static final String DEFAULT_CAMERA_TYPE = "back";

    private static final String TAG = "BarcodeScannerManager";

    private BarcodeScannerView mScannerView;
    private boolean mScannerViewVisible;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "cameraType")
    public void setCameraType(BarcodeScannerView view, @Nullable String cameraType) {
      if (cameraType != null) {
          view.setCameraType(cameraType);
      }
    }

    @ReactProp(name = "torchMode")
    public void setTorchMode(BarcodeScannerView view, @Nullable String torchMode) {
        if (torchMode != null) {
            view.setFlash(torchMode.equals("on"));
        }
    }

    @Override
    public BarcodeScannerView createViewInstance(ThemedReactContext context) {
        Log.i(TAG, "createViewInstance start");
        context.addLifecycleEventListener(this);
        mScannerView = new BarcodeScannerView(context);
        mScannerView.setCameraType(DEFAULT_CAMERA_TYPE);
        mScannerView.setFlash(DEFAULT_TORCH_MODE.equals("on"));
        mScannerViewVisible = true;
        Log.i(TAG, "createViewInstance end");
        return mScannerView;
    }

    @Override
    public void onHostResume() {
        Log.i(TAG, "onHostResume");
        if(mScannerView.isShow()){
            mScannerView.onResume();
        }
    }

    @Override
    public void onHostPause() {
        Log.i(TAG, "onHostPause");
        if(mScannerView.isShow()){
            mScannerView.onPause();
        }
    }

    @Override
    public void onHostDestroy() {
        Log.i(TAG, "onHostDestroy");
        mScannerView.stopCamera();
    }

    @Override
    public void addView(BarcodeScannerView parent, View child, int index) {
        parent.addView(child, index + 1);   // index 0 for camera preview reserved
    }
}
