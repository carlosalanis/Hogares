package org.lavid.hogares;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class recoAdapter extends RecyclerView.Adapter<recoAdapter.ViewHolder> {
    private String[] mDataset;

    public recoAdapter(String[] myDataset) { mDataset = myDataset; }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reco_lista, parent, false);

        return new recoAdapter.ViewHolder(v, mDataset);
    }

    @Override
    public void onBindViewHolder(recoAdapter.ViewHolder holder, int position) {
        ImageView imgReco = holder.itemView.findViewById(R.id.imgReco);
        TextView txtTitulo = holder.itemView.findViewById(R.id.txtHeader);
        TextView txtSubtitulo = holder.itemView.findViewById(R.id.txtSubtitulo);


        String id = mDataset[position].split("/")[0];
        String image = mDataset[position].split("/")[1];
        String titulo = mDataset[position].split("/")[2];
        String subtitulo = mDataset[position].split("/")[3];

        if(image.equals("elpresagio")) imgReco.setImageResource(R.drawable.elpresagio);
        if(image.equals("hacedordecirculos")) imgReco.setImageResource(R.drawable.hacedordecirculos);
        if(image.equals("comoadorar")) imgReco.setImageResource(R.drawable.comoadorar);
        if(image.equals("despertar")) imgReco.setImageResource(R.drawable.despertar);

        txtTitulo.setText(titulo);
        txtSubtitulo.setText(subtitulo);

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
            int idReco = Integer.parseInt(mData[pos].split("/")[0]);

            Context context = v.getContext();

            Intent mainIntent = new Intent(context, estudios.class);
            mainIntent.putExtra("cap", "BOOKS\\BOOK_" + idReco + ".html");
            ((Activity) context).startActivityForResult(mainIntent, 1002);


        }


    }

}
