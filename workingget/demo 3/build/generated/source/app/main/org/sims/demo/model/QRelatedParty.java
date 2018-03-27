package org.sims.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRelatedParty is a Querydsl query type for RelatedParty
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRelatedParty extends EntityPathBase<RelatedParty> {

    private static final long serialVersionUID = 1957526403L;

    public static final QRelatedParty relatedParty = new QRelatedParty("relatedParty");

    public final NumberPath<Long> dbid = createNumber("dbid", Long.class);

    public final StringPath href = createString("href");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath role = createString("role");

    public final ListPath<Service, QService> services = this.<Service, QService>createList("services", Service.class, QService.class, PathInits.DIRECT2);

    public final StringPath validFor = createString("validFor");

    public QRelatedParty(String variable) {
        super(RelatedParty.class, forVariable(variable));
    }

    public QRelatedParty(Path<? extends RelatedParty> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRelatedParty(PathMetadata metadata) {
        super(RelatedParty.class, metadata);
    }

}

