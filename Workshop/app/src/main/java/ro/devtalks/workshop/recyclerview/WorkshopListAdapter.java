package ro.devtalks.workshop.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ro.devtalks.workshop.R;
import ro.devtalks.workshop.models.Workshop;

final class WorkshopListAdapter extends RecyclerView.Adapter<WorkshopListAdapter.WorkshopViewHolder> {

    private final List<Workshop> workshops = new ArrayList<>();

    void setWorkshops(List<Workshop> workshops) {
        this.workshops.clear();
        this.workshops.addAll(workshops);
        notifyDataSetChanged();
    }

    @Override
    public WorkshopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_workshop, parent, false);
        return new WorkshopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WorkshopViewHolder holder, int position) {
        holder.bind(workshops.get(position));
    }

    @Override
    public int getItemCount() {
        return workshops.size();
    }

    static class WorkshopViewHolder extends RecyclerView.ViewHolder {

        final TextView tvId;
        final TextView tvName;
        final TextView tvDescription;

        WorkshopViewHolder(View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        void bind(Workshop workshop) {
            tvId.setText(String.valueOf(workshop.getId()));
            tvName.setText(workshop.getName());
            tvDescription.setText(workshop.getDescription());
        }

    }

}