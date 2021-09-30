package com.cleanup.todoc.database.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import com.cleanup.todoc.model.Project;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public class ProjectDao_Impl implements ProjectDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfProject;

  private final EntityInsertionAdapter __insertionAdapterOfProject_1;

  public ProjectDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProject = new EntityInsertionAdapter<Project>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Project`(`id`,`name`,`color`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Project value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getColor());
      }
    };
    this.__insertionAdapterOfProject_1 = new EntityInsertionAdapter<Project>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Project`(`id`,`name`,`color`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Project value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getColor());
      }
    };
  }

  @Override
  public void createUser(Project user) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfProject.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertIdProject(Project projet) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfProject_1.insert(projet);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }
}
