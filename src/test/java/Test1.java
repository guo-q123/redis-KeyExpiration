import com.lixiang.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.concurrent.TimeUnit;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @Date 2022/3/7 5:10 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Main.class })
public class Test1 {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void test1(){
        redisTemplate.opsForValue().set("hello","wuyu",10, TimeUnit.SECONDS);
    }

}
