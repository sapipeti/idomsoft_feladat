package hu.fics.interview.projection;

import hu.fics.interview.model.Email;
import hu.fics.interview.model.OfficialEmployee;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "employeeProjection", types = {OfficialEmployee.class})
public interface EmployeeProjection {
    Long getId();
    String getFirstName();
    String getLastName();
    List<Email> getEmails();
}
