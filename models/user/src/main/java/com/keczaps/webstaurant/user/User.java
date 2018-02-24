package com.keczaps.webstaurant.user;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Document(collection = "users")
public class User implements UserDetails {

    @Id
    private String id;

    private Collection<SimpleGrantedAuthority> authorities;

    @NotBlank
    private String username;

    private String password;

    private boolean accountNonLocked;

    private boolean accountNonExpired;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private String firstName;

    private String lastName;

    private Rank userRank;

    @NotBlank
    private String email;

    @CreatedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createdAt;

    private List<String> orders;

    public enum Rank{

        FLAVOR_AMATOUR("Flavor_amatour"),
        HUNGRY_WOLF("Hungry_Wolf"),
        MYSTERIOUS_GOURMENT("Mysterious_gourment"),
        GASTRONOMIC_MASTER("Gastronomic_master"),
        FLAVOR_CONNOISSEUR("Flavour_connoisseur");

        String rank;

        Rank(String rank) {
            this.rank = rank;
        }

    }

}
