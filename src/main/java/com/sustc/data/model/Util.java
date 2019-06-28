package com.sustc.data.model;

import com.sustc.data.service.CargoFileService;
import com.sustc.data.utils.CargoFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class Util {

    @Autowired
    private CargoFileService cargoFileService;

    public void cargoinsert(String id, Date created, Date updated, String epc, String raw, String del){
        CargoFile cargoFile = new CargoFile();
//        cargoFile.setId(id);
        cargoFile.setCreated(created);
        cargoFile.setUpdated(updated);
        cargoFile.setEpc(epc);
        cargoFile.setRaw(raw);
        cargoFile.setDel(del);
        System.out.println(cargoFile);

        cargoFileService.insert(cargoFile);
    }
}