package com.safeworld.upgrade;


import androidx.cardview.widget.CardView;
/**
 * The CardAdapter interface using for display card item
 * @author nieruize
 * @version 1.0
 */
public interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
