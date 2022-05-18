package com.example.fskating;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fskating.models.ModelCompetition;

import java.util.ArrayList;
import java.util.List;

public class AdapterCompetition extends RecyclerView.Adapter<AdapterCompetition.CompetitionView> {

    private List<ModelCompetition> competitionList;

    public AdapterCompetition() {
        this.competitionList = new ArrayList<>();
    }

    public void setCompetitionsList(List<ModelCompetition> competitionList) {
        this.competitionList = competitionList;
    }

    @NonNull
    @Override
    public CompetitionView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.competitions_item, parent, false);
        return new CompetitionView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionView holder, int position) {
        ModelCompetition modelCompetition = competitionList.get(position);
        holder.getData().setText(modelCompetition.getData());
        holder.getCompetitionName().setText(modelCompetition.getCompetitionName());
    }

    @Override
    public int getItemCount() {
        return competitionList.size();
    }

    class CompetitionView extends RecyclerView.ViewHolder {

        private final TextView data;
        private final TextView competitionName;

        public CompetitionView(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.data);
            competitionName = itemView.findViewById(R.id.competitionName);
        }

        public TextView getData() {
            return data;
        }

        public TextView getCompetitionName() {
            return competitionName;
        }

    }
}
