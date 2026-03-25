package com.iprism.swenhealth.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.TestItemBinding

class TestsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = TestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as TestsAdapter.TestViewHolder
        holder.binding.subTestsRv.layoutManager = LinearLayoutManager(holder.binding.subTestsRv.context)
        val subTestsAdapter = SubTestsAdapter()
        holder.binding.subTestsRv.adapter = subTestsAdapter
    }

    override fun getItemCount(): Int {
        return 3
    }

    class TestViewHolder(var binding: TestItemBinding) : RecyclerView.ViewHolder(binding.root)

}
