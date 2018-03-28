package org.sims.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QServiceOrder is a Querydsl query type for ServiceOrder
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QServiceOrder extends EntityPathBase<ServiceOrder> {

    private static final long serialVersionUID = -2132163679L;

    public static final QServiceOrder serviceOrder = new QServiceOrder("serviceOrder");

    public final NumberPath<Long> dbid = createNumber("dbid", Long.class);

    public final StringPath href = createString("href");

    public final StringPath id = createString("id");

    public final SetPath<Service, QService> services = this.<Service, QService>createSet("services", Service.class, QService.class, PathInits.DIRECT2);

    public QServiceOrder(String variable) {
        super(ServiceOrder.class, forVariable(variable));
    }

    public QServiceOrder(Path<? extends ServiceOrder> path) {
        super(path.getType(), path.getMetadata());
    }

    public QServiceOrder(PathMetadata metadata) {
        super(ServiceOrder.class, metadata);
    }

}

