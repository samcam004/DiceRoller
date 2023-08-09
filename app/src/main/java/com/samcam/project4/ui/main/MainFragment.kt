package com.samcam.project4.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.samcam.project4.R
import com.samcam.project4.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding : FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Begin Four Sided Dice
        binding.btnSubFour.setOnClickListener {
            if (!binding.tvNumOfFour.text.equals("0")) {
                binding.tvNumOfFour.text = (binding.tvNumOfFour.text.toString().toInt() - 1).toString()
            }
        }

        binding.btnAddFour.setOnClickListener {
            if (binding.tvNumOfFour.text.toString().toInt() <= 99) {
                binding.tvNumOfFour.text = (binding.tvNumOfFour.text.toString().toInt() + 1).toString()
            }
        }
        //End Four Sided Dice

        //Begin Six Sided Dice
        binding.btnSubSix.setOnClickListener {
            if (!binding.tvNumOfSix.text.equals("0")) {
                binding.tvNumOfSix.text = (binding.tvNumOfSix.text.toString().toInt() - 1).toString()
            }
        }

        binding.btnAddSix.setOnClickListener {
            if (binding.tvNumOfSix.text.toString().toInt() <= 99) {
                binding.tvNumOfSix.text = (binding.tvNumOfSix.text.toString().toInt() + 1).toString()
            }
        }
        //End Six Sided Dice

        //Begin Eight Sided Dice
        binding.btnSubEight.setOnClickListener {
            if (!binding.tvNumOfEight.text.equals("0")) {
                binding.tvNumOfEight.text = (binding.tvNumOfEight.text.toString().toInt() - 1).toString()
            }
        }

        binding.btnAddEight.setOnClickListener {
            if (binding.tvNumOfEight.text.toString().toInt() <= 99) {
                binding.tvNumOfEight.text = (binding.tvNumOfEight.text.toString().toInt() + 1).toString()
            }
        }
        //End Eight Sided Dice

        //Begin Ten Sided Dice
        binding.btnSubTen.setOnClickListener {
            if (!binding.tvNumOfTen.text.equals("0")) {
                binding.tvNumOfTen.text = (binding.tvNumOfTen.text.toString().toInt() - 1).toString()
            }
        }

        binding.btnAddTen.setOnClickListener {
            if (binding.tvNumOfTen.text.toString().toInt() <= 99) {
                binding.tvNumOfTen.text = (binding.tvNumOfTen.text.toString().toInt() + 1).toString()
            }
        }
        //End Ten Sided Dice

        //Begin Twelve Sided Dice
        binding.btnSubTwelve.setOnClickListener {
            if (!binding.tvNumOfTwelve.text.equals("0")) {
                binding.tvNumOfTwelve.text = (binding.tvNumOfTwelve.text.toString().toInt() - 1).toString()
            }
        }

        binding.btnAddTwelve.setOnClickListener {
            if (binding.tvNumOfTwelve.text.toString().toInt() <= 99) {
                binding.tvNumOfTwelve.text = (binding.tvNumOfTwelve.text.toString().toInt() + 1).toString()
            }
        }
        //End Twelve Sided Dice

        //Begin Twenty Sided Dice
        binding.btnSubTwenty.setOnClickListener {
            if (!binding.tvNumOfTwenty.text.equals("0")) {
                binding.tvNumOfTwenty.text = (binding.tvNumOfTwenty.text.toString().toInt() - 1).toString()
            }
        }

        binding.btnAddTwenty.setOnClickListener {
            if (binding.tvNumOfTwenty.text.toString().toInt() <= 99) {
                binding.tvNumOfTwenty.text = (binding.tvNumOfTwenty.text.toString().toInt() + 1).toString()
            }
        }
        //End Twenty Sided Dice

        binding.btnRoll.setOnClickListener {

            val action : MainFragmentDirections.ActionMainFragmentToRollFragment
                                = MainFragmentDirections.actionMainFragmentToRollFragment()

            action.numOfFour = binding.tvNumOfFour.text.toString().toInt()
            action.numOfSix = binding.tvNumOfSix.text.toString().toInt()
            action.numOfEight = binding.tvNumOfEight.text.toString().toInt()
            action.numOfTen = binding.tvNumOfTen.text.toString().toInt()
            action.numOfTwelve = binding.tvNumOfTwelve.text.toString().toInt()
            action.numOfTwenty = binding.tvNumOfTwenty.text.toString().toInt()

            Log.i("Main", "${action.numOfFour}")


            if (binding.etModFour.text.isNotEmpty()) {
                action.d4Mod = binding.etModFour.text.toString().toInt()
            }

            if (binding.etModSix.text.isNotBlank()) {
                action.d6Mod = binding.etModSix.text.toString().toInt()
            }

            if (binding.etModEight.text.isNotBlank()) {
                action.d8Mod = binding.etModEight.text.toString().toInt()
            }

            if (binding.etModTen.text.isNotBlank()) {
                action.d10Mod = binding.etModTen.text.toString().toInt()
            }

            if (binding.etModTwelve.text.isNotBlank()) {
                action.d12Mod = binding.etModTwelve.text.toString().toInt()
            }

            if (binding.etModTwenty.text.isNotEmpty()) {
                action.d20Mod = binding.etModTwenty.text.toString().toInt()
            }


            Navigation.findNavController(it).navigate(action)
        }
    }

}