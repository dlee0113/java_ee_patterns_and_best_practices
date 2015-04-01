package com.abien.messageme.presentation;

import com.abien.messageme.business.messaging.boundary.Messaging;
import com.abien.messageme.business.messaging.entity.Message;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class IndexPresenterTest {

    private IndexPresenter cut;
    
    @Before
    public void initialize(){
        this.cut = new IndexPresenter();
    }

    @Test
    public void save() {
        this.cut.boundary = mock(Messaging.class);
        this.cut.indexView = mock(IndexView.class);
        Message expected = new Message("duke");
        when(this.cut.indexView.getMessage()).thenReturn(expected);
        cut.save();
        verify(this.cut.boundary,times(1)).store(expected);
    }

}