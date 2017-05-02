package guava
import com.google.common.cache.*
import java.util.concurrent.TimeUnit
import com.Database

class CachingController {

    def index() { }

    def callCachingMethod(){
        String prashant =  "Prashant"
        String agarwal =  "Agarwal"
        String fintechlabs =  "Fintechlabs"
        LoadingCache<String, String> mycache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .recordStats()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .build(
                new CacheLoader<String, String>() {
                    public String load(String key) throws Exception {
                        return Database.fetchData(key)
                    }
                });

        try {
            println "record ===========>>>>>>>  "+mycache.get(prashant)
            println "cache stats ===========>>>>>>>  "+mycache.stats()
            println "record ===========>>>>>>>  "+mycache.get(agarwal)
            println "cache stats ===========>>>>>>>  "+mycache.stats()
            println "record ===========>>>>>>>  "+mycache.get(fintechlabs)
            println "cache stats ===========>>>>>>>  "+mycache.stats()
            println "record ===========>>>>>>>  "+mycache.get(prashant)
            println "cache stats ===========>>>>>>>  "+mycache.stats()
            println "record ===========>>>>>>>  "+mycache.get(agarwal)
            println "cache stats ===========>>>>>>>  "+mycache.stats()
            sleep 2000
            println "record ===========>>>>>>>  "+mycache.get(prashant)
            println "cache stats ===========>>>>>>>  "+mycache.stats()
            sleep 6000
            println "record ===========>>>>>>>  "+mycache.get(agarwal)
            println "cache stats ===========>>>>>>>  "+mycache.stats()
            sleep 6000
            println "record ===========>>>>>>>  "+mycache.get(agarwal)
            println "cache stats ===========>>>>>>>  "+mycache.stats()
            sleep 6000
            println "record ===========>>>>>>>  "+mycache.get(agarwal)
            println "cache stats ===========>>>>>>>  "+mycache.stats()
            sleep 2000
            println "record ===========>>>>>>>  "+mycache.get(agarwal)
            println "cache stats ===========>>>>>>>  "+mycache.stats()
        } catch (Exception e) {
            println "error " + e
        }
        render "cache method"
    }
}
