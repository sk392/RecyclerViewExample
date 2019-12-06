package latte.example.com.recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Latte on 2019-12-06.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.AdapterViewHolder> {
    interface OnItemClickListener {
        void onItemClick(CustomItem item, int position);
    }

    private ArrayList<CustomItem> items;
    private OnItemClickListener listener;

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recycler_item, null);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.onBind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<CustomItem> items) {
        this.items = items;

        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        CustomItem item;
        TextView title;

        AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(item, getAdapterPosition());
                }
            });
        }

        void onBind(CustomItem item) {
            this.item = item;
            title.setText(item.title);
        }
    }

}
