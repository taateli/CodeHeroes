/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author kaisa
 */
public class FileObject extends AbstractPersistable<Long> {

    private String name;
    private Long contentLength;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    public FileObject(byte[] content, String name) {
        if (name == null) {
            this.name = "sigproc.bib";
        } else if (name.contains(".bib")) {
            this.name = name;
        } else {
            this.name = name + ".bib";
        }
        this.contentLength = (long)content.length;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getContentLength() {
        return contentLength;
    }

    public void setContentLength(Long contentLength) {
        this.contentLength = contentLength;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

}
