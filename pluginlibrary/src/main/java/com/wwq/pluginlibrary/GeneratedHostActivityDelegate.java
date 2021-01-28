package com.wwq.pluginlibrary;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.lang.CharSequence;
import java.lang.ClassLoader;
import java.lang.Object;
import java.lang.String;

/**
 * 由
 * {@link com.tencent.shadow.coding.code_generator.ActivityCodeGenerator}
 * 自动生成
 * HostActivity的被委托者接口
 * 被委托者通过实现这个接口中声明的方法达到替代委托者实现的目的，从而将HostActivity的行为动态化。
 */
public interface GeneratedHostActivityDelegate {
  boolean isChangingConfigurations();

  void finish();

  ClassLoader getClassLoader();

  LayoutInflater getLayoutInflater();

  Resources getResources();

  void recreate();

  ComponentName getCallingActivity();

  CharSequence onCreateDescription();

  void onMultiWindowModeChanged(boolean arg0, Configuration arg1);

  void onMultiWindowModeChanged(boolean arg0);

  void onProvideAssistContent(Object arg0);

  void onProvideKeyboardShortcuts(Object arg0, Menu arg1, int arg2);

  Object onRetainNonConfigurationInstance();

  void onPerformDirectAction(String arg0, Bundle arg1, Object arg2, Object arg3);

  void onProvideAssistData(Bundle arg0);

  void onConfigurationChanged(Configuration arg0);

  void onPictureInPictureModeChanged(boolean arg0);

  void onPictureInPictureModeChanged(boolean arg0, Configuration arg1);

  void onLocalVoiceInteractionStarted();

  void onGetDirectActions(Object arg0, Object arg1);

  void onSaveInstanceState(Bundle arg0, Object arg1);

  void onRestoreInstanceState(Bundle arg0, Object arg1);

  void onLocalVoiceInteractionStopped();

  boolean onCreateThumbnail(Bitmap arg0, Canvas arg1);

  void onTopResumedActivityChanged(boolean arg0);

  boolean onNavigateUpFromChild(Activity arg0);

  void onCreateNavigateUpTaskStack(Object arg0);

  void onPrepareNavigateUpTaskStack(Object arg0);

  boolean onContextItemSelected(MenuItem arg0);

  void onContextMenuClosed(Menu arg0);

  boolean onSearchRequested();

  boolean onSearchRequested(Object arg0);

  boolean onCreateOptionsMenu(Menu arg0);

  boolean onCreatePanelMenu(int arg0, Menu arg1);

  boolean onPrepareOptionsMenu(Menu arg0);

  void onWindowAttributesChanged(WindowManager.LayoutParams arg0);

  void onOptionsMenuClosed(Menu arg0);

  void onUserInteraction();

  void onCreateContextMenu(ContextMenu arg0, View arg1, ContextMenu.ContextMenuInfo arg2);

  void onAttachedToWindow();

  View onCreatePanelView(int arg0);

  void onDetachedFromWindow();

  boolean onMenuItemSelected(int arg0, MenuItem arg1);

  void onWindowFocusChanged(boolean arg0);

  boolean onOptionsItemSelected(MenuItem arg0);

  boolean onGenericMotionEvent(MotionEvent arg0);

  void onVisibleBehindCanceled();

  ActionMode onWindowStartingActionMode(ActionMode.Callback arg0);

  ActionMode onWindowStartingActionMode(ActionMode.Callback arg0, int arg1);

  void onActivityReenter(int arg0, Intent arg1);

  void onActionModeStarted(ActionMode arg0);

  void onActionModeFinished(ActionMode arg0);

  Uri onProvideReferrer();

  void onRequestPermissionsResult(int arg0, String[] arg1, int[] arg2);

  void onEnterAnimationComplete();

  void onCreate(Bundle arg0, Object arg1);

  void onBackPressed();

  boolean onTrackballEvent(MotionEvent arg0);

  void onContentChanged();

  boolean onPreparePanel(int arg0, View arg1, Menu arg2);

  boolean onMenuOpened(int arg0, Menu arg1);

  boolean onKeyUp(int arg0, KeyEvent arg1);

  void onLowMemory();

  void onAttachFragment(Fragment arg0);

  boolean onKeyDown(int arg0, KeyEvent arg1);

  boolean onKeyLongPress(int arg0, KeyEvent arg1);

  void onStateNotSaved();

  boolean onKeyMultiple(int arg0, int arg1, KeyEvent arg2);

  void onPostCreate(Bundle arg0, Object arg1);

  void onTrimMemory(int arg0);

  boolean onKeyShortcut(int arg0, KeyEvent arg1);

  boolean onTouchEvent(MotionEvent arg0);

  View onCreateView(View arg0, String arg1, Context arg2, AttributeSet arg3);

  View onCreateView(String arg0, Context arg1, AttributeSet arg2);

  void onPanelClosed(int arg0, Menu arg1);

  boolean onNavigateUp();

  void onPointerCaptureChanged(boolean arg0);

  void onStop();

  void onStart();

  void onSaveInstanceState(Bundle arg0);

  void onRestoreInstanceState(Bundle arg0);

  void onChildTitleChanged(Activity arg0, CharSequence arg1);

  void onApplyThemeResource(Resources.Theme arg0, int arg1, boolean arg2);

  void onCreate(Bundle arg0);

  void onNewIntent(Intent arg0);

  void onUserLeaveHint();

  void onPostResume();

  void onRestart();

  void onPause();

  void onPostCreate(Bundle arg0);

  void onDestroy();

  void onResume();

  void onTitleChanged(CharSequence arg0, int arg1);

  Dialog onCreateDialog(int arg0);

  Dialog onCreateDialog(int arg0, Bundle arg1);

  void onPrepareDialog(int arg0, Dialog arg1, Bundle arg2);

  void onPrepareDialog(int arg0, Dialog arg1);

  void onActivityResult(int arg0, int arg1, Intent arg2);

  boolean dispatchGenericMotionEvent(MotionEvent arg0);

  boolean dispatchTouchEvent(MotionEvent arg0);

  boolean dispatchKeyShortcutEvent(KeyEvent arg0);

  boolean dispatchTrackballEvent(MotionEvent arg0);

  boolean dispatchKeyEvent(KeyEvent arg0);

  boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg0);

    void setResult(int arg0);
}
