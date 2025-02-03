package com.mrvoid.apps.tasks.di;

import android.app.Application;
import com.mrvoid.apps.tasks.data.db.TaskDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
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
public final class AppModule_ProvideTaskDatabaseFactory implements Factory<TaskDatabase> {
  private final Provider<Application> appProvider;

  public AppModule_ProvideTaskDatabaseFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public TaskDatabase get() {
    return provideTaskDatabase(appProvider.get());
  }

  public static AppModule_ProvideTaskDatabaseFactory create(Provider<Application> appProvider) {
    return new AppModule_ProvideTaskDatabaseFactory(appProvider);
  }

  public static TaskDatabase provideTaskDatabase(Application app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTaskDatabase(app));
  }
}
