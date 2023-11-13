package com.example.tp3.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3.NavigationListener
import com.example.tp3.R
import com.example.tp3.adapters.ListNeighborHandler
import com.example.tp3.adapters.ListNeighborsAdapter
import com.example.tp3.data.NeighborRepository
import com.example.tp3.models.Neighbor
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListNeighborsFragment : Fragment(), ListNeighborHandler  {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNeighbor: FloatingActionButton


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        addNeighbor = view.findViewById(R.id.buttonAddNeighbor)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment(NeighborRepository.getInstance().getNeighbours())

        addNeighbor.setOnClickListener {
            (activity as? NavigationListener)?.let {
                it.showFragment(AddNeighbourFragment())
                it.updateTitle(R.string.titleAddNeighbor)
            }
        }

    }

    private fun initFragment(neighbors: List<Neighbor>){
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }

    override fun onDeleteNeighbor(neighbor: Neighbor) {

        val builder = AlertDialog.Builder(context) // Use appropriate context
        builder.setTitle("Confirmer")
        builder.setMessage("Vous voulez supprimer cette utilisateur?")

        // Set the OK button and its action
        builder.setPositiveButton("OK") { dialog, which ->
           if (NeighborRepository.getInstance().deleteNeighbors(neighbor)){
               Toast.makeText(context, "Suppresion de l'utilisateur avec success", Toast.LENGTH_SHORT).show()
               initFragment(NeighborRepository.getInstance().getNeighbours())
           }
            else {
               Toast.makeText(context, "Probleme dans le delete", Toast.LENGTH_SHORT).show()
           }
        }

        builder.setNegativeButton("No") {dialog, which ->
            dialog.dismiss()
        }
        // Display the AlertDialog
        val dialog = builder.create()
        dialog.show()
    }

}
