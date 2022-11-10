package com.graduationproject.robokidsapp.ui.parentsFragments

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.graduationproject.robokidsapp.R
import com.graduationproject.robokidsapp.databinding.FragmentParentsHomeBinding
import com.graduationproject.robokidsapp.ui.MainActivity

class ParentsHomeFragment : Fragment() {
    private lateinit var mNavController: NavController
    private var _binding: FragmentParentsHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNavController = findNavController()


        MainActivity.binding.drawLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentParentsHomeBinding.inflate(inflater, container, false)

        binding.tvAddNewKids.setOnClickListener {
            val action = ParentsHomeFragmentDirections.actionParentsHomeFragmentToAddKidsFragment()
            mNavController.navigate(action)
        }

        return binding.root
    }


    override fun onResume() {
        super.onResume()
        MainActivity.binding.customToolbarMainActivity.visibility = View.VISIBLE
        MainActivity.binding.customToolbarMainActivity.title = ""

        //show status bar
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        activity?.window!!.statusBarColor = this.resources.getColor(R.color.teal_700)

        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onDestroyView() {
        super.onDestroyView()
        MainActivity.binding.customToolbarMainActivity.visibility = View.GONE
        _binding = null
    }

}