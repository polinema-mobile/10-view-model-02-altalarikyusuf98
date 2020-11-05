package id.putraprima.mvvmlogin.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.Account;

public class LoginFragmentViewModel extends ViewModel {
    private MutableLiveData<Account> accountMutableLiveData = new MutableLiveData<>();
    private Account account;

    public LoginFragmentViewModel(Account account) {
        this.accountMutableLiveData.setValue(account);
    }

    public void Login(){
        Log.d("username", this.accountMutableLiveData.getValue().getUsername());
        Log.d("password", this.accountMutableLiveData.getValue().getPassword());
    }
}
