package com.example.gototodo.adapter;

import android.graphics.Paint;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gototodo.R;
import com.example.gototodo.database.TaskAppDatabase;
import com.example.gototodo.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> list = new ArrayList<>();

    public void setTasks(List<Task> tasks) {
        this.list = tasks;
        notifyDataSetChanged();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView category, name;
        CheckBox checkBox;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.taskCategory);
            name = itemView.findViewById(R.id.taskTitle);
            checkBox = itemView.findViewById(R.id.checkDone);
        }
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);

        return new TaskViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

        Task task = list.get(position);

        holder.category.setText(task.category);
        holder.name.setText(task.title);

        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(task.isDone);

        if (task.isDone) {
            holder.name.setPaintFlags(
                    holder.name.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG
            );
        } else {
            holder.name.setPaintFlags(0);
        }

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.isDone = isChecked;

            TaskAppDatabase.getInstance(holder.itemView.getContext())
                    .taskDao()
                    .Update(task);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}