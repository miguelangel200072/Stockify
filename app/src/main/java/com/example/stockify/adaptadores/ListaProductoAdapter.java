package com.example.stockify.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockify.R;
import com.example.stockify.entidades.Producto;

import java.util.ArrayList;

public class ListaProductoAdapter extends RecyclerView.Adapter<ListaProductoAdapter.ProductoViewHolder> {

    ArrayList<Producto> listaProducto;

    public ListaProductoAdapter(ArrayList<Producto> listaProducto){
        this.listaProducto = listaProducto;
    }
    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_producto, null, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.tvDescr.setText(listaProducto.get(position).getDescr());
        holder.tvCodigo.setText(listaProducto.get(position).getCodigo());
        holder.tvStand.setText(listaProducto.get(position).getStandNuevo());

    }

    @Override
    public int getItemCount() {
        return listaProducto.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView tvDescr, tvCodigo, tvStand;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescr = itemView.findViewById(R.id.tvDescr);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvStand = itemView.findViewById(R.id.tvStand);

        }
    }
}
