package uam.dsti.sb_online_shop.domain;

import java.util.HashSet;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class CarOwner {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ownerid;
    private String firstname, lastname;

    public CarOwner() {}

    public CarOwner(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;

    }

    //@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "car_ownership",
        joinColumns = @JoinColumn(name = "ownerid"), // Corrected syntax
        inverseJoinColumns = @JoinColumn(name = "id") // Corrected syntax
    )
    //private Set<Car> cars = new HashSet<>();

    private Set<Car> cars = new HashSet<Car>();

    public Set<Car> getCars() {
        return cars;
    }

    //private List<Car> cars;
 
    //public List<Car> getCars() {
    //    return cars;
    //}

    //public void setCars(List<Car> cars){
    //    this.cars = cars;
    //}

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}


