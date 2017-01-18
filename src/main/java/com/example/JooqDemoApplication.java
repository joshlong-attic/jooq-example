package com.example;

import com.example.jooq.tables.Customer;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.Record2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.example.jooq.tables.Customer.CUSTOMER;
import static com.example.jooq.tables.Product.PRODUCT;


@SpringBootApplication
public class JooqDemoApplication implements CommandLineRunner {

	private final DSLContext context;

	public static void main(String[] args) {
		SpringApplication.run(JooqDemoApplication.class, args);
	}

	public JooqDemoApplication(DSLContext dslContext) {
		this.context = dslContext;
	}

	private void init() {
		this.context.deleteFrom(CUSTOMER);

		Stream.of("a", "b", "c", "d", "e").forEach(name -> this.context
				.insertInto(CUSTOMER)
				.columns(CUSTOMER.EMAIL)
				.values(name + "@email.com")
				.execute());

		this.context
				.select()
				.from(Customer.CUSTOMER)
				.stream()
				.forEach(cr -> {
					Long customerId = cr.into(Customer.CUSTOMER.ID).value1();
					Collection<Query> products =
							IntStream
									.range(1, new Random().nextInt(10))
									.mapToObj(i -> this.context
											.insertInto(PRODUCT)
											.columns(PRODUCT.CUSTOMER_ID, PRODUCT.SKU)
											.values(customerId, "sku" + customerId))
									.collect(Collectors.toList());
					this.context.batch(products).execute();
				});
	}

	@Override
	public void run(String... args) throws Exception {
		this.init();
		Map<Long, CustomerResult> resultMap = new HashMap<>();
		this.context
				.select()
				.from(Customer.CUSTOMER).leftJoin(PRODUCT).on(PRODUCT.CUSTOMER_ID.eq(CUSTOMER.ID))
				.stream()
				.forEach(c -> {
					CustomerResult cr = c.into(CUSTOMER.ID, CUSTOMER.EMAIL).into(CustomerResult.class);
					Long customerId = cr.getId();
					resultMap.putIfAbsent(customerId, cr);
					Record2<Long, String> into = c.into(PRODUCT.ID, PRODUCT.SKU);
					ProductResult pr = new ProductResult(cr, into.value1(), into.value2());
					Optional.ofNullable(pr.getId()).ifPresent(id -> resultMap.get(customerId).getProducts().add(pr));
				});

		resultMap.entrySet().forEach(ces -> System.out.println(ces.getValue()));

	}
}

class CustomerResult {

	private Long id;
	private String email;
	private Collection<ProductResult> products = new HashSet<>();

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Collection<ProductResult> getProducts() {
		return products;
	}

	public CustomerResult(Long id, String email) {
		this.id = id;
		this.email = email;
	}


	@Override
	public String toString() {
		return "CustomerResult{" +
				"id=" + id +
				", email='" + email + '\'' +
				", products=" + products +
				'}';
	}

	public CustomerResult(Long id, String email, Collection<ProductResult> products) {
		this(id, email);
		this.products = products;
	}
}

class ProductResult {

	private CustomerResult customer;
	private String sku;
	private Long id;

	public CustomerResult getCustomer() {
		return customer;
	}

	public String getSku() {
		return sku;
	}

	@Override
	public String toString() {
		return "ProductResult{" +
				"customer=#" + customer.getId() +
				", sku='" + sku + '\'' +
				", id=" + id +
				'}';
	}

	public Long getId() {
		return id;
	}

	public ProductResult(CustomerResult cr, Long id, String sku) {
		this.customer = cr;
		this.sku = sku;
		this.id = id;
	}
}
