package com.example.edu.adapersimple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
public class MyAdapter extends BaseAdapter {
    private List<PersonBean> list;
    private Context context;

    public MyAdapter(List<PersonBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //item的大小,也就是数据源的大小
    @Override
    public int getCount() {
        return list.size();
    }

    //PersonBean对象
    @Override
    public Object getItem(int position) {
        return null;
    }

    //item位置
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //返回view对象
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHoder holder = null;
        if (convertView != null) {
            view = convertView;
            holder = (ViewHoder) view.getTag();
        } else {
            //就是把布局文件加载成一个view
            view = LayoutInflater.from(context).inflate(R.layout.item_listview, null);
            holder = new ViewHoder();
            view.setTag(holder);
            holder.mImg = (ImageView) view.findViewById(R.id.img);
            holder.mTv = (TextView) view.findViewById(R.id.name);
        }
        holder.mImg.setImageResource(list.get(position).getIdImg());
        holder.mTv.setText(list.get(position).getName());
        return view;
    }
}

class ViewHoder {
    ImageView mImg;
    TextView mTv;
}
