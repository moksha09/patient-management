package com.pm.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(billing.BillingRequest request,
                                     io.grpc.stub.StreamObserver<billing.BillingResponse> responseObserver){
        log.info("createBillingAccount request received {}", request.toString());

        // Business logic - eg - save to db, perform calculation etc.

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(response); // send the response back to the client
        responseObserver.onCompleted(); // the sending of response is completed and we can now end the cycle now
    }
}
