package com.example.onlinetutoringsystem;

import static org.mockito.Mockito.when;

import com.example.onlinetutoringsystem.Activities.Service;
import com.example.onlinetutoringsystem.Data.ObservationView;
import com.example.onlinetutoringsystem.Data.UserDao;
import com.example.onlinetutoringsystem.Model.User;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest extends TestCase {
    @Mock
    private ObservationView view;
    @Mock
    private UserDao userDao;
    private Service service;
    @Before
    public void setUp() {
        service = new Service(view,userDao);
    }

    @Test
    public void NullUserName_NullEmail_NullPassword_NullPasswordConf(){
        when(view.getUsername()).thenReturn(null);
        when(view.getEmail()).thenReturn(null);
        when(view.getPassword()).thenReturn(null);
        when(view.getPasswordConf()).thenReturn(null);
        assertEquals(service.OnClick(),view.showNullError());
    }
    @Test
    public void EmptyStringUserName_EmptyStringCorrectEmail_EmptyStringPassword_EmptyStringNotMatchingPasswordConf() {
        when(view.getUsername()).thenReturn("");
        when(view.getEmail()).thenReturn("");
        when(view.getPassword()).thenReturn("");
        when(view.getPasswordConf()).thenReturn("");
        assertEquals(service.OnClick(),view.showEmptyStringError());
    }
    @Test
    public void CorrectUserName_CorrectEmail_Password_NotMatchingPasswordConf() {
        when(view.getUsername()).thenReturn("james");
        when(view.getEmail()).thenReturn("jack.jones@gmail.com");
        when(view.getPassword()).thenReturn("123456");
        when(view.getPasswordConf()).thenReturn("123522");
        assertEquals(service.OnClick(),view.showPassNotMatch());
    }
    @Test
    public void CorrectUserName_CorrectEmail_CorrectPassword_CorrectPasswordConf(){
        when(view.getUsername()).thenReturn("james");
        when(view.getEmail()).thenReturn("jack.jones@gmail.com");
        when(view.getPassword()).thenReturn("123456");
        when(view.getPasswordConf()).thenReturn("258274");
        assertEquals(service.OnClick(),view.showRegisteredSuccess());
    }
    @Test
    public void UserIsNotRegistered(){
        when(userDao.getUser("user1234","123456")).thenReturn(null);
        assertEquals(service.OnClick(),view.showNotRegistered());
    }
    @Test
    public void NoRecordFound(){
        User user = new User("user1234","123456","user1234@gmail.com");
        assertEquals(service.OnClick(),view.showNoRecordFound());
    }
}