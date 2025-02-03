package com.mrvoid.apps.tasks.ui.viewmodel;

import androidx.lifecycle.SavedStateHandle;
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
public final class TaskViewModel_Factory implements Factory<TaskViewModel> {
  private final Provider<TaskRepository> repositoryProvider;

  private final Provider<PreferenceManager> preferenceManagerProvider;

  private final Provider<SavedStateHandle> stateProvider;

  public TaskViewModel_Factory(Provider<TaskRepository> repositoryProvider,
      Provider<PreferenceManager> preferenceManagerProvider,
      Provider<SavedStateHandle> stateProvider) {
    this.repositoryProvider = repositoryProvider;
    this.preferenceManagerProvider = preferenceManagerProvider;
    this.stateProvider = stateProvider;
  }

  @Override
  public TaskViewModel get() {
    return newInstance(repositoryProvider.get(), preferenceManagerProvider.get(), stateProvider.get());
  }

  public static TaskViewModel_Factory create(Provider<TaskRepository> repositoryProvider,
      Provider<PreferenceManager> preferenceManagerProvider,
      Provider<SavedStateHandle> stateProvider) {
    return new TaskViewModel_Factory(repositoryProvider, preferenceManagerProvider, stateProvider);
  }

  public static TaskViewModel newInstance(TaskRepository repository,
      PreferenceManager preferenceManager, SavedStateHandle state) {
    return new TaskViewModel(repository, preferenceManager, state);
  }
}
