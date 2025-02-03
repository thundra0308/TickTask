package com.mrvoid.apps.tasks.model

import com.mrvoid.apps.tasks.data.model.Task

sealed class TaskEvent {
    object Initial:TaskEvent()
    data class ShowUndoDeleteTaskMessage(val task: Task) : TaskEvent()
    object NavigateToAllCompletedScreen : TaskEvent()
}