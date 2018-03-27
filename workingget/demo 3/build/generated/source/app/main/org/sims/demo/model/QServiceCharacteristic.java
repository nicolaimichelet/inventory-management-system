package org.sims.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QServiceCharacteristic is a Querydsl query type for ServiceCharacteristic
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QServiceCharacteristic extends EntityPathBase<ServiceCharacteristic> {

    private static final long serialVersionUID = 1888514728L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QServiceCharacteristic serviceCharacteristic = new QServiceCharacteristic("serviceCharacteristic");

    public final NumberPath<Long> dbid = createNumber("dbid", Long.class);

    public final StringPath name = createString("name");

    public final QService service;

    public final StringPath value = createString("value");

    public QServiceCharacteristic(String variable) {
        this(ServiceCharacteristic.class, forVariable(variable), INITS);
    }

    public QServiceCharacteristic(Path<? extends ServiceCharacteristic> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QServiceCharacteristic(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QServiceCharacteristic(PathMetadata metadata, PathInits inits) {
        this(ServiceCharacteristic.class, metadata, inits);
    }

    public QServiceCharacteristic(Class<? extends ServiceCharacteristic> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.service = inits.isInitialized("service") ? new QService(forProperty("service"), inits.get("service")) : null;
    }

}

