package org.lavid.hogares;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class bibleAdapter extends RecyclerView.Adapter<bibleAdapter.ViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder (View v) {
            super(v);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public bibleAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.texto_lista, parent, false);
        return new ViewHolder(v);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TextView numVersiculo = holder.itemView.findViewById(R.id.numVersiculo);
        TextView txtVersiculo = holder.itemView.findViewById(R.id.txtVersiculo);

        numVersiculo.setText(mDataset[position].split(":")[0]);
        txtVersiculo.setText(mDataset[position].split(":")[1]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}

