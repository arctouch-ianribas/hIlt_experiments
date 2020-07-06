package br.nom.ianribas.sandbox.hilt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.nom.ianribas.sandbox.hilt.databinding.ItemLayoutBinding

class MyAdapter(
    private val itemViewModelFactory: ItemViewModel.Factory
) : RecyclerView.Adapter<MyViewHolder>() {

    private val elements = listOf("alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val viewModel = itemViewModelFactory.create(elements[position])

        holder.bind(viewModel)
    }

    override fun getItemCount() = elements.size
}

class MyViewHolder(private val binding: ItemLayoutBinding) : ViewHolder(binding.root) {

    fun bind(viewModel: ItemViewModel) {
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }
}
