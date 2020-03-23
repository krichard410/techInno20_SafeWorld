package com.safeworld.upgrade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.safeworld.R;

import java.util.ArrayList;
import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private Context mContext;
    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;

    public CardPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public CardPagerAdapter(Context mContext) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        this.mContext = mContext;
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.upgrade_card, container, false);
        bind(mData.get(position), view);
        CardView cardView = view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(final CardItem item, View view) {
        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView contentTextView = view.findViewById(R.id.contentTextView);
        TextView subContentTextView = view.findViewById(R.id.subContentTextView);
        Button purchase = view.findViewById(R.id.btn_purchase);

        titleTextView.setText(item.getTitle());
        contentTextView.setText(item.getText());
        subContentTextView.setText(item.getSubTextResource());
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
