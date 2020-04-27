package com.epsilon.jive.models;

import java.util.List;

public class JiveContentWrapper {

    private long itemsPerPage;
    private JiveJsonLink links;
    private List<JiveContent> list;

    public long getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(long itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public JiveJsonLink getLinks() {
        return links;
    }

    public void setLinks(JiveJsonLink links) {
        this.links = links;
    }

    public List<JiveContent> getList() {
        return list;
    }

    public void setList(List<JiveContent> list) {
        this.list = list;
    }

    public JiveContentWrapper() {
    }

    public JiveContentWrapper(long itemsPerPage, JiveJsonLink links, List<JiveContent> contentList) {
        this.itemsPerPage = itemsPerPage;
        this.links = links;
        this.list = contentList;
    }

    @Override
    public String toString() {
        return "JiveContentWrapper{" +
                "itemsPerPage=" + itemsPerPage +
                ", links=" + links +
                ", contentList=" + list +
                '}';
    }
}
