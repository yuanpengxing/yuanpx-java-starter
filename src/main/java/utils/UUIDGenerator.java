package utils;

import org.testng.annotations.Test;

import java.util.UUID;

public class UUIDGenerator {

    @Test
    public void getUUID32(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","").toLowerCase();
        System.out.println(uuid);
    }

}
