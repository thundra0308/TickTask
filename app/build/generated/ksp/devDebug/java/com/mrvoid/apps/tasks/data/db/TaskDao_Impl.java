package com.mrvoid.apps.tasks.data.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mrvoid.apps.tasks.data.model.SubTask;
import com.mrvoid.apps.tasks.data.model.Task;
import com.mrvoid.apps.tasks.model.SortOrder;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TaskDao_Impl implements TaskDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Task> __insertionAdapterOfTask;

  private final EntityInsertionAdapter<SubTask> __insertionAdapterOfSubTask;

  private final EntityDeletionOrUpdateAdapter<Task> __deletionAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter<SubTask> __deletionAdapterOfSubTask;

  private final EntityDeletionOrUpdateAdapter<Task> __updateAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter<SubTask> __updateAdapterOfSubTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllCompletedTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllCompletedSubTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllSubTask;

  public TaskDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTask = new EntityInsertionAdapter<Task>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `task_table` (`id`,`title`,`status`,`importance`,`reminder`,`progress`,`subtask`,`color`,`start_date`,`endDate`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Task entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getTitle());
        final int _tmp = entity.isDone() ? 1 : 0;
        statement.bindLong(3, _tmp);
        final int _tmp_1 = entity.isImp() ? 1 : 0;
        statement.bindLong(4, _tmp_1);
        if (entity.getReminder() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getReminder());
        }
        statement.bindDouble(6, entity.getProgress());
        if (entity.getSubTaskList() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSubTaskList());
        }
        statement.bindLong(8, entity.getColor());
        if (entity.getStartDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getStartDate());
        }
        if (entity.getEndDate() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getEndDate());
        }
      }
    };
    this.__insertionAdapterOfSubTask = new EntityInsertionAdapter<SubTask>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `sub_task_table` (`id`,`subTitle`,`isDone`,`isImportant`,`sId`,`dateTime`,`reminder`) VALUES (?,?,?,?,nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SubTask entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getSubTitle());
        final int _tmp = entity.isDone() ? 1 : 0;
        statement.bindLong(3, _tmp);
        final int _tmp_1 = entity.isImportant() ? 1 : 0;
        statement.bindLong(4, _tmp_1);
        statement.bindLong(5, entity.getSId());
        if (entity.getDateTime() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getDateTime());
        }
        if (entity.getReminder() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getReminder());
        }
      }
    };
    this.__deletionAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `task_table` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Task entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__deletionAdapterOfSubTask = new EntityDeletionOrUpdateAdapter<SubTask>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `sub_task_table` WHERE `sId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SubTask entity) {
        statement.bindLong(1, entity.getSId());
      }
    };
    this.__updateAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR REPLACE `task_table` SET `id` = ?,`title` = ?,`status` = ?,`importance` = ?,`reminder` = ?,`progress` = ?,`subtask` = ?,`color` = ?,`start_date` = ?,`endDate` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Task entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getTitle());
        final int _tmp = entity.isDone() ? 1 : 0;
        statement.bindLong(3, _tmp);
        final int _tmp_1 = entity.isImp() ? 1 : 0;
        statement.bindLong(4, _tmp_1);
        if (entity.getReminder() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getReminder());
        }
        statement.bindDouble(6, entity.getProgress());
        if (entity.getSubTaskList() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSubTaskList());
        }
        statement.bindLong(8, entity.getColor());
        if (entity.getStartDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getStartDate());
        }
        if (entity.getEndDate() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getEndDate());
        }
        statement.bindLong(11, entity.getId());
      }
    };
    this.__updateAdapterOfSubTask = new EntityDeletionOrUpdateAdapter<SubTask>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR REPLACE `sub_task_table` SET `id` = ?,`subTitle` = ?,`isDone` = ?,`isImportant` = ?,`sId` = ?,`dateTime` = ?,`reminder` = ? WHERE `sId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SubTask entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getSubTitle());
        final int _tmp = entity.isDone() ? 1 : 0;
        statement.bindLong(3, _tmp);
        final int _tmp_1 = entity.isImportant() ? 1 : 0;
        statement.bindLong(4, _tmp_1);
        statement.bindLong(5, entity.getSId());
        if (entity.getDateTime() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getDateTime());
        }
        if (entity.getReminder() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getReminder());
        }
        statement.bindLong(8, entity.getSId());
      }
    };
    this.__preparedStmtOfDeleteAllCompletedTask = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM TASK_TABLE WHERE status = 1";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllTask = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM TASK_TABLE";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllCompletedSubTask = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM sub_task_table WHERE isDone = 1 AND id=?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllSubTask = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM SUB_TASK_TABLE where id=?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Task task, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTask.insert(task);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertSubTask(final SubTask subTask, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSubTask.insert(subTask);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Task task, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTask.handle(task);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteSubTask(final SubTask subTask, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSubTask.handle(subTask);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Task task, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTask.handle(task);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateSubTask(final SubTask subTask, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfSubTask.handle(subTask);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllCompletedTask(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllCompletedTask.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllCompletedTask.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllTask(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllTask.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllTask.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllCompletedSubTask(final int taskId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllCompletedSubTask.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, taskId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllCompletedSubTask.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllSubTask(final int id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllSubTask.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllSubTask.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Task>> getAllTaskByName(final String searchQuery) {
    final String _sql = "SELECT * FROM task_table WHERE title LIKE '%' || ? || '%' ORDER BY importance DESC,title ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, searchQuery);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"task_table"}, new Callable<List<Task>>() {
      @Override
      @NonNull
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsImp = CursorUtil.getColumnIndexOrThrow(_cursor, "importance");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfSubTaskList = CursorUtil.getColumnIndexOrThrow(_cursor, "subtask");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
          final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "endDate");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Task _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImp;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImp);
            _tmpIsImp = _tmp_1 != 0;
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final String _tmpSubTaskList;
            if (_cursor.isNull(_cursorIndexOfSubTaskList)) {
              _tmpSubTaskList = null;
            } else {
              _tmpSubTaskList = _cursor.getString(_cursorIndexOfSubTaskList);
            }
            final int _tmpColor;
            _tmpColor = _cursor.getInt(_cursorIndexOfColor);
            final Long _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getLong(_cursorIndexOfStartDate);
            }
            final Long _tmpEndDate;
            if (_cursor.isNull(_cursorIndexOfEndDate)) {
              _tmpEndDate = null;
            } else {
              _tmpEndDate = _cursor.getLong(_cursorIndexOfEndDate);
            }
            _item = new Task(_tmpId,_tmpTitle,_tmpIsDone,_tmpIsImp,_tmpReminder,_tmpProgress,_tmpSubTaskList,_tmpColor,_tmpStartDate,_tmpEndDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Task>> getAllTaskByNameDesc(final String searchQuery) {
    final String _sql = "SELECT * FROM task_table WHERE title LIKE '%' || ? || '%' ORDER BY importance DESC,title DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, searchQuery);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"task_table"}, new Callable<List<Task>>() {
      @Override
      @NonNull
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsImp = CursorUtil.getColumnIndexOrThrow(_cursor, "importance");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfSubTaskList = CursorUtil.getColumnIndexOrThrow(_cursor, "subtask");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
          final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "endDate");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Task _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImp;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImp);
            _tmpIsImp = _tmp_1 != 0;
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final String _tmpSubTaskList;
            if (_cursor.isNull(_cursorIndexOfSubTaskList)) {
              _tmpSubTaskList = null;
            } else {
              _tmpSubTaskList = _cursor.getString(_cursorIndexOfSubTaskList);
            }
            final int _tmpColor;
            _tmpColor = _cursor.getInt(_cursorIndexOfColor);
            final Long _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getLong(_cursorIndexOfStartDate);
            }
            final Long _tmpEndDate;
            if (_cursor.isNull(_cursorIndexOfEndDate)) {
              _tmpEndDate = null;
            } else {
              _tmpEndDate = _cursor.getLong(_cursorIndexOfEndDate);
            }
            _item = new Task(_tmpId,_tmpTitle,_tmpIsDone,_tmpIsImp,_tmpReminder,_tmpProgress,_tmpSubTaskList,_tmpColor,_tmpStartDate,_tmpEndDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Task>> getAllTaskByDate(final String searchQuery) {
    final String _sql = "SELECT * FROM task_table WHERE title LIKE '%' || ? || '%' ORDER BY importance DESC, start_date ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, searchQuery);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"task_table"}, new Callable<List<Task>>() {
      @Override
      @NonNull
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsImp = CursorUtil.getColumnIndexOrThrow(_cursor, "importance");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfSubTaskList = CursorUtil.getColumnIndexOrThrow(_cursor, "subtask");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
          final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "endDate");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Task _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImp;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImp);
            _tmpIsImp = _tmp_1 != 0;
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final String _tmpSubTaskList;
            if (_cursor.isNull(_cursorIndexOfSubTaskList)) {
              _tmpSubTaskList = null;
            } else {
              _tmpSubTaskList = _cursor.getString(_cursorIndexOfSubTaskList);
            }
            final int _tmpColor;
            _tmpColor = _cursor.getInt(_cursorIndexOfColor);
            final Long _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getLong(_cursorIndexOfStartDate);
            }
            final Long _tmpEndDate;
            if (_cursor.isNull(_cursorIndexOfEndDate)) {
              _tmpEndDate = null;
            } else {
              _tmpEndDate = _cursor.getLong(_cursorIndexOfEndDate);
            }
            _item = new Task(_tmpId,_tmpTitle,_tmpIsDone,_tmpIsImp,_tmpReminder,_tmpProgress,_tmpSubTaskList,_tmpColor,_tmpStartDate,_tmpEndDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Task>> getAllTaskByDateDesc(final String searchQuery) {
    final String _sql = "SELECT * FROM task_table WHERE title LIKE '%' || ? || '%' ORDER BY importance DESC, start_date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, searchQuery);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"task_table"}, new Callable<List<Task>>() {
      @Override
      @NonNull
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsImp = CursorUtil.getColumnIndexOrThrow(_cursor, "importance");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfSubTaskList = CursorUtil.getColumnIndexOrThrow(_cursor, "subtask");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
          final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "endDate");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Task _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImp;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImp);
            _tmpIsImp = _tmp_1 != 0;
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final String _tmpSubTaskList;
            if (_cursor.isNull(_cursorIndexOfSubTaskList)) {
              _tmpSubTaskList = null;
            } else {
              _tmpSubTaskList = _cursor.getString(_cursorIndexOfSubTaskList);
            }
            final int _tmpColor;
            _tmpColor = _cursor.getInt(_cursorIndexOfColor);
            final Long _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getLong(_cursorIndexOfStartDate);
            }
            final Long _tmpEndDate;
            if (_cursor.isNull(_cursorIndexOfEndDate)) {
              _tmpEndDate = null;
            } else {
              _tmpEndDate = _cursor.getLong(_cursorIndexOfEndDate);
            }
            _item = new Task(_tmpId,_tmpTitle,_tmpIsDone,_tmpIsImp,_tmpReminder,_tmpProgress,_tmpSubTaskList,_tmpColor,_tmpStartDate,_tmpEndDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Task>> getAllTaskByCategory(final String searchQuery) {
    final String _sql = "SELECT * FROM task_table WHERE title LIKE '%' || ? || '%' ORDER BY importance DESC, color ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, searchQuery);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"task_table"}, new Callable<List<Task>>() {
      @Override
      @NonNull
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsImp = CursorUtil.getColumnIndexOrThrow(_cursor, "importance");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfSubTaskList = CursorUtil.getColumnIndexOrThrow(_cursor, "subtask");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
          final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "endDate");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Task _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImp;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImp);
            _tmpIsImp = _tmp_1 != 0;
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final String _tmpSubTaskList;
            if (_cursor.isNull(_cursorIndexOfSubTaskList)) {
              _tmpSubTaskList = null;
            } else {
              _tmpSubTaskList = _cursor.getString(_cursorIndexOfSubTaskList);
            }
            final int _tmpColor;
            _tmpColor = _cursor.getInt(_cursorIndexOfColor);
            final Long _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getLong(_cursorIndexOfStartDate);
            }
            final Long _tmpEndDate;
            if (_cursor.isNull(_cursorIndexOfEndDate)) {
              _tmpEndDate = null;
            } else {
              _tmpEndDate = _cursor.getLong(_cursorIndexOfEndDate);
            }
            _item = new Task(_tmpId,_tmpTitle,_tmpIsDone,_tmpIsImp,_tmpReminder,_tmpProgress,_tmpSubTaskList,_tmpColor,_tmpStartDate,_tmpEndDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Task>> getAllTaskByCategoryDesc(final String searchQuery) {
    final String _sql = "SELECT * FROM task_table WHERE title LIKE '%' || ? || '%' ORDER BY importance DESC, color DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, searchQuery);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"task_table"}, new Callable<List<Task>>() {
      @Override
      @NonNull
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsImp = CursorUtil.getColumnIndexOrThrow(_cursor, "importance");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfSubTaskList = CursorUtil.getColumnIndexOrThrow(_cursor, "subtask");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
          final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "endDate");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Task _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImp;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImp);
            _tmpIsImp = _tmp_1 != 0;
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final String _tmpSubTaskList;
            if (_cursor.isNull(_cursorIndexOfSubTaskList)) {
              _tmpSubTaskList = null;
            } else {
              _tmpSubTaskList = _cursor.getString(_cursorIndexOfSubTaskList);
            }
            final int _tmpColor;
            _tmpColor = _cursor.getInt(_cursorIndexOfColor);
            final Long _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getLong(_cursorIndexOfStartDate);
            }
            final Long _tmpEndDate;
            if (_cursor.isNull(_cursorIndexOfEndDate)) {
              _tmpEndDate = null;
            } else {
              _tmpEndDate = _cursor.getLong(_cursorIndexOfEndDate);
            }
            _item = new Task(_tmpId,_tmpTitle,_tmpIsDone,_tmpIsImp,_tmpReminder,_tmpProgress,_tmpSubTaskList,_tmpColor,_tmpStartDate,_tmpEndDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getById(final int taskId, final Continuation<? super Task> $completion) {
    final String _sql = "SELECT * FROM TASK_TABLE WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, taskId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Task>() {
      @Override
      @NonNull
      public Task call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsImp = CursorUtil.getColumnIndexOrThrow(_cursor, "importance");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfSubTaskList = CursorUtil.getColumnIndexOrThrow(_cursor, "subtask");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
          final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "endDate");
          final Task _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImp;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImp);
            _tmpIsImp = _tmp_1 != 0;
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final String _tmpSubTaskList;
            if (_cursor.isNull(_cursorIndexOfSubTaskList)) {
              _tmpSubTaskList = null;
            } else {
              _tmpSubTaskList = _cursor.getString(_cursorIndexOfSubTaskList);
            }
            final int _tmpColor;
            _tmpColor = _cursor.getInt(_cursorIndexOfColor);
            final Long _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getLong(_cursorIndexOfStartDate);
            }
            final Long _tmpEndDate;
            if (_cursor.isNull(_cursorIndexOfEndDate)) {
              _tmpEndDate = null;
            } else {
              _tmpEndDate = _cursor.getLong(_cursorIndexOfEndDate);
            }
            _result = new Task(_tmpId,_tmpTitle,_tmpIsDone,_tmpIsImp,_tmpReminder,_tmpProgress,_tmpSubTaskList,_tmpColor,_tmpStartDate,_tmpEndDate);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<SubTask>> getAllSubTaskByName(final int id, final String searchQuery) {
    final String _sql = "SELECT * FROM sub_task_table WHERE id=? AND subTitle LIKE '%' || ? || '%' ORDER BY isImportant DESC, subTitle ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    _argIndex = 2;
    _statement.bindString(_argIndex, searchQuery);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sub_task_table"}, new Callable<List<SubTask>>() {
      @Override
      @NonNull
      public List<SubTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subTitle");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "isDone");
          final int _cursorIndexOfIsImportant = CursorUtil.getColumnIndexOrThrow(_cursor, "isImportant");
          final int _cursorIndexOfSId = CursorUtil.getColumnIndexOrThrow(_cursor, "sId");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final List<SubTask> _result = new ArrayList<SubTask>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SubTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpSubTitle;
            _tmpSubTitle = _cursor.getString(_cursorIndexOfSubTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImportant;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImportant);
            _tmpIsImportant = _tmp_1 != 0;
            final int _tmpSId;
            _tmpSId = _cursor.getInt(_cursorIndexOfSId);
            final Long _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getLong(_cursorIndexOfDateTime);
            }
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            _item = new SubTask(_tmpId,_tmpSubTitle,_tmpIsDone,_tmpIsImportant,_tmpSId,_tmpDateTime,_tmpReminder);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<SubTask>> getAllSubTaskByDate(final int id, final String searchQuery) {
    final String _sql = "SELECT * FROM sub_task_table WHERE id=? AND subTitle LIKE '%' || ? || '%' ORDER BY isImportant DESC,dateTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    _argIndex = 2;
    _statement.bindString(_argIndex, searchQuery);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sub_task_table"}, new Callable<List<SubTask>>() {
      @Override
      @NonNull
      public List<SubTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subTitle");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "isDone");
          final int _cursorIndexOfIsImportant = CursorUtil.getColumnIndexOrThrow(_cursor, "isImportant");
          final int _cursorIndexOfSId = CursorUtil.getColumnIndexOrThrow(_cursor, "sId");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final List<SubTask> _result = new ArrayList<SubTask>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SubTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpSubTitle;
            _tmpSubTitle = _cursor.getString(_cursorIndexOfSubTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImportant;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImportant);
            _tmpIsImportant = _tmp_1 != 0;
            final int _tmpSId;
            _tmpSId = _cursor.getInt(_cursorIndexOfSId);
            final Long _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getLong(_cursorIndexOfDateTime);
            }
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            _item = new SubTask(_tmpId,_tmpSubTitle,_tmpIsDone,_tmpIsImportant,_tmpSId,_tmpDateTime,_tmpReminder);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<SubTask>> getAllSubTaskByNameDesc(final int id, final String searchQuery) {
    final String _sql = "SELECT * FROM sub_task_table WHERE id=? AND subTitle LIKE '%' || ? || '%' ORDER BY isImportant DESC, subTitle DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    _argIndex = 2;
    _statement.bindString(_argIndex, searchQuery);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sub_task_table"}, new Callable<List<SubTask>>() {
      @Override
      @NonNull
      public List<SubTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subTitle");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "isDone");
          final int _cursorIndexOfIsImportant = CursorUtil.getColumnIndexOrThrow(_cursor, "isImportant");
          final int _cursorIndexOfSId = CursorUtil.getColumnIndexOrThrow(_cursor, "sId");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final List<SubTask> _result = new ArrayList<SubTask>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SubTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpSubTitle;
            _tmpSubTitle = _cursor.getString(_cursorIndexOfSubTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImportant;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImportant);
            _tmpIsImportant = _tmp_1 != 0;
            final int _tmpSId;
            _tmpSId = _cursor.getInt(_cursorIndexOfSId);
            final Long _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getLong(_cursorIndexOfDateTime);
            }
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            _item = new SubTask(_tmpId,_tmpSubTitle,_tmpIsDone,_tmpIsImportant,_tmpSId,_tmpDateTime,_tmpReminder);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<SubTask>> getAllSubTaskByDateDesc(final int id, final String searchQuery) {
    final String _sql = "SELECT * FROM sub_task_table WHERE id=? AND subTitle LIKE '%' || ? || '%' ORDER BY isImportant DESC,dateTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    _argIndex = 2;
    _statement.bindString(_argIndex, searchQuery);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sub_task_table"}, new Callable<List<SubTask>>() {
      @Override
      @NonNull
      public List<SubTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subTitle");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "isDone");
          final int _cursorIndexOfIsImportant = CursorUtil.getColumnIndexOrThrow(_cursor, "isImportant");
          final int _cursorIndexOfSId = CursorUtil.getColumnIndexOrThrow(_cursor, "sId");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final List<SubTask> _result = new ArrayList<SubTask>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SubTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpSubTitle;
            _tmpSubTitle = _cursor.getString(_cursorIndexOfSubTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImportant;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImportant);
            _tmpIsImportant = _tmp_1 != 0;
            final int _tmpSId;
            _tmpSId = _cursor.getInt(_cursorIndexOfSId);
            final Long _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getLong(_cursorIndexOfDateTime);
            }
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            _item = new SubTask(_tmpId,_tmpSubTitle,_tmpIsDone,_tmpIsImportant,_tmpSId,_tmpDateTime,_tmpReminder);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getBySubTaskId(final int sID, final Continuation<? super SubTask> $completion) {
    final String _sql = "SELECT * FROM sub_task_table WHERE sId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, sID);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<SubTask>() {
      @Override
      @NonNull
      public SubTask call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subTitle");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "isDone");
          final int _cursorIndexOfIsImportant = CursorUtil.getColumnIndexOrThrow(_cursor, "isImportant");
          final int _cursorIndexOfSId = CursorUtil.getColumnIndexOrThrow(_cursor, "sId");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final SubTask _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpSubTitle;
            _tmpSubTitle = _cursor.getString(_cursorIndexOfSubTitle);
            final boolean _tmpIsDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp != 0;
            final boolean _tmpIsImportant;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsImportant);
            _tmpIsImportant = _tmp_1 != 0;
            final int _tmpSId;
            _tmpSId = _cursor.getInt(_cursorIndexOfSId);
            final Long _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getLong(_cursorIndexOfDateTime);
            }
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            _result = new SubTask(_tmpId,_tmpSubTitle,_tmpIsDone,_tmpIsImportant,_tmpSId,_tmpDateTime,_tmpReminder);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Task>> getAllTasks(final String query, final SortOrder sortOrder) {
    return TaskDao.DefaultImpls.getAllTasks(TaskDao_Impl.this, query, sortOrder);
  }

  @Override
  public Flow<List<SubTask>> getAllSubTasks(final int id, final String query,
      final SortOrder sortOrder) {
    return TaskDao.DefaultImpls.getAllSubTasks(TaskDao_Impl.this, id, query, sortOrder);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
