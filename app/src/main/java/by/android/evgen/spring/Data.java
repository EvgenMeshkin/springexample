package by.android.evgen.spring;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by evgen on 15.03.2015.
 */
@JsonIgnoreProperties
public class Data {


    public Resut[] result;

    @Table(name = "KeyValue")
    public static class Resut extends Model {

        @Column(name = "index")
        public String index;
        @Column(name = "about")
        public String about;
        @Column(name = "_id")
        public String _id;
        @Column(name = "name")
        public String name;
        @Column(name = "age")
        public String age;
        @Column(name = "registered")
        public String registered;
        @Column(name = "longitude")
        public String longitude;
        @Column(name = "email")
        public String email;
        @Column(name = "eyeColor")
        public String eyeColor;
        @Column(name = "phone")
        public String phone;
        @Column(name = "address")
        public String address;
        @Column(name = "latitude")
        public String latitude;
        @Column(name = "balance")
        public String balance;
        @Column(name = "guid")
        public String guid;
        @Column(name = "company")
        public String company;
        @Column(name = "isActive")
        public String isActive;
        @Column(name = "picture")
        public String picture;
        @Column(name = "gender")
        public String gender;

    }

}
