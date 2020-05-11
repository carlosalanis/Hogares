package org.lavid.hogares;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class oracionesAdapter extends RecyclerView.Adapter<oracionesAdapter.ViewHolder> {
    private String[] mDataset;

    public oracionesAdapter(String[] myDataset) { mDataset = myDataset; }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.oraciones_lista, parent, false);

        return new oracionesAdapter.ViewHolder(v, mDataset);
    }

    @Override
    public void onBindViewHolder(oracionesAdapter.ViewHolder holder, int position) {
        TextView txtEstudio = holder.itemView.findViewById(R.id.txtEstudio);
        TextView txtTitulo = holder.itemView.findViewById(R.id.txtTitulo);
        TextView txtSubtitulo = holder.itemView.findViewById(R.id.txtSubtitulo);

        String estudio = mDataset[position].split("/")[0];
        String titulo = mDataset[position].split("/")[1];
        String subtitulo = mDataset[position].split("/")[2];


        txtEstudio.setText("Estudio: " + estudio);
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
            int idEstudio = Integer.parseInt(mData[pos].split("/")[0]);
            String clave = mData[pos].split("/")[3];

            Context context = v.getContext();

            Intent mainIntent = new Intent(context, estudios.class);
            mainIntent.putExtra("cap", "OCR_" + idEstudio + ".html");
            mainIntent.putExtra("bible", true);
            ((Activity) context).startActivityForResult(mainIntent,1002);

        }




    }

}
