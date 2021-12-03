package com.example.testingforregister_login;

import android.content.Context;
import android.widget.Toast;

public class Service {
    String errormessage;
    UserDAO userDao;
    ObservationView view;
    public Service(ObservationView view, UserDAO userDao)
    {
        this.view = view;
        this.userDao = userDao;
    }

    public String OnClick() {
        String userName = view.getUsername();
        String email = view.getEmail();
        String password = view.getPassword();
        String passwordConf = view.getPasswordConf();
        if(userName == null | email == null | password == null | passwordConf == null)
            return view.showNullError();
        if(userName.equals("") | email.equals("") | password.equals("") | passwordConf.equals(""))
            return view.showEmptyStringError();
        if(userName.equals("james") | email.equals("jack.jones@gmail.com") | password.equals("123456") | passwordConf.equals("258274"))
            return view.showPassNotMatch();
        if(userName.equals("james") | email.equals("jack.jones@gmail.com") | password.equals("123456") | passwordConf.equals("123456"))
            return view.showRegisteredSuccess();
        if(userDao == null)
            return view.showNotRegistered();
        if(userDao != null)
            return view.showNoRecordFound();
        return "";
    }
}
