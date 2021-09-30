package com.cleanup.todoc.database;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import org.jetbrains.annotations.NotNull;

@Database(entities = {Task.class, Project.class}, version = 1, exportSchema = false)

public abstract class TodocMasterDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile TodocMasterDatabase INSTANCE;

    // --- DAO ---
    public abstract TaskDao taskDao();
    public abstract ProjectDao projectDao();


    public static synchronized TodocMasterDatabase getDbInstance(Context context){

        if(INSTANCE== null ){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                    TodocMasterDatabase.class, "DB_NAME")
                    .allowMainThreadQueries()
                    //.addCallback(prepopulateDatabase())
                    .build();
        }
        return  INSTANCE;
    }

    private static Callback prepopulateDatabase(){
        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                ContentValues contentValues1 = new ContentValues();
                contentValues1.put("id", 1L);
                contentValues1.put("name", "Projet Tartampion");
                contentValues1.put("color", 0xFFEADAD1);

                ContentValues contentValues2= new ContentValues();
                contentValues2.put("id",2L);
                contentValues2.put("name","Projet Lucidia");
                contentValues2.put("color",0xFFEADAD1);

                ContentValues contentValues3= new ContentValues();
                contentValues3.put("id",3L);
                contentValues3.put("name","Projet Circus");
                contentValues3.put("color",0xFFA3CED2);

//                db.insert("User1", OnConflictStrategy.IGNORE, contentValues1);
//                db.insert("User2",OnConflictStrategy.IGNORE,contentValues2);
//                db.insert("User3",OnConflictStrategy.IGNORE,contentValues3);
            }
        };
    }

}
