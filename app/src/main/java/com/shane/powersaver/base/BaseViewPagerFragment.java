package com.shane.powersaver.base;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shane.powersaver.R;
import com.shane.powersaver.adapter.ViewPageFragmentAdapter;
import com.shane.powersaver.ui.empty.EmptyLayout;
import com.shane.powersaver.widget.PagerSlidingTabStrip;

/**
 * BaseViewPagerFragment:带有导航条的基类
 *
 * @author shane（https://github.com/lxxgreat）
 * @version 1.0
 * @created 2016-08-07
 *
 */
public abstract class BaseViewPagerFragment extends BaseFragment {

    protected PagerSlidingTabStrip mTabStrip;
    protected ViewPager mViewPager;
    protected ViewPageFragmentAdapter mTabsAdapter;
    protected EmptyLayout mErrorLayout;
    protected View mRoot;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRoot == null) {
            View root = inflater.inflate(R.layout.base_viewpage_fragment, null);

            mTabStrip = (PagerSlidingTabStrip) root
                    .findViewById(R.id.pager_tabstrip);

            mViewPager = (ViewPager) root.findViewById(R.id.pager);

            mErrorLayout = (EmptyLayout) root.findViewById(R.id.error_layout);

            mTabsAdapter = new ViewPageFragmentAdapter(getChildFragmentManager(),
                    mTabStrip, mViewPager);
            setScreenPageLimit();
            onSetupTabAdapter(mTabsAdapter);

            mRoot = root;
        }
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            int pos = savedInstanceState.getInt("position");
            mViewPager.setCurrentItem(pos, true);
        }
    }

    protected void setScreenPageLimit() {
    }

    // @Override
    // public void onSaveInstanceState(Bundle outState) {
    // //No call for super(). Bug on API Level > 11.
    // if (outState != null && mViewPager != null) {
    // outState.putInt("position", mViewPager.getCurrentItem());
    // }
    // //super.onSaveInstanceState(outState);
    // }

    protected abstract void onSetupTabAdapter(ViewPageFragmentAdapter adapter);
}