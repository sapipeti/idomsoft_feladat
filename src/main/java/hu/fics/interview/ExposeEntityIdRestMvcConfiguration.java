package hu.fics.interview;

import hu.fics.interview.model.Email;
import hu.fics.interview.model.Office;
import hu.fics.interview.model.OfficeAddress;
import hu.fics.interview.model.OfficialEmployee;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class ExposeEntityIdRestMvcConfiguration extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Email.class);
    config.exposeIdsFor(Office.class);
    config.exposeIdsFor(OfficeAddress.class);
    config.exposeIdsFor(OfficialEmployee.class);
  }
}
