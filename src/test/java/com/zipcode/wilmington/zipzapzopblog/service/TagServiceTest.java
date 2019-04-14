package com.zipcode.wilmington.zipzapzopblog.service;

import com.zipcode.wilmington.zipzapzopblog.model.Tag;
import com.zipcode.wilmington.zipzapzopblog.repository.PostRepo;
import com.zipcode.wilmington.zipzapzopblog.repository.TagRepo;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class TagServiceTest {

    @Test
    public void createTagTest(){

        //given
        Tag tag = new Tag("TEST TAG");

        //mock
        TagRepo tagRepo = mock(TagRepo.class);
        PostRepo postRepo = mock(PostRepo.class);

        //expected data
        Long expectedId = 3l;
        Tag tagToReturn = new Tag("TEST TAG");
        tagToReturn.setId(expectedId);

        // when the method save is called with the tag
        // then return the created tag
        when(tagRepo.save(tag)).thenReturn(tagToReturn);

        // create class to test
        TagService tagService = new TagService(tagRepo,postRepo);

        // call the method to test
        Tag actual = tagService.createTag(tag);

        //verify the result
        Assert.assertEquals(expectedId, actual.getId());
    }

    @Test
    public void updateTest(){
        //given
        Tag tagToReturn = new Tag("TEST TAG");
        tagToReturn.setId(3L);

        //mock
        TagRepo tagRepo = mock(TagRepo.class);
        PostRepo postRepo = mock(PostRepo.class);

        // when actions
        when(tagRepo.findById(3L)).thenReturn(Optional.of(tagToReturn));
        // create class to test
        TagService tagService = new TagService(tagRepo,postRepo);
        Tag tag = tagRepo.findById(3L).get();


        // call the method to test
        Tag actual = tagService.update(tag);

        // Make sure the method save got called with the tag
        verify(tagRepo).save(tag);
    }


}
