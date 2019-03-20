package thienvu.bt04;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import thienvu.bt04.Model;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends ArrayAdapter<Model> {
    private List<Model> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView tvName;
        TextView tvPhoneNumber;
        ImageView ivAvatar1;
        ImageView ivAvatar2;
    }

    public MyAdapter(Context context, List<Model> data) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Model dataModel = getItem(position);
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);

            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvPhoneNumber = convertView.findViewById(R.id.tvPhoneNumber);
            viewHolder.ivAvatar1 = convertView.findViewById(R.id.ivAvatar1);
            viewHolder.ivAvatar2 =convertView.findViewById(R.id.ivAvatar2);
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        lastPosition = position;


        viewHolder.tvName.setText(dataModel.getName());
        viewHolder.tvPhoneNumber.setText(dataModel.getPhoneNumber());
        viewHolder.ivAvatar1.setImageResource(dataModel.getAvatar1Uri());
        viewHolder.ivAvatar2.setImageResource(dataModel.getAvatar1Uri());

        return result;
    }
}