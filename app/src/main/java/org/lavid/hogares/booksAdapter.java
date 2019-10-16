package org.lavid.hogares;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class booksAdapter extends RecyclerView.Adapter<booksAdapter.ViewHolder> {
    private String[] mDataset;


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
        TextView txtLibro = holder.itemView.findViewById(R.id.txtLibro);
        TextView txtSub = holder.itemView.findViewById(R.id.txtSub);
        CardView card = holder.itemView.findViewById(R.id.card_view);

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



