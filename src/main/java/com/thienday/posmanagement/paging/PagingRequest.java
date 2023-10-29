package com.thienday.posmanagement.paging;

import lombok.Data;

@Data
public class PagingRequest {
    Integer page;
    Integer size;
    String sortDirection;
    String[] properties;

    public Integer getPage(){
        return this.page == null ? 0 : this.page;
    }
    public Integer getSize(){
        return this.size == null ? 0 : this.size;
    }

    public String getSortDirection(){
        return this.sortDirection == null ? "desc" : this.sortDirection;
    }

    public String[] getProperties(){
        return this.properties == null ? new String[] {"createdTime"} : this.properties;
    }
}
