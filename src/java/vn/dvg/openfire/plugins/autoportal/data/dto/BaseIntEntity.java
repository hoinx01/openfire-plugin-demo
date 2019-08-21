package vn.dvg.openfire.plugins.autoportal.data.dto;

import lombok.val;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class BaseIntEntity extends BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer integer) {
        val a = int.class;
    }
}
