package provider;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import provider.ulti.Nationality;

import java.util.HashMap;
import java.util.Map;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Information", description = "Information数据模型")
public class Information {
    @ApiModelProperty("薪水")
    private Integer salary;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("国籍")
    private String nationality;
    @ApiModelProperty("联系信息")
    private Map<String, String> contact = new HashMap<String, String>();

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
