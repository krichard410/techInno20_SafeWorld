package com.safeworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.safeworld.upgrade.CardItem;
import com.safeworld.upgrade.CardPagerAdapter;
import com.safeworld.upgrade.ShadowTransformer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
/**
 * The UpgradeFragment use for show subscription type
 * @author nieruize
 * @version 1.0
 */
public class UpgradeFragment extends Fragment {

    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_upgrade, container, false);
        mViewPager = root.findViewById(R.id.view_pager);

        mCardAdapter = new CardPagerAdapter(getContext());
        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1, R.string.subtext_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_2, R.string.subtext_2));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_3, R.string.subtext_3));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        mCardShadowTransformer.enableScaling(true);
        return root;
    }
}