package com.springboot.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
    private  long id;
    @NotEmpty(message ="Name should not be null or empty")
    private  String name;

   @Email(message="Email should not be null or empty")
    @NotEmpty
    private  String email;
   @Size(min=10,message = "Comment body must be minimum 10 characters")
   @NotEmpty
    private  String body;
}
