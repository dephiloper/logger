package assistantmirror.maxiphil.de.mirrorconfigurator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import assistantmirror.maxiphil.de.mirrorconfigurator.config.ConfigItem;
import assistantmirror.maxiphil.de.mirrorconfigurator.config.ConfigItemBool;
import assistantmirror.maxiphil.de.mirrorconfigurator.config.ConfigItemString;

public class ConfigListAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final List<ConfigItem> items;


    ConfigListAdapter(Context context, List<ConfigItem> items) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.items.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ConfigItem item = this.items.get(position);

        if(convertView == null || !item.getClass().toString().equals(convertView.getTag())) {
            // If convertView is null we have to inflate a new layout
            if (item instanceof ConfigItemBool) {
                convertView = this.inflater.inflate(R.layout.config_entry_checkbox_list_item, parent, false);
                convertView.setTag(ConfigItemBool.class.toString());
            } else if (item instanceof ConfigItemString) {
                convertView = this.inflater.inflate(R.layout.config_entry_text_list_item, parent, false);
                convertView.setTag(ConfigItemString.class.toString());
            }
        }

        if (convertView == null)
            return null;

        if (item instanceof ConfigItemBool) {
            // Retrieve the view holder from the convertView
            ConfigItemBool itemBool = (ConfigItemBool) item;

            // Bind the values to the views
            TextView key = convertView.findViewById(R.id.list_item_key);
            CheckBox value = convertView.findViewById(R.id.list_item_value_bool);
            key.setText(itemBool.getKey());
            value.setChecked(itemBool.isValue());
        } else if (item instanceof ConfigItemString) {
            // Retrieve the view holder from the convertView
            ConfigItemString itemString = (ConfigItemString) item;

            // Bind the values to the views
            TextView key = convertView.findViewById(R.id.list_item_key);
            TextView value = convertView.findViewById(R.id.list_item_value_string);
            key.setText(itemString.getKey());
            value.setText(itemString.getValue());
        }

        return convertView;
    }
}
