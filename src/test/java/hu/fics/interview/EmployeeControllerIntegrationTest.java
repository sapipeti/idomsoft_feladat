package hu.fics.interview;

import hu.fics.interview.model.Email;
import hu.fics.interview.model.OfficialEmployee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;
    private Long aktId;

    private String getRootUrl() {
        return "http://localhost:" + port + "/springboot-crud-rest";
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testGetAllEmployees() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employee",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void testGetEmployeeById() {
        OfficialEmployee employee = restTemplate.getForObject(getRootUrl() + "/employee/"+aktId, OfficialEmployee.class);
        System.out.println(employee.getEmails());
        assertNotNull(employee);
    }

    @Before
    public void testCreateEmployee() {
        OfficialEmployee employee = new OfficialEmployee();
        employee.setFirstName("admin");
        employee.setLastName("admin");

        Email email=new Email();
        email.setAddress("admin.admin@tst.hu");

        ResponseEntity<Email> emailPostResponse = restTemplate.postForEntity(getRootUrl() + "/email", email, Email.class);
        emailPostResponse.getBody().setEmployee(employee);
        List<Email> emailList=new ArrayList<>();
        emailList.add(emailPostResponse.getBody());

        //employee.setEmails(emailList);

        ResponseEntity<OfficialEmployee> postResponse = restTemplate.postForEntity(getRootUrl() + "/employee", employee, OfficialEmployee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        aktId=postResponse.getBody().getId();
    }

    @Test
    public void testUpdateEmployee() {
        OfficialEmployee employee = restTemplate.getForObject(getRootUrl() + "/employee/" + aktId, OfficialEmployee.class);
        employee.setFirstName("admin1");
        employee.setLastName("admin2");

        restTemplate.put(getRootUrl() + "/employee/" + aktId, employee);

        OfficialEmployee updatedEmployee = restTemplate.getForObject(getRootUrl() + "/employee/" + aktId, OfficialEmployee.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteEmployee() {

        OfficialEmployee employee = restTemplate.getForObject(getRootUrl() + "/employee/" + aktId, OfficialEmployee.class);
        assertNotNull(employee);

        restTemplate.delete(getRootUrl() + "/employee/" + aktId);

        try {
            employee = restTemplate.getForObject(getRootUrl() + "/employee/" + aktId, OfficialEmployee.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
