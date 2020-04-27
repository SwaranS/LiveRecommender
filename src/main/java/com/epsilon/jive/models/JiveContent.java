package com.epsilon.jive.models;

public class JiveContent {

    private long id;
    private String subject;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public JiveContent(long id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public JiveContent() {
    }

    @Override
    public String toString() {
        return "JiveContent{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                '}';
    }
}
