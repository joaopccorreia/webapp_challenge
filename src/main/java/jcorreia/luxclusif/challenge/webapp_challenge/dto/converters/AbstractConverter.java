package jcorreia.luxclusif.challenge.webapp_challenge.dto.converters;

import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<S, T> implements Converter<S, T> {

    public List<T> convert(List<S> list) {
        return list.stream().map(this::convert).collect(Collectors.toList());
    }
}
