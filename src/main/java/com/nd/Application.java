package com.nd;

import com.nd.entity.Car;
import com.nd.mapper.CarMapper;
import com.nd.entity.Client;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Application {
    public static void main(String[] args) throws IOException {
        InputStream props = Resources.getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(props);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder()
                        .build(inputStream, properties);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            CarMapper carMapper = sqlSession.getMapper(CarMapper.class);

            System.out.println("Cars before adding brand new one for a client");
            List<Car> cars = carMapper.findAll();
            cars.forEach(System.out::println);

            Client alice = new Client();
            alice.setName("Alice");
            alice.setAge(22);

            Car audiA5 = new Car();
            audiA5.setBrand("Audi");
            audiA5.setModel("A5");
            audiA5.setClient(alice);

            carMapper.addCar(audiA5);

            System.out.println("Cars after");
            cars = carMapper.findAll();
            cars.forEach(System.out::println);
        }
    }
}
