package com.example.gototodo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gototodo.entity.Task;

import java.util.List;


@Dao
public interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY id DESC")
    LiveData<List<Task>> getAllTasks();

    @Insert
    void Insert(Task task);

    @Delete
    void Delete(Task task);

    @Update
    void Update(Task task);
}
