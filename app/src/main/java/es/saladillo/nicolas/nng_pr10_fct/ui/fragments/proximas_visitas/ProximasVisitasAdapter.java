package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.proximas_visitas;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import es.saladillo.nicolas.nng_pr10_fct.R;
import es.saladillo.nicolas.nng_pr10_fct.data.model.InfoTarjetaVisita;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas.VisitasAdapter;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas.VisitasViewModel;

public class ProximasVisitasAdapter extends ListAdapter<InfoTarjetaVisita, ProximasVisitasAdapter.ViewHolder> {
    VisitasViewModel vm;
    public ProximasVisitasAdapter(VisitasViewModel vm) {
        super(new DiffUtil.ItemCallback<InfoTarjetaVisita>() {
            @Override
            public boolean areItemsTheSame(@NonNull InfoTarjetaVisita oldItem, @NonNull InfoTarjetaVisita newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull InfoTarjetaVisita oldItem, @NonNull InfoTarjetaVisita newItem) {
                return TextUtils.equals(oldItem.getHoraInicio(), newItem.getHoraInicio())
                        && oldItem.getDia() == newItem.getDia()
                        && TextUtils.equals(oldItem.getNombre(), newItem.getNombre())
                        && TextUtils.equals(oldItem.getEmpresa(), newItem.getEmpresa());
            }
        });

        this.vm = vm;
    }


    @Override
    public InfoTarjetaVisita getItem(int position) {
        return super.getItem(position);
    }


    @NonNull
    @Override
    public ProximasVisitasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProximasVisitasAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.visita_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProximasVisitasAdapter.ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    //VIEWHOLDER
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView lblDia,lblMes,lblAnio,lblNombreEstudianteVisita,lblEmpresaEstudianteVisita,lblHoraInicioYfin;
        private long visitaId;

        ViewHolder(View itemView) {
            super(itemView);
            lblDia = ViewCompat.requireViewById(itemView, R.id.lblDia);
            lblMes = ViewCompat.requireViewById(itemView, R.id.lblMes);
            lblAnio = ViewCompat.requireViewById(itemView, R.id.lblAnio);
            lblNombreEstudianteVisita = ViewCompat.requireViewById(itemView, R.id.lblNombreEstudianteVisita);
            lblEmpresaEstudianteVisita = ViewCompat.requireViewById(itemView, R.id.lblEmpresaEstudianteVisita);
            lblHoraInicioYfin = ViewCompat.requireViewById(itemView, R.id.lblHoraInicioYfin);

            itemView.setOnClickListener(v -> navegarAestudiante(v));
        }

        private void navegarAestudiante(View v) {
            NavController navCtrl = Navigation.findNavController(v);
            Bundle argumentos = new Bundle();
            argumentos.putLong("idVisita", visitaId);
            navCtrl.navigate(R.id.actionVisitasToCreacionModifVisita,argumentos);
        }

        void bind(InfoTarjetaVisita info) {
            int year,month,day;

            Date date;
            Calendar cal;

            date = new Date(info.getDia());
            cal = Calendar.getInstance();
            cal.setTime(date);
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);
            day = cal.get(Calendar.DAY_OF_MONTH);

            lblDia.setText(String.valueOf(day));
            lblMes.setText(String.valueOf(month));
            lblAnio.setText(String.valueOf(year));
            lblNombreEstudianteVisita.setText(info.getNombre());
            lblEmpresaEstudianteVisita.setText(info.getEmpresa());
            lblHoraInicioYfin.setText(String.format("De %s a %s",info.getHoraInicio(),info.getHoraFin()));

            visitaId = info.getId();


        }
    }
}
