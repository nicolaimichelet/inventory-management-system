package org.sims.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QServiceRef is a Querydsl query type for ServiceRef
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QServiceRef extends EntityPathBase<ServiceRef> {

    private static final long serialVersionUID = -1173164634L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QServiceRef serviceRef = new QServiceRef("serviceRef");

    public final NumberPath<Long> dbid = createNumber("dbid", Long.class);

    public final StringPath href = createString("href");

    public final StringPath id = createString("id");

    public final QServiceRelationship serviceRelationship;

    public QServiceRef(String variable) {
        this(ServiceRef.class, forVariable(variable), INITS);
    }

    public QServiceRef(Path<? extends ServiceRef> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QServiceRef(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QServiceRef(PathMetadata metadata, PathInits inits) {
        this(ServiceRef.class, metadata, inits);
    }

    public QServiceRef(Class<? extends ServiceRef> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.serviceRelationship = inits.isInitialized("serviceRelationship") ? new QServiceRelationship(forProperty("serviceRelationship"), inits.get("serviceRelationship")) : null;
    }

}

