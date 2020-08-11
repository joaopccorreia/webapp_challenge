package jcorreia.luxclusif.challenge.webapp_challenge.dto.converters;

import jcorreia.luxclusif.challenge.webapp_challenge.dto.ItemDto;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemDtoToItem extends AbstractConverter<ItemDto, Item> {

    @Override
    public Item convert(ItemDto itemDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(itemDto, Item.class);
    }
}
