package com.rick.springdatajparick;

import com.rick.springdatajparick.domain.*;
import com.rick.springdatajparick.repository.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringDataJpaRickApplicationTests {

    @Autowired
    private MyRepository myRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void contextLoads() {
        System.out.println("测试开始");
    }

    @Test
    void test01(){
        Optional<Pet> pet = myRepository.findById(1);
        System.out.println(pet.get());
    }

    @Test
    void test02(){
        Pet caiyu = myRepository.findByName("caiyu");
        System.out.println(caiyu);
    }

    @Test
    void test03(){
        Pet byColor = myRepository.findByColor("#002FA7");
        System.out.println(byColor);
    }

    @Test
    void test04(){
        Pet by_color = myRepository.find_by_color("#002FA7");
        System.out.println(by_color);
    }

    @Test
    void test05(){
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC,"id"));
        Page<Pet> all = myRepository.findAll(pageRequest);
        List<Pet> content = all.getContent();
        for (Pet pet : content) {
            System.out.println(pet);
        }
    }


    @Test
    void test06(){
        Specification<Pet> specification = new Specification<>() {
            @Override
            public Predicate toPredicate(Root<Pet> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name").as(String.class),"ya%");
            }
        };

        Optional<Pet> one = myRepository.findOne(specification);
        System.out.println(one.get());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void test07(){
        Person person = new Person();
        person.setId(1);
        person.setUsername("yasuo");


        Car car = new Car();
        car.setId(1);
        car.setBrand("AMG");


        car.setPerson(person);
        personRepository.save(person);
        carRepository.save(car);


    }

    @Test
    @Transactional
    void test08(){
        Specification<Person> specification = new Specification<>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("id").as(Integer.class),1);
            }
        };

        Optional<Person> one = personRepository.findOne(specification);
        System.out.println(one.get());
    }

    @Test
    @Transactional
    void test09(){
        Optional<Person> byId = personRepository.findById(1);
        System.out.println(byId.get());

    }

    @Test
    @Transactional
    @Rollback(value = false)
    void test10(){
        Optional<Person> person = personRepository.findById(1);
        personRepository.delete(person.get());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void test11(){
        User user = new User();
        user.setUsername("yasuo");
        user.setPassword("yasuomvp");

        Role role = new Role();
        role.setRoleName("ROLE_A");

        Role role1 = new Role();
        role1.setRoleName("ROLE_B");

        user.getRoleSet().add(role);
        user.getRoleSet().add(role1);

        User save = userRepository.save(user);

        System.out.println(save);
        System.out.println(save.getRoleSet());

    }

    @Test
    @Transactional
    void test12(){
        Optional<User> optionalUser = userRepository.findById(1);
        User user = optionalUser.get();
        System.out.println(user);
        System.out.println(user.getRoleSet());
    }


}
