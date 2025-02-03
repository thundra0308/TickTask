package com.mrvoid.apps.tasks.di;

import com.mrvoid.apps.tasks.data.db.TaskDatabase;
import com.mrvoid.apps.tasks.data.repository.NotificationRepository;
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
public final class AppModule_ProvideNotificationRepositoryFactory implements Factory<NotificationRepository> {
  private final Provider<TaskDatabase> databaseProvider;

  public AppModule_ProvideNotificationRepositoryFactory(Provider<TaskDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public NotificationRepository get() {
    return provideNotificationRepository(databaseProvider.get());
  }

  public static AppModule_ProvideNotificationRepositoryFactory create(
      Provider<TaskDatabase> databaseProvider) {
    return new AppModule_ProvideNotificationRepositoryFactory(databaseProvider);
  }

  public static NotificationRepository provideNotificationRepository(TaskDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideNotificationRepository(database));
  }
}
