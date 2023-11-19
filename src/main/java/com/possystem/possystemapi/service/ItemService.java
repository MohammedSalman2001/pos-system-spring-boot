package com.possystem.possystemapi.service;




import com.possystem.possystemapi.dto.core.ItemDto;

import java.util.List;

public interface ItemService {
    public ItemDto save(ItemDto dto);

    public ItemDto update(ItemDto dto);

    public void  delete(String code);

    public ItemDto find(String code);

    public List<ItemDto> findAll();
}
