package uam.dsti.sb_online_shop.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;
    private String model;
    private String color;
    private String registerNumber;

    @Column(name = "`year`") // Escape the reserved word "year" in SQL
    private Integer year;

    //private double price;
    private BigDecimal price;

    // Constructor, getters, and setters
    
    public Car(){}


    //public Car(String brand, String model, String color, String registerNumber, int year, BigDecimal price, CarOwner owner) {
    public Car(String brand, String model, String color, String registerNumber, int year, BigDecimal price, Set<CarOwner> owners) {
        super();
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
        //this.owner = owner;
        this.owners = owners;
    }

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToMany(mappedBy="cars")
    //@JoinColumn(name = "owner") // Use double quotes for the name attribute
    //private CarOwner owner;
    //@JoinTable(
    //    name = "car_ownership",
    //    joinColumns = @JoinColumn(name = "car_id"),
    //    inverseJoinColumns = @JoinColumn(name = "ownerid")
    //)
    private Set<CarOwner> owners = new HashSet<CarOwner>();

    public Set<CarOwner>  getOwners() {
        return owners;
    }
    public Long getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }


    public String getColor() {
        return color;
    }


    public String getRegisterNumber() {
        return registerNumber;
    }


    public int getYear() {
        return year;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }  

    //public CarOwner getOwner() {
    //    return owner;
    //}

    //public void setOwner(CarOwner owner) {
    //   this.owner = owner;
    //}

    public void setOwners(Set<CarOwner> owners) {
        this.owners = owners;
    }
}
