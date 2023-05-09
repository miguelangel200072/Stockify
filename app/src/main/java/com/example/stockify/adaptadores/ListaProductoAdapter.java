package com.example.stockify.adaptadores;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockify.R;
import com.example.stockify.db.EliminarProductoDB;
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

        holder.tvDescr.setText(listaProducto.get(position).getDescr());
        holder.tvCodigo.setText(listaProducto.get(position).getCodigo());
        holder.tvStand.setText(listaProducto.get(position).getStandNuevo());

        // Agrega el listener para eliminar el producto al hacer clic en el elemento
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Muestra un diálogo de confirmación antes de eliminar el producto
                new AlertDialog.Builder(holder.itemView.getContext())
                        .setTitle("Eliminar producto")
                        .setMessage("¿Está seguro de que desea eliminar este producto?")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Elimina el producto de la base de datos y de la lista
                                EliminarProductoDB eliminarProductoDB = new EliminarProductoDB(holder.itemView.getContext());
                                boolean eliminado = eliminarProductoDB.eliminarProducto(listaProducto.get(position).getIdProd());
                                if (eliminado) {
                                    listaProducto.remove(position);
                                    notifyItemRemoved(position);
                                    notifyItemRangeChanged(position, listaProducto.size());
                                    Toast.makeText(holder.itemView.getContext(), "Producto eliminado", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(holder.itemView.getContext(), "Error al eliminar el producto", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });
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
