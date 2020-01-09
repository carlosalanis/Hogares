package org.lavid.hogares;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

public class especialesAdapter extends RecyclerView.Adapter<especialesAdapter.ViewHolder> {
    private String[] mDataset;

    public especialesAdapter(String[] myDataset) { mDataset = myDataset; }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.especiales_lista, parent, false);

        return new especialesAdapter.ViewHolder(v, mDataset);
    }

    @Override
    public void onBindViewHolder(especialesAdapter.ViewHolder holder, int position) {
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
            String clave = mData[pos].split("/")[3].toLowerCase().trim();

            Context context = v.getContext();

            SharedPreferences settings = v.getContext().getSharedPreferences("HOGARES_PREFS", 0);
            SharedPreferences.Editor editor = settings.edit();
            boolean isESPChapterAdmin = settings.getBoolean("isESPChapterAdmin" + idEstudio, false);

            if (isESPChapterAdmin) {
                Intent mainIntent = new Intent(context, chapters.class);
                mainIntent.putExtra("cap", "ESP\\ESP_" + idEstudio + ".html");
                ((Activity) context).startActivityForResult(mainIntent, 1002);
            } else {
                AlertDialog.Builder b = new AlertDialog.Builder(v.getContext());
                b.setMessage("Para acceder al contenido, es necesario ingresar la palabra clave, su líder de grupo puede proporcionársela.");
                final EditText input = new EditText(v.getContext());
                input.setSingleLine();

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                lp.topMargin = 100;
                lp.setMarginStart(50);
                lp.setMarginEnd(50);
                lp.bottomMargin = 50;
                TextInputLayout textInputLayout = new TextInputLayout(v.getContext());
                LinearLayout.LayoutParams textInputLayoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                textInputLayout.setLayoutParams(textInputLayoutParams);
                textInputLayout.addView(input, lp);
                textInputLayout.setHint("Palabra clave");

                b.setView(textInputLayout);
                b.setPositiveButton("Aceptar", ((DialogInterface dialog, int which) -> {
                    final String result;
                    result = input.getText().toString();
                    if (result.toLowerCase().trim().equals(clave)) {
                        editor.putBoolean("isESPChapterAdmin" + idEstudio, true);
                        editor.apply();

                        Intent mainIntent = new Intent(context, chapters.class);
                        mainIntent.putExtra("cap", "ESP\\ESP_" + idEstudio + ".html");
                        ((Activity) context).startActivityForResult(mainIntent, 1002);

                        dialog.dismiss();
                    } else {
                        dialog.dismiss();
                    }
                }));

                b.create().show();
            }

        }


    }

}
