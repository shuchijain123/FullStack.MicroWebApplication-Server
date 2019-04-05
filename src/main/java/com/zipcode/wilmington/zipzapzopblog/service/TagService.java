package com.zipcode.wilmington.zipzapzopblog.service;

import com.zipcode.wilmington.zipzapzopblog.model.Tag;
import com.zipcode.wilmington.zipzapzopblog.repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    private final TagRepo tagRepo;

    @Autowired
    public TagService(TagRepo tagRepo) {
        this.tagRepo = tagRepo;
    }

    public Tag getTag(Long id){
        return tagRepo.findById(id).orElse(null);
    }
    public Tag createTag(Tag tag) {
        return tagRepo.save(tag);
    }

    public List findAll() {

        List<Tag> list = new ArrayList();

        tagRepo.findAll().forEach(tag -> list.add(tag));

        return list;
    }
}
