package com.safeworld.upgrade;

/**
 * The Course class using for creating course object
 * @author nieruize
 * @version 1.0
 */
public class CardItem {

    // attribute
    private int mTextResource;
    private int mSubTextResource;
    private int mTitleResource;

    // constructor
    public CardItem(int title, int text, int subTextResource) {
        mTitleResource = title;
        mTextResource = text;
        mSubTextResource = subTextResource;
    }

    // get method
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
