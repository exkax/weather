package kg.geektech.weather.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.geektech.weather.R;



public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {

    protected VB binding;
    protected  abstract VB bind();
    protected NavController controller;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = bind();
        controller = Navigation.findNavController(requireActivity(), R.id.nav_host);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViews();
        callRequests();
        setupListeners();
        setupObservers();
    }

    protected abstract void setupViews();
    protected abstract void setupListeners();
    protected abstract void setupObservers();
    protected abstract void callRequests();
}