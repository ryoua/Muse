package settings;

import com.muse.Application;
import com.muse.common.threadLocal.UserLocal;
import com.muse.manager.setting.model.EmailSetting;
import com.muse.manager.setting.service.EmailSettingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@RunWith(SpringRunner.class)
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class EmailSettingTest {
    @Autowired
    private EmailSettingService emailSettingService;

    private static long id = 0L;

    static {
        UserLocal.setUserId(1L);
    }

    @Test
    public void testAdd() {
        EmailSetting emailSetting = new EmailSetting();
        emailSetting.setAccount("test@qq.com");
        emailSetting.setAddress("smtp.qq");
        emailSetting.setPort("8080");
        emailSetting.setName("测试");
        emailSetting.setPassword("123");
        emailSetting.setIsSSL(false);
        emailSetting.setIsTLS(false);
        emailSetting.setRemark("无");
        emailSetting.setUsername("test@qq.com");
        long id = emailSettingService.addEmailSetting(emailSetting);
        EmailSettingTest.id = id;
    }

    @Test
    public void testGet() {
        Assert.assertNotNull(emailSettingService.getEmailSettingById(id));
    }

    @Test
    public void testUpdate() {
        EmailSetting emailSettingById = emailSettingService.getEmailSettingById(id);
        emailSettingById.setRemark("1");
        emailSettingService.updateEmailSettingById(emailSettingById);
        Assert.assertEquals("邮箱设置修改失败","1", emailSettingService.getEmailSettingById(id).getRemark());
    }
}
