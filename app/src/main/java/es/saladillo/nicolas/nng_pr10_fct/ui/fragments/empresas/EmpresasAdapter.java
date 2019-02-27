package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import es.saladillo.nicolas.nng_pr10_fct.R;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;


public class EmpresasAdapter extends ListAdapter<Empresa, EmpresasAdapter.ViewHolder> {

    public EmpresasAdapter() {
        super(new DiffUtil.ItemCallback<Empresa>() {
            @Override
            public boolean areItemsTheSame(@NonNull Empresa oldItem, @NonNull Empresa newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Empresa oldItem, @NonNull Empresa newItem) {
                return TextUtils.equals(oldItem.getNombre(), newItem.getNombre()) && TextUtils.equals(oldItem.getCif(), newItem.getCif());
            }
        });

    }


    @Override
    public Empresa getItem(int position) {
        return super.getItem(position);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.empresa_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    //VIEWHOLDER
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView lblNombre, lblPersonaContacto, lblTelefono;

        ViewHolder(View itemView) {
            super(itemView);
            lblNombre = ViewCompat.requireViewById(itemView, R.id.lblNombreEmpresa);
            lblPersonaContacto = ViewCompat.requireViewById(itemView, R.id.lblPersonaContacto);
            lblTelefono = ViewCompat.requireViewById(itemView, R.id.lblTelefono);
        }

        void bind(Empresa empresa) {
            lblNombre.setText(empresa.getNombre());
            lblPersonaContacto.setText(empresa.getNombre_contacto());
            lblTelefono.setText(empresa.getTelefono());
        }
    }
}


