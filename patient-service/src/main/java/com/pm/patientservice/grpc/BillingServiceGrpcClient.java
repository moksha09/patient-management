package com.pm.patientservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BillingServiceGrpcClient {

    // It's' a nested class within the BillingServiceGrpc class which provide the blocking
    // or synchronous client calls to Grpc server running in billing service
    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    public BillingServiceGrpcClient(
            // providing environment variables for our docker conatiner
            @Value("${billing.service.address:localhost}")String serverAddress,
            @Value("${billing.service.grpc.port:9001}") int serverPort) {
        log.info("Connecting to billing service at - {}:{}", serverAddress, serverPort);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort).usePlaintext().build();
        blockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }

    public BillingResponse createBillingAccount(String patientId, String name, String email){
        BillingRequest request = BillingRequest.newBuilder()
                .setPatientId(patientId)
                .setName(name)
                .setEmail(email)
                .build();

        BillingResponse response = blockingStub.createBillingAccount(request);
        log.info("Received response from billing service via GRPC: {}", response);
        return response;
    }
}
