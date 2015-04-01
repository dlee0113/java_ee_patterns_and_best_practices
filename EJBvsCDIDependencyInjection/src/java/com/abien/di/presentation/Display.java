package com.abien.di.presentation;

import com.abien.di.messenger.SessionInfo;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Named
@ApplicationScoped
public class Display {

    @Inject
    SessionInfo sessionInfo;

    public SessionInfo getSessionInfo() {
        return sessionInfo;
    }
}
