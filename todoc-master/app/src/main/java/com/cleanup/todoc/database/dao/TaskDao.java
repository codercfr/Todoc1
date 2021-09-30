package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task")
    List<Task>getAllTask();

    @Insert
    void insertAllData(Task task);

    @Update(onConflict = REPLACE)
    void updateItem(Task item);

    @Delete
    void deleteTask(Task itemId);

}
