package org.sims.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QService is a Querydsl query type for Service
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QService extends EntityPathBase<Service> {

    private static final long serialVersionUID = -1220438099L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QService service = new QService("service");

    public final StringPath category = createString("category");

    public final NumberPath<Long> dbid = createNumber("dbid", Long.class);

    public final StringPath description = createString("description");

    public final StringPath endDate = createString("endDate");

    public final BooleanPath hasStarted = createBoolean("hasStarted");

    public final StringPath href = createString("href");

    public final StringPath id = createString("id");

    public final BooleanPath isServiceEnabled = createBoolean("isServiceEnabled");

    public final BooleanPath isStateful = createBoolean("isStateful");

    public final StringPath name = createString("name");

    public final SetPath<Note, QNote> notes = this.<Note, QNote>createSet("notes", Note.class, QNote.class, PathInits.DIRECT2);

    public final StringPath orderDate = createString("orderDate");

    public final SetPath<Place, QPlace> places = this.<Place, QPlace>createSet("places", Place.class, QPlace.class, PathInits.DIRECT2);

    public final SetPath<RelatedParty, QRelatedParty> relatedParties = this.<RelatedParty, QRelatedParty>createSet("relatedParties", RelatedParty.class, QRelatedParty.class, PathInits.DIRECT2);

    public final SetPath<ServiceCharacteristic, QServiceCharacteristic> serviceCharacteristics = this.<ServiceCharacteristic, QServiceCharacteristic>createSet("serviceCharacteristics", ServiceCharacteristic.class, QServiceCharacteristic.class, PathInits.DIRECT2);

    public final QServiceOrder serviceOrder;

    public final SetPath<ServiceRelationship, QServiceRelationship> serviceRelationships = this.<ServiceRelationship, QServiceRelationship>createSet("serviceRelationships", ServiceRelationship.class, QServiceRelationship.class, PathInits.DIRECT2);

    public final QServiceSpecification serviceSpecification;

    public final StringPath startDate = createString("startDate");

    public final StringPath startMode = createString("startMode");

    public final StringPath state = createString("state");

    public final ListPath<SupportingResource, QSupportingResource> supportingResources = this.<SupportingResource, QSupportingResource>createList("supportingResources", SupportingResource.class, QSupportingResource.class, PathInits.DIRECT2);

    public final ListPath<SupportingService, QSupportingService> supportingServices = this.<SupportingService, QSupportingService>createList("supportingServices", SupportingService.class, QSupportingService.class, PathInits.DIRECT2);

    public final StringPath type = createString("type");

    public QService(String variable) {
        this(Service.class, forVariable(variable), INITS);
    }

    public QService(Path<? extends Service> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QService(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QService(PathMetadata metadata, PathInits inits) {
        this(Service.class, metadata, inits);
    }

    public QService(Class<? extends Service> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.serviceOrder = inits.isInitialized("serviceOrder") ? new QServiceOrder(forProperty("serviceOrder")) : null;
        this.serviceSpecification = inits.isInitialized("serviceSpecification") ? new QServiceSpecification(forProperty("serviceSpecification"), inits.get("serviceSpecification")) : null;
    }

}

