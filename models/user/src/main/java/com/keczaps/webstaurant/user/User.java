package com.keczaps.webstaurant.user;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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

    /*public void setAuthorities(List<Map<String,String>> authorities){
        for (Map<String,String> authority : authorities) {
            if (authority.containsKey("role"))
                this.authorities.add(new SimpleGrantedAuthority(authority.get("role")));
            else
                this.authorities.add(new SimpleGrantedAuthority(authority.get("authority")));
        }
    }*/

}
