package com.example.app.server.domain;


public class DomainObject {

    private Long id = null;

    private Integer version = 0;

    /**
     * Auto-increment version # whenever persisted
     */
    void onPersist()
    {
        this.version++;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    // Equality based on ID field
    @Override
    public boolean equals(Object o)
    {
        if(o != null && (o instanceof DomainObject)) {
            return ((DomainObject)o).getId().compareTo(id) == 0;
        }
        return false;
    }

    // Required for checking equality
    @Override
    public int hashCode()
    {
        return ((Long)id).hashCode();
    }

}
