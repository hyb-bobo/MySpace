package joyce.guava.main;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class LoadingCacheDemo {
 
    public static void main(String[] args) {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(100) // 最大缓存数目
                .expireAfterAccess(1, TimeUnit.SECONDS) // 缓存1秒后过期
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return key;
                    }
                });
        cache.put("j", "java");
        cache.put("c", "cpp");
        cache.put("s", "scala");
        cache.put("g", "go");
        try {
            System.out.println(cache.get("j"));
            TimeUnit.SECONDS.sleep(1);
            System.out.println(cache.get("s")); // 1秒后 输出scala
            TimeUnit.SECONDS.sleep(2);
            System.out.println(cache.get("s")); // 2秒后 输出s
 
 
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
 
}