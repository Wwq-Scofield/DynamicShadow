package com.wwq.pluginlibrary;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Dialog;
import android.app.DirectAction;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.SharedElementCallback;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.PersistableBundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.CharSequence;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.String;
import java.util.List;
import java.util.function.Consumer;

/**
 * 由
 * {@link com.tencent.shadow.coding.code_generator.ActivityCodeGenerator}
 * 自动生成
 */
@SuppressLint({"NullableProblems", "deprecation"})
public abstract class GeneratedPluginActivity extends ShadowContext implements Window.Callback, KeyEvent.Callback {
  GeneratedHostActivityDelegator hostActivityDelegator;

  public boolean isChangingConfigurations() {
    return hostActivityDelegator.superIsChangingConfigurations();
  }

  public void finish() {
    hostActivityDelegator.superFinish();
  }

  public LayoutInflater getLayoutInflater() {
    return hostActivityDelegator.superGetLayoutInflater();
  }

  public void recreate() {
    hostActivityDelegator.superRecreate();
  }

  public ComponentName getCallingActivity() {
    return hostActivityDelegator.superGetCallingActivity();
  }

  public CharSequence onCreateDescription() {
    return hostActivityDelegator.superOnCreateDescription();
  }

  public void onMultiWindowModeChanged(boolean arg0, Configuration arg1) {
    hostActivityDelegator.superOnMultiWindowModeChanged(arg0, arg1);
  }

  public void onMultiWindowModeChanged(boolean arg0) {
    hostActivityDelegator.superOnMultiWindowModeChanged(arg0);
  }

  public void onProvideAssistContent(AssistContent arg0) {
    hostActivityDelegator.superOnProvideAssistContent(arg0);
  }

  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> arg0, Menu arg1, int arg2) {
    hostActivityDelegator.superOnProvideKeyboardShortcuts(arg0, arg1, arg2);
  }

  public Object onRetainNonConfigurationInstance() {
    return hostActivityDelegator.superOnRetainNonConfigurationInstance();
  }

  public void onPerformDirectAction(String arg0, Bundle arg1, CancellationSignal arg2,
      Consumer<Bundle> arg3) {
    hostActivityDelegator.superOnPerformDirectAction(arg0, arg1, arg2, arg3);
  }

  public void onProvideAssistData(Bundle arg0) {
    hostActivityDelegator.superOnProvideAssistData(arg0);
  }

  public void onConfigurationChanged(Configuration arg0) {
    hostActivityDelegator.superOnConfigurationChanged(arg0);
  }

  public void onPictureInPictureModeChanged(boolean arg0) {
    hostActivityDelegator.superOnPictureInPictureModeChanged(arg0);
  }

  public void onPictureInPictureModeChanged(boolean arg0, Configuration arg1) {
    hostActivityDelegator.superOnPictureInPictureModeChanged(arg0, arg1);
  }

  public void onLocalVoiceInteractionStarted() {
    hostActivityDelegator.superOnLocalVoiceInteractionStarted();
  }

  public void onGetDirectActions(CancellationSignal arg0, Consumer<List<DirectAction>> arg1) {
    hostActivityDelegator.superOnGetDirectActions(arg0, arg1);
  }

  public void onSaveInstanceState(Bundle arg0, PersistableBundle arg1) {
    hostActivityDelegator.superOnSaveInstanceState(arg0, arg1);
  }

  public void onRestoreInstanceState(Bundle arg0, PersistableBundle arg1) {
    hostActivityDelegator.superOnRestoreInstanceState(arg0, arg1);
  }

  public void onLocalVoiceInteractionStopped() {
    hostActivityDelegator.superOnLocalVoiceInteractionStopped();
  }

  public boolean onCreateThumbnail(Bitmap arg0, Canvas arg1) {
    return hostActivityDelegator.superOnCreateThumbnail(arg0, arg1);
  }

  public void onTopResumedActivityChanged(boolean arg0) {
    hostActivityDelegator.superOnTopResumedActivityChanged(arg0);
  }

  public abstract boolean onNavigateUpFromChild(ShadowActivity arg0);

  public void onCreateNavigateUpTaskStack(TaskStackBuilder arg0) {
    hostActivityDelegator.superOnCreateNavigateUpTaskStack(arg0);
  }

  public void onPrepareNavigateUpTaskStack(TaskStackBuilder arg0) {
    hostActivityDelegator.superOnPrepareNavigateUpTaskStack(arg0);
  }

  public boolean onContextItemSelected(MenuItem arg0) {
    return hostActivityDelegator.superOnContextItemSelected(arg0);
  }

  public void onContextMenuClosed(Menu arg0) {
    hostActivityDelegator.superOnContextMenuClosed(arg0);
  }

  public boolean onSearchRequested() {
    return hostActivityDelegator.superOnSearchRequested();
  }

  public boolean onSearchRequested(SearchEvent arg0) {
    return hostActivityDelegator.superOnSearchRequested(arg0);
  }

  public boolean onCreateOptionsMenu(Menu arg0) {
    return hostActivityDelegator.superOnCreateOptionsMenu(arg0);
  }

  public boolean onCreatePanelMenu(int arg0, Menu arg1) {
    return hostActivityDelegator.superOnCreatePanelMenu(arg0, arg1);
  }

  public boolean onPrepareOptionsMenu(Menu arg0) {
    return hostActivityDelegator.superOnPrepareOptionsMenu(arg0);
  }

  public void onWindowAttributesChanged(WindowManager.LayoutParams arg0) {
    hostActivityDelegator.superOnWindowAttributesChanged(arg0);
  }

  public void onOptionsMenuClosed(Menu arg0) {
    hostActivityDelegator.superOnOptionsMenuClosed(arg0);
  }

  public void onUserInteraction() {
    hostActivityDelegator.superOnUserInteraction();
  }

  public void onCreateContextMenu(ContextMenu arg0, View arg1, ContextMenu.ContextMenuInfo arg2) {
    hostActivityDelegator.superOnCreateContextMenu(arg0, arg1, arg2);
  }

  public void onAttachedToWindow() {
    hostActivityDelegator.superOnAttachedToWindow();
  }

  public View onCreatePanelView(int arg0) {
    return hostActivityDelegator.superOnCreatePanelView(arg0);
  }

  public void onDetachedFromWindow() {
    hostActivityDelegator.superOnDetachedFromWindow();
  }

  public boolean onMenuItemSelected(int arg0, MenuItem arg1) {
    return hostActivityDelegator.superOnMenuItemSelected(arg0, arg1);
  }

  public void onWindowFocusChanged(boolean arg0) {
    hostActivityDelegator.superOnWindowFocusChanged(arg0);
  }

  public boolean onOptionsItemSelected(MenuItem arg0) {
    return hostActivityDelegator.superOnOptionsItemSelected(arg0);
  }

  public boolean onGenericMotionEvent(MotionEvent arg0) {
    return hostActivityDelegator.superOnGenericMotionEvent(arg0);
  }

  public void onVisibleBehindCanceled() {
    hostActivityDelegator.superOnVisibleBehindCanceled();
  }

  public ActionMode onWindowStartingActionMode(ActionMode.Callback arg0) {
    return hostActivityDelegator.superOnWindowStartingActionMode(arg0);
  }

  public ActionMode onWindowStartingActionMode(ActionMode.Callback arg0, int arg1) {
    return hostActivityDelegator.superOnWindowStartingActionMode(arg0, arg1);
  }

  public void onActivityReenter(int arg0, Intent arg1) {
    hostActivityDelegator.superOnActivityReenter(arg0, arg1);
  }

  public void onActionModeStarted(ActionMode arg0) {
    hostActivityDelegator.superOnActionModeStarted(arg0);
  }

  public void onActionModeFinished(ActionMode arg0) {
    hostActivityDelegator.superOnActionModeFinished(arg0);
  }

  public Uri onProvideReferrer() {
    return hostActivityDelegator.superOnProvideReferrer();
  }

  public void onRequestPermissionsResult(int arg0, String[] arg1, int[] arg2) {
    hostActivityDelegator.superOnRequestPermissionsResult(arg0, arg1, arg2);
  }

  public void onEnterAnimationComplete() {
    hostActivityDelegator.superOnEnterAnimationComplete();
  }

  public void onCreate(Bundle arg0, PersistableBundle arg1) {
    hostActivityDelegator.superOnCreate(arg0, arg1);
  }

  public void onBackPressed() {
    hostActivityDelegator.superOnBackPressed();
  }

  public boolean onTrackballEvent(MotionEvent arg0) {
    return hostActivityDelegator.superOnTrackballEvent(arg0);
  }

  public void onContentChanged() {
    hostActivityDelegator.superOnContentChanged();
  }

  public boolean onPreparePanel(int arg0, View arg1, Menu arg2) {
    return hostActivityDelegator.superOnPreparePanel(arg0, arg1, arg2);
  }

  public boolean onMenuOpened(int arg0, Menu arg1) {
    return hostActivityDelegator.superOnMenuOpened(arg0, arg1);
  }

  public boolean onKeyUp(int arg0, KeyEvent arg1) {
    return hostActivityDelegator.superOnKeyUp(arg0, arg1);
  }

  public void onLowMemory() {
    hostActivityDelegator.superOnLowMemory();
  }

  public void onAttachFragment(Fragment arg0) {
    hostActivityDelegator.superOnAttachFragment(arg0);
  }

  public boolean onKeyDown(int arg0, KeyEvent arg1) {
    return hostActivityDelegator.superOnKeyDown(arg0, arg1);
  }

  public boolean onKeyLongPress(int arg0, KeyEvent arg1) {
    return hostActivityDelegator.superOnKeyLongPress(arg0, arg1);
  }

  public void onStateNotSaved() {
    hostActivityDelegator.superOnStateNotSaved();
  }

  public boolean onKeyMultiple(int arg0, int arg1, KeyEvent arg2) {
    return hostActivityDelegator.superOnKeyMultiple(arg0, arg1, arg2);
  }

  public void onPostCreate(Bundle arg0, PersistableBundle arg1) {
    hostActivityDelegator.superOnPostCreate(arg0, arg1);
  }

  public void onTrimMemory(int arg0) {
    hostActivityDelegator.superOnTrimMemory(arg0);
  }

  public boolean onKeyShortcut(int arg0, KeyEvent arg1) {
    return hostActivityDelegator.superOnKeyShortcut(arg0, arg1);
  }

  public boolean onTouchEvent(MotionEvent arg0) {
    return hostActivityDelegator.superOnTouchEvent(arg0);
  }

  public View onCreateView(View arg0, String arg1, Context arg2, AttributeSet arg3) {
    return hostActivityDelegator.superOnCreateView(arg0, arg1, arg2, arg3);
  }

  public View onCreateView(String arg0, Context arg1, AttributeSet arg2) {
    return hostActivityDelegator.superOnCreateView(arg0, arg1, arg2);
  }

  public void onPanelClosed(int arg0, Menu arg1) {
    hostActivityDelegator.superOnPanelClosed(arg0, arg1);
  }

  public boolean onNavigateUp() {
    return hostActivityDelegator.superOnNavigateUp();
  }

  public void onPointerCaptureChanged(boolean arg0) {
    hostActivityDelegator.superOnPointerCaptureChanged(arg0);
  }

  public void onStop() {
    hostActivityDelegator.superOnStop();
  }

  public void onStart() {
    hostActivityDelegator.superOnStart();
  }

  public void onSaveInstanceState(Bundle arg0) {
    hostActivityDelegator.superOnSaveInstanceState(arg0);
  }

  public void onRestoreInstanceState(Bundle arg0) {
    hostActivityDelegator.superOnRestoreInstanceState(arg0);
  }

  public abstract void onChildTitleChanged(ShadowActivity arg0, CharSequence arg1);

  public void onApplyThemeResource(Resources.Theme arg0, int arg1, boolean arg2) {
    hostActivityDelegator.superOnApplyThemeResource(arg0, arg1, arg2);
  }

  public void onCreate(Bundle arg0) {
    Log.d("shadow_ca","hostActivityDelegator = "+hostActivityDelegator);
    hostActivityDelegator.superOnCreate(arg0);
  }

  public void onNewIntent(Intent arg0) {
    hostActivityDelegator.superOnNewIntent(arg0);
  }

  public void onUserLeaveHint() {
    hostActivityDelegator.superOnUserLeaveHint();
  }

  public void onPostResume() {
    hostActivityDelegator.superOnPostResume();
  }

  public void onRestart() {
    hostActivityDelegator.superOnRestart();
  }

  public void onPause() {
    hostActivityDelegator.superOnPause();
  }

  public void onPostCreate(Bundle arg0) {
    hostActivityDelegator.superOnPostCreate(arg0);
  }

  public void onDestroy() {
    hostActivityDelegator.superOnDestroy();
  }

  public void onResume() {
    hostActivityDelegator.superOnResume();
  }

  public void onTitleChanged(CharSequence arg0, int arg1) {
    hostActivityDelegator.superOnTitleChanged(arg0, arg1);
  }

  public Dialog onCreateDialog(int arg0) {
    return hostActivityDelegator.superOnCreateDialog(arg0);
  }

  public Dialog onCreateDialog(int arg0, Bundle arg1) {
    return hostActivityDelegator.superOnCreateDialog(arg0, arg1);
  }

  public void onPrepareDialog(int arg0, Dialog arg1, Bundle arg2) {
    hostActivityDelegator.superOnPrepareDialog(arg0, arg1, arg2);
  }

  public void onPrepareDialog(int arg0, Dialog arg1) {
    hostActivityDelegator.superOnPrepareDialog(arg0, arg1);
  }

  public void onActivityResult(int arg0, int arg1, Intent arg2) {
    hostActivityDelegator.superOnActivityResult(arg0, arg1, arg2);
  }

  public boolean dispatchGenericMotionEvent(MotionEvent arg0) {
    return hostActivityDelegator.superDispatchGenericMotionEvent(arg0);
  }

  public boolean dispatchTouchEvent(MotionEvent arg0) {
    return hostActivityDelegator.superDispatchTouchEvent(arg0);
  }

  public boolean dispatchKeyShortcutEvent(KeyEvent arg0) {
    return hostActivityDelegator.superDispatchKeyShortcutEvent(arg0);
  }

  public boolean dispatchTrackballEvent(MotionEvent arg0) {
    return hostActivityDelegator.superDispatchTrackballEvent(arg0);
  }

  public boolean dispatchKeyEvent(KeyEvent arg0) {
    return hostActivityDelegator.superDispatchKeyEvent(arg0);
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg0) {
    return hostActivityDelegator.superDispatchPopulateAccessibilityEvent(arg0);
  }

  public abstract ShadowActivity getParent();

  public boolean isDestroyed() {
    return hostActivityDelegator.isDestroyed();
  }

  public void dump(String arg0, FileDescriptor arg1, PrintWriter arg2, String[] arg3) {
    hostActivityDelegator.dump(arg0, arg1, arg2, arg3);
  }

  public void setResult(int arg0, Intent arg1) {
    hostActivityDelegator.setResult(arg0, arg1);
  }

  public void setResult(int arg0) {
    hostActivityDelegator.superSetResult(arg0);
  }

  public void requestShowKeyboardShortcuts() {
    hostActivityDelegator.requestShowKeyboardShortcuts();
  }

  public Object getLastNonConfigurationInstance() {
    return hostActivityDelegator.getLastNonConfigurationInstance();
  }

  public boolean isVoiceInteraction() {
    return hostActivityDelegator.isVoiceInteraction();
  }

  public void enterPictureInPictureMode() {
    hostActivityDelegator.enterPictureInPictureMode();
  }

  public boolean enterPictureInPictureMode(PictureInPictureParams arg0) {
    return hostActivityDelegator.enterPictureInPictureMode(arg0);
  }

  public void stopManagingCursor(Cursor arg0) {
    hostActivityDelegator.stopManagingCursor(arg0);
  }

  public boolean isVoiceInteractionRoot() {
    return hostActivityDelegator.isVoiceInteractionRoot();
  }

  public void stopLocalVoiceInteraction() {
    hostActivityDelegator.stopLocalVoiceInteraction();
  }

  public void startManagingCursor(Cursor arg0) {
    hostActivityDelegator.startManagingCursor(arg0);
  }

  public boolean isInMultiWindowMode() {
    return hostActivityDelegator.isInMultiWindowMode();
  }

  public FragmentManager getFragmentManager() {
    return hostActivityDelegator.getFragmentManager();
  }

  public VoiceInteractor getVoiceInteractor() {
    return hostActivityDelegator.getVoiceInteractor();
  }

  public void dismissKeyboardShortcutsHelper() {
    hostActivityDelegator.dismissKeyboardShortcutsHelper();
  }

  public void startLocalVoiceInteraction(Bundle arg0) {
    hostActivityDelegator.startLocalVoiceInteraction(arg0);
  }

  public void setPictureInPictureParams(PictureInPictureParams arg0) {
    hostActivityDelegator.setPictureInPictureParams(arg0);
  }

  public boolean isInPictureInPictureMode() {
    return hostActivityDelegator.isInPictureInPictureMode();
  }

  public int getMaxNumPictureInPictureActions() {
    return hostActivityDelegator.getMaxNumPictureInPictureActions();
  }

  public int getChangingConfigurations() {
    return hostActivityDelegator.getChangingConfigurations();
  }

  public boolean isLocalVoiceInteractionSupported() {
    return hostActivityDelegator.isLocalVoiceInteractionSupported();
  }

  public void registerForContextMenu(View arg0) {
    hostActivityDelegator.registerForContextMenu(arg0);
  }

  public void unregisterForContextMenu(View arg0) {
    hostActivityDelegator.unregisterForContextMenu(arg0);
  }

  public void setDefaultKeyMode(int arg0) {
    hostActivityDelegator.setDefaultKeyMode(arg0);
  }

  public void setFinishOnTouchOutside(boolean arg0) {
    hostActivityDelegator.setFinishOnTouchOutside(arg0);
  }

  public boolean requestWindowFeature(int arg0) {
    return hostActivityDelegator.requestWindowFeature(arg0);
  }

  public void setFeatureDrawableResource(int arg0, int arg1) {
    hostActivityDelegator.setFeatureDrawableResource(arg0, arg1);
  }

  public void setFeatureDrawableUri(int arg0, Uri arg1) {
    hostActivityDelegator.setFeatureDrawableUri(arg0, arg1);
  }

  public TransitionManager getContentTransitionManager() {
    return hostActivityDelegator.getContentTransitionManager();
  }

  public void setFeatureDrawable(int arg0, Drawable arg1) {
    hostActivityDelegator.setFeatureDrawable(arg0, arg1);
  }

  public void setFeatureDrawableAlpha(int arg0, int arg1) {
    hostActivityDelegator.setFeatureDrawableAlpha(arg0, arg1);
  }

  public void invalidateOptionsMenu() {
    hostActivityDelegator.invalidateOptionsMenu();
  }

  public void setContentTransitionManager(TransitionManager arg0) {
    hostActivityDelegator.setContentTransitionManager(arg0);
  }

  public boolean startNextMatchingActivity(Intent arg0, Bundle arg1) {
    return hostActivityDelegator.startNextMatchingActivity(arg0, arg1);
  }

  public boolean startNextMatchingActivity(Intent arg0) {
    return hostActivityDelegator.startNextMatchingActivity(arg0);
  }

  public void setSecondaryProgress(int arg0) {
    hostActivityDelegator.setSecondaryProgress(arg0);
  }

  public void startActivityForResult(Intent arg0, int arg1, Bundle arg2) {
    hostActivityDelegator.startActivityForResult(arg0, arg1, arg2);
  }

  public void startActivityForResult(Intent arg0, int arg1) {
    hostActivityDelegator.startActivityForResult(arg0, arg1);
  }

  public void finishAfterTransition() {
    hostActivityDelegator.finishAfterTransition();
  }

  public void overridePendingTransition(int arg0, int arg1) {
    hostActivityDelegator.overridePendingTransition(arg0, arg1);
  }

  public abstract void startActivityFromChild(ShadowActivity arg0, Intent arg1, int arg2,
      Bundle arg3);

  public abstract void startActivityFromChild(ShadowActivity arg0, Intent arg1, int arg2);

  public void startActivityFromFragment(Fragment arg0, Intent arg1, int arg2, Bundle arg3) {
    hostActivityDelegator.startActivityFromFragment(arg0, arg1, arg2, arg3);
  }

  public void startActivityFromFragment(Fragment arg0, Intent arg1, int arg2) {
    hostActivityDelegator.startActivityFromFragment(arg0, arg1, arg2);
  }

  public PendingIntent createPendingResult(int arg0, Intent arg1, int arg2) {
    return hostActivityDelegator.createPendingResult(arg0, arg1, arg2);
  }

  public int getVolumeControlStream() {
    return hostActivityDelegator.getVolumeControlStream();
  }

  public boolean shouldUpRecreateTask(Intent arg0) {
    return hostActivityDelegator.shouldUpRecreateTask(arg0);
  }

  public MediaController getMediaController() {
    return hostActivityDelegator.getMediaController();
  }

  public abstract boolean navigateUpToFromChild(ShadowActivity arg0, Intent arg1);

  public Intent getParentActivityIntent() {
    return hostActivityDelegator.getParentActivityIntent();
  }

  public void setEnterSharedElementCallback(SharedElementCallback arg0) {
    hostActivityDelegator.setEnterSharedElementCallback(arg0);
  }

  public void setExitSharedElementCallback(SharedElementCallback arg0) {
    hostActivityDelegator.setExitSharedElementCallback(arg0);
  }

  public void startIntentSenderForResult(IntentSender arg0, int arg1, Intent arg2, int arg3,
      int arg4, int arg5, Bundle arg6) throws IntentSender.SendIntentException {
    hostActivityDelegator.startIntentSenderForResult(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void startIntentSenderForResult(IntentSender arg0, int arg1, Intent arg2, int arg3,
      int arg4, int arg5) throws IntentSender.SendIntentException {
    hostActivityDelegator.startIntentSenderForResult(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public boolean startActivityIfNeeded(Intent arg0, int arg1) {
    return hostActivityDelegator.startActivityIfNeeded(arg0, arg1);
  }

  public boolean startActivityIfNeeded(Intent arg0, int arg1, Bundle arg2) {
    return hostActivityDelegator.startActivityIfNeeded(arg0, arg1, arg2);
  }

  public void setMediaController(MediaController arg0) {
    hostActivityDelegator.setMediaController(arg0);
  }

  public boolean requestVisibleBehind(boolean arg0) {
    return hostActivityDelegator.requestVisibleBehind(arg0);
  }

  public void setTaskDescription(ActivityManager.TaskDescription arg0) {
    hostActivityDelegator.setTaskDescription(arg0);
  }

  public void requestPermissions(String[] arg0, int arg1) {
    hostActivityDelegator.requestPermissions(arg0, arg1);
  }

  public boolean isActivityTransitionRunning() {
    return hostActivityDelegator.isActivityTransitionRunning();
  }

  public abstract void startIntentSenderFromChild(ShadowActivity arg0, IntentSender arg1, int arg2,
      Intent arg3, int arg4, int arg5, int arg6, Bundle arg7) throws
      IntentSender.SendIntentException;

  public abstract void startIntentSenderFromChild(ShadowActivity arg0, IntentSender arg1, int arg2,
      Intent arg3, int arg4, int arg5, int arg6) throws IntentSender.SendIntentException;

  public void setProgressBarVisibility(boolean arg0) {
    hostActivityDelegator.setProgressBarVisibility(arg0);
  }

  public void finishAndRemoveTask() {
    hostActivityDelegator.finishAndRemoveTask();
  }

  public String getCallingPackage() {
    return hostActivityDelegator.getCallingPackage();
  }

  public int getRequestedOrientation() {
    return hostActivityDelegator.getRequestedOrientation();
  }

  public void setVolumeControlStream(int arg0) {
    hostActivityDelegator.setVolumeControlStream(arg0);
  }

  public String getLocalClassName() {
    return hostActivityDelegator.getLocalClassName();
  }

  public abstract void finishActivityFromChild(ShadowActivity arg0, int arg1);

  public void setRequestedOrientation(int arg0) {
    hostActivityDelegator.setRequestedOrientation(arg0);
  }

  public void setProgressBarIndeterminate(boolean arg0) {
    hostActivityDelegator.setProgressBarIndeterminate(arg0);
  }

  public void postponeEnterTransition() {
    hostActivityDelegator.postponeEnterTransition();
  }

  public void setInheritShowWhenLocked(boolean arg0) {
    hostActivityDelegator.setInheritShowWhenLocked(arg0);
  }

  public DragAndDropPermissions requestDragAndDropPermissions(DragEvent arg0) {
    return hostActivityDelegator.requestDragAndDropPermissions(arg0);
  }

  public void showLockTaskEscapeMessage() {
    hostActivityDelegator.showLockTaskEscapeMessage();
  }

  public void setShowWhenLocked(boolean arg0) {
    hostActivityDelegator.setShowWhenLocked(arg0);
  }

  public void startPostponedEnterTransition() {
    hostActivityDelegator.startPostponedEnterTransition();
  }

  public ComponentName getComponentName() {
    return hostActivityDelegator.getComponentName();
  }

  public int getTaskId() {
    return hostActivityDelegator.getTaskId();
  }

  public void setTitle(int arg0) {
    hostActivityDelegator.setTitle(arg0);
  }

  public void setTitle(CharSequence arg0) {
    hostActivityDelegator.setTitle(arg0);
  }

  public CharSequence getTitle() {
    return hostActivityDelegator.getTitle();
  }

  public void setVisible(boolean arg0) {
    hostActivityDelegator.setVisible(arg0);
  }

  public void setContentView(View arg0, ViewGroup.LayoutParams arg1) {
    hostActivityDelegator.setContentView(arg0, arg1);
  }

  public void setContentView(int arg0) {
    hostActivityDelegator.setContentView(arg0);
  }

  public void setContentView(View arg0) {
    hostActivityDelegator.setContentView(arg0);
  }

  public boolean hasWindowFocus() {
    return hostActivityDelegator.hasWindowFocus();
  }

  public <T extends View> T requireViewById(int arg0) {
    return hostActivityDelegator.requireViewById(arg0);
  }

  public Cursor managedQuery(Uri arg0, String[] arg1, String arg2, String[] arg3, String arg4) {
    return hostActivityDelegator.managedQuery(arg0, arg1, arg2, arg3, arg4);
  }

  public void setIntent(Intent arg0) {
    hostActivityDelegator.setIntent(arg0);
  }

  public abstract ShadowApplication getApplication();

  public Scene getContentScene() {
    return hostActivityDelegator.getContentScene();
  }

  public View getCurrentFocus() {
    return hostActivityDelegator.getCurrentFocus();
  }

  public void setActionBar(Toolbar arg0) {
    hostActivityDelegator.setActionBar(arg0);
  }

  public boolean isChild() {
    return hostActivityDelegator.isChild();
  }

  public Intent getIntent() {
    return hostActivityDelegator.getIntent();
  }

  public boolean showAssist(Bundle arg0) {
    return hostActivityDelegator.showAssist(arg0);
  }

  public LoaderManager getLoaderManager() {
    return hostActivityDelegator.getLoaderManager();
  }

  public ActionBar getActionBar() {
    return hostActivityDelegator.getActionBar();
  }

  public Window getWindow() {
    return hostActivityDelegator.getWindow();
  }

  public void reportFullyDrawn() {
    hostActivityDelegator.reportFullyDrawn();
  }

  public <T extends View> T findViewById(int arg0) {
    return hostActivityDelegator.findViewById(arg0);
  }

  public WindowManager getWindowManager() {
    return hostActivityDelegator.getWindowManager();
  }

  public void addContentView(View arg0, ViewGroup.LayoutParams arg1) {
    hostActivityDelegator.addContentView(arg0, arg1);
  }

  public void runOnUiThread(Runnable arg0) {
    hostActivityDelegator.runOnUiThread(arg0);
  }

  public boolean isImmersive() {
    return hostActivityDelegator.isImmersive();
  }

  public void setImmersive(boolean arg0) {
    hostActivityDelegator.setImmersive(arg0);
  }

  public void setVrModeEnabled(boolean arg0, ComponentName arg1) throws
      PackageManager.NameNotFoundException {
    hostActivityDelegator.setVrModeEnabled(arg0, arg1);
  }

  public void removeDialog(int arg0) {
    hostActivityDelegator.removeDialog(arg0);
  }

  public void dismissDialog(int arg0) {
    hostActivityDelegator.dismissDialog(arg0);
  }

  public SearchEvent getSearchEvent() {
    return hostActivityDelegator.getSearchEvent();
  }

  public Uri getReferrer() {
    return hostActivityDelegator.getReferrer();
  }

  public boolean moveTaskToBack(boolean arg0) {
    return hostActivityDelegator.moveTaskToBack(arg0);
  }

  public SharedPreferences getPreferences(int arg0) {
    return hostActivityDelegator.getPreferences(arg0);
  }

  public void openOptionsMenu() {
    hostActivityDelegator.openOptionsMenu();
  }

  public void triggerSearch(String arg0, Bundle arg1) {
    hostActivityDelegator.triggerSearch(arg0, arg1);
  }

  public boolean releaseInstance() {
    return hostActivityDelegator.releaseInstance();
  }

  public abstract void finishFromChild(ShadowActivity arg0);

  public void closeOptionsMenu() {
    hostActivityDelegator.closeOptionsMenu();
  }

  public void setProgress(int arg0) {
    hostActivityDelegator.setProgress(arg0);
  }

  public void openContextMenu(View arg0) {
    hostActivityDelegator.openContextMenu(arg0);
  }

  public void startSearch(String arg0, boolean arg1, Bundle arg2, boolean arg3) {
    hostActivityDelegator.startSearch(arg0, arg1, arg2, arg3);
  }

  public void finishAffinity() {
    hostActivityDelegator.finishAffinity();
  }

  public void finishActivity(int arg0) {
    hostActivityDelegator.finishActivity(arg0);
  }

  public boolean isTaskRoot() {
    return hostActivityDelegator.isTaskRoot();
  }

  public void showDialog(int arg0) {
    hostActivityDelegator.showDialog(arg0);
  }

  public boolean showDialog(int arg0, Bundle arg1) {
    return hostActivityDelegator.showDialog(arg0, arg1);
  }

  public void closeContextMenu() {
    hostActivityDelegator.closeContextMenu();
  }

  public void takeKeyEvents(boolean arg0) {
    hostActivityDelegator.takeKeyEvents(arg0);
  }

  public boolean isFinishing() {
    return hostActivityDelegator.isFinishing();
  }

  public void setTitleColor(int arg0) {
    hostActivityDelegator.setTitleColor(arg0);
  }

  public int getTitleColor() {
    return hostActivityDelegator.getTitleColor();
  }

  public MenuInflater getMenuInflater() {
    return hostActivityDelegator.getMenuInflater();
  }

  public ActionMode startActionMode(ActionMode.Callback arg0, int arg1) {
    return hostActivityDelegator.startActionMode(arg0, arg1);
  }

  public ActionMode startActionMode(ActionMode.Callback arg0) {
    return hostActivityDelegator.startActionMode(arg0);
  }

  public void stopLockTask() {
    hostActivityDelegator.stopLockTask();
  }

  public void startLockTask() {
    hostActivityDelegator.startLockTask();
  }

  public boolean navigateUpTo(Intent arg0) {
    return hostActivityDelegator.navigateUpTo(arg0);
  }

  public void setTurnScreenOn(boolean arg0) {
    hostActivityDelegator.setTurnScreenOn(arg0);
  }

  public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks arg0) {
    hostActivityDelegator.registerActivityLifecycleCallbacks(arg0);
  }

  public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks arg0) {
    hostActivityDelegator.unregisterActivityLifecycleCallbacks(arg0);
  }

  public boolean shouldShowRequestPermissionRationale(String arg0) {
    return hostActivityDelegator.shouldShowRequestPermissionRationale(arg0);
  }

  public void setProgressBarIndeterminateVisibility(boolean arg0) {
    hostActivityDelegator.setProgressBarIndeterminateVisibility(arg0);
  }
}
