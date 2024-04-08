package com.example.demo.mapper;

import com.example.demo.dto.AllTopicResponseDTO;
import com.example.demo.entity.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AllTopicMapper {
    AllTopicMapper INSTANCE = Mappers.getMapper(AllTopicMapper.class);

    AllTopicResponseDTO TopicToAllDTO(Topic topic);

}
