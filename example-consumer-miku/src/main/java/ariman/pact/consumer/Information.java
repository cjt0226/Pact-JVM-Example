package ariman.pact.consumer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Information {
    private Integer salary;
    private String name;
    private String nationality;
    private Map<String, String> contact = new HashMap<>();

//    public Integer getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Integer salary) {
//        this.salary = salary;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Map<String, String> getContact() {
//        return contact;
//    }
//
//    public void setContact(Map<String, String> contact) {
//        this.contact = contact;
//    }
//
//    public String getNationality() {
//        return nationality;
//    }
//
//    public void setNationality(String nationality) {
//        this.nationality = nationality;
//    }
}
