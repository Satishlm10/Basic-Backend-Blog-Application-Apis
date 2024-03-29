package com.learning.blog.blogappapis.payloads;



import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4,message = "username must be min of 4 characters")
    private String name;

    @Email(message = "provided email address is not valid")
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 3, max = 15, message = "Password must be minimum of 3 char and max of 15 chars")
    private String password;

    @NotEmpty
    private String about;

}
