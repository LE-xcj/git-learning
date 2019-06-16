package com.xc.gituse;

import com.xc.gituse.config.GitUseApplicationConfig;
import com.xc.gituse.dao.UserJpaResposityDao;
import com.xc.gituse.entity.Role;
import com.xc.gituse.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chujian
 * @ClassName RelationTest
 * @Description 功能描述
 * @date 2019/6/16 22:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GitUseApplicationConfig.class)
public class RelationTest {


    @Autowired
    private UserJpaResposityDao userJpaResposityDao;

    @Test
    public void testSave() {
        User user = new User();

        user.setId(88888);
        user.setName("pppp");
        user.setAddress("beijin");
        user.setAge(136);

        Role role = new Role();
        role.setName("vip");

        role.getUsers().add(user);
        user.setRole(role);


        this.userJpaResposityDao.save(user);

    }

}
    