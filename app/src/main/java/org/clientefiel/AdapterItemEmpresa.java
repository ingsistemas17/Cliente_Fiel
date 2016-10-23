package org.clientefiel;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import modelo.Empresa;

/**
 * Created by carlos.morales on 22/10/2016.
 */
public class AdapterItemEmpresa extends ArrayAdapter<Empresa> {

    protected Activity activity;
    protected ArrayList<ItemEmpresa> items;


    public AdapterItemEmpresa(Context context, List<Empresa> objects) {
        super(context, 0, objects);
    }



/*    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<ItemEmpresa> category) {
        for (int i = 0; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }*/

   /* @Override
    public Empresa getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.item_empresa,
                    parent,
                    false);
        }

        Empresa dir = getItem(position);

        TextView title = (TextView) convertView.findViewById(R.id.category);
        title.setText(dir.getNombreEmpresa());

        TextView description = (TextView) convertView.findViewById(R.id.texto);


        if(dir.getEstadoEmpresa().equals("1")) {
            description.setTextColor(description.getResources().getColor(R.color.txt_empresa_abierta));
            description.setText("Abierto");
        }
        else {
            description.setTextColor(description.getResources().getColor(R.color.txt_empresa_cerrada));
            description.setText("Cerrado");
        }
//        ImageView imagen = (ImageView) v.findViewById(R.id.imageView4);
//        imagen.setImageDrawable(dir.getImage());

        return convertView;
    }

/*    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }*/
}
