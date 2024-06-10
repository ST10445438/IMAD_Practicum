package com.example.imad_practicum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlin.random.Random

class DailyMonitor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_monitor2)

        fun GetRandomConditions() : String {
            val conditions = arrayOf<String>("Sunny","Rainy","Thunderclouds","Damp","Cloudy","Hot","Cold")
            val randomvalue = Random.nextInt(conditions.size)
            return conditions[randomvalue]
        }
        SecondPage.ConnectivityUtils.isConnected(this)
        
    }

    class CollectionDemoFragment : Fragment() {
        // When requested, this adapter returns a DemoObjectFragment,
        // representing an object in the collection.
        private lateinit var demoCollectionAdapter: DemoCollectionAdapter
        private lateinit var viewPager: ViewPager2

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.collection_demo, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            demoCollectionAdapter = DemoCollectionAdapter(this)
            viewPager = view.findViewById(R.id.pager)
            viewPager.adapter = demoCollectionAdapter
        }
    }

    class DemoCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 100

        override fun createFragment(position: Int): Fragment {
            // Return a NEW fragment instance in createFragment(int).
            val fragment = DemoObjectFragment()
            fragment.arguments = Bundle().apply {
                // The object is just an integer.
                val ARG_OBJECT = null
                putInt(ARG_OBJECT, position + 1)
            }
            return fragment
        }
    }

    // Instances of this class are fragments representing a single
// object in the collection.
    class DemoObjectFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            return inflater.inflate(R.layout.fragment_collection_object, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
                val textView: TextView = view.findViewById(android.R.id.text1)
                textView.text = getInt(ARG_OBJECT).toString()
            }
        }
    }

    companion object {
        private const val ARG_OBJECT = "object"
    }

}