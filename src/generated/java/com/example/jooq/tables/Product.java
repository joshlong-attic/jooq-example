/**
 * This class is generated by jOOQ
 */
package com.example.jooq.tables;


import com.example.jooq.Keys;
import com.example.jooq.Public;
import com.example.jooq.tables.records.ProductRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Product extends TableImpl<ProductRecord> {

    private static final long serialVersionUID = -381914774;

    /**
     * The reference instance of <code>PUBLIC.PRODUCT</code>
     */
    public static final Product PRODUCT = new Product();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductRecord> getRecordType() {
        return ProductRecord.class;
    }

    /**
     * The column <code>PUBLIC.PRODUCT.ID</code>.
     */
    public final TableField<ProductRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("(NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_E85096E6_C230_469A_9715_808E7A54E483)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT.CUSTOMER_ID</code>.
     */
    public final TableField<ProductRecord, Long> CUSTOMER_ID = createField("CUSTOMER_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT.SKU</code>.
     */
    public final TableField<ProductRecord, String> SKU = createField("SKU", org.jooq.impl.SQLDataType.VARCHAR.length(10).nullable(false), this, "");

    /**
     * Create a <code>PUBLIC.PRODUCT</code> table reference
     */
    public Product() {
        this("PRODUCT", null);
    }

    /**
     * Create an aliased <code>PUBLIC.PRODUCT</code> table reference
     */
    public Product(String alias) {
        this(alias, PRODUCT);
    }

    private Product(String alias, Table<ProductRecord> aliased) {
        this(alias, aliased, null);
    }

    private Product(String alias, Table<ProductRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ProductRecord, Long> getIdentity() {
        return Keys.IDENTITY_PRODUCT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ProductRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ProductRecord>> getKeys() {
        return Arrays.<UniqueKey<ProductRecord>>asList(Keys.CONSTRAINT_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ProductRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ProductRecord, ?>>asList(Keys.CONSTRAINT_18);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product as(String alias) {
        return new Product(alias, this);
    }

    /**
     * Rename this table
     */
    public Product rename(String name) {
        return new Product(name, null);
    }
}
