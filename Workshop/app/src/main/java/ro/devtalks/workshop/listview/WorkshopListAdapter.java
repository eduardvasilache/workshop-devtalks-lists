package ro.devtalks.workshop.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ro.devtalks.workshop.R;
import ro.devtalks.workshop.models.Workshop;

final class WorkshopListAdapter extends BaseAdapter {

    private final List<Workshop> workshops = new ArrayList<>();

    void setWorkshops(List<Workshop> workshops) {
        this.workshops.clear();
        this.workshops.addAll(workshops);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return workshops.size();
    }

    @Override
    public Workshop getItem(int position) {
        return workshops.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WorkshopViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workshop, parent, false);

            viewHolder = new WorkshopViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (WorkshopViewHolder) convertView.getTag();
        }

        Workshop workshop = getItem(position);

        viewHolder.tvId.setText(String.valueOf(workshop.getId()));
        viewHolder.tvName.setText(workshop.getName());
        viewHolder.tvDescription.setText(workshop.getDescription());

        return convertView;
    }

    private static class WorkshopViewHolder {

        final TextView tvId;
        final TextView tvName;
        final TextView tvDescription;

        WorkshopViewHolder(View view) {
            tvId = view.findViewById(R.id.tvId);
            tvName = view.findViewById(R.id.tvName);
            tvDescription = view.findViewById(R.id.tvDescription);
        }

    }

}