package io.invertase.googlemobileads

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNGoogleMobileAdsMediaViewManagerDelegate
import com.facebook.react.viewmanagers.RNGoogleMobileAdsMediaViewManagerInterface

@ReactModule(name = ReactNativeGoogleMobileAdsMediaViewManager.NAME)
class ReactNativeGoogleMobileAdsMediaViewManager :
  ViewGroupManager<ReactNativeGoogleMobileAdsMediaView>(),
  RNGoogleMobileAdsMediaViewManagerInterface<ReactNativeGoogleMobileAdsMediaView> {

  private val delegate: ViewManagerDelegate<ReactNativeGoogleMobileAdsMediaView> =
    RNGoogleMobileAdsMediaViewManagerDelegate(this)

  override fun getDelegate(): ViewManagerDelegate<ReactNativeGoogleMobileAdsMediaView> = delegate

  override fun getName(): String = NAME

  override fun createViewInstance(context: ThemedReactContext): ReactNativeGoogleMobileAdsMediaView =
    ReactNativeGoogleMobileAdsMediaView(context)

  @ReactProp(name = "responseId")
  override fun setResponseId(view: ReactNativeGoogleMobileAdsMediaView, responseId: String?) {
    view.setResponseId(responseId)
  }

  @ReactProp(name = "resizeMode")
  override fun setResizeMode(view: ReactNativeGoogleMobileAdsMediaView, resizeMode: String?) {
    view.setResizeMode(resizeMode)
  }

  companion object {
    const val NAME = "RNGoogleMobileAdsMediaView"
  }
}