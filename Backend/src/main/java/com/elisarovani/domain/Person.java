package com.elisarovani.domain;


import com.elisarovani.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity

public abstract class Person implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        protected Integer id;
        protected String name;
        @Column(unique = true)
        protected String email;
        protected String password;

        @ElementCollection (fetch = FetchType.EAGER)
        @CollectionTable(name = "PROFILES")
        protected Set<Integer> profiles = new HashSet<>();

        @JsonFormat(pattern = "yyyy/MM/dd")
        protected LocalDate dateCreated = LocalDate.now();

        public Person(){
                super();
                addProfiles(Profile.CLIENT);
        }

        public Person(Integer id, String name, String email, String password) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.password = password;
                addProfiles(Profile.CLIENT);
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Set<Profile> getProfiles() {
                return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
        }

        public void addProfiles(Profile profile) {
                this.profiles.add(profile.getCode());
        }

        public LocalDate getDateCreated() {
                return dateCreated;
        }

        public void setDateCreated(LocalDate dateCreated) {
                this.dateCreated = dateCreated;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return id.equals(person.id);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id);
        }
}
