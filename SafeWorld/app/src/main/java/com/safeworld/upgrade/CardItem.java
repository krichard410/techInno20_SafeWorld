package com.safeworld.upgrade;

public class CardItem {

    private int mTextResource;
    private int mSubTextResource;
    private int mTitleResource;

    public CardItem(int title, int text, int subTextResource) {
        mTitleResource = title;
        mTextResource = text;
        mSubTextResource = subTextResource;
    }

    public int getText() {
        return mTextResource;
    }

    public int getTitle() {
        return mTitleResource;
    }

    public int getSubTextResource() {
        return mSubTextResource;
    }
}
