package com.hiberus.kruger.hiberuskrugerapp.ui.main.card.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hiberus.kruger.hiberuskrugerapp.R;
import com.hiberus.kruger.hiberuskrugerapp.network.models.Card;
import java.util.List;

public class CardListRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Card> cards;
    private OnCardListener mOnCardListener;

    public CardListRecyclerAdapter(List<Card> cards, OnCardListener mOnCardListener) {
        this.cards = cards;
        this.mOnCardListener = mOnCardListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card_list_item, parent, false);
        return new ViewHolder(view, mOnCardListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(cards.get(position));
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName, tvType;

        OnCardListener mOnCardListener;

        public ViewHolder(@NonNull View itemView, OnCardListener onCardListener) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvType = itemView.findViewById(R.id.tvType);
            mOnCardListener = onCardListener;
            itemView.setOnClickListener(this);
        }

        public void bind(Card card) {
            tvName.setText(card.getName());
            tvType.setText(card.getType());
        }

        @Override
        public void onClick(View v) {
            mOnCardListener.onCardClick(getAdapterPosition());
        }
    }

    public interface OnCardListener {
        void onCardClick(int position);
    }
}