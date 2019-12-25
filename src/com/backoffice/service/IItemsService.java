package com.backoffice.service;

import com.backoffice.model.Items;
import java.util.List;

public interface IItemsService {
    public List<Items> findAllItems();
    public Items findById(Integer id);
    public void saveOrUpdate(Items items);
    public void deleteById(Integer id);
}
