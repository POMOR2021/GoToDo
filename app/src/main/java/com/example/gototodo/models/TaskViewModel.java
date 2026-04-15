package com.example.gototodo.models;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.gototodo.dao.TaskDao;
import com.example.gototodo.database.TaskAppDatabase;
import com.example.gototodo.entity.Task;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskDao taskDao;
    private LiveData<List<Task>> allTasks;

    public TaskViewModel(@NonNull Application application) {
        super(application);

        taskDao = TaskAppDatabase.getInstance(application).taskDao();
        allTasks = taskDao.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }
}
