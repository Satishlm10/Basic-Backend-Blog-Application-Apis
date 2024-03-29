package com.learning.blog.blogappapis.payloads;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponses {
    private String message;
    private Boolean success;
}
