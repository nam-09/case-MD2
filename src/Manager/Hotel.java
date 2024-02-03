package Manager;

import IO.HotelIO;
import Model.Person;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> persons;

    public Hotel() {
        persons = new ArrayList<>();
    }
    private static List<Hotel> hotels = new ArrayList<>();

    public Hotel(int i, String s, String s1, String s2) {
    }

    public static void writerHotel() {
        HotelIO.writerHotel(hotels);
    }

    public static void readHotel() {
        HotelIO.readerHotel(hotels);
    }

    public static List<Hotel> getHotels() {
        return hotels;
    }

    public static void setHotels(List<Hotel> hotels) {
        Hotel.hotels = hotels;
    }

    public void add(Person person) {
        this.persons.add(person);
    }
    public boolean update(String passport, Person updatedPerson) {
        for (int i = 0; i < this.persons.size(); i++) {
            if (this.persons.get(i).getPassport().equals(passport)) {
                this.persons.set(i, updatedPerson);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String passport) {
        Person person = this.persons.stream().filter(p -> p.getPassport().equals(passport)).findFirst().orElse(null);
        if (person == null) {
            return false;
        } else {
            this.persons.remove(person);
            return true;
        }
    }

    public int calculator(String passport) {
        Person person = this.persons.stream().filter(p -> p.getPassport().equals(passport)).findFirst().orElse(null);
        if (person == null) {
            return 0;
        }
        return person.getRoom().getPrice() * person.getNumberRent();
    }

    public void show() {
        this.persons.forEach(p -> System.out.println(p.toString()));
    }
}