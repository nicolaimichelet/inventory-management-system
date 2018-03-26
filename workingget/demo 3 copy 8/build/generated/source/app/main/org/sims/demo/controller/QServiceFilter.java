package org.sims.demo.controller;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QServiceFilter is a Querydsl query type for ServiceFilter
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QServiceFilter extends EntityPathBase<ServiceFilter> {

    private static final long serialVersionUID = -2101359458L;

    public static final QServiceFilter serviceFilter = new QServiceFilter("serviceFilter");

    public final StringPath category = createString("category");

    public final StringPath href = createString("href");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QServiceFilter(String variable) {
        super(ServiceFilter.class, forVariable(variable));
    }

    public QServiceFilter(Path<? extends ServiceFilter> path) {
        super(path.getType(), path.getMetadata());
    }

    public QServiceFilter(PathMetadata metadata) {
        super(ServiceFilter.class, metadata);
    }

}

