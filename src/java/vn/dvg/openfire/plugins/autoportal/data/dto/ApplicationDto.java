package vn.dvg.openfire.plugins.autoportal.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApplicationDto extends BaseIntEntity {
    private String name;
    private Date createdAt;
    private Date modifiedAt;
}
