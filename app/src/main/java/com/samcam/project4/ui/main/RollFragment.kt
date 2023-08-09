package com.samcam.project4.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.net.Uri
import com.samcam.project4.databinding.FragmentRollBinding
import kotlin.random.Random

class RollFragment : Fragment() {

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    private lateinit var binding: FragmentRollBinding
    //private lateinit var viewModel: RollViewModel

    override fun onStart() {
        super.onStart()

        arguments?.let {
            val args = RollFragmentArgs.fromBundle(it)

            binding.tvNumD4.text = (args.numOfFour).toString()
            binding.tvNumD6.text = args.numOfSix.toString()
            binding.tvNumD8.text = args.numOfEight.toString()
            binding.tvNumD10.text = args.numOfTen.toString()
            binding.tvNumD12.text = args.numOfTwelve.toString()
            binding.tvNumD20.text = args.numOfTwenty.toString()


            binding.tvModD4.text = args.d4Mod.toString()
            binding.tvModD6.text = args.d6Mod.toString()
            binding.tvModD8.text = args.d8Mod.toString()
            binding.tvModD10.text = args.d10Mod.toString()
            binding.tvModD12.text = args.d12Mod.toString()
            binding.tvModD20.text = args.d20Mod.toString()

            if (binding.tvNumD4.text.toString() != "0") {
                val stats = getStats(
                    4,
                    binding.tvNumD4.text.toString().toInt(),
                    binding.tvModD4.text.toString().toInt()
                )

                binding.tvSumD4.text = stats[0].toInt().toString()
                binding.tvLowD4.text = stats[1].toInt().toString()
                binding.tvHighD4.text = stats[2].toInt().toString()
                binding.tvAveD4.text = String.format("%.1f", stats[3])
            }

            if (binding.tvNumD6.text.toString() != "0") {
                val stats = getStats(
                    6,
                    binding.tvNumD6.text.toString().toInt(),
                    binding.tvModD6.text.toString().toInt()
                )

                binding.tvSumD6.text = stats[0].toInt().toString()
                binding.tvLowD6.text = stats[1].toInt().toString()
                binding.tvHighD6.text = stats[2].toInt().toString()
                binding.tvAveD6.text = String.format("%.1f", stats[3])
            }

            if (binding.tvNumD8.text.toString() != "0") {
                val stats = getStats(
                    8,
                    binding.tvNumD8.text.toString().toInt(),
                    binding.tvModD8.text.toString().toInt()
                )

                binding.tvSumD8.text = stats[0].toInt().toString()
                binding.tvLowD8.text = stats[1].toInt().toString()
                binding.tvHighD8.text = stats[2].toInt().toString()
                binding.tvAveD8.text = String.format("%.1f", stats[3])
            }

            if (binding.tvNumD10.text.toString() != "0") {
                val stats = getStats(
                    10,
                    binding.tvNumD10.text.toString().toInt(),
                    binding.tvModD10.text.toString().toInt()
                )

                binding.tvSumD10.text = stats[0].toInt().toString()
                binding.tvLowD10.text = stats[1].toInt().toString()
                binding.tvHighD10.text = stats[2].toInt().toString()
                binding.tvAveD10.text = String.format("%.1f", stats[3])
            }

            if (binding.tvNumD12.text.toString() != "0") {
                val stats = getStats(
                    12,
                    binding.tvNumD12.text.toString().toInt(),
                    binding.tvModD12.text.toString().toInt()
                )

                binding.tvSumD12.text = stats[0].toInt().toString()
                binding.tvLowD12.text = stats[1].toInt().toString()
                binding.tvHighD12.text = stats[2].toInt().toString()
                binding.tvAveD12.text = String.format("%.1f", stats[3])
            }

            if (binding.tvNumD20.text.toString() != "0") {
                val stats = getStats(
                    20,
                    binding.tvNumD20.text.toString().toInt(),
                    binding.tvModD20.text.toString().toInt()
                )

                binding.tvSumD20.text = stats[0].toInt().toString()
                binding.tvLowD20.text = stats[1].toInt().toString()
                binding.tvHighD20.text = stats[2].toInt().toString()
                binding.tvAveD20.text = String.format("%.1f", stats[3])
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRollBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun getStats(diceType : Int, numDice : Int, rollMod : Int) : ArrayList<Double> {
        val rolls : ArrayList<Int> = ArrayList()
        val sendBack : ArrayList<Double> = ArrayList()
        var count = numDice
        var setRand = diceType + 1
        var sum = 0.0
        var low = 0.0
        var high = 0.0
        var average = 0.0

        for (i  in 1..count) {
            rolls.add(Random.nextInt(1, setRand) + rollMod)
        }

        for (i in 0 until count) {
            sum += rolls.get(i).toDouble()
        }

        low = rolls.min().toDouble()
        high = rolls.max().toDouble()
        average = sum.toDouble() / count.toDouble()

        sendBack.add(sum)
        sendBack.add(low)
        sendBack.add(high)
        sendBack.add(average)

        return sendBack
    }

}