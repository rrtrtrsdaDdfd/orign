package com.example.demo.mapper;

import com.example.demo.dto.TopicByIdDTO;
import com.example.demo.entity.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TopicMapper {
    TopicMapper INSTANCE = Mappers.getMapper(TopicMapper.class);

    TopicByIdDTO TopicToDTO(Topic topic);
}
