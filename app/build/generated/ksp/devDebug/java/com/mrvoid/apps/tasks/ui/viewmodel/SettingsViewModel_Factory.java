package com.mrvoid.apps.tasks.ui.viewmodel;

import com.mrvoid.apps.tasks.data.db.TaskDatabase;
import com.mrvoid.apps.tasks.data.repository.TaskRepository;
import com.mrvoid.apps.tasks.util.preference.PreferenceManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<TaskDatabase> taskDatabaseProvider;

  private final Provider<TaskRepository> taskRepositoryProvider;

  private final Provider<PreferenceManager> preferenceManagerProvider;

  public SettingsViewModel_Factory(Provider<TaskDatabase> taskDatabaseProvider,
      Provider<TaskRepository> taskRepositoryProvider,
      Provider<PreferenceManager> preferenceManagerProvider) {
    this.taskDatabaseProvider = taskDatabaseProvider;
    this.taskRepositoryProvider = taskRepositoryProvider;
    this.preferenceManagerProvider = preferenceManagerProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(taskDatabaseProvider.get(), taskRepositoryProvider.get(), preferenceManagerProvider.get());
  }

  public static SettingsViewModel_Factory create(Provider<TaskDatabase> taskDatabaseProvider,
      Provider<TaskRepository> taskRepositoryProvider,
      Provider<PreferenceManager> preferenceManagerProvider) {
    return new SettingsViewModel_Factory(taskDatabaseProvider, taskRepositoryProvider, preferenceManagerProvider);
  }

  public static SettingsViewModel newInstance(TaskDatabase taskDatabase,
      TaskRepository taskRepository, PreferenceManager preferenceManager) {
    return new SettingsViewModel(taskDatabase, taskRepository, preferenceManager);
  }
}
