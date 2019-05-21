package com.example.USTAT.search;


import com.example.USTAT.enums.Gender;
import com.example.USTAT.enums.Level;
import com.example.USTAT.enums.Location;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//first filter in website. Where by data that was filled out by student we will find teachers
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProgressBar {

    private String subject;
    private Level levelOfTeacher;
    private int age;
    private Gender genderOfTeacher;
    private BigDecimal cost;
    private Location location;

    public static class Builder {
        private String subject;
        private Level levelOfTeacher;
        private int age;
        private Gender genderOfTeacher;
        private BigDecimal cost;
        private Location location;

        public Builder(String subject, Location location) {
            this.subject = subject;
            this.location = location;
        }

        public Builder withLevelOfTeacher(Level levelOfTeacher) {
            this.levelOfTeacher = levelOfTeacher;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withGenderOfTeacher(Gender genderOfTeacher) {
            this.genderOfTeacher = genderOfTeacher;
            return this;
        }

        public Builder withCost(BigDecimal cost) {
            this.cost = cost;
            return this;
        }

        public ProgressBar build() {
            ProgressBar progressBar = new ProgressBar();
            progressBar.subject = subject;
            progressBar.levelOfTeacher = levelOfTeacher;
            progressBar.age = age;
            progressBar.genderOfTeacher = genderOfTeacher;
            progressBar.cost = cost;
            progressBar.location = location;
            return progressBar;
        }
    }
}