package com.example.gototodo.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class Task {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String category;
    public boolean isDone;

    public Task(int id, String title, String category, boolean isDone){
        this.title = title;
        this.category = category;
        this.isDone = isDone;
    }
}
