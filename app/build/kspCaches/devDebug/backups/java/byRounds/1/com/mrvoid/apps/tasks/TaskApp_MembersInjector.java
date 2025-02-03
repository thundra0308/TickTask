package com.mrvoid.apps.tasks;

import android.content.SharedPreferences;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Named;
import javax.inject.Provider;

@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class TaskApp_MembersInjector implements MembersInjector<TaskApp> {
  private final Provider<SharedPreferences> notificationPreferenceProvider;

  public TaskApp_MembersInjector(Provider<SharedPreferences> notificationPreferenceProvider) {
    this.notificationPreferenceProvider = notificationPreferenceProvider;
  }

  public static MembersInjector<TaskApp> create(
      Provider<SharedPreferences> notificationPreferenceProvider) {
    return new TaskApp_MembersInjector(notificationPreferenceProvider);
  }

  @Override
  public void injectMembers(TaskApp instance) {
    injectNotificationPreference(instance, notificationPreferenceProvider.get());
  }

  @InjectedFieldSignature("com.mrvoid.apps.tasks.TaskApp.notificationPreference")
  @Named("daily_notification")
  public static void injectNotificationPreference(TaskApp instance,
      SharedPreferences notificationPreference) {
    instance.notificationPreference = notificationPreference;
  }
}
