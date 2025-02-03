package com.mrvoid.apps.tasks.di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({
    "javax.inject.Named",
    "dagger.hilt.android.qualifiers.ApplicationContext"
})
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
public final class AppModule_ProvideSharedPreferencesForNotificationFactory implements Factory<SharedPreferences> {
  private final Provider<Context> appProvider;

  public AppModule_ProvideSharedPreferencesForNotificationFactory(Provider<Context> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideSharedPreferencesForNotification(appProvider.get());
  }

  public static AppModule_ProvideSharedPreferencesForNotificationFactory create(
      Provider<Context> appProvider) {
    return new AppModule_ProvideSharedPreferencesForNotificationFactory(appProvider);
  }

  public static SharedPreferences provideSharedPreferencesForNotification(Context app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSharedPreferencesForNotification(app));
  }
}
