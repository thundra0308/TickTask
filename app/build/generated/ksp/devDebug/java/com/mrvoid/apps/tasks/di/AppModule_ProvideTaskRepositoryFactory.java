package com.mrvoid.apps.tasks.di;

import com.mrvoid.apps.tasks.data.db.TaskDatabase;
import com.mrvoid.apps.tasks.data.repository.TaskRepository;
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
public final class AppModule_ProvideTaskRepositoryFactory implements Factory<TaskRepository> {
  private final Provider<TaskDatabase> dbProvider;

  public AppModule_ProvideTaskRepositoryFactory(Provider<TaskDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public TaskRepository get() {
    return provideTaskRepository(dbProvider.get());
  }

  public static AppModule_ProvideTaskRepositoryFactory create(Provider<TaskDatabase> dbProvider) {
    return new AppModule_ProvideTaskRepositoryFactory(dbProvider);
  }

  public static TaskRepository provideTaskRepository(TaskDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTaskRepository(db));
  }
}
