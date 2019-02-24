package com.example.testingswapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class PeopleAdapter extends ArrayAdapter<Person> {

    List<Person> personList;
    Context context;
    private LayoutInflater inflater;

    public PeopleAdapter(Context context, List<Person> objectList) {
        super(context, 0, objectList);
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        personList = objectList;
    }

    @Override
    public Person getItem(int position) {
        return personList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            View view = inflater.inflate(R.layout.search_listview, parent, false);
            viewHolder = ViewHolder.create((RelativeLayout) view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Person item = getItem(position);
        viewHolder.dataTextView.setText(item.getName());

        return viewHolder.personView;
    }

    private static class ViewHolder {
        public final RelativeLayout personView;
        public final TextView dataTextView;

        private ViewHolder(RelativeLayout personView, TextView dataTextView) {
            this.personView = personView;
            this.dataTextView = dataTextView;
        }

        public static ViewHolder create (RelativeLayout personView) {
            TextView dataTextView = (TextView) personView.findViewById(R.id.textView);
            return new ViewHolder(personView, dataTextView);
        }
    }
}
