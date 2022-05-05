package com.youxiang8727.peronatw;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<ApiResult.Records.Location.WeatherElement.Time> list = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textview_start_time.setText(list.get(position).getStartTime());
        holder.textview_end_time.setText(list.get(position).getEndTime());
        holder.textview_degree.setText(list.get(position).getParameter().getParameterName() + "C");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ApiResult apiResult) {
        List<ApiResult.Records.Location.WeatherElement.Time> list = new ArrayList<>();
        for (ApiResult.Records.Location.WeatherElement element : apiResult.getRecords().getLocation().get(0).getWeatherElement()) {
            for (ApiResult.Records.Location.WeatherElement.Time time : element.getTime()) {
                list.add(time);
            }
        }
        this.list = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textview_start_time, textview_end_time, textview_degree;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textview_start_time = itemView.findViewById(R.id.textview_start_time);
            textview_end_time = itemView.findViewById(R.id.textview_end_time);
            textview_degree = itemView.findViewById(R.id.textview_degree);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SecondActivity.class)
                            .putExtra("time", list.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
