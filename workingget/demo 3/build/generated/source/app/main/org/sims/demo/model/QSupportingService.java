package org.sims.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSupportingService is a Querydsl query type for SupportingService
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSupportingService extends EntityPathBase<SupportingService> {

    private static final long serialVersionUID = 1219479674L;

    public static final QSupportingService supportingService = new QSupportingService("supportingService");

    public final StringPath category = createString("category");

    public final NumberPath<Long> dbid = createNumber("dbid", Long.class);

    public final StringPath href = createString("href");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final ListPath<Service, QService> services = this.<Service, QService>createList("services", Service.class, QService.class, PathInits.DIRECT2);

    public QSupportingService(String variable) {
        super(SupportingService.class, forVariable(variable));
    }

    public QSupportingService(Path<? extends SupportingService> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSupportingService(PathMetadata metadata) {
        super(SupportingService.class, metadata);
    }

}

