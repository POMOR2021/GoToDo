package com.example.gototodo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gototodo.adapter.TaskAdapter;
import com.example.gototodo.bottomSheet.AddTaskBottomSheet;
import com.example.gototodo.database.TaskAppDatabase;
import com.example.gototodo.models.TaskViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private TaskViewModel taskViewModel;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.ToDoRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        taskAdapter = new TaskAdapter();
        recyclerView.setAdapter(taskAdapter);

        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        taskViewModel.getAllTasks().observe(getViewLifecycleOwner(), tasks -> {
            taskAdapter.setTasks(tasks);
        });

        FloatingActionButton fab = view.findViewById(R.id.add_button);

        fab.setOnClickListener(v -> {
            AddTaskBottomSheet sheet =
                    new AddTaskBottomSheet(TaskAppDatabase.getInstance(getContext()).taskDao());
            sheet.show(getParentFragmentManager(), "AddTask");
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}