package com.example.onlinetutoringsystem.Data;

import android.content.Context;

public interface ObservationView {

    String getUsername();

    String getEmail();

    String getPassword();

    String getPasswordConf();

    Context getContext();

    String showNullError();

    String showEmptyStringError();

    String showPassNotMatch();

    String showRegisteredSuccess();

    String showNotRegistered();

    String showNoRecordFound();

}
