package com.saber.restful;

import com.saber.restful.entities.Article;
import com.saber.restful.entities.Department;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebRestfulApplicationTests {

	@Autowired
	DataSource dataSource;
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Autowired
	JestClient jestClient;

	@Test
	public void contextLoads() throws SQLException {
		System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void testRabbit(){
		rabbitTemplate.convertAndSend("saber.direct","saber",new Department(1,"国防部"));
	}
	@Test
	public void receive(){
		Object o = rabbitTemplate.receiveAndConvert("saber");
		System.out.println(o.getClass());
		System.out.println(o);
	}

	@Test
	public void jestTest(){
		Article article = new Article();
		article.setId(1);
		article.setContent("saber");
		article.setTitle("重大新闻");
		article.setContent("普天同庆");
		//构建索引
        Index build = new Index.Builder(article).index("abyss").type("news").build();
        try {
            jestClient.execute(build);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getJestInfo(){
	    String action = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"title\" : \"新\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search build = new Search.Builder(action).addIndex("abyss").addType("news").build();
        try {
            SearchResult execute = jestClient.execute(build);
            System.out.println(execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
