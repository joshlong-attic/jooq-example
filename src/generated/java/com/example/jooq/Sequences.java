/**
 * This class is generated by jOOQ
 */
package com.example.jooq;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in PUBLIC
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>PUBLIC.SYSTEM_SEQUENCE_4F30980E_86A8_43DC_BE39_39A1A1445BFE</code>
     */
    public static final Sequence<Long> SYSTEM_SEQUENCE_4F30980E_86A8_43DC_BE39_39A1A1445BFE = new SequenceImpl<Long>("SYSTEM_SEQUENCE_4F30980E_86A8_43DC_BE39_39A1A1445BFE", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);

    /**
     * The sequence <code>PUBLIC.SYSTEM_SEQUENCE_7B8F533C_1976_42BF_9966_B0080EADFD19</code>
     */
    public static final Sequence<Long> SYSTEM_SEQUENCE_7B8F533C_1976_42BF_9966_B0080EADFD19 = new SequenceImpl<Long>("SYSTEM_SEQUENCE_7B8F533C_1976_42BF_9966_B0080EADFD19", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}