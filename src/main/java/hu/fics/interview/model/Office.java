package hu.fics.interview.model;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "seq_off", initialValue = 1, allocationSize = 1)
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_off")
    private Long id;

    @OneToMany(mappedBy = "office")
    private List<OfficeAddress> address;

    @OneToMany(mappedBy = "workPlace")
    private List<OfficialEmployee> workers;
    
    @OneToOne(mappedBy = "bossWorkPlace")
    private OfficialEmployee boss;
    
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OfficeAddress> getAddress() {
        return address;
    }

    public void setAddress(List<OfficeAddress> address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OfficialEmployee> getWorkers() {
        return workers;
    }

    public void setWorkers(List<OfficialEmployee> workers) {
        this.workers = workers;
    }

    public OfficialEmployee getBoss() {
        return boss;
    }

    public void setBoss(OfficialEmployee boss) {
        this.boss = boss;
    }
    
    
}
