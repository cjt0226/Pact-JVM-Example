package provider;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import provider.ulti.Nationality;

@Api(tags = "Provider 接口")
@RestController
public class InformationController {

    private Information information = new Information();
    @ApiOperation("查询信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "Miku")})
    @RequestMapping(value = "/information",method = RequestMethod.GET)
    public Information information(@RequestParam(value="name", defaultValue="Miku") String name) {
        if (name.equals("Miku")) {
            HashMap contact = new HashMap<String, String>();
            contact.put("Email", "hatsune.miku@ariman.com");
            contact.put("Phone Number", "9090950");
            information.setNationality(Nationality.getNationality());
            information.setContact(contact);
            information.setName("Hatsune Miku");
            information.setSalary(45000);

        } else if (name.equals("Nanoha")) {
            HashMap contact = new HashMap<String, String>();
            contact.put("Email", "takamachi.nanoha@ariman.com");
            contact.put("Phone Number", "9090940");
            information.setNationality(Nationality.getNationality());
            information.setContact(contact);
            information.setName("Takamachi Nanoha");
            information.setSalary(80000);

        } else {
            information.setNationality(Nationality.getNationality());
            information.setContact(null);
            information.setName(name);
            information.setSalary(0);
        }

        return information;
    }
}
