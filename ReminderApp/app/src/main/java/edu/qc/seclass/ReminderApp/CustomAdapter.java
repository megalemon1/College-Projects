package edu.qc.seclass.ReminderApp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.qc.seclass.myapplicatio.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList id, reminder_type, reminder, hour, minute;

    CustomAdapter(Context context, ArrayList id, ArrayList reminder_type, ArrayList reminder, ArrayList hour, ArrayList minute) {
        this.context = context;
        this.id = id;
        this.reminder_type = reminder_type;
        this.reminder = reminder;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.reminder_type_text.setText(String.valueOf(reminder_type.get(position)));
        holder.reminder_text.setText(String.valueOf(reminder.get(position)));
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("Id", String.valueOf(id.get(holder.getAdapterPosition())));
                intent.putExtra("Type", String.valueOf(reminder_type.get(holder.getAdapterPosition())));
                intent.putExtra("Reminder", String.valueOf(reminder.get(holder.getAdapterPosition())));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reminder_type.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView reminder_type_text, reminder_text, hour_text, minute_text;
        ConstraintLayout constraintLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            reminder_type_text = itemView.findViewById(R.id.reminder_type_text);
            reminder_text = itemView.findViewById(R.id.reminder_text);
            constraintLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
