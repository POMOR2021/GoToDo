package com.example.gototodo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.gototodo.dao.TaskDao;
import com.example.gototodo.entity.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class TaskAppDatabase extends RoomDatabase {

    private static TaskAppDatabase instance;

    public abstract TaskDao taskDao();

    public static synchronized TaskAppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            TaskAppDatabase.class,
                            "tasks_db"
                    ).allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}