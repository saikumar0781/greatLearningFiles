package StreamApi;

import java.util.ArrayList;
import java.util.List;

public class findingAverageAgeByGender {

    Employee1 emp1  = new Employee1(1,"sai","male",24);
    
    List<Employee1> employee1List = new ArrayList<>();

}
class Employee1{
    int id;
    String name;
    String gender;
    int age;

    public Employee1(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
