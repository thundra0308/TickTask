package com.mrvoid.apps.tasks.data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TaskDatabase_Impl extends TaskDatabase {
  private volatile TaskDao _taskDao;

  private volatile NotificationDao _notificationDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `task_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `status` INTEGER NOT NULL, `importance` INTEGER NOT NULL, `reminder` INTEGER, `progress` REAL NOT NULL, `subtask` TEXT, `color` INTEGER NOT NULL, `start_date` INTEGER, `endDate` INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `sub_task_table` (`id` INTEGER NOT NULL, `subTitle` TEXT NOT NULL, `isDone` INTEGER NOT NULL, `isImportant` INTEGER NOT NULL, `sId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `dateTime` INTEGER, `reminder` INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `notification_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `taskId` INTEGER NOT NULL, `title` TEXT NOT NULL, `date` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '76df1c1db49be76e2a579c701ba7c8b0')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `task_table`");
        db.execSQL("DROP TABLE IF EXISTS `sub_task_table`");
        db.execSQL("DROP TABLE IF EXISTS `notification_table`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsTaskTable = new HashMap<String, TableInfo.Column>(10);
        _columnsTaskTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskTable.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskTable.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskTable.put("importance", new TableInfo.Column("importance", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskTable.put("reminder", new TableInfo.Column("reminder", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskTable.put("progress", new TableInfo.Column("progress", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskTable.put("subtask", new TableInfo.Column("subtask", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskTable.put("color", new TableInfo.Column("color", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskTable.put("start_date", new TableInfo.Column("start_date", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskTable.put("endDate", new TableInfo.Column("endDate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTaskTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTaskTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTaskTable = new TableInfo("task_table", _columnsTaskTable, _foreignKeysTaskTable, _indicesTaskTable);
        final TableInfo _existingTaskTable = TableInfo.read(db, "task_table");
        if (!_infoTaskTable.equals(_existingTaskTable)) {
          return new RoomOpenHelper.ValidationResult(false, "task_table(com.mrvoid.apps.tasks.data.model.Task).\n"
                  + " Expected:\n" + _infoTaskTable + "\n"
                  + " Found:\n" + _existingTaskTable);
        }
        final HashMap<String, TableInfo.Column> _columnsSubTaskTable = new HashMap<String, TableInfo.Column>(7);
        _columnsSubTaskTable.put("id", new TableInfo.Column("id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubTaskTable.put("subTitle", new TableInfo.Column("subTitle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubTaskTable.put("isDone", new TableInfo.Column("isDone", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubTaskTable.put("isImportant", new TableInfo.Column("isImportant", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubTaskTable.put("sId", new TableInfo.Column("sId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubTaskTable.put("dateTime", new TableInfo.Column("dateTime", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubTaskTable.put("reminder", new TableInfo.Column("reminder", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSubTaskTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSubTaskTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSubTaskTable = new TableInfo("sub_task_table", _columnsSubTaskTable, _foreignKeysSubTaskTable, _indicesSubTaskTable);
        final TableInfo _existingSubTaskTable = TableInfo.read(db, "sub_task_table");
        if (!_infoSubTaskTable.equals(_existingSubTaskTable)) {
          return new RoomOpenHelper.ValidationResult(false, "sub_task_table(com.mrvoid.apps.tasks.data.model.SubTask).\n"
                  + " Expected:\n" + _infoSubTaskTable + "\n"
                  + " Found:\n" + _existingSubTaskTable);
        }
        final HashMap<String, TableInfo.Column> _columnsNotificationTable = new HashMap<String, TableInfo.Column>(4);
        _columnsNotificationTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTable.put("taskId", new TableInfo.Column("taskId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTable.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTable.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotificationTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotificationTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotificationTable = new TableInfo("notification_table", _columnsNotificationTable, _foreignKeysNotificationTable, _indicesNotificationTable);
        final TableInfo _existingNotificationTable = TableInfo.read(db, "notification_table");
        if (!_infoNotificationTable.equals(_existingNotificationTable)) {
          return new RoomOpenHelper.ValidationResult(false, "notification_table(com.mrvoid.apps.tasks.data.model.Notification).\n"
                  + " Expected:\n" + _infoNotificationTable + "\n"
                  + " Found:\n" + _existingNotificationTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "76df1c1db49be76e2a579c701ba7c8b0", "52b39f02b02ede5b02ecdb31bfabeb98");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "task_table","sub_task_table","notification_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `task_table`");
      _db.execSQL("DELETE FROM `sub_task_table`");
      _db.execSQL("DELETE FROM `notification_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(TaskDao.class, TaskDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NotificationDao.class, NotificationDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public TaskDao getDao() {
    if (_taskDao != null) {
      return _taskDao;
    } else {
      synchronized(this) {
        if(_taskDao == null) {
          _taskDao = new TaskDao_Impl(this);
        }
        return _taskDao;
      }
    }
  }

  @Override
  public NotificationDao getNotificationDao() {
    if (_notificationDao != null) {
      return _notificationDao;
    } else {
      synchronized(this) {
        if(_notificationDao == null) {
          _notificationDao = new NotificationDao_Impl(this);
        }
        return _notificationDao;
      }
    }
  }
}
