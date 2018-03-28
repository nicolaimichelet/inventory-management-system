package org.sims.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSupportingResource is a Querydsl query type for SupportingResource
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSupportingResource extends EntityPathBase<SupportingResource> {

    private static final long serialVersionUID = 1723857641L;

    public static final QSupportingResource supportingResource = new QSupportingResource("supportingResource");

    public final NumberPath<Long> dbid = createNumber("dbid", Long.class);

    public final StringPath href = createString("href");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final ListPath<Service, QService> services = this.<Service, QService>createList("services", Service.class, QService.class, PathInits.DIRECT2);

    public QSupportingResource(String variable) {
        super(SupportingResource.class, forVariable(variable));
    }

    public QSupportingResource(Path<? extends SupportingResource> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSupportingResource(PathMetadata metadata) {
        super(SupportingResource.class, metadata);
    }

}

