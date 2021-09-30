package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createUser(Project user);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertIdProject(Project projet);
}

