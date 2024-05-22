package cn.sine2cr.sine2crchainclientsdk;


import cn.sine2cr.sine2crchainclientsdk.service.ServiceManager;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@Data
@ComponentScan
public class Sine2crChainClientConfig {
    @Bean("sine2crChainClient")
    public ServiceManager sine2crChainClient()  {
        return new ServiceManager();
    }
}


