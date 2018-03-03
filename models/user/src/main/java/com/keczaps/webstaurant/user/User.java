package com.keczaps.webstaurant.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.Lists;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
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
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
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

    public void setAuthorities(Collection<LinkedHashMap<String,String>> authorities){
        this.authorities = Lists.newArrayList();
        if (authorities == null) {
            return;
        }
        for (LinkedHashMap<String,String> authority : authorities){
            this.authorities.add(new SimpleGrantedAuthority(authority.get("authority")));
        }
    }
}
