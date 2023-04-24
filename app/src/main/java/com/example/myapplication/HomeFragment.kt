package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), NewsTypeAdapter.OnItemClickListener, NewsCardAdapter.OnItemClickListenerCard, Communicator {
    lateinit var types: MutableList<NewsType>
    lateinit var news_cards: MutableList<NewsCard>
    lateinit var adapter:NewsTypeAdapter
    lateinit var cardsAdapter:NewsCardAdapter
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        loadData()
        binding.readMore.setOnClickListener{
            passDataCom(news_cards[0])
        }
//        binding.search.clearFocus()
        binding.search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val filteredList = news_cards.filter { it.title.contains(s.toString(), ignoreCase = true) }
                cardsAdapter = NewsCardAdapter(filteredList as MutableList<NewsCard>, this@HomeFragment)
                binding.newsRv.adapter = cardsAdapter
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        binding.notification.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, NotificationFragment())
                .commit()
        }
        return binding.root
    }
    private fun loadData(){
        news_cards = mutableListOf()
        news_cards.add(NewsCard(R.drawable.joe2, "Wow! Donald Trump...", "201K", "300K", R.drawable.cnn, "CNN", "Trending", "55K", "Wow! adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff.afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff", "6 days ago"))
        news_cards.add(NewsCard(R.drawable._43964008_doctors_infectionist_research_and_covid19_concept_confident_young_happy_asian_female_doctor_show, "Hot! USA has released...", "501K", "100K", R.drawable.bbc_news, "BBC News", "Latest", "60K", "Afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff.afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. . afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff.afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff.", "10 days ago"))
        news_cards.add(NewsCard(R.drawable.joe_biden, "nimaadir", "201K", "300K", R.drawable.cnn, "CNN", "Politics", "55K", "Afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff.afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. . afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff.afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff", "6 days ago"))
        news_cards.add(NewsCard(R.drawable.joe_biden, "nimaadir", "201K", "300K", R.drawable.bbc_news, "BBC News", "Health", "55K", "Afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff.afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. . afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff.afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff", "6 days ago"))
        news_cards.add(NewsCard(R.drawable._43964008_doctors_infectionist_research_and_covid19_concept_confident_young_happy_asian_female_doctor_show, "Hot! USA has released...", "501K", "100K", R.drawable.bbc_news, "BBC News", "Latest", "60K", "Afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff.afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. . afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff.afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff. afasdfs adfsadadf adsfasdfafa asfdasfsafasfd asdfsafasfaff.", "10 days ago"))
        types = mutableListOf()
        types.add(NewsType("Trending", false))
        types.add(NewsType("Latest", false))
        types.add(NewsType("Health", false))
        types.add(NewsType("Politics", false))
        adapter = NewsTypeAdapter(types, this)
        cardsAdapter = NewsCardAdapter(news_cards, this)
        var layoutHorizontal = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        var layoutHorizontal1 = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.typesRv.layoutManager = layoutHorizontal
        binding.newsRv.layoutManager = layoutHorizontal1
        binding.newsRv.adapter = cardsAdapter
        binding.typesRv.adapter = adapter
    }
    private fun filterType(text:String) {
        val filteredList = news_cards.filter { it.news_type == text }
        cardsAdapter = NewsCardAdapter(filteredList as MutableList<NewsCard>, this@HomeFragment)
        binding.newsRv.adapter = cardsAdapter
    }
    override fun onItemClick(position: Int) {
        var got = types[position].status
        for (i in 0 until types.size){
            if (types[i].status){
                types[i].status = false
                adapter.notifyItemChanged(i)
            }
        }
        types[position].status = !got
        if (types[position].status){
            filterType(types[position].type)
        }else{
            loadData()
        }
        adapter.notifyItemChanged(position)
    }


    override fun passDataCom(obj: NewsCard) {
        val info: String = obj.info
        val watches: String = obj.watches
        val likes: String = obj.likes
        val mes: String = obj.messages
        val news_comp: String = obj.news_comp
        val img: Int = obj.wallpaper
        val icon: Int = obj.news_icon
        val title: String = obj.title
        val type: String = obj.news_type
        val day: String = obj.days
        val bundle = Bundle()
        bundle.putString("info", info )
        bundle.putString("likes", likes )
        bundle.putString("watches", watches )
        bundle.putString("news_type", type )
        bundle.putString("news_comp", news_comp )
        bundle.putString("mes", mes )
        bundle.putString("day", day )
        bundle.putString("title", title )
        bundle.putInt("icon", icon )
        bundle.putInt("img", img )
        var tr = parentFragmentManager.beginTransaction()
        val frag2 = NewsFragment()
        frag2.arguments = bundle
        tr.replace(R.id.main_container, frag2)
        tr.addToBackStack(null)
        tr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        tr.commit()
    }

    override fun onItemClickCard(position: Int) {
        passDataCom(news_cards[position])
    }
}