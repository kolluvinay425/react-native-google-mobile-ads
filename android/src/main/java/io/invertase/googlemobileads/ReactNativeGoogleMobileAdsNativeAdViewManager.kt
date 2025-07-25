package io.invertase.googlemobileads

import android.view.View
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNGoogleMobileAdsNativeViewManagerDelegate
import com.facebook.react.viewmanagers.RNGoogleMobileAdsNativeViewManagerInterface

@ReactModule(name = ReactNativeGoogleMobileAdsNativeAdViewManager.NAME)
class ReactNativeGoogleMobileAdsNativeAdViewManager :
  ViewGroupManager<ReactNativeGoogleMobileAdsNativeAdView>(),
  RNGoogleMobileAdsNativeViewManagerInterface<ReactNativeGoogleMobileAdsNativeAdView> {

  private val delegate: ViewManagerDelegate<ReactNativeGoogleMobileAdsNativeAdView> =
    RNGoogleMobileAdsNativeViewManagerDelegate(this)

  override fun getDelegate(): ViewManagerDelegate<ReactNativeGoogleMobileAdsNativeAdView> = delegate

  override fun getName(): String = NAME

  override fun createViewInstance(context: ThemedReactContext): ReactNativeGoogleMobileAdsNativeAdView =
    ReactNativeGoogleMobileAdsNativeAdView(context)

  override fun onDropViewInstance(adView: ReactNativeGoogleMobileAdsNativeAdView) {
    super.onDropViewInstance(adView)
    adView.destroy()
  }

  override fun prepareToRecycleView(
    reactContext: ThemedReactContext,
    view: ReactNativeGoogleMobileAdsNativeAdView
  ): ReactNativeGoogleMobileAdsNativeAdView? {
    return null
  }

  @ReactProp(name = "responseId")
  override fun setResponseId(view: ReactNativeGoogleMobileAdsNativeAdView, responseId: String?) {
    view.setResponseId(responseId)
  }

  @ReactMethod
  override fun registerAsset(view: ReactNativeGoogleMobileAdsNativeAdView, assetKey: String, reactTag: Int) {
    view.registerAsset(assetKey, reactTag)
  }

  override fun addView(parent: ReactNativeGoogleMobileAdsNativeAdView, child: View, index: Int) {
    parent.viewGroup.addView(child, index)
  }

  override fun getChildCount(parent: ReactNativeGoogleMobileAdsNativeAdView): Int {
    return parent.viewGroup.childCount
  }

  override fun getChildAt(parent: ReactNativeGoogleMobileAdsNativeAdView, index: Int): View? {
    return parent.viewGroup.getChildAt(index)
  }

  override fun removeViewAt(parent: ReactNativeGoogleMobileAdsNativeAdView, index: Int) {
    parent.viewGroup.removeViewAt(index)
  }

  companion object {
    const val NAME = "RNGoogleMobileAdsNativeView"
  }
}