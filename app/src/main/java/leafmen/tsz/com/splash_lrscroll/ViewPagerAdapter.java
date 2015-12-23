package leafmen.tsz.com.splash_lrscroll;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;


import java.util.List;

/**
 * Created by LiQiang on 2015/12/18.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private List<View> views;
    private Context context;

public ViewPagerAdapter(List<View> views,Context context){
    this.views = views;
    this.context = context;

}

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView(views.get(position));

    }

    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(views.get(position));
        return  views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }
}
