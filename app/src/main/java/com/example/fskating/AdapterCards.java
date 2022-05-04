package com.example.fskating;

import static com.example.fskating.R.drawable.anya_card;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterCards extends RecyclerView.Adapter<AdapterCards.CardView> {

    private List<Integer> cardsList;

    public AdapterCards() {
        this.cardsList = new ArrayList<>();
    }

    public void setCardsList(List<Integer> cardsList) {
        this.cardsList = cardsList;
    }

    @NonNull
    @Override
    public CardView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_icon, parent, false);
        return new CardView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCards.CardView holder, int position) {
        holder.getCard().setImageResource(cardsList.get(position));
    }

    @Override
    public int getItemCount() {
        return cardsList.size();
    }

    class CardView extends RecyclerView.ViewHolder {

        private final ImageButton card;

        public CardView(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.img);
        }

        public ImageButton getCard() {
            return card;
        }

    }
}
