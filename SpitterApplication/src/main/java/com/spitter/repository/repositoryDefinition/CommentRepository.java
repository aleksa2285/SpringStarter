package com.spitter.repository.repositoryDefinition;

import com.spitter.util.Comment;

public interface CommentRepository {
    void addComment(Comment comment);
    void removeComment();
}
