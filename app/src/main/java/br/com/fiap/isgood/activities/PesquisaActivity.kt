package br.com.fiap.isgood.activities

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import br.com.fiap.isgood.R
import br.com.fiap.isgood.fragments.tab.LancheFragment
import br.com.fiap.isgood.fragments.tab.RestauranteFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class PesquisaActivity : BaseDrawerActivity() {

    lateinit  var recyclerView:RecyclerView;
    lateinit  var tabLayout:TabLayout;
    lateinit  var viewPager2: ViewPager2;
    lateinit  var searchView: SearchView;
    val tabs = arrayListOf<String>("Restaurantes","Lanches");



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setOriginalContentView(R.layout.activity_pesquisa);
        searchView = findViewById(R.id.search_bar);
        configureTabs();
    }

    private fun configureTabs() {
        tabLayout = findViewById(R.id.tabLayoutPesquisa);
        viewPager2 = findViewById(R.id.fragViewPagerPesquisa);
        viewPager2.adapter = FragmentViewPageAdapter(this,tabs.size);

        TabLayoutMediator (tabLayout,viewPager2,TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.text = tabs[position];
        }).attach();
    }

    class FragmentViewPageAdapter (activity: BaseDrawerActivity, private val tabSize: Int) : FragmentStateAdapter (activity) {

        override fun getItemCount(): Int {
            return tabSize;
        }

        override fun createFragment(position: Int): Fragment {

            when(position) {
                0 -> return RestauranteFragment();
                1 -> return LancheFragment();
            }

            return Fragment();
        }
    }
}