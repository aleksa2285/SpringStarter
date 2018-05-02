package com.spitter.repository.repositoryDefinition;

import com.spitter.util.Comment;
import com.spitter.util.Reetweet;
import com.spitter.util.Spittle;

public interface CommentRepository {
    void addComment(Comment comment);
    void removeComment();
    void fetchComments(Reetweet retweet);
    void fetchComments(Spittle spittle);
}
