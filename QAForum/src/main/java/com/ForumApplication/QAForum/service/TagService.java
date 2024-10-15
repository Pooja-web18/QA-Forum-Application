package com.ForumApplication.QAForum.service;

import com.ForumApplication.QAForum.model.Tag;
import java.util.List;

public interface TagService {
    Tag createTag(Tag tag);
    Tag getTagById(Long tagId);
    List<Tag> getAllTags();
    Tag updateTag(Tag tag);
    void deleteTag(Long tagId);
}
