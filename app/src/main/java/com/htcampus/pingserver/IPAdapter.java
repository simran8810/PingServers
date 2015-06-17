package com.htcampus.pingserver;

import com.htcampus.pingserver.NewIp;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class IPAdapter extends BaseAdapter {

    private Context context;
    private List<LinearLayout> ipItems;

    public IPAdapter(Context context, List<LinearLayout> navDrawerItems) {
        this.context = context;
        this.ipItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return ipItems.size();
    }

    @Override
    public Object getItem(int position) {
        return ipItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /**
         * The following list not implemented reusable list items as list items
         * are showing incorrect data Add the solution if you have one
         * */

        View row;
        LinearLayout caption;
        if(convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            row = mInflater.inflate(R.layout.input_ip,null);
            Log.e("convertview","null");
        }

        else {

            row = convertView;
            Log.e("convertview","not null")
;        }


        ipItems.get(position);

        return row;
    }


}
