package com.example.email;

import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    List<ItemModel> listItems;

    public ItemAdapter(List<ItemModel> listItems) {
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_items, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.Background= view.findViewById(R.id.txtground);
            viewHolder.Name = view.findViewById(R.id.txtname);
            viewHolder.Time = view.findViewById(R.id.txttime);
            viewHolder.Subject = view.findViewById(R.id.txtsubject);
            viewHolder.Content = view.findViewById(R.id.txtcontent);
            viewHolder.ImageFavour = view.findViewById(R.id.image_favour);
            view.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) view.getTag();
        }

        final ItemModel item = listItems.get(position);
        viewHolder.Background.setText(item.getName().substring(0,1));
       // viewHolder.Background.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.SRC_IN);
        viewHolder.Name.setText(item.getName());
        viewHolder.Time.setText(item.getTime());
        viewHolder.Subject.setText(item.getSubject());
        viewHolder.Content.setText(item.getContent());
        if(item.isSelected()){
            viewHolder.ImageFavour.setImageResource(R.drawable.ic_star_favourite);
        }else
            viewHolder.ImageFavour.setImageResource(R.drawable.ic_star_empty);

        viewHolder.ImageFavour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSelected = listItems.get(position).isSelected;
                listItems.get(position).setSelected(!isSelected);
                notifyDataSetChanged();
            }
        });

        return view;
    }


    class ViewHolder{
        TextView Background;
        TextView Name ;
        TextView Time ;
        TextView Subject ;
        TextView Content ;
        ImageView ImageFavour ;
    }
}
