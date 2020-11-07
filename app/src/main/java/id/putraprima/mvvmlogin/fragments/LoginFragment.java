package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.putraprima.mvvmlogin.R;
import id.putraprima.mvvmlogin.databinding.FragmentLoginBinding;
import id.putraprima.mvvmlogin.models.Account;
import id.putraprima.mvvmlogin.viewmodels.LoginFragmentViewModel;
import id.putraprima.mvvmlogin.viewmodels.LoginFragmentViewModelFactory;

public class LoginFragment extends Fragment {

    private LoginFragmentViewModel loginFragmentViewModel;
    Bundle bundle = new Bundle();

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentLoginBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false);
        View view = binding.getRoot();


        LoginFragmentViewModelFactory viewModelLoginFactory = new LoginFragmentViewModelFactory(new Account("altalarik@mail.com", "polinema"));
        loginFragmentViewModel = new ViewModelProvider(this, viewModelLoginFactory).get(LoginFragmentViewModel.class);
        binding.setViewModel(loginFragmentViewModel);
        binding.setLifecycleOwner(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginFragmentViewModel.validLiveData().observe(this.getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(loginFragmentViewModel.validLiveData().getValue() == true){
                    bundle.putString("username", loginFragmentViewModel.accountLiveData().getValue().username);
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment, bundle);
                }
            }
        });


    }
}