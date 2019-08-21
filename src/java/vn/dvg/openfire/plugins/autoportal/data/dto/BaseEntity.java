package vn.dvg.openfire.plugins.autoportal.data.dto;

import lombok.Getter;
import lombok.Setter;

public abstract class BaseEntity<TId> extends BaseDto{
    public abstract TId getId();
    public abstract void setId(TId id);
}
