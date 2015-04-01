package com.abien.messageme.presentation;

import com.abien.messageme.business.messaging.boundary.Messaging;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Presenter
public class IndexPresenter {
    @Inject
    Messaging boundary;
    @Inject
    IndexView indexView;

    public void save(){
        boundary.store(indexView.getMessage());
    }
}
