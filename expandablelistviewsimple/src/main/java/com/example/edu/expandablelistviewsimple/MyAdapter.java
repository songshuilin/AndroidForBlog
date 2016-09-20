package com.example.edu.expandablelistviewsimple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/19.
 */
public class MyAdapter extends BaseExpandableListAdapter{

    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getGroupCount() {
        return ContentUtil.mImgs.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ContentUtil.child_img[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return ContentUtil.mImgs[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return ContentUtil.child_img[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHodler holder = null;
        View view = null;
        if (convertView != null) {
            view = convertView;
            holder = (GroupViewHodler) view.getTag();
        } else {
            holder = new GroupViewHodler();
            view = inflater.inflate(R.layout.group_item, null);
            view.setTag(holder);
            holder.group_img = (ImageView) view.findViewById(R.id.group_img);
            holder.group_name = (TextView) view.findViewById(R.id.group_name);
            holder.group_count = (TextView) view.findViewById(R.id.group_content);
        }
        holder.group_img.setImageResource(ContentUtil.mImgs[groupPosition]);
        holder.group_name.setText(ContentUtil.names[groupPosition]);
        holder.group_count.setText(ContentUtil.counts[groupPosition]);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHodler hodler = null;
        View view = null;
        if (convertView != null) {
            view = convertView;
            hodler = (ChildViewHodler) view.getTag();
        } else {
            hodler = new ChildViewHodler();
            view = inflater.inflate(R.layout.child_item, null);
            view.setTag(hodler);
            hodler.child_img = (ImageView) view.findViewById(R.id.child_img);
            hodler.child_name = (TextView) view.findViewById(R.id.child_name);
            hodler.child_content = (TextView) view.findViewById(R.id.child_content);
        }
        hodler.child_img.setImageResource(ContentUtil.child_img[groupPosition][childPosition]);
        hodler.child_name.setText(ContentUtil.child_names[groupPosition][childPosition]);
        hodler.child_content.setText(ContentUtil.child_contents[groupPosition][childPosition]);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}

class GroupViewHodler {
    ImageView group_img;
    TextView group_name, group_count;

}

class ChildViewHodler {
    ImageView child_img;
    TextView child_name, child_content;
}
