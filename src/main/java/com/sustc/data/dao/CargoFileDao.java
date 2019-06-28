package com.sustc.data.dao;

import com.sustc.data.utils.CargoFile;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoFileDao {

    void insert(CargoFile cargoFile);

    CargoFile search(String epc);
}
