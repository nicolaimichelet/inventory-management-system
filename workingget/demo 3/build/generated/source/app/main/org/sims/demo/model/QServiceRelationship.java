package org.sims.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QServiceRelationship is a Querydsl query type for ServiceRelationship
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QServiceRelationship extends EntityPathBase<ServiceRelationship> {

    private static final long serialVersionUID = 1330792069L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QServiceRelationship serviceRelationship = new QServiceRelationship("serviceRelationship");

    public final NumberPath<Long> dbid = createNumber("dbid", Long.class);

    public final QService service;

    public final QServiceRef serviceRef;

    public final StringPath type = createString("type");

    public QServiceRelationship(String variable) {
        this(ServiceRelationship.class, forVariable(variable), INITS);
    }

    public QServiceRelationship(Path<? extends ServiceRelationship> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QServiceRelationship(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QServiceRelationship(PathMetadata metadata, PathInits inits) {
        this(ServiceRelationship.class, metadata, inits);
    }

    public QServiceRelationship(Class<? extends ServiceRelationship> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.service = inits.isInitialized("service") ? new QService(forProperty("service"), inits.get("service")) : null;
        this.serviceRef = inits.isInitialized("serviceRef") ? new QServiceRef(forProperty("serviceRef"), inits.get("serviceRef")) : null;
    }

}

