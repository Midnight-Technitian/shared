package dev.glabay.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
@Getter
@Setter
public class UserCredentialsDto {
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String password;
    private String rePassword;
}