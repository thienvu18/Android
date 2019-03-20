package thienvu.bt04;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import thienvu.bt04.Model;

class MyAdapter extends ArrayAdapter<Model> {

    Context context;
    int res;

    public MyAdapter(@RecentlyNonNull @NonNull Context context, int resource) {
        super(context, resource);
        context = context;
        res = resource;
    }

    @RecentlyNonNull
    @NonNull
    @Override
    public View getView(int position, @RecentlyNullable @Nullable View convertView, @RecentlyNonNull @NonNull ViewGroup parent) {
        super.getView(position, convertView, parent);
        View row = ((Activity)context).getLayoutInflater().inflate(res, null);

        ImageView ivImage1 = row.findViewById(R.id.ivImage1);
        ImageView ivImage2 = row.findViewById(R.id.ivImage2);
        TextView tvText1 = row.findViewById(R.id.tvText1);
        TextView tvText2 = row.findViewById(R.id.tvText2);


        ivImage1.setImageResource(android.R.drawable.ic_btn_speak_now);
        ivImage2.setImageResource(android.R.drawable.ic_btn_speak_now);
        tvText1.setText("aaa");
        tvText2.setText("BBBB");

        return row;
    }
}