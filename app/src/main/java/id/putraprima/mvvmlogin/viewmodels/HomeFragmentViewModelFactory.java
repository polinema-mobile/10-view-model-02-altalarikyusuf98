package id.putraprima.mvvmlogin.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.putraprima.mvvmlogin.models.Account;

public class HomeFragmentViewModelFactory implements ViewModelProvider.Factory {

    private Account account;

    public HomeFragmentViewModelFactory(Account account){
        this.account = account;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(LoginFragmentViewModel.class)){
            return (T) new LoginFragmentViewModel(account);
        }
        throw new IllegalArgumentException("Permintaan ViewModel ViewModelHome");
    }
}
