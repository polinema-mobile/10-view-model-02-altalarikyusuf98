package id.putraprima.mvvmlogin.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.Account;

public class LoginFragmentViewModel extends ViewModel {
    private MutableLiveData<Account> loginMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> validMutableLive = new MutableLiveData<>();
    private MutableLiveData<String> errorUsername = new MutableLiveData<>();
    private MutableLiveData<String> errorPassword = new MutableLiveData<>();

    private Account account;
    public String username, password;

    public LoginFragmentViewModel(Account account){
        this.account = account;
        this.loginMutableLiveData.setValue(this.account);

    }

    public void Login(){
        if(account.getUsername().equals(username) && account.getPassword().equals(password)){
            loginMutableLiveData.setValue(account);
            validMutableLive.setValue(true);
            return;
        }else if(account.getUsername().isEmpty() && account.getPassword().isEmpty()){
            errorUsername.setValue("Masukkan username");
            errorPassword.setValue("Masukkan Password");
            validMutableLive.setValue(false);
            return;
        }else if(account.getUsername().isEmpty() || account.getUsername() == null && account.getPassword().equals(password)){
            errorUsername.setValue("Masukkan username");
            validMutableLive.setValue(false);
        }else if(account.getUsername().equals(username) && account.getPassword().isEmpty() || account.getPassword() == null){
            errorPassword.setValue("Masukkan password");
            validMutableLive.setValue(false);
            return;
        }else if(!account.getUsername().equals(username) || !account.getPassword().equals(password)){
            errorUsername.setValue("Tolong masukkan username yang benar");
            errorPassword.setValue("Tolong masukkan password yang benar");
            validMutableLive.setValue(false);
            return;
        }
    }
    public LiveData<Account> accountLiveData(){
        return loginMutableLiveData;
    }
    public LiveData<Boolean> validLiveData() {
        return this.validMutableLive;
    }
    public LiveData<String> errorUsername(){
        return this.errorUsername;
    }
    public LiveData<String> errorPassword(){
        return this.errorPassword;
    }
}
