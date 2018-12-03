package com.hanslaser.blog.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.stereotype.Component;

/**
 * @author LuoJu
 * @since 2018.12.03
 */
@Component
public class MySqlPhysicalNamingStrategyStandardImpl extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return Identifier.toIdentifier(name.getText().toLowerCase());
    }
}