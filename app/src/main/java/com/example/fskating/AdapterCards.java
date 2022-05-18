package com.example.fskating;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fskating.fragments.FragmentCard;
import com.example.fskating.models.ModelCard;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterCards extends RecyclerView.Adapter<AdapterCards.CardView> {

    private List<ModelCard> cardsList;
    Fragment fr;

    public AdapterCards(Fragment fr) {
        this.fr = fr;
        this.cardsList = new ArrayList<>();
    }

    public void setCardsList(List<ModelCard> cardsList) {
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
        holder.getCard().setImageResource(cardsList.get(position).getRes());
        holder.getCard().setOnClickListener(view -> {
            FragmentChanger.replaceFragment(
                    fr.requireActivity().getSupportFragmentManager(),
                    R.id.fc,
                    new FragmentCard(cardsList.get(position).getIdCard())
                    );
        });
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
