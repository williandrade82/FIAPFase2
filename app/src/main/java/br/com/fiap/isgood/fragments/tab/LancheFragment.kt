package br.com.fiap.isgood.fragments.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.isgood.R
import br.com.fiap.isgood.adapters.ListRestauranteAdapter
import br.com.fiap.isgood.models.Lanche

class LancheFragment:Fragment (){

    lateinit  var recyclerView: RecyclerView;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lanche,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewLanches);
        configureRecyclerView();
    }

    private fun configureRecyclerView() {
        recyclerView.setLayoutManager(LinearLayoutManager(getActivity()));

        val lanche1 = Lanche (nome="lanche1", endereco = "lanche1")
        val lanche2 = Lanche (nome="lanche2", endereco = "lanche2")
        val lanche3 = Lanche (nome="lanche3", endereco = "lanche3")

        val listLanches = ArrayList<Lanche>();
        listLanches.add(lanche1);
        listLanches.add(lanche2);
        listLanches.add(lanche3);

        val adapter = ListLancheAdapter(listLanches);
        recyclerView.adapter = adapter;
    }

    class ListLancheAdapter (private val dataSet: ArrayList<Lanche>) :
        RecyclerView.Adapter<ListLancheAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nome: TextView;
            val endereco: TextView;
            init {
                nome = view.findViewById(R.id.textViewNomeLanche);
                endereco = view.findViewById(R.id.textViewPrecoLanche);
            }
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_lanche_item, viewGroup, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            viewHolder.nome.text = dataSet[position].nome;
            viewHolder.endereco.text = dataSet[position].nome;
        }

        override fun getItemCount() = dataSet.size
    }
}

