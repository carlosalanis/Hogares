package org.lavid.hogares;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class planAdapter extends RecyclerView.Adapter<planAdapter.ViewHolder> {
    private String[] mDataset;
    private TextView txtCita;
    private TextView txtSub;
    private CardView card;
    private ImageView imgBiblia;
    private DatabaseHelper dbHelper = null;


    public planAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.plan_lista, parent, false);

        return new ViewHolder(v, mDataset);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String cita;
        txtCita = holder.itemView.findViewById(R.id.txtCita);
        txtSub = holder.itemView.findViewById(R.id.txtSub);
        card = holder.itemView.findViewById(R.id.card_view);
        imgBiblia = holder.itemView.findViewById(R.id.imgBiblia);

        String vers = mDataset[position].split("/")[6];
        if(vers.isEmpty())
            cita = mDataset[position].split("/")[4] + " " + mDataset[position].split("/")[5];
        else
            cita = mDataset[position].split("/")[4] + " " + mDataset[position].split("/")[5] + ":" + vers;



        int id = Integer.parseInt(mDataset[position].split("/")[0]);
        dbHelper = new DatabaseHelper(holder.itemView.getContext());
        Boolean leido = dbHelper.GetLeido(id);

        String numversiculos;
        if(vers.isEmpty()) {
            numversiculos = dbHelper.GetNumVersiculos(id);
        }
        else {
            int verini = Integer.parseInt(vers.split("-")[0]);
            int verfin = Integer.parseInt(vers.split("-")[1]);
            int nv = verfin - verini + 1;
            numversiculos = Integer.toString(nv);
        }


        if(leido) {
            txtCita.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.colorDarkGray));
            txtSub.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.colorDarkGray));
            imgBiblia.setBackgroundResource(R.drawable.ic_24px);
            txtSub.setText(numversiculos + " versículos");
        }
        else {
            txtCita.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.colorWhite));
            txtSub.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.colorWhite));
            card.setBackgroundResource(R.color.colorPurple);
            imgBiblia.setBackgroundResource(R.drawable.bible_purple);
            txtSub.setText(numversiculos + " versículos");
        }


        txtCita.setText(cita);


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
            int versiculoini=0; int versiculofin=0;
            int pos = getLayoutPosition();
            int id = Integer.parseInt(mData[pos].split("/")[0]);
            int idLibro = Integer.parseInt(mData[pos].split("/")[3]);
            int capitulo = Integer.parseInt(mData[pos].split("/")[5]);
            String versiculos = mData[pos].split("/")[6];

            if(!versiculos.isEmpty()) { versiculoini = Integer.parseInt(versiculos.split("-")[0]); versiculofin = Integer.parseInt(versiculos.split("-")[1]); }

            Context context = v.getContext();
            Intent mainIntent = new Intent(context, readerActivity.class);
            mainIntent.putExtra("ID", id);
            mainIntent.putExtra("IDLIBRO", idLibro);
            mainIntent.putExtra("CAPITULO", capitulo);
            mainIntent.putExtra("VERSICULOINI", versiculoini);
            mainIntent.putExtra("VERSICULOFIN", versiculofin);
            ((Activity) context).startActivityForResult(mainIntent,1002);

        }




    }

}


