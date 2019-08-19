package com.sld.commoncore.uid;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * id生成
 */
public class UidGenerator extends IdentityGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        Object id =  SnowFlake.nextId();
        if (id != null) {
            return (Serializable) id;
        }
        return super.generate(session, object);
    }
}
