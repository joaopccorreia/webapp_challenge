package jcorreia.luxclusif.challenge.webapp_challenge.dto.converters;

import jcorreia.luxclusif.challenge.webapp_challenge.dto.ItemDto;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemDto extends AbstractConverter<Item, ItemDto> {

    @Override
    public ItemDto convert(Item item) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(item, ItemDto.class);
    }
}
