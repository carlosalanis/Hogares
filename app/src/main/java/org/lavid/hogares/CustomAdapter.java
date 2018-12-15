package org.lavid.hogares;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CustomAdapter extends PagerAdapter {

    private Activity activity;
    private Integer[] imagesArray;

    public CustomAdapter(Activity activity,Integer[] imagesArray) {
        this.activity = activity;
        this.imagesArray = imagesArray;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = activity.getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.view_red, container, false);
        ImageView imageView = viewItem.findViewById(R.id.image_item);
        imageView.setImageResource(imagesArray[position]);
        container.addView(viewItem);

        return viewItem;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imagesArray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub
        return view == ((View)object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }
}
