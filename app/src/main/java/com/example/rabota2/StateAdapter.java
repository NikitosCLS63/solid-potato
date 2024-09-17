package com.example.rabota2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<State> states;
    private final Context context; // Добавлен контекст

    StateAdapter(Context context, List<State> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
        this.context = context; // Инициализация контекста
    }

    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        State state = states.get(position);
        holder.nameView.setText(state.getName()); // Исправлено имя переменной
        holder.capitalView.setText(state.getCapital()); // Исправлено имя переменной

        // Обработка нажатия на элемент списка
        holder.itemView.setOnClickListener(v -> {
            // Показать всплывающее сообщение
            Toast.makeText(context, "Вы выбрали: " + state.getName() + ", столица: " + state.getCapital(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView; // Исправлено имя переменной
        final TextView capitalView; // Исправлено имя переменной

        ViewHolder(View view) {
            super(view);
            flagView = view.findViewById(R.id.flag);
            nameView = view.findViewById(R.id.name);
            capitalView = view.findViewById(R.id.capital);
        }
    }
}
