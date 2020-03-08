package com.example.epidemic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PageResult<T> {

    public static class Meta {

        @JsonProperty("total_count")
        public long totalCount;

        @JsonProperty("page_count")
        public int pageCount;

        @JsonProperty("current_page")
        public int currentPage;

        @JsonProperty("per_page")
        public int perPage;

        public long getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(long totalCount) {
            this.totalCount = totalCount;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getPerPage() {
            return perPage;
        }

        public void setPerPage(int perPage) {
            this.perPage = perPage;
        }
    }

    @JsonProperty("items")
    public List<T> list;

    @JsonProperty("_meta")
    public Meta meta;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
