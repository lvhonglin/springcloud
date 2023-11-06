package org.example.register;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @NacosInjected
    private NamingService namingService;
    @GetMapping("/registry")
    public String registry() throws NacosException {
        Instance instance = new Instance();
        instance.setClusterName("TestCluster");
        instance.setEphemeral(true);//临时节点是CP模式是Raft算法，持久化节点是AP模式是Distro算法
        instance.setIp("111.111.111.1111");
        instance.setPort(8888);
        instance.setWeight(10);
        System.out.println("nameService:"+namingService);
        namingService.registerInstance("springboot-test",instance);
        return "succ";
    }
    @GetMapping("/get")
    public String get() throws NacosException {
        return namingService.getAllInstances("springboot-test").toString();
    }
}
