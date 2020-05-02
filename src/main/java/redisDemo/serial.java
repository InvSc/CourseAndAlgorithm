<<<<<<< HEAD
package redisDemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import redis.clients.jedis.Jedis;

public class serial {
    @Setter
    @Getter
    @AllArgsConstructor
    class Student {
        String Name;
        Integer Number;
        Integer Age;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("123.57.253.59", 6379);
        jedis.auth("123456");
    }
}
=======
package redisDemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import redis.clients.jedis.Jedis;

public class serial {
    @Setter
    @Getter
    @AllArgsConstructor
    class Student {
        String Name;
        Integer Number;
        Integer Age;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("123.57.253.59", 6379);
        jedis.auth("123456");
    }
}
>>>>>>> 60c04ceb61109a267521c8ff38071a8061e1ad8a
