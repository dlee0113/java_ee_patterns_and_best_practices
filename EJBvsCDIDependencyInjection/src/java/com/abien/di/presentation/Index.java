package com.abien.di.presentation;

import com.abien.di.messenger.SessionInfo;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Model
public class Index {
    
    @Inject
    SessionInfo sessionInfo;

    public SessionInfo getSessionInfo(){
        return sessionInfo;
    }

}
