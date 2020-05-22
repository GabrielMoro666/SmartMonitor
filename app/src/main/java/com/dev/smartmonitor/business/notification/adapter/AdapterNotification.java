package com.dev.smartmonitor.business.notification.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dev.smartmonitor.R;
import com.dev.smartmonitor.business.notification.model.RowNotification;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdapterNotification extends RecyclerView.Adapter{
    private List<RowNotification> recyclerViewItems;
    private Context context;

    public AdapterNotification(List<RowNotification> recyclerViewItems, Context context) {
        this.recyclerViewItems = recyclerViewItems;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View recycleViewItem;

        recycleViewItem = inflater.inflate(R.layout.activity_adapter_notification_row, parent, false);
        return new RowNotificationHolder(recycleViewItem);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RowNotification rowNotification = recyclerViewItems.get(position);

        RowNotificationHolder rowItemHolder = (RowNotificationHolder) holder;

        rowItemHolder.textViewData.setText(new SimpleDateFormat("dd/MM/yyyy").format(rowNotification.getData()));
        rowItemHolder.textViewTitulo.setText(rowNotification.getTitulo());
        rowItemHolder.textViewDescricao.setText(rowNotification.getDescricao());
    }

    public class RowNotificationHolder extends RecyclerView.ViewHolder {
        public TextView textViewData;
        public TextView textViewTitulo;
        public CheckBox checkBoxConcluir;
        public TextView textViewDescricao;

        public RowNotificationHolder(View itemView) {
            super(itemView);
            this.textViewData = (TextView)itemView.findViewById(R.id.textViewRowTableAplicativo);
            this.textViewTitulo = (TextView)itemView.findViewById(R.id.textViewRowTableTempo);
            this.checkBoxConcluir = (CheckBox)itemView.findViewById(R.id.checkBoxRowNotificationConcluido);
            this.textViewDescricao = (TextView)itemView.findViewById(R.id.textViewRowNotificationDescricao);
        }

        public class CheckedChangedCheckBoxCheckConcluir implements CompoundButton.OnCheckedChangeListener{

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int position;

                position = getAdapterPosition();

                if (isChecked) {

                }

            }
        }

    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }
}