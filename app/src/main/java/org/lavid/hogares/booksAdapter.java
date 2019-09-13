package org.lavid.hogares;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class booksAdapter extends RecyclerView.Adapter<booksAdapter.ViewHolder> {
    private String[] mDataset;
    private TextView txtLibro;
    private TextView txtSub;
    private CardView card;
    private DatabaseHelper dbHelper = null;


    public booksAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.books_lista, parent, false);

        return new ViewHolder(v, mDataset);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String cita;
        txtLibro = holder.itemView.findViewById(R.id.txtLibro);
        txtSub = holder.itemView.findViewById(R.id.txtSub);
        card = holder.itemView.findViewById(R.id.card_view);

        String id = mDataset[position].split("/")[0];
        String nombre = mDataset[position].split("/")[1];

        txtLibro.setText(nombre);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        String[] mData;

        private ViewHolder (View v, String[] data) {
            super(v);
            mData = data;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            int idLibro = Integer.parseInt(mData[pos].split("/")[0]);
            String nombreLibro = mData[pos].split("/")[1];

            Context context = v.getContext();

            Intent mainIntent = new Intent(context, ChapterIndexActivity.class);
            mainIntent.putExtra("IDLIBRO", idLibro);
            mainIntent.putExtra("NOMBRELIBRO", nombreLibro);

            ((Activity) context).startActivityForResult(mainIntent,1002);

        }




    }

}



