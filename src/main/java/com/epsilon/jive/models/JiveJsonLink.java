package com.epsilon.jive.models;

public class JiveJsonLink {
    private String next;
    private String previous;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public JiveJsonLink(String next, String previous) {
        this.next = next;
        this.previous = previous;
    }

    public JiveJsonLink() {
    }

    @Override
    public String toString() {
        return "JiveJsonLink{" +
                "next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                '}';
    }
}
