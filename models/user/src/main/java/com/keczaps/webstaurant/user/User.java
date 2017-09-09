package com.keczaps.webstaurant.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Document(collection = "users")
public class User implements UserDetails {

    @Id
    private String id;

    private Collection<SimpleGrantedAuthority> authorities;

    private String username;

    private String password;

    private boolean accountNonLocked;

    private boolean accountNonExpired;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private String firstName;

    private String lastName;

    private Rank rank;

    private String email;

    public enum Rank{

        FLAVOR_AMATOUR("Amator smaków"),
        HUNGRY_WOLF("Głodny wilk"),
        MYSTERIOUS_GOURMENT("Mistyczny smakosz"),
        GASTRONOMIC_MASTER("Gastronomiczny mistrz"),
        FLAVOR_CONNOISSEUR("Koneser smaków");

        String rank;

        Rank(String rank) {
            this.rank = rank;
        }

    }

}
