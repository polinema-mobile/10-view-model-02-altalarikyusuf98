package id.putraprima.mvvmlogin.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.Account;

public class HomeFragmentViewModel extends ViewModel {

    private MutableLiveData<Account> homeMutableLiveData = new MutableLiveData<>();
    private Account account;

    public HomeFragmentViewModel(Account account){
        this.account = account;
        this.homeMutableLiveData.setValue(account);
    }
    public LiveData<Account> modelLoginLiveData(){
        return homeMutableLiveData;
    }
}
