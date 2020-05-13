package com.example.letscode.demoletscode.domain.dto;

import com.example.letscode.demoletscode.domain.Message;
import com.example.letscode.demoletscode.domain.User;
import com.example.letscode.demoletscode.domain.util.MessageHelper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    private long id;
    private String text;
    private String tag;
    private User author;
    private String filename;
    private Long likes;
    private boolean meLiked;

    public MessageDTO(Message message, Long likes, boolean meLiked) {
        this.id = message.getId();
        this.text = message.getText();
        this.tag = message.getTag();
        this.author = message.getAuthor();
        this.filename = message.getFilename();
        this.likes = likes;
        this.meLiked = meLiked;
    }

    public String getAuthorName(){
        return MessageHelper.getAuthorName(author);
    }
}
