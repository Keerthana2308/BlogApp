package com.springboot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "PostDto Model Information"
)
public class PostDto {
    private long id;
    //title should not be null or empty
    //title should have at least 2 characters

    @Schema(
            description = "Blog Post title"
    )
    @Size(min=2,message ="Post title should have at least 2 character")
    @NotEmpty
    private  String title;

    @Schema(
            description = "Blog Post description"
    )
    @Size(min=10,message ="Post description should have at least 10 character")
    @NotEmpty
    private String description;

    @Schema(
            description = "Blog Post content"
    )
    @NotEmpty
    private  String content;

    private Set<CommentDto> comments;

    @Schema
            (
                    description = "Blog Post category"
            )
    private Long categoryId;

}
