package com.abien.business.patterns.restserialization.articles.entity;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adam bien, adam-bien.com
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Article implements Serializable{

    private String title;
    private String content;
    private String tags;
    private Date publicationDate;
    
    public Article() {
    }

    public Article(String title, String content, String tags, Date publicationDate) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Article{" + "title=" + title + ", content=" + content + ", tags=" + tags + ", publicationDate=" + publicationDate + '}';
    }
    
    
}
