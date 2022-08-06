package com.nd;

import com.nd.entity.Car;
import com.nd.mapper.CarMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Application {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        InputStream props = Resources.getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(props);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder()
                        .build(inputStream, properties);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
            List<Car> cars = carMapper.findAll();
            cars.forEach(System.out::println);
        }
    }
}
