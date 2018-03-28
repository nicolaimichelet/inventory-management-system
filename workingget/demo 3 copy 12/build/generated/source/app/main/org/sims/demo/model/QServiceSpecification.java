package org.sims.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QServiceSpecification is a Querydsl query type for ServiceSpecification
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QServiceSpecification extends EntityPathBase<ServiceSpecification> {

    private static final long serialVersionUID = -860456362L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QServiceSpecification serviceSpecification = new QServiceSpecification("serviceSpecification");

    public final NumberPath<Long> dbid = createNumber("dbid", Long.class);

    public final StringPath href = createString("href");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final QService service;

    public final StringPath version = createString("version");

    public QServiceSpecification(String variable) {
        this(ServiceSpecification.class, forVariable(variable), INITS);
    }

    public QServiceSpecification(Path<? extends ServiceSpecification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QServiceSpecification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QServiceSpecification(PathMetadata metadata, PathInits inits) {
        this(ServiceSpecification.class, metadata, inits);
    }

    public QServiceSpecification(Class<? extends ServiceSpecification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.service = inits.isInitialized("service") ? new QService(forProperty("service"), inits.get("service")) : null;
    }

}

