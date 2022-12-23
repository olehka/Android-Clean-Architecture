package com.olehka.cleanandroid.core.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.olehka.cleanandroid.R
import com.olehka.cleanandroid.shared.core.model.Failure

abstract class BaseFragment<VB: ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    internal fun notify(@StringRes message: Int, viewContainer: View = binding.root) =
        Snackbar.make(viewContainer, message, Snackbar.LENGTH_SHORT).show()

    internal fun renderFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> notify(R.string.failure_network_connection)
            is Failure.ServerError -> notify(R.string.failure_server_error)
            else -> notify(R.string.failure_message)
        }
    }
}
