package com.wwq.pluginlibrary;

import android.app.ActionBar;
import android.app.Activity;
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
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Display;
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
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.CharSequence;
import java.lang.Class;
import java.lang.ClassLoader;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.String;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/**
 * 由
 * {@link com.tencent.shadow.coding.code_generator.ActivityCodeGenerator}
 * 自动生成
 * HostActivityDelegator作为委托者的接口。主要提供它的委托方法的super方法，
 * 以便Delegate可以通过这个接口调用到Activity的super方法。
 */
public interface GeneratedHostActivityDelegator {
  Activity getParent();

  boolean isDestroyed();

  void dump(String arg0, FileDescriptor arg1, PrintWriter arg2, String[] arg3);

  void setResult(int arg0, Intent arg1);

  void setResult(int arg0);

  void requestShowKeyboardShortcuts();

  Object getLastNonConfigurationInstance();

  boolean isVoiceInteraction();

  void enterPictureInPictureMode();

  boolean enterPictureInPictureMode(PictureInPictureParams arg0);

  void stopManagingCursor(Cursor arg0);

  boolean isVoiceInteractionRoot();

  void stopLocalVoiceInteraction();

  void startManagingCursor(Cursor arg0);

  boolean isInMultiWindowMode();

  FragmentManager getFragmentManager();

  VoiceInteractor getVoiceInteractor();

  void dismissKeyboardShortcutsHelper();

  void startLocalVoiceInteraction(Bundle arg0);

  void setPictureInPictureParams(PictureInPictureParams arg0);

  boolean isInPictureInPictureMode();

  int getMaxNumPictureInPictureActions();

  int getChangingConfigurations();

  boolean isLocalVoiceInteractionSupported();

  void registerForContextMenu(View arg0);

  void unregisterForContextMenu(View arg0);

  void setDefaultKeyMode(int arg0);

  void setFinishOnTouchOutside(boolean arg0);

  boolean requestWindowFeature(int arg0);

  void setFeatureDrawableResource(int arg0, int arg1);

  void setFeatureDrawableUri(int arg0, Uri arg1);

  TransitionManager getContentTransitionManager();

  void setFeatureDrawable(int arg0, Drawable arg1);

  void setFeatureDrawableAlpha(int arg0, int arg1);

  void invalidateOptionsMenu();

  void setContentTransitionManager(TransitionManager arg0);

  boolean startNextMatchingActivity(Intent arg0, Bundle arg1);

  boolean startNextMatchingActivity(Intent arg0);

  void setSecondaryProgress(int arg0);

  void startActivityForResult(Intent arg0, int arg1, Bundle arg2);

  void startActivityForResult(Intent arg0, int arg1);

  void startIntentSender(IntentSender arg0, Intent arg1, int arg2, int arg3, int arg4) throws
      IntentSender.SendIntentException;

  void startIntentSender(IntentSender arg0, Intent arg1, int arg2, int arg3, int arg4, Bundle arg5)
      throws IntentSender.SendIntentException;

  void finishAfterTransition();

  void overridePendingTransition(int arg0, int arg1);

  void startActivityFromChild(Activity arg0, Intent arg1, int arg2, Bundle arg3);

  void startActivityFromChild(Activity arg0, Intent arg1, int arg2);

  void startActivityFromFragment(Fragment arg0, Intent arg1, int arg2, Bundle arg3);

  void startActivityFromFragment(Fragment arg0, Intent arg1, int arg2);

  PendingIntent createPendingResult(int arg0, Intent arg1, int arg2);

  int getVolumeControlStream();

  boolean shouldUpRecreateTask(Intent arg0);

  MediaController getMediaController();

  boolean navigateUpToFromChild(Activity arg0, Intent arg1);

  Intent getParentActivityIntent();

  void setEnterSharedElementCallback(SharedElementCallback arg0);

  void setExitSharedElementCallback(SharedElementCallback arg0);

  void startIntentSenderForResult(IntentSender arg0, int arg1, Intent arg2, int arg3, int arg4,
      int arg5, Bundle arg6) throws IntentSender.SendIntentException;

  void startIntentSenderForResult(IntentSender arg0, int arg1, Intent arg2, int arg3, int arg4,
      int arg5) throws IntentSender.SendIntentException;

  boolean startActivityIfNeeded(Intent arg0, int arg1);

  boolean startActivityIfNeeded(Intent arg0, int arg1, Bundle arg2);

  void setMediaController(MediaController arg0);

  boolean requestVisibleBehind(boolean arg0);

  void setTaskDescription(ActivityManager.TaskDescription arg0);

  void requestPermissions(String[] arg0, int arg1);

  boolean isActivityTransitionRunning();

  void startIntentSenderFromChild(Activity arg0, IntentSender arg1, int arg2, Intent arg3, int arg4,
      int arg5, int arg6, Bundle arg7) throws IntentSender.SendIntentException;

  void startIntentSenderFromChild(Activity arg0, IntentSender arg1, int arg2, Intent arg3, int arg4,
      int arg5, int arg6) throws IntentSender.SendIntentException;

  void setProgressBarVisibility(boolean arg0);

  void finishAndRemoveTask();

  String getCallingPackage();

  int getRequestedOrientation();

  void setVolumeControlStream(int arg0);

  String getLocalClassName();

  void finishActivityFromChild(Activity arg0, int arg1);

  void setRequestedOrientation(int arg0);

  void setProgressBarIndeterminate(boolean arg0);

  void postponeEnterTransition();

  void setInheritShowWhenLocked(boolean arg0);

  DragAndDropPermissions requestDragAndDropPermissions(DragEvent arg0);

  void showLockTaskEscapeMessage();

  void setShowWhenLocked(boolean arg0);

  void startPostponedEnterTransition();

  ComponentName getComponentName();

  int getTaskId();

  void setTitle(int arg0);

  void setTitle(CharSequence arg0);

  CharSequence getTitle();

  void setVisible(boolean arg0);

  void setContentView(View arg0, ViewGroup.LayoutParams arg1);

  void setContentView(int arg0);

  void setContentView(View arg0);

  boolean hasWindowFocus();

  <T extends View> T requireViewById(int arg0);

  Cursor managedQuery(Uri arg0, String[] arg1, String arg2, String[] arg3, String arg4);

  void setIntent(Intent arg0);

  Application getApplication();

  Scene getContentScene();

  View getCurrentFocus();

  void setActionBar(Toolbar arg0);

  boolean isChild();

  Intent getIntent();

  boolean showAssist(Bundle arg0);

  LoaderManager getLoaderManager();

  ActionBar getActionBar();

  Window getWindow();

  void reportFullyDrawn();

  <T extends View> T findViewById(int arg0);

  WindowManager getWindowManager();

  void addContentView(View arg0, ViewGroup.LayoutParams arg1);

  void runOnUiThread(Runnable arg0);

  boolean isImmersive();

  void setImmersive(boolean arg0);

  void setVrModeEnabled(boolean arg0, ComponentName arg1) throws
      PackageManager.NameNotFoundException;

  void removeDialog(int arg0);

  void dismissDialog(int arg0);

  SearchEvent getSearchEvent();

  void setTheme(int arg0);

  Uri getReferrer();

  boolean moveTaskToBack(boolean arg0);

  SharedPreferences getPreferences(int arg0);

  void openOptionsMenu();

  void triggerSearch(String arg0, Bundle arg1);

  boolean releaseInstance();

  void finishFromChild(Activity arg0);

  void closeOptionsMenu();

  void setProgress(int arg0);

  void openContextMenu(View arg0);

  void startSearch(String arg0, boolean arg1, Bundle arg2, boolean arg3);

  void finishAffinity();

  void startActivities(Intent[] arg0, Bundle arg1);

  void startActivities(Intent[] arg0);

  void finishActivity(int arg0);

  boolean isTaskRoot();

  Object getSystemService(String arg0);

  void showDialog(int arg0);

  boolean showDialog(int arg0, Bundle arg1);

  void closeContextMenu();

  void takeKeyEvents(boolean arg0);

  boolean isFinishing();

  void setTitleColor(int arg0);

  int getTitleColor();

  void startActivity(Intent arg0, Bundle arg1);

  void startActivity(Intent arg0);

  MenuInflater getMenuInflater();

  ActionMode startActionMode(ActionMode.Callback arg0, int arg1);

  ActionMode startActionMode(ActionMode.Callback arg0);

  void stopLockTask();

  void startLockTask();

  boolean navigateUpTo(Intent arg0);

  void setTurnScreenOn(boolean arg0);

  void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks arg0);

  void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks arg0);

  boolean shouldShowRequestPermissionRationale(String arg0);

  void setProgressBarIndeterminateVisibility(boolean arg0);

  void applyOverrideConfiguration(Configuration arg0);

  void setTheme(Resources.Theme arg0);

  Resources.Theme getTheme();

  AssetManager getAssets();

  int checkPermission(String arg0, int arg1, int arg2);

  String getPackageName();

  PackageManager getPackageManager();

  boolean deleteFile(String arg0);

  File getCacheDir();

  String getPackageResourcePath();

  boolean moveSharedPreferencesFrom(Context arg0, String arg1);

  File getNoBackupFilesDir();

  File getExternalFilesDir(String arg0);

  SharedPreferences getSharedPreferences(String arg0, int arg1);

  File[] getExternalCacheDirs();

  File[] getExternalMediaDirs();

  SQLiteDatabase openOrCreateDatabase(String arg0, int arg1, SQLiteDatabase.CursorFactory arg2);

  SQLiteDatabase openOrCreateDatabase(String arg0, int arg1, SQLiteDatabase.CursorFactory arg2,
      DatabaseErrorHandler arg3);

  int getWallpaperDesiredMinimumWidth();

  void sendOrderedBroadcast(Intent arg0, String arg1, BroadcastReceiver arg2, Handler arg3,
      int arg4, String arg5, Bundle arg6);

  void sendOrderedBroadcast(Intent arg0, String arg1);

  void sendBroadcastAsUser(Intent arg0, UserHandle arg1, String arg2);

  void sendBroadcastAsUser(Intent arg0, UserHandle arg1);

  File getFileStreamPath(String arg0);

  int getWallpaperDesiredMinimumHeight();

  File getExternalCacheDir();

  void sendOrderedBroadcastAsUser(Intent arg0, UserHandle arg1, String arg2, BroadcastReceiver arg3,
      Handler arg4, int arg5, String arg6, Bundle arg7);

  void sendStickyBroadcast(Intent arg0);

  void sendStickyOrderedBroadcast(Intent arg0, BroadcastReceiver arg1, Handler arg2, int arg3,
      String arg4, Bundle arg5);

  void removeStickyBroadcast(Intent arg0);

  File[] getExternalFilesDirs(String arg0);

  boolean deleteSharedPreferences(String arg0);

  ContentResolver getContentResolver();

  Context getApplicationContext();

  ApplicationInfo getApplicationInfo();

  String getPackageCodePath();

  void enforceUriPermission(Uri arg0, String arg1, String arg2, int arg3, int arg4, int arg5,
      String arg6);

  void enforceUriPermission(Uri arg0, int arg1, int arg2, int arg3, String arg4);

  void enforceCallingOrSelfPermission(String arg0, String arg1);

  void sendStickyBroadcastAsUser(Intent arg0, UserHandle arg1);

  ComponentName startForegroundService(Intent arg0);

  void grantUriPermission(String arg0, Uri arg1, int arg2);

  Context createConfigurationContext(Configuration arg0);

  void updateServiceGroup(ServiceConnection arg0, int arg1, int arg2);

  void enforceCallingPermission(String arg0, String arg1);

  void enforceCallingUriPermission(Uri arg0, int arg1, String arg2);

  boolean bindIsolatedService(Intent arg0, int arg1, String arg2, Executor arg3,
      ServiceConnection arg4);

  void revokeUriPermission(Uri arg0, int arg1);

  void revokeUriPermission(String arg0, Uri arg1, int arg2);

  void sendStickyOrderedBroadcastAsUser(Intent arg0, UserHandle arg1, BroadcastReceiver arg2,
      Handler arg3, int arg4, String arg5, Bundle arg6);

  boolean startInstrumentation(ComponentName arg0, String arg1, Bundle arg2);

  int checkCallingOrSelfPermission(String arg0);

  int checkCallingPermission(String arg0);

  int checkSelfPermission(String arg0);

  Context createPackageContext(String arg0, int arg1) throws PackageManager.NameNotFoundException;

  int checkCallingOrSelfUriPermission(Uri arg0, int arg1);

  Context createContextForSplit(String arg0) throws PackageManager.NameNotFoundException;

  Context createDisplayContext(Display arg0);

  boolean isDeviceProtectedStorage();

  int checkCallingUriPermission(Uri arg0, int arg1);

  void unregisterReceiver(BroadcastReceiver arg0);

  void removeStickyBroadcastAsUser(Intent arg0, UserHandle arg1);

  void enforcePermission(String arg0, int arg1, int arg2, String arg3);

  String getSystemServiceName(Class<?> arg0);

  int checkUriPermission(Uri arg0, int arg1, int arg2, int arg3);

  int checkUriPermission(Uri arg0, String arg1, String arg2, int arg3, int arg4, int arg5);

  File getDir(String arg0, int arg1);

  File getDatabasePath(String arg0);

  String[] fileList();

  File getFilesDir();

  boolean moveDatabaseFrom(Context arg0, String arg1);

  Context getBaseContext();

  boolean deleteDatabase(String arg0);

  Drawable peekWallpaper();

  void clearWallpaper() throws IOException;

  void unbindService(ServiceConnection arg0);

  void setWallpaper(Bitmap arg0) throws IOException;

  void setWallpaper(InputStream arg0) throws IOException;

  FileOutputStream openFileOutput(String arg0, int arg1) throws FileNotFoundException;

  File getObbDir();

  Drawable getWallpaper();

  boolean stopService(Intent arg0);

  boolean isRestricted();

  FileInputStream openFileInput(String arg0) throws FileNotFoundException;

  void sendBroadcast(Intent arg0, String arg1);

  void sendBroadcast(Intent arg0);

  String getOpPackageName();

  File getDataDir();

  File[] getObbDirs();

  Looper getMainLooper();

  File getCodeCacheDir();

  String[] databaseList();

  Intent registerReceiver(BroadcastReceiver arg0, IntentFilter arg1, String arg2, Handler arg3,
      int arg4);

  Intent registerReceiver(BroadcastReceiver arg0, IntentFilter arg1, int arg2);

  Intent registerReceiver(BroadcastReceiver arg0, IntentFilter arg1, String arg2, Handler arg3);

  Intent registerReceiver(BroadcastReceiver arg0, IntentFilter arg1);

  ComponentName startService(Intent arg0);

  Executor getMainExecutor();

  boolean bindService(Intent arg0, ServiceConnection arg1, int arg2);

  boolean bindService(Intent arg0, int arg1, Executor arg2, ServiceConnection arg3);

  void enforceCallingOrSelfUriPermission(Uri arg0, int arg1, String arg2);

  Context createDeviceProtectedStorageContext();

  void unregisterComponentCallbacks(ComponentCallbacks arg0);

  void registerComponentCallbacks(ComponentCallbacks arg0);

  void attachBaseContext(Context arg0);

  boolean isChangingConfigurations();

  void finish();

  ClassLoader getClassLoader();

  LayoutInflater getLayoutInflater();

  Resources getResources();

  void recreate();

  ComponentName getCallingActivity();

  void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> arg0, Menu arg1, int arg2);

  boolean onSearchRequested();

  boolean onSearchRequested(SearchEvent arg0);

  boolean onCreatePanelMenu(int arg0, Menu arg1);

  void onWindowAttributesChanged(WindowManager.LayoutParams arg0);

  void onAttachedToWindow();

  View onCreatePanelView(int arg0);

  void onDetachedFromWindow();

  boolean onMenuItemSelected(int arg0, MenuItem arg1);

  void onWindowFocusChanged(boolean arg0);

  ActionMode onWindowStartingActionMode(ActionMode.Callback arg0);

  ActionMode onWindowStartingActionMode(ActionMode.Callback arg0, int arg1);

  void onActionModeStarted(ActionMode arg0);

  void onActionModeFinished(ActionMode arg0);

  void onContentChanged();

  boolean onPreparePanel(int arg0, View arg1, Menu arg2);

  boolean onMenuOpened(int arg0, Menu arg1);

  void onPanelClosed(int arg0, Menu arg1);

  void onPointerCaptureChanged(boolean arg0);

  boolean dispatchGenericMotionEvent(MotionEvent arg0);

  boolean dispatchTouchEvent(MotionEvent arg0);

  boolean dispatchKeyShortcutEvent(KeyEvent arg0);

  boolean dispatchTrackballEvent(MotionEvent arg0);

  boolean dispatchKeyEvent(KeyEvent arg0);

  boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg0);

  boolean superIsChangingConfigurations();

  void superFinish();

  ClassLoader superGetClassLoader();

  LayoutInflater superGetLayoutInflater();

  Resources superGetResources();

  void superRecreate();

  ComponentName superGetCallingActivity();

  CharSequence superOnCreateDescription();

  void superOnMultiWindowModeChanged(boolean arg0, Configuration arg1);

  void superOnMultiWindowModeChanged(boolean arg0);

  void superOnProvideAssistContent(AssistContent arg0);

  void superOnProvideKeyboardShortcuts(List<KeyboardShortcutGroup> arg0, Menu arg1, int arg2);

  Object superOnRetainNonConfigurationInstance();

  void superOnPerformDirectAction(String arg0, Bundle arg1, CancellationSignal arg2,
      Consumer<Bundle> arg3);

  void superOnProvideAssistData(Bundle arg0);

  void superOnConfigurationChanged(Configuration arg0);

  void superOnPictureInPictureModeChanged(boolean arg0);

  void superOnPictureInPictureModeChanged(boolean arg0, Configuration arg1);

  void superOnLocalVoiceInteractionStarted();

  void superOnGetDirectActions(CancellationSignal arg0, Consumer<List<DirectAction>> arg1);

  void superOnSaveInstanceState(Bundle arg0, PersistableBundle arg1);

  void superOnRestoreInstanceState(Bundle arg0, PersistableBundle arg1);

  void superOnLocalVoiceInteractionStopped();

  boolean superOnCreateThumbnail(Bitmap arg0, Canvas arg1);

  void superOnTopResumedActivityChanged(boolean arg0);

  boolean superOnNavigateUpFromChild(Activity arg0);

  void superOnCreateNavigateUpTaskStack(TaskStackBuilder arg0);

  void superOnPrepareNavigateUpTaskStack(TaskStackBuilder arg0);

  boolean superOnContextItemSelected(MenuItem arg0);

  void superOnContextMenuClosed(Menu arg0);

  boolean superOnSearchRequested();

  boolean superOnSearchRequested(SearchEvent arg0);

  boolean superOnCreateOptionsMenu(Menu arg0);

  boolean superOnCreatePanelMenu(int arg0, Menu arg1);

  boolean superOnPrepareOptionsMenu(Menu arg0);

  void superOnWindowAttributesChanged(WindowManager.LayoutParams arg0);

  void superOnOptionsMenuClosed(Menu arg0);

  void superOnUserInteraction();

  void superOnCreateContextMenu(ContextMenu arg0, View arg1, ContextMenu.ContextMenuInfo arg2);

  void superOnAttachedToWindow();

  View superOnCreatePanelView(int arg0);

  void superOnDetachedFromWindow();

  boolean superOnMenuItemSelected(int arg0, MenuItem arg1);

  void superOnWindowFocusChanged(boolean arg0);

  boolean superOnOptionsItemSelected(MenuItem arg0);

  boolean superOnGenericMotionEvent(MotionEvent arg0);

  void superOnVisibleBehindCanceled();

  ActionMode superOnWindowStartingActionMode(ActionMode.Callback arg0);

  ActionMode superOnWindowStartingActionMode(ActionMode.Callback arg0, int arg1);

  void superOnActivityReenter(int arg0, Intent arg1);

  void superOnActionModeStarted(ActionMode arg0);

  void superOnActionModeFinished(ActionMode arg0);

  Uri superOnProvideReferrer();

  void superOnRequestPermissionsResult(int arg0, String[] arg1, int[] arg2);

  void superOnEnterAnimationComplete();

  void superOnCreate(Bundle arg0, PersistableBundle arg1);

  void superOnBackPressed();

  boolean superOnTrackballEvent(MotionEvent arg0);

  void superOnContentChanged();

  boolean superOnPreparePanel(int arg0, View arg1, Menu arg2);

  boolean superOnMenuOpened(int arg0, Menu arg1);

  boolean superOnKeyUp(int arg0, KeyEvent arg1);

  void superOnLowMemory();

  void superOnAttachFragment(Fragment arg0);

  boolean superOnKeyDown(int arg0, KeyEvent arg1);

  boolean superOnKeyLongPress(int arg0, KeyEvent arg1);

  void superOnStateNotSaved();

  boolean superOnKeyMultiple(int arg0, int arg1, KeyEvent arg2);

  void superOnPostCreate(Bundle arg0, PersistableBundle arg1);

  void superOnTrimMemory(int arg0);

  boolean superOnKeyShortcut(int arg0, KeyEvent arg1);

  boolean superOnTouchEvent(MotionEvent arg0);

  View superOnCreateView(View arg0, String arg1, Context arg2, AttributeSet arg3);

  View superOnCreateView(String arg0, Context arg1, AttributeSet arg2);

  void superOnPanelClosed(int arg0, Menu arg1);

  boolean superOnNavigateUp();

  void superOnPointerCaptureChanged(boolean arg0);

  void superOnStop();

  void superOnStart();

  void superOnSaveInstanceState(Bundle arg0);

  void superOnRestoreInstanceState(Bundle arg0);

  void superOnChildTitleChanged(Activity arg0, CharSequence arg1);

  void superOnApplyThemeResource(Resources.Theme arg0, int arg1, boolean arg2);

  void superOnCreate(Bundle arg0);

  void superOnNewIntent(Intent arg0);

  void superOnUserLeaveHint();

  void superOnPostResume();

  void superOnRestart();

  void superOnPause();

  void superOnPostCreate(Bundle arg0);

  void superOnDestroy();

  void superOnResume();

  void superOnTitleChanged(CharSequence arg0, int arg1);

  Dialog superOnCreateDialog(int arg0);

  Dialog superOnCreateDialog(int arg0, Bundle arg1);

  void superOnPrepareDialog(int arg0, Dialog arg1, Bundle arg2);

  void superOnPrepareDialog(int arg0, Dialog arg1);

  void superOnActivityResult(int arg0, int arg1, Intent arg2);

  boolean superDispatchGenericMotionEvent(MotionEvent arg0);

  boolean superDispatchTouchEvent(MotionEvent arg0);

  boolean superDispatchKeyShortcutEvent(KeyEvent arg0);

  boolean superDispatchTrackballEvent(MotionEvent arg0);

  boolean superDispatchKeyEvent(KeyEvent arg0);

  boolean superDispatchPopulateAccessibilityEvent(AccessibilityEvent arg0);

  Activity superGetParent();

  boolean superIsDestroyed();

  void superDump(String arg0, FileDescriptor arg1, PrintWriter arg2, String[] arg3);

  void superSetResult(int arg0, Intent arg1);

  void superSetResult(int arg0);

  void superRequestShowKeyboardShortcuts();

  Object superGetLastNonConfigurationInstance();

  boolean superIsVoiceInteraction();

  void superEnterPictureInPictureMode();

  boolean superEnterPictureInPictureMode(PictureInPictureParams arg0);

  void superStopManagingCursor(Cursor arg0);

  boolean superIsVoiceInteractionRoot();

  void superStopLocalVoiceInteraction();

  void superStartManagingCursor(Cursor arg0);

  boolean superIsInMultiWindowMode();

  FragmentManager superGetFragmentManager();

  VoiceInteractor superGetVoiceInteractor();

  void superDismissKeyboardShortcutsHelper();

  void superStartLocalVoiceInteraction(Bundle arg0);

  void superSetPictureInPictureParams(PictureInPictureParams arg0);

  boolean superIsInPictureInPictureMode();

  int superGetMaxNumPictureInPictureActions();

  int superGetChangingConfigurations();

  boolean superIsLocalVoiceInteractionSupported();

  void superRegisterForContextMenu(View arg0);

  void superUnregisterForContextMenu(View arg0);

  void superSetDefaultKeyMode(int arg0);

  void superSetFinishOnTouchOutside(boolean arg0);

  boolean superRequestWindowFeature(int arg0);

  void superSetFeatureDrawableResource(int arg0, int arg1);

  void superSetFeatureDrawableUri(int arg0, Uri arg1);

  TransitionManager superGetContentTransitionManager();

  void superSetFeatureDrawable(int arg0, Drawable arg1);

  void superSetFeatureDrawableAlpha(int arg0, int arg1);

  void superInvalidateOptionsMenu();

  void superSetContentTransitionManager(TransitionManager arg0);

  boolean superStartNextMatchingActivity(Intent arg0, Bundle arg1);

  boolean superStartNextMatchingActivity(Intent arg0);

  void superSetSecondaryProgress(int arg0);

  void superStartActivityForResult(Intent arg0, int arg1, Bundle arg2);

  void superStartActivityForResult(Intent arg0, int arg1);

  void superStartIntentSender(IntentSender arg0, Intent arg1, int arg2, int arg3, int arg4) throws
      IntentSender.SendIntentException;

  void superStartIntentSender(IntentSender arg0, Intent arg1, int arg2, int arg3, int arg4,
      Bundle arg5) throws IntentSender.SendIntentException;

  void superFinishAfterTransition();

  void superOverridePendingTransition(int arg0, int arg1);

  void superStartActivityFromChild(Activity arg0, Intent arg1, int arg2, Bundle arg3);

  void superStartActivityFromChild(Activity arg0, Intent arg1, int arg2);

  void superStartActivityFromFragment(Fragment arg0, Intent arg1, int arg2, Bundle arg3);

  void superStartActivityFromFragment(Fragment arg0, Intent arg1, int arg2);

  PendingIntent superCreatePendingResult(int arg0, Intent arg1, int arg2);

  int superGetVolumeControlStream();

  boolean superShouldUpRecreateTask(Intent arg0);

  MediaController superGetMediaController();

  boolean superNavigateUpToFromChild(Activity arg0, Intent arg1);

  Intent superGetParentActivityIntent();

  void superSetEnterSharedElementCallback(SharedElementCallback arg0);

  void superSetExitSharedElementCallback(SharedElementCallback arg0);

  void superStartIntentSenderForResult(IntentSender arg0, int arg1, Intent arg2, int arg3, int arg4,
      int arg5, Bundle arg6) throws IntentSender.SendIntentException;

  void superStartIntentSenderForResult(IntentSender arg0, int arg1, Intent arg2, int arg3, int arg4,
      int arg5) throws IntentSender.SendIntentException;

  boolean superStartActivityIfNeeded(Intent arg0, int arg1);

  boolean superStartActivityIfNeeded(Intent arg0, int arg1, Bundle arg2);

  void superSetMediaController(MediaController arg0);

  boolean superRequestVisibleBehind(boolean arg0);

  void superSetTaskDescription(ActivityManager.TaskDescription arg0);

  void superRequestPermissions(String[] arg0, int arg1);

  boolean superIsActivityTransitionRunning();

  void superStartIntentSenderFromChild(Activity arg0, IntentSender arg1, int arg2, Intent arg3,
      int arg4, int arg5, int arg6, Bundle arg7) throws IntentSender.SendIntentException;

  void superStartIntentSenderFromChild(Activity arg0, IntentSender arg1, int arg2, Intent arg3,
      int arg4, int arg5, int arg6) throws IntentSender.SendIntentException;

  void superSetProgressBarVisibility(boolean arg0);

  void superFinishAndRemoveTask();

  String superGetCallingPackage();

  int superGetRequestedOrientation();

  void superSetVolumeControlStream(int arg0);

  String superGetLocalClassName();

  void superFinishActivityFromChild(Activity arg0, int arg1);

  void superSetRequestedOrientation(int arg0);

  void superSetProgressBarIndeterminate(boolean arg0);

  void superPostponeEnterTransition();

  void superSetInheritShowWhenLocked(boolean arg0);

  DragAndDropPermissions superRequestDragAndDropPermissions(DragEvent arg0);

  void superShowLockTaskEscapeMessage();

  void superSetShowWhenLocked(boolean arg0);

  void superStartPostponedEnterTransition();

  ComponentName superGetComponentName();

  int superGetTaskId();

  void superSetTitle(int arg0);

  void superSetTitle(CharSequence arg0);

  CharSequence superGetTitle();

  void superSetVisible(boolean arg0);

  void superSetContentView(View arg0, ViewGroup.LayoutParams arg1);

  void superSetContentView(int arg0);

  void superSetContentView(View arg0);

  boolean superHasWindowFocus();

  <T extends View> T superRequireViewById(int arg0);

  Cursor superManagedQuery(Uri arg0, String[] arg1, String arg2, String[] arg3, String arg4);

  void superSetIntent(Intent arg0);

  Application superGetApplication();

  Scene superGetContentScene();

  View superGetCurrentFocus();

  void superSetActionBar(Toolbar arg0);

  boolean superIsChild();

  Intent superGetIntent();

  boolean superShowAssist(Bundle arg0);

  LoaderManager superGetLoaderManager();

  ActionBar superGetActionBar();

  Window superGetWindow();

  void superReportFullyDrawn();

  <T extends View> T superFindViewById(int arg0);

  WindowManager superGetWindowManager();

  void superAddContentView(View arg0, ViewGroup.LayoutParams arg1);

  void superRunOnUiThread(Runnable arg0);

  boolean superIsImmersive();

  void superSetImmersive(boolean arg0);

  void superSetVrModeEnabled(boolean arg0, ComponentName arg1) throws
      PackageManager.NameNotFoundException;

  void superRemoveDialog(int arg0);

  void superDismissDialog(int arg0);

  SearchEvent superGetSearchEvent();

  void superSetTheme(int arg0);

  Uri superGetReferrer();

  boolean superMoveTaskToBack(boolean arg0);

  SharedPreferences superGetPreferences(int arg0);

  void superOpenOptionsMenu();

  void superTriggerSearch(String arg0, Bundle arg1);

  boolean superReleaseInstance();

  void superFinishFromChild(Activity arg0);

  void superCloseOptionsMenu();

  void superSetProgress(int arg0);

  void superOpenContextMenu(View arg0);

  void superStartSearch(String arg0, boolean arg1, Bundle arg2, boolean arg3);

  void superFinishAffinity();

  void superStartActivities(Intent[] arg0, Bundle arg1);

  void superStartActivities(Intent[] arg0);

  void superFinishActivity(int arg0);

  boolean superIsTaskRoot();

  Object superGetSystemService(String arg0);

  void superShowDialog(int arg0);

  boolean superShowDialog(int arg0, Bundle arg1);

  void superCloseContextMenu();

  void superTakeKeyEvents(boolean arg0);

  boolean superIsFinishing();

  void superSetTitleColor(int arg0);

  int superGetTitleColor();

  void superStartActivity(Intent arg0, Bundle arg1);

  void superStartActivity(Intent arg0);

  MenuInflater superGetMenuInflater();

  ActionMode superStartActionMode(ActionMode.Callback arg0, int arg1);

  ActionMode superStartActionMode(ActionMode.Callback arg0);

  void superStopLockTask();

  void superStartLockTask();

  boolean superNavigateUpTo(Intent arg0);

  void superSetTurnScreenOn(boolean arg0);

  void superRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks arg0);

  void superUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks arg0);

  boolean superShouldShowRequestPermissionRationale(String arg0);

  void superSetProgressBarIndeterminateVisibility(boolean arg0);

  void superApplyOverrideConfiguration(Configuration arg0);

  void superSetTheme(Resources.Theme arg0);

  Resources.Theme superGetTheme();

  AssetManager superGetAssets();

  int superCheckPermission(String arg0, int arg1, int arg2);

  String superGetPackageName();

  PackageManager superGetPackageManager();

  boolean superDeleteFile(String arg0);

  File superGetCacheDir();

  String superGetPackageResourcePath();

  boolean superMoveSharedPreferencesFrom(Context arg0, String arg1);

  File superGetNoBackupFilesDir();

  File superGetExternalFilesDir(String arg0);

  SharedPreferences superGetSharedPreferences(String arg0, int arg1);

  File[] superGetExternalCacheDirs();

  File[] superGetExternalMediaDirs();

  SQLiteDatabase superOpenOrCreateDatabase(String arg0, int arg1,
      SQLiteDatabase.CursorFactory arg2);

  SQLiteDatabase superOpenOrCreateDatabase(String arg0, int arg1, SQLiteDatabase.CursorFactory arg2,
      DatabaseErrorHandler arg3);

  int superGetWallpaperDesiredMinimumWidth();

  void superSendOrderedBroadcast(Intent arg0, String arg1, BroadcastReceiver arg2, Handler arg3,
      int arg4, String arg5, Bundle arg6);

  void superSendOrderedBroadcast(Intent arg0, String arg1);

  void superSendBroadcastAsUser(Intent arg0, UserHandle arg1, String arg2);

  void superSendBroadcastAsUser(Intent arg0, UserHandle arg1);

  File superGetFileStreamPath(String arg0);

  int superGetWallpaperDesiredMinimumHeight();

  File superGetExternalCacheDir();

  void superSendOrderedBroadcastAsUser(Intent arg0, UserHandle arg1, String arg2,
      BroadcastReceiver arg3, Handler arg4, int arg5, String arg6, Bundle arg7);

  void superSendStickyBroadcast(Intent arg0);

  void superSendStickyOrderedBroadcast(Intent arg0, BroadcastReceiver arg1, Handler arg2, int arg3,
      String arg4, Bundle arg5);

  void superRemoveStickyBroadcast(Intent arg0);

  File[] superGetExternalFilesDirs(String arg0);

  boolean superDeleteSharedPreferences(String arg0);

  ContentResolver superGetContentResolver();

  Context superGetApplicationContext();

  ApplicationInfo superGetApplicationInfo();

  String superGetPackageCodePath();

  void superEnforceUriPermission(Uri arg0, String arg1, String arg2, int arg3, int arg4, int arg5,
      String arg6);

  void superEnforceUriPermission(Uri arg0, int arg1, int arg2, int arg3, String arg4);

  void superEnforceCallingOrSelfPermission(String arg0, String arg1);

  void superSendStickyBroadcastAsUser(Intent arg0, UserHandle arg1);

  ComponentName superStartForegroundService(Intent arg0);

  void superGrantUriPermission(String arg0, Uri arg1, int arg2);

  Context superCreateConfigurationContext(Configuration arg0);

  void superUpdateServiceGroup(ServiceConnection arg0, int arg1, int arg2);

  void superEnforceCallingPermission(String arg0, String arg1);

  void superEnforceCallingUriPermission(Uri arg0, int arg1, String arg2);

  boolean superBindIsolatedService(Intent arg0, int arg1, String arg2, Executor arg3,
      ServiceConnection arg4);

  void superRevokeUriPermission(Uri arg0, int arg1);

  void superRevokeUriPermission(String arg0, Uri arg1, int arg2);

  void superSendStickyOrderedBroadcastAsUser(Intent arg0, UserHandle arg1, BroadcastReceiver arg2,
      Handler arg3, int arg4, String arg5, Bundle arg6);

  boolean superStartInstrumentation(ComponentName arg0, String arg1, Bundle arg2);

  int superCheckCallingOrSelfPermission(String arg0);

  int superCheckCallingPermission(String arg0);

  int superCheckSelfPermission(String arg0);

  Context superCreatePackageContext(String arg0, int arg1) throws
      PackageManager.NameNotFoundException;

  int superCheckCallingOrSelfUriPermission(Uri arg0, int arg1);

  Context superCreateContextForSplit(String arg0) throws PackageManager.NameNotFoundException;

  Context superCreateDisplayContext(Display arg0);

  boolean superIsDeviceProtectedStorage();

  int superCheckCallingUriPermission(Uri arg0, int arg1);

  void superUnregisterReceiver(BroadcastReceiver arg0);

  void superRemoveStickyBroadcastAsUser(Intent arg0, UserHandle arg1);

  void superEnforcePermission(String arg0, int arg1, int arg2, String arg3);

  String superGetSystemServiceName(Class<?> arg0);

  int superCheckUriPermission(Uri arg0, int arg1, int arg2, int arg3);

  int superCheckUriPermission(Uri arg0, String arg1, String arg2, int arg3, int arg4, int arg5);

  File superGetDir(String arg0, int arg1);

  File superGetDatabasePath(String arg0);

  String[] superFileList();

  File superGetFilesDir();

  boolean superMoveDatabaseFrom(Context arg0, String arg1);

  Context superGetBaseContext();

  boolean superDeleteDatabase(String arg0);

  Drawable superPeekWallpaper();

  void superClearWallpaper() throws IOException;

  void superUnbindService(ServiceConnection arg0);

  void superSetWallpaper(Bitmap arg0) throws IOException;

  void superSetWallpaper(InputStream arg0) throws IOException;

  FileOutputStream superOpenFileOutput(String arg0, int arg1) throws FileNotFoundException;

  File superGetObbDir();

  Drawable superGetWallpaper();

  boolean superStopService(Intent arg0);

  boolean superIsRestricted();

  FileInputStream superOpenFileInput(String arg0) throws FileNotFoundException;

  void superSendBroadcast(Intent arg0, String arg1);

  void superSendBroadcast(Intent arg0);

  String superGetOpPackageName();

  File superGetDataDir();

  File[] superGetObbDirs();

  Looper superGetMainLooper();

  File superGetCodeCacheDir();

  String[] superDatabaseList();

  Intent superRegisterReceiver(BroadcastReceiver arg0, IntentFilter arg1, String arg2, Handler arg3,
      int arg4);

  Intent superRegisterReceiver(BroadcastReceiver arg0, IntentFilter arg1, int arg2);

  Intent superRegisterReceiver(BroadcastReceiver arg0, IntentFilter arg1, String arg2,
      Handler arg3);

  Intent superRegisterReceiver(BroadcastReceiver arg0, IntentFilter arg1);

  ComponentName superStartService(Intent arg0);

  Executor superGetMainExecutor();

  boolean superBindService(Intent arg0, ServiceConnection arg1, int arg2);

  boolean superBindService(Intent arg0, int arg1, Executor arg2, ServiceConnection arg3);

  void superEnforceCallingOrSelfUriPermission(Uri arg0, int arg1, String arg2);

  Context superCreateDeviceProtectedStorageContext();

  void superUnregisterComponentCallbacks(ComponentCallbacks arg0);

  void superRegisterComponentCallbacks(ComponentCallbacks arg0);

  void superAttachBaseContext(Context arg0);
}
