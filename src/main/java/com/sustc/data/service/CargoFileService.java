package com.sustc.data.service;

import com.sustc.data.utils.CargoFile;

public interface CargoFileService {

    void insert(CargoFile cargoFile);
    CargoFile search(String epc);
}
