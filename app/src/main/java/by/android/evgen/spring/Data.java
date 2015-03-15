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

        public long index;
        public String about;
        public String _id;
        @Column(name = "name")
        public String name;
        public String age;
        public String registered;
        public String longitude;
        @Column(name = "email")
        public String email;
        public String eyeColor;
        public String phone;
        public String address;
        public String latitude;
        public String balance;
        public String guid;
        public String company;
        public String isActive;
        @Column(name = "picture")
        public String picture;
        public String gender;

    }

}
