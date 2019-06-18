package com.xc.gituse.service.impl;

import com.xc.gituse.dao.*;
import com.xc.gituse.entity.Role;
import com.xc.gituse.entity.User;
import com.xc.gituse.entity.vo.UserVO;
import com.xc.gituse.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
/**
 * @author chujian
 * @ClassName UserServiceImpl
 * @Description 功能描述
 * @date 2019/6/14 21:48
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public int createUser(User user) throws Exception {
        User save = userDao.save(user);
        if (null == save) {
            return 0;
        }

        return 1;
    }

    @Override
    public int deleteUser(Integer id) throws Exception {

        userDao.deleteById(id);

        return 1;
    }

    @Override
    public User queryUserById(Integer id) throws Exception {

        Optional<User> byId = userDao.findById(id);
        User user = byId.get();
        return user;
    }

    @Override
    public int updateUserById(User user) throws Exception {

        User user1 = userDao.saveAndFlush(user);

        return 1;
    }


    @Autowired
    private UserRepositoryDao userRepositoryDao;

    @Override
    public List<User> findByName(String name) {


        return userRepositoryDao.findByName(name);
    }

    @Override
    public List<User> findByNameAndAge(String name, int age) {
        return userRepositoryDao.findByNameAndAge(name, age);
    }

    @Override
    public List<User> findByNameLike(String name) {
        return userRepositoryDao.findByNameLike(name);
    }



    @Autowired
    private UserRespositoryQueryDao userRespositoryQueryDao;

    @Override
    public List<User> listUsersByName(String name) {
        return userRespositoryQueryDao.listUsersByName(name);
    }

    @Override
    public List<User> listUsersByNameSQL(String name) {
        return userRespositoryQueryDao.listUsersByNameSQL(name);
    }

    @Override
    public void updateUserById(String name, Integer id) {
        int i = userRespositoryQueryDao.updateUserById(name, id);
        System.out.println(i);
    }

    @Autowired
    private UserPageRepositoryDao userPageRepositoryDao;

    @Override
    public List<User> listUsersSort(List<String> properties) {

        /**
         * 定义排序对象，根据properties中的字段顺序进行排序
         * 所有属性都按照降序排序
         */
        Sort sort = new Sort(Sort.Direction.DESC, properties);

        // 获取结果集的迭代器对象
        Iterator<User> users = userPageRepositoryDao.findAll(sort).iterator();

        // 使用org.apache.commons.collections4来对迭代器对象进行list的转换
        List<User> us = IteratorUtils.toList(users);


        return us;

    }


    @Override
    public UserVO listUserByPage(int page, int size) {

        // 创建分页查询参数对象，包含page（页数，第一页是从0开始），size：一页显示的页数
        Pageable pageAble = new QPageRequest(page, size);

        // 结果集
        Page<User> all = userPageRepositoryDao.findAll(pageAble);

        // 重新包装成vo对象返回
        UserVO vo = new UserVO();
        vo.setCurrentPage(page);
        vo.setUsers(all.getContent());
        vo.setTotalE(all.getTotalElements());
        vo.setTotalPage(all.getTotalPages());

        return vo;
    }

    @Autowired
    private UserJpaResposityDao userJpaResposityDao;


    @Override
    public UserVO listUserByJpaResposity(int page, int size) {
        // 创建分页查询参数对象，包含page（页数，第一页是从0开始），size：一页显示的页数
        Pageable pageAble = new QPageRequest(page, size);

        Page<User> all = userJpaResposityDao.findAll(pageAble);

        // 重新包装成vo对象返回
        UserVO vo = new UserVO();
        vo.setCurrentPage(page);
        vo.setUsers(all.getContent());
        vo.setTotalE(all.getTotalElements());
        vo.setTotalPage(all.getTotalPages());

        return vo;
    }

    @Override
    public List<User> listUserByJpaOrder(List<String> properties) {

        /**
         * 定义排序对象，根据properties中的字段顺序进行排序
         * 所有属性都按照降序排序
         */
        Sort sort = new Sort(Sort.Direction.DESC, properties);

        List<User> all = userJpaResposityDao.findAll(sort);

        return all;
    }


    @Autowired
    private UserJpaSecificationDao userJpaSecificationDao;

    @Override
    public UserVO userSpecQuery(User param) {

        // 用于封装查询条件
        Specification<User> spec = new Specification<User>() {

            /**
             *
             * @param root  查询对象的属性封装
             * @param query  封装执行的查询中的各个部分信息
             * @param criteriaBuilder 查询条件的构造器，定义不同的查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<User> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {

                Path<String> age = root.get("age");
                Path<String> name = root.get("name");

                List<Predicate> list = new ArrayList<Predicate>();

                list.add(criteriaBuilder.equal(age, param.getAge()));
                list.add(criteriaBuilder.like(name, "%" + param.getName()));

                Predicate[] arr = new Predicate[list.size()];

                Predicate[] predicates = list.toArray(arr);


                /**
                 * 其实下面所有的复杂条件拼接都遵循这样的规则，Predicate[]数组表示表中的字段和谓语（in、like、=....）
                 * criteriaBuilder调用的方法，都会在Predicate[]数组中的表示的字段参数之间添加连词 （in、or、and....）
                 */
                if (param.getAge() > 30) {

                    // 在arr所有表示的字段参数中添加and连词
                    // 结果：user0_.age=40 and (user0_.name like ?)
                    return criteriaBuilder.or(criteriaBuilder.and(list.toArray(arr)));
                } else if (param.getAge() > 20) {

                    /**
                     * 添加多一个字段的赛选条件
                     */
                    Path<String> city = root.get("city");
                    list.add(criteriaBuilder.notLike(city, "%" + param.getCity()));
                    Predicate[] arr2 = new Predicate[3];
                    arr2[0] = list.get(1);  // arr2[0] = name;
                    arr2[1] = list.get(0);  // arr2[1] = age
                    arr2[2] = list.get(2);  // arr2[2] = city

                    // 这里模拟一个复杂的条件查询
                    /**
                     * user0_.age=30 and (user0_.city not like ?) or    第一部分
                     * user0_.age=30 or     第二部分
                     * (user0_.name like ?) and user0_.age=30   第三部分
                     *
                     * 解析：
                     *  “user0_.age=30 and (user0_.city not like ?)” : 表示的是：criteriaBuilder.and(arr2[1], arr2[2])这一部分
                     *  "user0_.age=30"  ： 这是or的第二部分
                     *  "(user0_.name like ?) and user0_.age=30"   表示第三部分：criteriaBuilder.and(arr2[0], arr2[1])
                     */
                    return criteriaBuilder.or(
                            criteriaBuilder.and(
                                    arr2[1], arr2[2]),      // or 的第一部分
                                    arr2[1],                // or 的第二部分
                                    criteriaBuilder.and(arr2[0], arr2[1])      // or 的第三部分
                    );
                }else if (param.getAge() > 10) {
                    return criteriaBuilder.and(predicates);
                } else {
                    return criteriaBuilder.or(criteriaBuilder.and(predicates[0]));
                }
            }
        };
        Sort sort = new Sort(Sort.Direction.DESC, "age");
        Pageable pageable = new PageRequest(0, 2, sort);
        Page<User> page = userJpaSecificationDao.findAll(spec, pageable);


        // 重新包装成vo对象返回
        UserVO vo = new UserVO();
        vo.setUsers(page.getContent());
        vo.setTotalE(page.getTotalElements());
        vo.setTotalPage(page.getTotalPages());

        return vo;
        // return result;


        // userJpaSecificationDao.findAll(spec);
    }


    public void insertOneToMany(User user) {


        Role role = new Role();
        role.setName("vip");

        role.getUsers().add(user);
        user.setRole(role);

        this.userJpaResposityDao.save(user);
    }

    @Override
    public List<User> testLaszy() {
        List<User> all = userJpaResposityDao.findAll();
        return all;
    }

    @Override
    public List<User> testNoneLaszy() {

        List<User> all = userJpaResposityDao.findAll();

        for (User user : all) {
            log.info("user", user.getRole());
        }
        return all;
    }

    @Override
    public User findUserAndOrder(Integer id) {
        Optional<User> byId = userJpaResposityDao.findById(id);
        User user = byId.get();

        Role role = user.getRole();
        log.info("role", role);
        return user;
    }


}
    