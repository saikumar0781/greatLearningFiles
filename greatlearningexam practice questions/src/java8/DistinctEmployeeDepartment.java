package java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistinctEmployeeDepartment {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("ABC",30,"Female","HR"));
        list.add(new Employee("PQR",25,"Male","IT"));
        list.add(new Employee("XYZ",28,"Female","IT"));
        list.add(new Employee("LMN",30,"Male","HR"));

        //list.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

//        Map<String,Long> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
//        System.out.println(map);

       Map<String,Double> map = list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
        System.out.println(map);
    }
}
