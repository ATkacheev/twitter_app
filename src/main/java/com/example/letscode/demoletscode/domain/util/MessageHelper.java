package com.example.letscode.demoletscode.domain.util;

import com.example.letscode.demoletscode.domain.User;

public abstract class MessageHelper {
    public static String getAuthorName(User author){
        return author != null ? author.getUsername() : "<none>";
    }
}
