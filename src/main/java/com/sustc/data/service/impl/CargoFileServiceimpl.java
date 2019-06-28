package com.sustc.data.service.impl;

import com.sustc.data.dao.CargoFileDao;
import com.sustc.data.service.CargoFileService;
import com.sustc.data.utils.CargoFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoFileServiceimpl implements CargoFileService {

    @Autowired
    CargoFileDao cargoFileDao;

    @Override
    public void insert(CargoFile cargoFile) {
        cargoFileDao.insert(cargoFile);
    }

    @Override
    public CargoFile search(String epc) {
        return cargoFileDao.search(epc);
    }
}
