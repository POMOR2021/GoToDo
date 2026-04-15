package com.example.gototodo.bottomSheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gototodo.R;
import com.example.gototodo.dao.TaskDao;
import com.example.gototodo.entity.Task;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddTaskBottomSheet extends BottomSheetDialogFragment {
    private TaskDao taskDao;

    public AddTaskBottomSheet(TaskDao taskDao){
        this.taskDao = taskDao;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.bottom_add_task,container, false);

        EditText category = view.findViewById(R.id.editCategory);
        EditText title = view.findViewById(R.id.editName);
        Button add = view.findViewById(R.id.btnAdd);

        add.setOnClickListener(v -> {
            String addCategory = category.getText().toString();
            String addTitle = title.getText().toString();

            if(addTitle.isEmpty()) Toast.makeText(getContext(), "Заполните все поля!", Toast.LENGTH_SHORT).show();

            Task task = new Task(addTitle, addCategory, false);

            new Thread(() -> {
               taskDao.Insert(task);
            }).start();
        });
        return view;
    }
}
