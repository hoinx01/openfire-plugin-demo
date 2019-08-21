package vn.dvg.openfire.plugins.autoportal.restapi.services;

import lombok.val;
import vn.dvg.openfire.plugins.autoportal.data.dao.ApplicationDao;
import vn.dvg.openfire.plugins.autoportal.restapi.models.application.ApplicationResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationService {
    public static List<ApplicationResponse> getAllApplications() throws SQLException, IllegalAccessException {
        val dtoes = ApplicationDao.getAll();
        val result = new ArrayList<ApplicationResponse>();
        for (val dto: dtoes
             ) {
            val model = new ApplicationResponse();
            model.setId(dto.getId());
            model.setName(dto.getName());
            model.setCreatedAt(dto.getCreatedAt());
            model.setModifiedAt(dto.getModifiedAt());
            result.add(model);
        }
        return result;
    }

    public static List<ApplicationResponse> filter() throws SQLException, IllegalAccessException {
        val dtoes = ApplicationDao.filter();
        val result = new ArrayList<ApplicationResponse>();
        for (val dto: dtoes
        ) {
            val model = new ApplicationResponse();
            model.setId(dto.getId());
            model.setName(dto.getName());
            model.setCreatedAt(dto.getCreatedAt());
            model.setModifiedAt(dto.getModifiedAt());
            result.add(model);
        }
        return result;
    }

}
