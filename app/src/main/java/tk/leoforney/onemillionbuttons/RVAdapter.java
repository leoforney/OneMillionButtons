package tk.leoforney.onemillionbuttons;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import com.futuremind.recyclerviewfastscroll.SectionTitleProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dynamic Signals on 2/4/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> implements SectionTitleProvider {

    List<Integer> data;

    public RVAdapter(int size) {

        data = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            int buttonnum = i + 1;
            data.add(buttonnum);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button b = (Button) LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_template, parent, false);
        return new ViewHolder(b);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.button.setText("Button #" + data.get(position));
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    @Override
    public String getSectionTitle(int position) {
        return "#" + data.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        Button button;

        public ViewHolder(Button itemView) {
            super(itemView);
            button = itemView;
        }
    }
}
