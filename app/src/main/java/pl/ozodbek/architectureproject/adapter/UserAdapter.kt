package pl.ozodbek.architectureproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.ozodbek.architectureproject.database.UserEntity
import pl.ozodbek.architectureproject.databinding.UserItemBinding

class UserAdapter :
    ListAdapter<UserEntity, UserAdapter.AdapterViewHolder>(MyDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater, parent, false)
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val question = getItem(position)
        holder.bind(question)
    }


    inner class AdapterViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(userEntity: UserEntity) {

            binding.name.text = userEntity.name
            binding.age.text = userEntity.name


        }
    }

    private class MyDiffCallback : DiffUtil.ItemCallback<UserEntity>() {
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity) =
            oldItem == newItem
    }
}