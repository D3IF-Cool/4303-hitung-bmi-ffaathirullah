package org.d3if4203.hitungbmi.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import org.d3if4203.hitungbmi.R
import org.d3if4203.hitungbmi.data.KategoriBmi
import org.d3if4203.hitungbmi.databinding.FragmentSaranBinding

class SaranFragment : Fragment() {

    private lateinit var binding: FragmentSaranBinding
    private val args: SaranFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSaranBinding.inflate(
                layoutInflater, container, false)
        updateUI(args.kategori)
        binding.share.setOnClickListener { shareData() }
        return binding.root
    }

    private fun updateUI(kategori: KategoriBmi){
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        binding.bBadan.text =  "Berat Badan :" + args.bBadan.toString()
        binding.tBadan.text =  "Tinggi Badan :" + args.tBadan.toString()

        when(kategori){
            KategoriBmi.KURUS ->{
                actionBar?.title = getString(R.string.judul_kurus)
                binding.imageView.setImageResource(R.drawable.kurus)
                binding.textView.text = getString(R.string.saran_kurus)
            }
            KategoriBmi.IDEAL -> {
                actionBar?.title = getString(R.string.judul_ideal)
                binding.imageView.setImageResource(R.drawable.ideal)
                binding.textView.text = getString(R.string.saran_ideal)
            }
            KategoriBmi.GEMUK -> {
                actionBar?.title = getString(R.string.judul_gemuk)
                binding.imageView.setImageResource(R.drawable.gemuk)
                binding.textView.text = getString(R.string.saran_gemuk)
            }
        }
    }


    private fun shareData() {
        val message = getString(
            R.string.bagikan_template
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }

}