import com.sustc.data.service.CargoFileService;
import com.sustc.data.utils.CargoFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class CargoTest {

    @Autowired
    private CargoFileService cargoFileService;

    @Test
    public void cargoinsert(){
        CargoFile cargoFile = new CargoFile();
//        cargoFile.setId("122");
        cargoFile.setCreated(new Date());
        cargoFile.setUpdated(new Date());
        cargoFile.setEpc("ep");
        cargoFile.setRaw("raw");
        cargoFile.setDel("del");
        System.out.println(cargoFile);
        System.out.println("lll" + cargoFileService.search("e"));
//        cargoFileService.insert(cargoFile);
    }
}
