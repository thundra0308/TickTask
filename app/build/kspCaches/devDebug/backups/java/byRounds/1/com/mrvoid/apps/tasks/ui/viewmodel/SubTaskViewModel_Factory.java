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
public final class SubTaskViewModel_Factory implements Factory<SubTaskViewModel> {
  private final Provider<TaskRepository> repositoryProvider;

  private final Provider<PreferenceManager> preferenceManagerProvider;

  private final Provider<SavedStateHandle> stateProvider;

  public SubTaskViewModel_Factory(Provider<TaskRepository> repositoryProvider,
      Provider<PreferenceManager> preferenceManagerProvider,
      Provider<SavedStateHandle> stateProvider) {
    this.repositoryProvider = repositoryProvider;
    this.preferenceManagerProvider = preferenceManagerProvider;
    this.stateProvider = stateProvider;
  }

  @Override
  public SubTaskViewModel get() {
    return newInstance(repositoryProvider.get(), preferenceManagerProvider.get(), stateProvider.get());
  }

  public static SubTaskViewModel_Factory create(Provider<TaskRepository> repositoryProvider,
      Provider<PreferenceManager> preferenceManagerProvider,
      Provider<SavedStateHandle> stateProvider) {
    return new SubTaskViewModel_Factory(repositoryProvider, preferenceManagerProvider, stateProvider);
  }

  public static SubTaskViewModel newInstance(TaskRepository repository,
      PreferenceManager preferenceManager, SavedStateHandle state) {
    return new SubTaskViewModel(repository, preferenceManager, state);
  }
}
