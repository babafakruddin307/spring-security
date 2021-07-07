###spring-security
#Implementation spring security 

**create spring starter project

add maven dependecies in pom.xml file
**
```

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.apache.cxf</groupId>
			<artifactId>cxf-spring-boot-starter-jaxrs</artifactId>
			<version>3.3.1</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
    
    
```

** create model class**

```
package com.baba.jaxws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product")
public class Product {

	private long id;
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

```


** create service interface**

```
package com.baba.jaxws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
@Path("/productservice")
public interface ProductService {

	@GET
	@Path("/products")
	List<Product> getProducts();
	@POST
	@Path("/products")
	long addProduct(Product product);
} 

```

** implemt service class**

```
package com.baba.jaxws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService {
	
	List<Product> products=new ArrayList<>();
	private long id=123;
	
	ProductServiceImpl(){
		Product product=new Product();
		product.setId(id);
		product.setDescription("java crash course 8");
		products.add(product);
	}
	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public long addProduct(Product product) {

		product.setId(++id);
		products.add(product);
		return id;
	}

}

```

**By default cross site checking is desabled in spring security so to support post request in spring security we need write code to desable cross check**

```
package com.baba.jaxws;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	 @Override
	    protected void configure(HttpSecurity http) throws Exception{
	        http.cors().and().csrf().disable();
	    }
}

```

