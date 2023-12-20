package com.thienday.posmanagement.response;

import com.thienday.posmanagement.entity.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class UserResponse {
    private String userName;
    private String firstName;
    private String lastName;
    private String mobilePhone;
    private String email;

    private boolean isSuperAdmin = false;

    private Set<String> roles;

    public static UserResponse toResponse(User user){
        return UserResponse.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .mobilePhone(user.getMobilePhone())
                .roles(CollectionUtils.isEmpty(user.getRoles()) ? new HashSet<>()
                        : user.getRoles().stream().collect(Collectors.toSet()) )
                .isSuperAdmin(user.isSuperAdmin())
                .build();
    }
}
